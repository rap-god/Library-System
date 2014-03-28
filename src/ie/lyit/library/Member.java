package ie.lyit.library;

public class Member {
	
	//Declare variables
	private String memberID;
	static boolean loggedOn;
	private static Member currentMember;
	
	//Constructors
	public Member(String i){
		memberID = i;
		loggedOn = true;
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public static Member getCurrentMember() {
		return currentMember;
	}
	
	public static void setCurrentMember(Member m) {
		currentMember = new Member(m.getMemberID());
	}
	
	public static void logOut() {
		loggedOn = false;
	}
	
	@Override
	public String toString() {
		return "Member [memberID=" + memberID +"]";
	}
}
