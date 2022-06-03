package java_sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import helpers.databaseHelper;
import helpers.jsonHelper;
import objectLists.actors;
import objectLists.addresses;

public class main_class {
	public static void main(String[] args) throws SQLException {
		Connection conn = databaseHelper.DbConnect("movies");
		
		//ShowAllTables(conn);
		
		//updateActors(conn, "Fredrik Lindah");
		
		//createActors(conn, "Johan tha Teach", "Helsingborg", 39);
		
		//deleteActors(conn, 5);
		
		ShowAllTables(conn);
		
		conn.close();
	}
		
	private static void ShowAllTables(Connection conn) {
		actors myActors = new actors(conn);
		addresses myAddresses = new addresses(conn);
		
		ArrayList<String> document = new ArrayList<String>();
		document.add(myActors.toJson());
		document.add(myAddresses.toJson());

		String jsonDoc = jsonHelper.toJsonObjectFromStrings(document);
		System.out.println(jsonDoc);
	}
	
	private static void updateActors(Connection conn, String name) {
		actors myActors = new actors(conn);
		
		int quantity = myActors.updateActors(name, "Malmo", -1);
		System.out.println("Updated : " + quantity);
		
		quantity = myActors.updateActorsCity("Kiruna", "s%");
		System.out.println("Updated : " + quantity);
	}
	
	private static void createActors(Connection conn, String name, String hometown, int age) {
		actors myActors = new actors(conn);

		myActors.createActors(name, hometown, age);
		System.out.println("Actor created : ");
	}
	
	
	private static void deleteActors(Connection conn, int address_id) {
		actors myActors = new actors(conn);
		myActors.deleteActors(address_id);
	}
	
}
