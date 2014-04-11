package ie.lyit.library;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * Class for instantiating a new Loan object.
 */

public class Loan {
	Database data = new Database();
	private int lastLoanID;
	private int loanID;
	private String loanDate;
	private String dueDate;
	private String returnDate;
	private String memberID;
	private int ISBN;

	/**
	 * Constructor for creating a Loan object
	 * 
	 * @param loanDate
	 *            The date the loan was taken out.
	 */
	public Loan(String memberID, int ISBN) {
		Date currentDate = new Date();
		Date incrementDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 14);
		incrementDate = c.getTime();
		this.loanDate = new SimpleDateFormat("dd-MM-yyyy").format(currentDate);
		this.dueDate = new SimpleDateFormat("dd-MM-yyyy").format(incrementDate);
		this.memberID = memberID;
		this.ISBN = ISBN;
		lastLoanID = data.getLastLoanID();
		loanID = ++lastLoanID;
	}

	public Loan(int loanID, String loanDate, String dueDate, String memberID,
			int ISBN) {
		this.loanID = loanID;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
		this.memberID = memberID;
		this.ISBN = ISBN;
	}

	/**
	 * Retrieve the unique loan ID
	 * 
	 * @return The loan's ID
	 */
	public int getLoanID() {
		return loanID;
	}

	/**
	 * Retrieve the date the loan was taken out on.
	 * 
	 * @return The date the loan was taken out.
	 */
	public String getLoanDate() {
		return loanDate;
	}

	/**
	 * Retrieve the date the loan is due for.
	 * 
	 * @return The due date of the loan.
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Set the loan's due date.
	 * 
	 * @param dueDate
	 *            The loan's due date.
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Retrieve the date the item loaned was actually returned.
	 * 
	 * @return The date the item was returned.
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * Set the return date.
	 * 
	 * @param returnDate
	 *            The item's return date.
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Retrieve the ID of the member who has taken out the loan.
	 * 
	 * @return ID of the member who has taken out the loan.
	 */
	public String getMemberID() {
		return memberID;
	}

	/**
	 * Retrieves the ISBN of the book being loaned out.
	 * 
	 * @return ISBN of the book being taken out on loan.
	 */
	public int getISBN() {
		return ISBN;
	}

	public Book getLoanedBook(int ISBN) {

		try {
			Database data = new Database();
			return data.getBookByISBN(ISBN);
		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Book Not found!");
			return null;
		}

	}

	@Override
	public String toString() {
		return loanID + ": " + loanDate + " Due:" + dueDate + " "
				+ getLoanedBook(ISBN).getTitle();
	}

}
