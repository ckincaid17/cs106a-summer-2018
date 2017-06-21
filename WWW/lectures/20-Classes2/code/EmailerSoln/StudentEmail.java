
public class StudentEmail {

	private String email;
	private String name;
	
	public StudentEmail(String name, String emailAddress) {
		this.email = emailAddress;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
}
