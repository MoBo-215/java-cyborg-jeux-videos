package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static String dburl="jdbc:mysql://localhost:3306/ecf_jv";
	private static String dbuser="root";
	private static String dbpass="";
	public static Connection connexion=null;
	
	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Driver OK");
			connexion=DriverManager.getConnection(dburl,dbuser,dbpass);
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("PROBLEME MYSQL DRIVER");
        }
	}
}
