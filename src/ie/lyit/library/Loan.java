package ie.lyit.library;

import java.util.Date;

/**
 * Class for instantiating a new Loan object. 
 * @author Sean Morris
 *
 */

public class Loan {
	static int loanID = 0000;
	private Date loanDate;
	private Date dueDate;
	private Date returnDate;
	
	/**
	 * Constructor for creating a Loan object
	 * @param loanDate The date the loan was taken out.
	 */
	public Loan(Date loanDate) {
		this.loanDate = loanDate;
		loanID++;
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
	public Date getLoanDate() {
		return loanDate;
	}

	/**
	 * Set the loan date
	 * @param loanDate The loan date
	 */
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	/**
	 * Retrieve the date the loan is due for.
	 * @return The due date of the loan.
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * Set the loan's due date.
	 * @param dueDate The loan's due date.
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Retrieve the date the item loaned was actually returned.
	 * @return The date the item was returned.
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Set the return date.
	 * @param returnDate The item's return date.
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Loan [loanDate=" + loanDate + ", dueDate=" + dueDate
				+ ", returnDate=" + returnDate + "]";
	}

}
