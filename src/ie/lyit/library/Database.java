package ie.lyit.library;

import java.sql.*;

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
	 * Closes the connection to the SQLite database.
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		connection.close();
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
	 */
	public boolean validLogin(String userName, String password) {
		ResultSet results;
		String userPass = new String();
		try {
			results = stmt.executeQuery("SELECT * FROM MEMBER WHERE MemberID = '" +userName +"';");
			userPass = results.getString("Password");
			closeConnection();
			
			return password.equals(userPass);
			
		} catch (SQLException e) {
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
	/*public void addBook(Book b) {
		int ISBN = b.getISBN();
		String
		stmt.executeUpdate("INSERT INTO BOOK VALUES(" +ISBN +", " +));
	}
	
	*/
}