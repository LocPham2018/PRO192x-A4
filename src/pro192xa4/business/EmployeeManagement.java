/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa4.business;

import java.util.ArrayList;
import java.util.Collections;
import pro192xa4.entity.Employee;
import pro192xa4.entity.Staff;
import pro192xa4.entity.Teacher;

/**
 *
 * @author hp
 */
public class EmployeeManagement {

    //store all staff/teacher
    ArrayList<Employee> listE;

    public EmployeeManagement() {        
        listE = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        //add emp to listE
        //your code
    	listE.add(emp);
    }
    //search by staff/teacher's name
    public ArrayList<Employee> searchByName(String name) {
        //store all matching staff or teacher
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        for (Employee emp : listE) {
        	String str = emp.getFullName().toLowerCase();
        	//use indexOf to find the query name in str
        	//if return -1 (name does not occur in str), emp will not be added into empFound
        	if (str.indexOf(name.toLowerCase()) != -1) {
        		empFound.add(emp);
        	}
        }
        return empFound;
    }
    //search by staff/teacher's department/faculty
    public ArrayList<Employee> searchByDept(String dept) {
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        for (Employee emp : listE) {
        	String str = (emp instanceof Teacher) ? ((Teacher) emp).getFaculty() : ((Staff) emp).getDepartment();
        	str = str.toLowerCase();
        	//use indexOf to find dept in str
        	//if return -1 (dept does not occur in str), emp will not be added into empFound
        	if (str.indexOf(dept.toLowerCase()) != -1) {
        		empFound.add(emp);
        	}
        }
        return empFound;
    }

    public ArrayList<Employee> listAll() {
        //sort the list of staff/teacher before return
        //your code
    	Collections.sort(listE);
        return listE;
    }

}
