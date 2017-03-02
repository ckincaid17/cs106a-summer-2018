
public class StudentEmailAddress {

	private String studentName = null;
	private String emailAddress = null;
	
	public StudentEmailAddress(String name, String email) {
		studentName = name;
		emailAddress = email;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
}
