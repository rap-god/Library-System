package ie.lyit.library;

/**
 * This class is for creating and initiliasing Member objects.
 * Contains fields for the Member ID and a boolean indicating if 
 * they are currently logged on or not.
 * 
 * Also records which member (if any) is currently logged on.
 * 
 * @author Sean Morris
 *
 */
public class Member {
	
	//Declare variables
	private String memberID;
	static boolean loggedOn;
	private static Member currentMember;
	
	/**
	 * Constructor for initiliasing the member. Reads in the member ID
	 * and creates the member. Also sets Logged On to true, because a
	 * member is only created when registering or logging on.
	 * @param i The member's (unique) ID.
	 */
	public Member(String i){
		memberID = i;
		loggedOn = true;
	}
	
	/**
	 * Method for returning the member's ID.
	 * @return Member's ID
	 */
	public String getMemberID() {
		return memberID;
	}
	
	/**
	 * Method for setting the member's ID.
	 * @param memberID The member's ID.
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	/**
	 * Method that returns the details of the member that is currently logged on.
	 * @return The currently logged on member.
	 */
	public static Member getCurrentMember() {
		return currentMember;
	}
	
	/**
	 * Method for setting which member is currently logged on.
	 * @param m Member that is currently logged on.
	 */
	public static void setCurrentMember(Member m) {
		currentMember = new Member(m.getMemberID());
	}
	
	/**
	 * Method used for "logging out" the user.
	 * Sets the current member to null and sets loggedOn to false.
	 */
	public static void logOut() {
		currentMember = null;
		loggedOn = false;
	}
	
	@Override
	public String toString() {
		return "Member [memberID=" + memberID +"]";
	}
}
