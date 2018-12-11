package adf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author G
 */

//Semi-Singleton
public class DatabaseConnection {
	private static Connection connection;
	
	private DatabaseConnection() {
		//Disabled
	};
	
	public static Connection getActiveConnection() {
		try {
			//Not required since JDK 1.6
			Class.forName(Database.ORACLE_THIN.getClassName());
			connection = DriverManager.getConnection(
					String.format(Database.ORACLE_THIN.getURL(), "localhost","1521", "orcl"), //Static information (will be declared as constants later)
					"HR", //Fed as input (in the installation page)
					"oracle"); //Fed as input (in the installation page)
			return connection;
					
		} catch (ClassNotFoundException | SQLException e) {
			//Handled for now (should be re-thrown)
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
