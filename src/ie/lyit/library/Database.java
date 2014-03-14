package ie.lyit.library;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Class for initializing the database connection and handling the reads/writes.
 */
public class Database {
	private Connection connection;
	private Statement stmt;
	private Statement updateStmt;
	
	public Database() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:library.sqlite"); // Connect to library.sqlite (should be in local dir)
			stmt = connection.createStatement();
			updateStmt = connection.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Searches the database for a book based on its title. Returns the book if a match has been found.
	 * @param title The title to search for.
	 * @return The book, if a match has been found.
	 * @throws SQLException
	 */
	public Book getBookByTitle(String title) throws SQLException {
		ResultSet results = stmt.executeQuery("SELECT * FROM BOOK WHERE TITLE = '" +title +"'");
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
	
	/**
	 * Search the database for a book that matches the given ISBN, and return it.
	 * @param ISBN The ISBN to search for.
	 * @return The book with the matching ISBN.
	 * @throws SQLException
	 */
	public Book getBookByISBN(int ISBN) throws SQLException {
		ResultSet results = stmt.executeQuery("SELECT * FROM BOOK WHERE ISBN = '" +ISBN +"'");
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
	
	/**
	 * Create a new member with the given parameters.
	 * @param userName Username selected by the user.
	 * @param password User's password.
	 * @throws SQLException
	 */
	public void registerUser(String userName, String password) throws SQLException {
		updateStmt.executeUpdate("INSERT INTO Member (MemberID, Password)"
				+ " VALUES('" +userName +"', '"+ password +"');");
		closeConnection();
	}
	
	/**
	 * Verifies the login details entered by a user on the login screen.
	 * @param userName Username entered.
	 * @param password Password entered.
	 * @return True or false depending on whether the details are correct or not.
	 * @throws SQLException 
	 */
	public boolean validLogin(String userName, String password) throws SQLException {
		ResultSet results;
		String userPass = new String();
		try {
			results = stmt.executeQuery("SELECT * FROM MEMBER WHERE MemberID = '" +userName +"';");
			userPass = results.getString("Password");
			closeConnection();
			
			return password.equals(userPass);
			
		} catch (SQLException e) {
			closeConnection();
			return false;
		}
		
		
	}
	
	public boolean validLoginLibrarian(String librararianID, String password) throws SQLException {
		ResultSet results;
		String userPass = new String();
		try {
			results = stmt.executeQuery("SELECT * FROM LIBRARIAN WHERE LibrarianId = '" +librararianID +"';");
			userPass = results.getString("Password");
		} catch (SQLException e) {
			closeConnection();
			return false;
		}
		
		
		if (password.equals(userPass)) {
			closeConnection();
			return true;
		}
		
		else {
			closeConnection();
			return false;
		}
	}
	
	/**
	 * Create a new loan record in the database, using the fields provided in the given Loan object.
	 * @param l Loan object to be added to the database.
	 * @throws SQLException
	 */
	public void createLoan(Loan l) throws SQLException {
		updateStmt.executeUpdate("INSERT INTO Loan(LoanID, LoanDate, DueDate, MemberID, ISBN)"
				+ "VALUES('" +Loan.getLoanID() +"', '" +l.getLoanDate() +"', '" +l.getDueDate() +"', '" +l.getMemberID() +"'," +l.getISBN() +"'" );
		
		closeConnection();
	}
	
public void addBook(int isbn, String author, String title,String date, String desc, String publisher, String genre, String image, int quantity)  {
		
		
		try{
			
			updateStmt.executeUpdate("INSERT INTO BOOK VALUES('" +isbn +"', '" +author+"','"+title+"','"+date+"','"+desc+"','"+publisher+"','"+genre+"','"+image+"','"+quantity+"')");
			JOptionPane.showMessageDialog(null, "Success");
			closeConnection();
			
			
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "All Fields Must Contain Data");
			
		}
	}
	
	
	public void getColumns(){
		
		try {
			ResultSet results = stmt.executeQuery("SELECT * FROM book");
			
			// Get resultset metadata
			
			ResultSetMetaData metadata = results.getMetaData();
			
			int columnCount = metadata.getColumnCount();
			
			 
			System.out.println("book columns : ");
			// Get the column names; column indices start from 1
			
			for (int i=1; i<=columnCount; i++) {
			
			  String columnName = metadata.getColumnName(i);
			  System.out.println(columnName);
			}
		 }
		catch (SQLException e) {
			
			  System.out.println("Could not retrieve database metadata " + e.getMessage());
			
		}
			
	}

	
	public ArrayList<Book> select()throws SQLException{
		
		ResultSet results = stmt.executeQuery("SELECT * FROM BOOK");
		int bookISBN = 0;
		String author = new String();
		String bookTitle = new String();
		int publishedYear = 0;
		String genre = new String();
		String description = new String();
		String publisher = new String();
		ArrayList<Book> temp = new ArrayList<Book>();
		
		while(results.next()) {
			bookISBN = results.getInt("ISBN");
			author = results.getString("Author");
			bookTitle = results.getString("Title");
			publishedYear = results.getInt("Year_Published");
			genre = results.getString("Genre");
			description = results.getString("Description");
			publisher = results.getString("Publisher");
			
			temp.add(new Book(bookISBN, author, bookTitle, publishedYear, genre, description, publisher));
		}
		
		return temp;
	}
	
	public void removeBook(int isbn){
		try{
			updateStmt.executeUpdate("DELETE FROM BOOK WHERE ISBN = "+isbn);
			closeConnection();
			JOptionPane.showMessageDialog(null, "Book Was Deleted");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Book Not Found");
		}
		
			//DELETE FROM Registration " +WHERE id = 101;
		
	}
	
	/**
	 * Closes the connection to the SQLite database.
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		connection.close();
	}
}