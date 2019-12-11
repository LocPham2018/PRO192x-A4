package pro192xa4.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pro192xa4.business.AllowanceCalulator;
import pro192xa4.business.EmployeeManagement;
import pro192xa4.entity.EDegree;
import pro192xa4.entity.EPosition;
import pro192xa4.entity.Employee;
import pro192xa4.entity.Staff;
import pro192xa4.entity.Teacher;

public class PRO192xA4 {

	// create an employee by inputing it's attribute values from keyboard
	static Employee createNewImployee() {
		System.out.print("Do you want to create a Staff or a Teacher (enter S for Staff, otherwise for Teacher)?");
		// accept Staff or Teacher details from keyboard
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		if (choice.equalsIgnoreCase("s")) {
			Staff s = new Staff();
			// input staff details
			// your code
			System.out.print("Name: ");
			String nameInput = scan.nextLine();
			while (!nameInput.matches("^([A-Z][a-z]+)+[' '][A-Z][a-z]+$")) {
				// nameInput example: Tran Van A
				System.out.print("Invalid name. Please try again.\nName: ");
				nameInput = scan.nextLine();
			}
			s.setFullName(nameInput);
			System.out.print("Salary ratio: ");
			String salaryInput = scan.nextLine();
			while (!salaryInput.matches("^[1-9][0-9]*.[0-9]*$")) {
				// salaryInput has the form of float number
				System.out.print("Invalid input. Please try again.\nSalary ratio: ");
				salaryInput = scan.nextLine();
			}
			s.setSalaryRatio(Float.parseFloat(salaryInput));
			System.out.print("Department: ");
			String depInput = scan.next();
			while (!depInput.matches("^[A-Z][A-Za-z]+$")) {
				// depInput only includes letters
				System.out.print("Invalid department. Please try again.\nDepartment: ");
				depInput = scan.nextLine();
			}
			s.setDepartment(depInput);
			System.out.print("Position (1=HEAD, 2=VICE_HEAD, 3=STAFF): ");
			String posInput = scan.nextLine();
			while (!posInput.matches("^[1-3]$")) {
				// posInput must be 1, 2 or 3
				System.out.print("Invalid input. Please try again.\nPosition (1=HEAD, 2=VICE_HEAD, 3=STAFF): ");
				posInput = scan.nextLine();
			}
			switch (Integer.parseInt(posInput)) {
			case 1:
				s.setPosition(EPosition.HEAD);
				break;
			case 2:
				s.setPosition(EPosition.VICE_HEAD);
				break;
			default:
				s.setPosition(EPosition.STAFF);
				break;
			}
			System.out.print("Number of working days: ");
			String dayInput = scan.nextLine();
			while (!dayInput.matches("^[1-9][0-9]*.[0-9]*$")) {
				// dayInput has the form of float number
				System.out.print("Invalid input. Please try again.\nNumber of working days: ");
				dayInput = scan.nextLine();
			}
			s.setNoOfWorkingDay(Float.parseFloat(dayInput));
			return s;

		} else {
			Teacher t = new Teacher();
			// inputs Teacher details
			// your code
			System.out.print("Name: ");
			String nameInput = scan.nextLine();
			while (!nameInput.matches("^([A-Z][a-z]+)+[' '][A-Z][a-z]+$")) {
				// nameInput example: Tran Van A
				System.out.print("Invalid name. Please try again.\nName: ");
				nameInput = scan.nextLine();
			}
			t.setFullName(nameInput);
			System.out.print("Salary ratio: ");
			String salaryInput = scan.nextLine();
			while (!salaryInput.matches("^[1-9][0-9]*.[0-9]*$")) {
				// salaryInput has the form of float number
				System.out.print("Invalid input. Please try again.\nSalary ratio: ");
				salaryInput = scan.nextLine();
			}
			t.setSalaryRatio(Float.parseFloat(salaryInput));
			System.out.print("Faculty: ");
			String facInput = scan.next();
			while (!facInput.matches("^[A-Z][A-Za-z]+$")) {
				// facInput only includes letters
				System.out.print("Invalid faculty. Please try again.\nFaculty: ");
				facInput = scan.next();
			}
			t.setFaculty(facInput);
			System.out.print("Degree (1=BACHELOR, 2=MASTER, 3=DOCTOR): ");
			String degInput = scan.nextLine();
			while (!degInput.matches("^[1-3]$")) {
				// degInput must be 1, 2 or 3
				System.out.print("Invalid input. Please try again.\nDegree (1=BACHELOR, 2=MASTER, 3=DOCTOR): ");
				degInput = scan.nextLine();
			}
			switch (Integer.parseInt(degInput)) {
			case 1:
				t.setDegree(EDegree.BACHELOR);
				break;
			case 2:
				t.setDegree(EDegree.MASTER);
				break;
			default:
				t.setDegree(EDegree.DOCTOR);
				break;
			}
			System.out.print("Number of teaching hours: ");
			String hourInput = scan.nextLine();
			while (!hourInput.matches("^[1-9][0-9]*$")) {
				// hourInput has the form of integer
				System.out.print("Invalid input. Please try again.\nNumber of teaching hours: ");
				hourInput = scan.nextLine();
			}
			t.setTeachingHours(Integer.parseInt(hourInput));
			return t;
		}

	}

