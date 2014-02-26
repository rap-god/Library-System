package ie.lyit.library;
import java.sql.*;
 
public class Database { 
	
	public static void main(String args[]) { 
		Connection con; 

		try{ 
		   Class.forName("com.mysql.jdbc.Driver"); 
		   con = DriverManager.getConnection("jdbc:mysql:///test", "root", "password"); 
		   Statement stmt = con.createStatement();  
		}
		catch(ClassNotFoundException e){ 
		   System.out.println(e.toString());
		} 
		
		catch(SQLException e){ 
		System.out.println(e.toString()); 
		} 
	
	}
} 