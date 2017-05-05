
public class UndergraduateStudent extends Student {
	public String studentMajor;

	public String getMajor() {
		return studentMajor;
	}

	public void setMajor(String major) {
		studentMajor = major;
	}

	public String toString() {
		String attributes = "Undergraduate Student " + name + "\r\nStudent ID: " + IDno + "\r\nMajor: " + studentMajor;
		return attributes;
	}

	public UndergraduateStudent(String n, int id, String major) {
		super(n, id);
		studentMajor = major;
	}

}
