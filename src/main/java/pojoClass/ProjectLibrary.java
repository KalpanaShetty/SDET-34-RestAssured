package pojoClass;

/**
 * This is pojo class for RMGYANTRA Project APIs
 * @author Chaitra M
 *
 */
public class ProjectLibrary {

	//declare the variables globally
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	//create constructor to initialise
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	
    //Generate getters and setters to access the variables 
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	
	
	
	
	

}
