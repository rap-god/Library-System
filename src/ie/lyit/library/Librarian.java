package ie.lyit.library;

public class Librarian {

	private String librarianID;
	static boolean loggedOn;
	
	//Constructors
	public Librarian(String i , String n){
		librarianID = i;
		loggedOn = true;
	}
	
	
	public String getLibrarianID() {
		return librarianID;
	}
	
	public void setLibrarianID(String librarianID) {
		this.librarianID = librarianID;
	}
	
	
	
	public boolean isLoggedOn() {
		return loggedOn;
	}
	
	public static void logOut() {
		loggedOn = false;
	}
	@Override
	public String toString() {
		return "Member [memberID=" + librarianID + "]";
	}
}
