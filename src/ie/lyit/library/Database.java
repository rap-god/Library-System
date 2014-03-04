package ie.lyit.library;

import java.sql.*;

/**
 * Class for initializing the database connection and handling the reads/writes.
 */
public class Database {
	private Connection connection;
	private Statement stmt;
	private ResultSet results;
	
	public Database() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:library.sqlite"); // Connect to library.sqlite (should be in local dir)
			stmt = connection.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Book getBookByTitle(String title) throws SQLException {
		results = stmt.executeQuery("SELECT * FROM BOOK WHERE TITLE = '" +title +"'");
		int ISBN = 0;
		String author = new String();
		String bookTitle = new String();
		int publishedYear = 0;
		String genre = new String("Novel");
		//int loanID = 0;
		String description = new String();
		String publisher = new String();
		
		while(results.next()) {
			ISBN = results.getInt("ISBN");
			author = results.getString("Author");
			bookTitle = results.getString("Title");
			publishedYear = results.getInt("Year_Published");
			//genre = results.getString("Genre");
			//loanID = results.getInt("LoanID");
			description = results.getString("Description");
			publisher = results.getString("Publisher");
		}
		
		Book b1 = new Book(ISBN, author, bookTitle, publishedYear, genre, description, publisher);
		
		//b1.setLoanID(loanID);
		return b1;
	}
	/*
	public void addBook(Book b) {
		stmt.executeUpdate("")
	}*/
}