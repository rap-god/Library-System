package ie.lyit.library;

import java.sql.*;

/**
 * Class for initializing the database connection and handling the reads/writes.
 */
public class Database {

	public static void main(String args[]) {
		
		Connection con; 
		Statement stmt;
		ResultSet rs;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:library.sqlite"); // Connect to library.sqlite (should be in local dir)
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM BOOK"); // Selects everything in the BOOK table

			// Print out fields
			while (rs.next()) {
				int ISBN = rs.getInt("ISBN");
				String author = rs.getString("Author");
				String title = rs.getString("Title");
				int year = rs.getInt("Year_Published");
				System.out.println("ISBN: " + ISBN);
				System.out.println("AUTHOR: " + author);
				System.out.println("TITLE: " + title);
				System.out.println("YEAR: " + year);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
}