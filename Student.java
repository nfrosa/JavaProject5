
public class Student {

	public String name;
	public String IDno;

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getIDNumber() {
		return IDno;
	}

	public void setIDNumber(int id) {
		IDno = id + "";
	}

	public String toString() {
		String attributes = null;
		return attributes;
	}

	public Student(String n, int id) {
		name = n;
		IDno = id + "";
	}
}
