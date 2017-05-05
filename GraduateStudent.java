
public class GraduateStudent extends Student {
	public String gradMajor;
	public String gradAdvisor;

	public String getMajor() {
		return gradMajor;
	}

	public void setMajor(String major) {
		gradMajor = major;
	}

	public String getAdvisor() {
		return gradAdvisor;
	}

	public void setAdvisor(String advisor) {
		gradAdvisor = advisor;
	}

	public String toString() {
		String attributes = "Graduate Student " + name + "\r\nStudent ID: " + IDno + "\r\nMajor: " + gradMajor
				+ "\r\nAdvisor: " + gradAdvisor;
		return attributes;
	}

	public GraduateStudent(String n, int id, String major, String advisor) {
		super(n, id);
		gradMajor = major;
		gradAdvisor = advisor;
	}
}