	// transfer employee data from text to array list
	static Employee transferData(String[] arr) throws Exception {
		if (arr[0].equalsIgnoreCase("Staff")) {
			Staff s = new Staff();
			s.setFullName(arr[1]);
			s.setDepartment(arr[2]);
			if (arr[3].equalsIgnoreCase("HEAD"))
				s.setPosition(EPosition.HEAD);
			if (arr[3].equalsIgnoreCase("VICE_HEAD"))
				s.setPosition(EPosition.VICE_HEAD);
			if (arr[3].equalsIgnoreCase("STAFF"))
				s.setPosition(EPosition.STAFF);
			s.setSalaryRatio(Float.parseFloat(arr[4]));
			s.setNoOfWorkingDay(Float.parseFloat(arr[6]));
			return s;
		} else {
			Teacher t = new Teacher();
			t.setFullName(arr[1]);
			t.setFaculty(arr[2]);
			if (arr[3].equalsIgnoreCase("BACHELOR"))
				t.setDegree(EDegree.BACHELOR);
			if (arr[3].equalsIgnoreCase("MASTER"))
				t.setDegree(EDegree.MASTER);
			if (arr[3].equalsIgnoreCase("DOCTOR"))
				t.setDegree(EDegree.DOCTOR);
			t.setSalaryRatio(Float.parseFloat(arr[4]));
			t.setTeachingHours(Integer.parseInt(arr[6]));
			return t;
		}
	}

	// display a list of employee
	static void display(ArrayList<Employee> listE) {
		System.out.println("Results:");
		System.out.println("Name, Fac/Dept, Deg/Pos, Sal Ratio, Allowance, T.Hours/W.Days, Salary");
		for (Employee e : listE) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// declare IO variables
		BufferedWriter bw = null;
		FileWriter fw = null;
		BufferedReader br = null;
		FileReader fr = null;

		try {
			File file = new File("data.txt");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("*****Load data: data.txt file not found.");
			}
			// initialize IO variable
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			// create employee management object
			EmployeeManagement empMan = new EmployeeManagement();
			// read data from file and append to empMan
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String[] arr = currentLine.split(", ");
				if (arr.length != 8) {
					throw new Exception("Error reading file: wrong file format.");
				}
				Employee emp = transferData(arr);
				float allowance = AllowanceCalulator.calculateAllowance(emp);
				emp.setAllowance(allowance);
				empMan.addEmployee(emp);
			}

			// menu
			Scanner scan = new Scanner(System.in);
			boolean keepRunning = true;
			while (keepRunning) {
				System.out.println("University Staff Management 1.0");
				System.out.println("\t1.Add staff");
				System.out.println("\t2.Search staff by name");
				System.out.println("\t3.Search staff by department/faculty");
				System.out.println("\t4.Display all staff");
				System.out.println("\t5.Exit");
				System.out.print("Select function (1,2,3,4 or 5): ");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:// add staff/teacher
					Employee emp = createNewImployee();
					float allowance = AllowanceCalulator.calculateAllowance(emp);
					emp.setAllowance(allowance);
					empMan.addEmployee(emp);
					// write/append to file
					if (emp instanceof Staff) {
						bw.write("Staff, " + ((Staff) emp).toString());
						bw.newLine();
					} else {
						bw.write("Teacher, " + ((Teacher) emp).toString());
						bw.newLine();
					}
					break;
				case 2:// search by name
					System.out.print("\tEnter name to search: ");
					scan = new Scanner(System.in);
					String name = scan.nextLine();
					ArrayList<Employee> foundByName = empMan.searchByName(name);
					display(foundByName);
					break;
				case 3:// search by dept
					System.out.print("\tEnter dept/fac to search: ");
					scan = new Scanner(System.in);
					String dept = scan.nextLine();
					ArrayList<Employee> foundByDept = empMan.searchByDept(dept);
					display(foundByDept);
					break;
				case 4:// display all
					ArrayList<Employee> listE = empMan.listAll();
					display(listE);
					break;
				case 5:// exit
					keepRunning = false;
					scan.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close file
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
