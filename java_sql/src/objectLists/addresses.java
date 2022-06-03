package objectLists;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.addressBean;
import helpers.jsonHelper;

public class addresses {
	private Connection _connection;
	private ArrayList<addressBean> _addresses;

	public addresses(Connection cn) {
		this._connection = cn;
		this._addresses = new ArrayList<addressBean>();
		getAddresses();
	}

	public ArrayList<addressBean> getAddresses() {
		String qry = "select * from address";

		if (this._addresses.size() > 0) 
			return this._addresses;
			
		this._addresses = new ArrayList<addressBean>();
		try {
			PreparedStatement myQry = this._connection.prepareStatement(qry);
			ResultSet rs = myQry.executeQuery();
			while(rs.next()) {
				this._addresses.add(buildAddress(rs));
			}
			
			rs.close();
			myQry.close();			
		} catch (SQLException e) {
			System.out.println("getActors exception");
			e.printStackTrace();
		}

		return this._addresses;
	}

	public String toJson() {
		String beansContent = "";
		for (addressBean ab : this._addresses) {
			beansContent += ab.toJson() + ",";
		}

		return jsonHelper
				.toJsonArray("Addresses", beansContent);
	}
	
 	private addressBean buildAddress(ResultSet rs) {
 		addressBean ab = new addressBean();

		try {
			ab.setId(rs.getInt("address_id"));
			ab.setAddress(rs.getString("address"));
			ab.setPostalcode(rs.getString("postalcode"));
			ab.setState(rs.getString("state"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ab;
	}

}