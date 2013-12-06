import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database {
	 static Connection con = null;
	public static void connectDatabase(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(
			                     "jdbc:mysql://localhost:3306/mule",
			                     username,
			                     password);	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addToDatabase(String value){
	    Statement stmt = null;
	    try {
		stmt = con.createStatement();	
		String s = "INSERT INTO `store` (`key` ,`load`) VALUES ('primary', '" + value + "') ON DUPLICATE KEY UPDATE `load` = '" + value +"'";
		stmt.addBatch(s);
		stmt.executeBatch();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public static String getStringDatabase(){
	    Statement stmt = null;
	    String result = null;
	    try {
		stmt = con.createStatement();	
		String s = "SELECT * FROM store ";
		ResultSet rs = stmt.executeQuery(s);
		 while (rs.next()) {
		        result = rs.getString("load");
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	    
	    return result;
	}   
	
	public static void main(String[] args) {
		
		Database.connectDatabase("root", "q1w2e3r4");
		Database.addToDatabase("1111");
		String a = getStringDatabase();
		Database.addToDatabase("2222");
		String b = getStringDatabase();
		System.out.println(a);
		System.out.println(b);
	}
}