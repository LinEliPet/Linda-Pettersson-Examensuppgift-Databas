package objectLists;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.actorBean;
import helpers.jsonHelper;

public class actors {
	private Connection _connection;
	private ArrayList<actorBean> _actors;
	
	private String selectAllActors = "select * from actor";
	private String updateActors = "UPDATE actor SET hometown ?, actor_age = ? WHERE actor_name = ?;";
	private String updateActorsShort = "UPDATE actor SET hometown = ? WHERE actor_name = ?;";
	private String updateActorsCity = "UPDATE actor SET hometown = ? WHERE hometown LIKE ?;";
	
	private String createActors = "CREATE actor SET hometown = ?, actor_age = ? WHERE actor_name = ?;";
	private String deleteActors = "DELETE FROM actor WHERE address_id = ?;";
	
	public actors(Connection cn) { //Metoden sparas och återanvänds.
		this._connection = cn;
		this._actors = new ArrayList<actorBean>();
		getActors();
	}
	
	public ArrayList<actorBean> getActors() {
		if (this._actors.size() > 0) 
			return this._actors;
			
		this._actors = new ArrayList<actorBean>();
		try (PreparedStatement myQry = this._connection.prepareStatement(selectAllActors)) {
			runQuery(myQry);
		} catch (SQLException e) {
			System.out.println("getActors exception for statement");
			e.printStackTrace();
		}
		
		return this._actors;
	}
	
	
	public int createActors(
			String name, 
			String hometown, 
			int age) {
	
		int num = 0;
		try (PreparedStatement myQry = this._connection.prepareStatement(createActors)) {
			myQry.setString(1, name);
			myQry.setString(2, hometown);
			myQry.setInt(3, age);
			num = myQry.executeUpdate();
		}catch (SQLException e) {
			System.out.println("createActors exception for statement");
			e.printStackTrace();
		}
		return num;
	}
	
	
	public int updateActors(
			String name, 
			String newCity, 
			int newAge) { 
		
		String qry = "";
		if (newAge == -1) {
			qry = updateActorsShort;
		} else {
			qry = updateActors;
		}
		
		int count = -1;
		try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
			myQry.setString(1, newCity);
			
			if (newAge == -1) {
				myQry.setString(2, name);
			} else {
				myQry.setInt(2, newAge);
				myQry.setString(3, name);
			}

			count = myQry.executeUpdate();
		} catch (SQLException e) {
					System.out.println("updateActors exception for statement");
					e.printStackTrace();
				}
		
		return count;
	}
	
	public int updateActorsCity(
			String oldCity, 
			String newCity) { 
			
		int count = -1;
		try (PreparedStatement myQry = this._connection.prepareStatement(updateActorsCity)) {
			myQry.setString(1, oldCity);
			myQry.setString(2, newCity);
			count = myQry.executeUpdate();
		} catch (SQLException e) {
					System.out.println("updateActors exception for statement");
					e.printStackTrace();
				}
		
		return count;
	}
	
	
	public int deleteActors(
			int address_id) {
		
		int count = -1;
		try (PreparedStatement myQry = this._connection.prepareStatement(deleteActors)){
			myQry.setInt(1, address_id);
			count = myQry.executeUpdate();
		
		}catch (SQLException e) {
			System.out.println("deleteActor exception for statement");
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public String toJson() {
		String beansContent = "";
		for (actorBean ab : this._actors) {
			beansContent += ab.toJson() + ",";
		}
		
		return jsonHelper
			.toJsonArray("Actors", beansContent);
	}

 	private actorBean buildActor(ResultSet rs) {
		actorBean ab = new actorBean();

		try {
			ab.setId(rs.getInt("actor_id"));
			ab.setAge(rs.getInt("actor_age"));
			ab.setName(rs.getString("actor_name"));
			ab.setHometown(rs.getString("hometown"));
			ab.setAddressId(rs.getInt("address_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ab;
	}
	
 	private void buildActors(ResultSet rs) throws SQLException {
 		while(rs.next()) {
			this._actors.add(buildActor(rs));
		}
 	}
 	
 	private void runQuery(PreparedStatement query) {
		try (ResultSet rs = query.executeQuery()) {
			buildActors(rs);
		} catch (SQLException e) {
			System.out.println("getActors exception for result set");
			e.printStackTrace();
		}

 	}

	public String getCreateActors() {
		return createActors;
	}

	public void setCreateActors(String createActors) {
		this.createActors = createActors;
	}
}