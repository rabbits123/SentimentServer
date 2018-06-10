package sentiment.json.type;

public class Lecturer {
	private int ID;
	private String lecturerName;
	private String gender;
	private String dateOfBirth;
	
	
	public Lecturer(int iD, String lecturerName, String gender, String dateOfBirth) {
		super();
		ID = iD;
		this.lecturerName = lecturerName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLecturerName() {
		return lecturerName;
	}
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
