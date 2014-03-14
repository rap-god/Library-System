package ie.lyit.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Class for instantiating a new Loan object. 
 * @author Sean Morris
 *
 */

public class Loan {
	static int loanID = 0;
	private String loanDate;
	private String dueDate;
	private String returnDate;
	private String memberID;
	private int ISBN;
	
	/**
	 * Constructor for creating a Loan object
	 * @param loanDate The date the loan was taken out.
	 */
	public Loan(String memberID, int ISBN) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		loanDate = formatter.format(currentDate.getTime());
		currentDate.add(Calendar.DATE, 14);
		dueDate = formatter.format("dd/MM/yyyy");
		this.memberID = memberID;
		this.ISBN = ISBN;
	}

	/**
	 * Retrieve the unique loan ID
	 * @return The loan's ID
	 */
	public static int getLoanID() {
		return loanID;
	}

	/**
	 * Retrieve the date the loan was taken out on.
	 * @return The date the loan was taken out.
	 */
	public String getLoanDate() {
		return loanDate;
	}

	/**
	 * Retrieve the date the loan is due for.
	 * @return The due date of the loan.
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Set the loan's due date.
	 * @param dueDate The loan's due date.
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Retrieve the date the item loaned was actually returned.
	 * @return The date the item was returned.
	 */
	public String getReturnDate() {
		return returnDate;
	}
	
	/**
	 * Set the return date.
	 * @param returnDate The item's return date.
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Retrieve the ID of the member who has taken out the loan.
	 * @return ID of the member who has taken out the loan.
	 */
	public String getMemberID() {
		return memberID;
	}
	
	/**
	 * Retrieves the ISBN of the book being loaned out.
	 * @return ISBN of the book being taken out on loan.
	 */
	public int getISBN() {
		return ISBN;
	}
	
	@Override
	public String toString() {
		return "Loan [loanDate=" + loanDate + ", dueDate=" + dueDate
				+ ", returnDate=" + returnDate + "]";
	}

}
