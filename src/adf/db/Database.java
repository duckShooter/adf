package adf.db;

public final class Database {
	
		//Visible within this packages only
	 	final static class DatabaseInfo {
		private String URL;
		private String className;
		
		public DatabaseInfo(String URL, String className) {
			this.URL = URL;
			this.className = className;
		}

		public String getURL() {
			return URL;
		}

		public String getClassName() {
			return className;
		}
	}
	
	//jdbc:mysql://<host>:<port>/<dbname>
	public static final DatabaseInfo MYSQL = new DatabaseInfo(
			"jdbc:mysql://%s:%s/%s", 
			"com.mysql.jdbc.Driver");
	
	//jdbc:postgresql://<host>:<port>/<dbname>
	public static final DatabaseInfo POSTGRESQL = new DatabaseInfo(
				"jdbc:postgresql://%s:%s/%s", 
				"org.postgresql.Driver");
	
	//jdbc:oracle:thin:@<host>:<port>:<dbname>
	public static final DatabaseInfo ORACLE_THIN = new DatabaseInfo(
				"jdbc:oracle:thin:@%s:%s:%s", 
				"oracle.jdbc.driver.OracleDriver");
	
	//jdbc:oracle:oci:@<host>:<port>/<dbname>
	public static final DatabaseInfo ORACLE_OCI = new DatabaseInfo(
					"jdbc:oracle:oci:@%s:%s/%s", 
					"oracle.jdbc.driver.OracleDriver");
	
	//jdbc:weblogic:mssqlserver4:<dbname>@<host>:<port>
	public static final DatabaseInfo SQLSERVER_WEBLOGIC = new DatabaseInfo(
			"jdbc:weblogic:mssqlserver4:%s@%s:/%s", 
			"weblogic.jdbc.mssqlserver4.Driver");
	
	//jdbc:inetdae:<host>:<port>?database=<dbname>
	public static final DatabaseInfo SQLSERVER_SPRINTA = new DatabaseInfo(
			"jdbc:inetdae:%s:%s?database=%s", 
			"com.inet.tds.TdsDriver");
	
	//jdbc:JTurbo://<host>:<port>/<dbname>
	public static final DatabaseInfo SQLSERVER_JTURBO = new DatabaseInfo(
			"jdbc:JTurbo://%s:%s/%s", 
			"com.ashna.jturbo.driver.Driver");
	
	//jdbc:sqlserver://<host>:<port>;databaseName=<dbname>
	public static final DatabaseInfo SQLSERVER_MS = new DatabaseInfo(
			"jdbc:sqlserver://%s:%s;databaseName=%s", 
			"com.microsoft.jdbc.sqlserver.SQLServerDriver");
	
}
