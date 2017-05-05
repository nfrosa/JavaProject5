
public class HighSchoolStudent extends Student {
	public String school;

	public String getNameOfSchool() {
		return school;
	}

	public void setNameOfSchool(String schoolName) {
		school = schoolName;
	}

	public String toString() {
		String attributes = "High School Student " + name + "\r\nStudent ID: " + IDno + "\r\nName of School: " + school;
		return attributes;
	}

	public HighSchoolStudent(String n, int id, String schoolName) {
		super(n, id);
		name = n;
		IDno = id + "";
		school = schoolName;
	}
}
