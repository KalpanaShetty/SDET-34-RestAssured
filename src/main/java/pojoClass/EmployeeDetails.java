package pojoClass;

/**
 * This class contains emp details 
 * @author Chaitra M
 *
 */
public class EmployeeDetails {
	
	//Step 1: declare the required variables as global
	String eName;
	String eId;
	int ephone;
	String email;
	
	//Step 2: create a constructor to initialise 
	public EmployeeDetails(String eName, String eId, int ephone, String email) {
		this.eName = eName;
		this.eId = eId;
		this.ephone = ephone;
		this.email = email;
	}
	
	//used for deserialization - empty constructor is used to re initailise the class during execution
	public EmployeeDetails()
	{
		
	}

	//Step 3: provide getters and setters
	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public int getEphone() {
		return ephone;
	}

	public void setEphone(int ephone) {
		this.ephone = ephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	

}
