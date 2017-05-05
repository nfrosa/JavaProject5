import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Project5 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean startProgram = false;
		ArrayList<String> dictionary = new ArrayList<String>();
		ArrayList<String> essay = new ArrayList<String>();
		String fileName = null;
		while (startProgram == false) {
			System.out.println("Please specify the name of the file that contains the dictionary information.");
			fileName = console.next();
			if (fileName.equals("Finished")) {
				break;
			}
			try {
				File file = new File(fileName + ".txt");
				Scanner input = new Scanner(file);
				while (input.hasNext()) {
					dictionary.add(input.nextLine().toLowerCase());
				}
				input.close();
				startProgram = true;
				System.out.println("File opened successfully!");
			} catch (FileNotFoundException ex) {
				System.out.println("File " + fileName + " cannot be found!");
			}
		}
		String studentInfo = "";
		while (!studentInfo.equals("Finished")) {
			essay.clear();
			System.out.println("Please specify the ID of the student whose essay will be graded.");
			studentInfo = console.next();
			if (studentInfo.equalsIgnoreCase("Finished")) {
				break;
			}
			Student newStudent = new Student(null, 0);
			try {
				File file = new File(studentInfo + ".txt");
				Scanner input = new Scanner(file);
				String essayString = "";
				while (input.hasNext()) {
					// taking in student info
					String studentType = input.nextLine();
					String studentName = input.nextLine();
					String studentID = input.nextLine();
					if (studentType.equals("Graduate Student")) {
						GraduateStudent student = new GraduateStudent(null, 0, null, null);
						String studentMajor = input.nextLine();
						String advisor = input.nextLine();
						while (input.hasNext()) {
							essayString += input.nextLine().toLowerCase();
						}
						student.name = studentName;
						student.IDno = studentID;
						student.gradMajor = studentMajor;
						student.gradAdvisor = advisor;
						newStudent = student;
						System.out.println("File opened successfully!");
					} else if (studentType.equals("HighSchool Student")) {
						HighSchoolStudent student = new HighSchoolStudent(null, 0, null);
						String school = input.nextLine();
						while (input.hasNext()) {
							essayString += input.nextLine().toLowerCase();
						}
						student.name = studentName;
						student.IDno = studentID;
						student.school = school;
						newStudent = student;
						System.out.println("File opened successfully!");
					} else if (studentType.equals("Undergraduate Student")) {
						UndergraduateStudent student = new UndergraduateStudent(null, 0, null);
						String studentMajor = input.nextLine();
						while (input.hasNext()) {
							essayString += input.nextLine().toLowerCase();
						}
						student.name = studentName;
						student.IDno = studentID;
						student.studentMajor = studentMajor;
						newStudent = student;
						System.out.println("File opened successfully!");
					}
				}
				// formatting essay
				essayString = essayString.replaceAll("[.,?:;!]", " ");
				String[] essayArray = essayString.split(" ");
				for (int i = 0; i < essayArray.length; i++) {
					if (!essayArray[i].equals("")) {
						essay.add(essayArray[i]);
					}
				}
				input.close();
			} catch (FileNotFoundException ex) {
				System.out.println("File " + studentInfo + " cannot be found!");
				continue;
			}
			//formatting dictionary
			for (int i = 0; i < dictionary.size(); i++) {
				dictionary.set(i, dictionary.get(i).replaceAll("\\W", ""));
			}
			ArrayList<String> mispelledWords = new ArrayList<String>();
			for (int i = 0; i < essay.size(); i++) {
				essay.set(i, essay.get(i).replaceAll("\\W", ""));
			}
			File gradedEssay = new File(newStudent.IDno + "_graded.txt");
			int score;
			int mispelled;
			try {
				mispelledWords.clear();
				PrintWriter output = new PrintWriter(gradedEssay);
				output.print(newStudent.toString());
				score = 100;
				mispelled = 0;
				for (int i = 0; i < essay.size(); i++) {
					if (dictionary.contains(essay.get(i))) {
					} else {
						if (newStudent instanceof GraduateStudent) {
							score -= 5;
							mispelled++;
							mispelledWords.add(essay.get(i));
						} else if (newStudent instanceof UndergraduateStudent) {
							score -= 3;
							mispelled++;
							mispelledWords.add(essay.get(i));
						} else if (newStudent instanceof HighSchoolStudent) {
							score -= 1;
							mispelled++;
							mispelledWords.add(essay.get(i));
						}
					}

				}
				output.println("\r\nReceived a score of " + score + " with " + mispelled + " misspelled words:");
				for (int i = 0; i < mispelledWords.size(); i++) {
					output.println("(" + (i + 1) + ")" + mispelledWords.get(i));
				}
				output.close();
			} catch (Exception e) {

			}
		}
	}

}
