package pro192xa4.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pro192xa4.business.AllowanceCalulator;
import pro192xa4.business.EmployeeManagement;
import pro192xa4.entity.EPosition;
import pro192xa4.entity.Employee;
import pro192xa4.entity.Staff;

public class EmployeeTest {
	
	static EmployeeManagement empMan = new EmployeeManagement();
	
	// Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
    	// declare employees
        Staff s1 = new Staff();
        s1.setFullName("Tran Hao");
        s1.setDepartment("Acad");
        s1.setPosition(EPosition.VICE_HEAD);
        s1.setSalaryRatio(3.1f);
        s1.setNoOfWorkingDay(120);
        s1.setAllowance(AllowanceCalulator.calculateAllowance(s1));
        
        Staff s2 = new Staff();
        s2.setFullName("Trinh Hao");
        s2.setDepartment("IT");
        s2.setPosition(EPosition.VICE_HEAD);
        s2.setSalaryRatio(3.1f);
        s2.setNoOfWorkingDay(120);
        
        Staff s3 = new Staff();
        s3.setFullName("Tran Cung");
        s3.setDepartment("IT");
        s3.setPosition(EPosition.VICE_HEAD);
        s3.setSalaryRatio(3.1f);
        s3.setNoOfWorkingDay(120);
        
        // add to list
        empMan.addEmployee(s1);
        empMan.addEmployee(s2);
        empMan.addEmployee(s3);
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        // System.out.println("@AfterClass - runOnceAfterClass");
    }
    
    @Test
    public void test_searchByName() {
        ArrayList<Employee> foundByName = empMan.searchByName("Tran Hao");
        assertTrue(foundByName.size() == 1);
        float expectedSalary = 6863f;
        float resultSalary = foundByName.get(0).getSalary();
        // System.out.println(resultSalary);
        assertTrue(resultSalary == expectedSalary);
    }
    
    @Test
    public void test_searchByDept() {
    	ArrayList<Employee> foundByDept = empMan.searchByDept("IT");
    	assertTrue(foundByDept.size() == 2);
    }

}
