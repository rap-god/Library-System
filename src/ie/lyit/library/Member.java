package ie.lyit.library;

public class Member {
	
	//Declare variables
	private String memberID;
	private String name;
	private int reservationID;
	private int loanID;
	static boolean loggedOn;
	
	//Constructors
	public Member(String i , String n){
		memberID = i;
		name = n;
		loggedOn = true;
	}
	
	public Member(String i, String n, int r, int l ){
		memberID = i;
		name = n;
		reservationID = r;
		loanID = l;
		loggedOn = true;
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getReservationID() {
		return reservationID;
	}
	
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	
	public int getLoanID() {
		return loanID;
	}
	
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	
	public boolean isLoggedOn() {
		return loggedOn;
	}
	
	public static void logOut() {
		loggedOn = false;
	}
	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", name=" + name
				+ ", reservationID=" + reservationID + ", loanID=" + loanID
				+ "]";
	}
}
