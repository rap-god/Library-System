package ie.lyit.library;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Class for initializing the database connection and handling the reads/writes.
 */
public class Database {
	private Connection connection;
	private static Statement stmt;
	private Statement updateStmt;
	public static ArrayList<Book> books = new ArrayList<Book>();
	String n ="", e="";
	String b;
	int isbn;
	String g;
	String image;
	String category;
	
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
	
	public void createLoan(Loan l) {
		try {
			updateStmt.executeUpdate("INSERT INTO LOAN(LoanID, LoanDate, DueDate, MemberID, ISBN) "
					+ "VALUES('" +l.getLoanID() +"', '" +l.getLoanDate() +"', '" +l.getDueDate() +"', '" +l.getMemberID() +"', '" +l.getISBN() +"');");
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Loan> getLoans(String memberID) {
		ArrayList<Loan> totalLoans = new ArrayList<Loan>();
		ResultSet results;
		try {
			results = stmt.executeQuery("SELECT * FROM LOAN WHERE MemberID = '" +memberID +"';");
			
			while (results.next()) {
				int loanID = results.getInt("LoanID");
				String loanDate = results.getString("LoanDate");
				String dueDate = results.getString("DueDate");
				int ISBN = results.getInt("ISBN");
				totalLoans.add(new Loan(loanID, loanDate, dueDate, memberID, ISBN));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return totalLoans;
	}
	
	public int getLastLoanID() {
		int lastID = -1;
		ResultSet results;
		
		try {
			results = stmt.executeQuery("SELECT * FROM LOAN WHERE LoanID = (SELECT MAX(LoanID) FROM LOAN);");
			
			while(results.next()) {
				lastID = results.getInt("LoanID");
			}
				
			return lastID;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
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
	public String validLogin(String userName, String password) throws SQLException {
		try{
			ResultSet results;
			String userPass;
			// Check if the user is an admin first
			results = stmt.executeQuery("SELECT * FROM MEMBER WHERE MemberID = '" +userName +"';");
			userPass = results.getString("Password");
			
			String isLibrarian = results.getString("Is_Librarian");
			System.out.println(isLibrarian);
			
			if(isLibrarian.equals("true") && password.equals(userPass)) {
				closeConnection();
				return "Librarian";
			}
			
			else if(isLibrarian.equals("false") && password.equals(userPass)) {
				closeConnection();
				return "Member";
			}
			
			else{
				closeConnection();
				return "Invalid!";
			}
		}
		
		catch(SQLException e) {
			closeConnection();
			return "Invalid";
		}
	}
	
	public void addBook(int isbn, String author, String title,String date, String desc, String publisher, String genre, String image)  {	
		try{		
			updateStmt.executeUpdate("INSERT INTO BOOK VALUES('" +isbn +"', '" +author+"','"+title+"','"+date+"','"+desc+"','"+publisher+"','"+genre+"','"+image+"')");
			JOptionPane.showMessageDialog(null, "Success");									
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "All Fields Must Contain Data");
		}
	}
	
	public ArrayList<String> getMembers() {
		ResultSet results;
		try{
			results = stmt.executeQuery("SELECT MemberID FROM Member");
			ArrayList<String> memberNames = new ArrayList<String>();
			
			while(results.next()) {
				memberNames.add(results.getString("MemberID"));
			}
			return memberNames;
		}
		
		catch(SQLException e) {
			return null;
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
	
	public void removeBook(int isbn){
		try{
			updateStmt.executeUpdate("DELETE FROM BOOK WHERE ISBN = "+isbn);
			//closeConnection();
			JOptionPane.showMessageDialog(null, "Book Was Deleted");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Book Not Found");
		}	
	}
	
	/**
	 * Closes the connection to the SQLite database.
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	//Public method to populate JTable with Books
	public void populateTable(DefaultTableModel j) throws SQLException{
		ResultSet results = stmt.executeQuery("SELECT * FROM BOOK");
		while(results.next()){
			isbn = results.getInt("ISBN");
			n = results.getString("Author");
			e = results.getString("Title");
			b = results.getString("Genre");
			j.addRow(new Object[]{isbn,n, e, b});
			
		}
		
	}
	
	public void returnLoan(int loanID) {
		try {
			Date now = new Date();
			//String returnDate = new SimpleDateFormat("dd-MM-yyyy").format(now);
			updateStmt.executeUpdate("DELETE FROM Loan WHERE LoanID = '" +loanID +"'");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchBooks(String value, DefaultTableModel j) throws SQLException{
		
		ResultSet results = stmt.executeQuery("Select * from book where title like'%"+value+"%' or author like'%"+value+"%'");
		while(results.next()){
			isbn = results.getInt("ISBN");
			n = results.getString("Author");
			e = results.getString("Title");
			b = results.getString("Genre");
			
			j.addRow(new Object[]{isbn,n, e, b});
			
		}
		
	}
	
	public String getImage(int isbn) throws SQLException{
		ResultSet results = stmt.executeQuery("Select ImagePath from book where isbn="+isbn);
		while(results.next()){
		image = results.getString("ImagePath");
		}
		return image;
	}
	
	// return Genres from database
	public ArrayList<String> getCategory() throws SQLException{
		ArrayList<String> test = new ArrayList<String>();
		
		ResultSet results = stmt.executeQuery("Select genre from book");
		while(results.next()){
			category = results.getString("Genre");
			if(test.contains(category)){
				
			}
			else{
				test.add(category);
			}
		}
		return test;
	}
	public void searchByGenre(String genre, DefaultTableModel j) throws SQLException{
		
		ResultSet results = stmt.executeQuery("Select ISBN, Author, Title, Genre from book where genre ='"+genre+"'");
		while(results.next()){
			isbn = results.getInt("ISBN");
			n = results.getString("Author");
			e = results.getString("Title");
			g = results.getString("Genre");
			j.addRow(new Object[]{isbn,n, e, g});
		}
	}
	public void detailedSearch(String genre, DefaultTableModel j, String value) throws SQLException{
		ResultSet results = stmt.executeQuery("Select ISBN, Author, Title, Genre from book where genre='"+genre+"' and (title like'%"+value+"%' or author like'%"+value+"%')");
		while(results.next()){
			isbn = results.getInt("ISBN");
			n = results.getString("Author");
			e = results.getString("Title");
			g = results.getString("Genre");
		
			j.addRow(new Object[]{isbn,n, e, g});
		
		}
	}
	public void populateComboBox(DefaultComboBoxModel j) throws SQLException{
		ResultSet results = stmt.executeQuery("SELECT genre FROM BOOK");
		ArrayList<String> temp = new ArrayList<String>();
		j.addElement("-All books-");
		while(results.next()){
			category = results.getString("Genre");
			if(temp.contains(category)){
				
			}
			else{
				temp.add(category);
				j.addElement(category);
			}	
		}
	}
}