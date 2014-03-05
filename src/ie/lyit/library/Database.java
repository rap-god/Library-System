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
		String genre = new String();
		String description = new String();
		String publisher = new String();
		
		while(results.next()) {
			ISBN = results.getInt("ISBN");
			author = results.getString("Author");
			bookTitle = results.getString("Title");
			publishedYear = results.getInt("Year_Published");
			genre = results.getString("Genre");
			description = results.getString("Description");
			publisher = results.getString("Publisher");
		}
		
		Book b1 = new Book(ISBN, author, bookTitle, publishedYear, genre, description, publisher);
		
		return b1;
	}
	
	public Book getBookByISBN(int ISBN) throws SQLException {
		results = stmt.executeQuery("SELECT * FROM BOOK WHERE ISBN = '" +ISBN +"'");
		int bookISBN = 0;
		String author = new String();
		String bookTitle = new String();
		int publishedYear = 0;
		String genre = new String();
		String description = new String();
		String publisher = new String();
		
		while(results.next()) {
			bookISBN = results.getInt("ISBN");
			author = results.getString("Author");
			bookTitle = results.getString("Title");
			publishedYear = results.getInt("Year_Published");
			genre = results.getString("Genre");
			description = results.getString("Description");
			publisher = results.getString("Publisher");
		}
		
		Book b1 = new Book(bookISBN, author, bookTitle, publishedYear, genre, description, publisher);
		

		return b1;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	/*
	public void addBook(Book b) {
		stmt.executeUpdate("")
	}*/
}