package edu.matc.persistence;

import org.junit.Test;
import edu.matc.entity.Employee;
import org.apache.log4j.Logger;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

/**
 * EmployeeDaoTest to test methods in EmployeeDao Class
 *
 @author SueHundt
 *
 */

public class EmployeeDaoTest extends EmployeeDao {

    static Logger log = Logger.getLogger(EmployeeDaoTest.class.getName());
    EmployeeDaoTest dao;

    @Before
    public void setup() {
        dao = new EmployeeDaoTest();
    }

    @Test  // GET ALL
    public void testGetAllEmployees(){
        List<Employee> employees = dao.getAllEmployees();
        assertTrue(employees.size() > 0);
    }

    @Test  // GET BY ID                                                                                              4
    public void testGetEmployeeById() {
        Employee employee = dao.getEmployeeById(4);
        assertEquals("Return wrong employee", "Mike", employee.getFirstName());
    }

    @Test  // GET BY LAST NAME                                                                             JOHNSTON
    public void testGetEmployeesByLastName(){

            List<Employee> employeesWithLastName = dao.getEmployeesByLastName("Sally");
            assertEquals("Employees Not Found", 2, employeesWithLastName.size());
    }

    @Test  // GET BY Email Address                                                                             JOHNSTON
    public void testGetEmployeesByEmailAddress(){

        Employee employeesWithEmailAddress = dao.getEmployeeByEmailAddress("sue@badgerwelding.com");
        assertEquals("Employee with Email Address Not Found", "Hundt", employeesWithEmailAddress.getLastName());
    }

    @Test  // UPDATE BY ID                                                                                        70
    public void testUpdateEmployee()  {

        Employee employee = dao.getEmployeeById(64);
        String newName = "Johnson";
        employee.setLastName(newName);
        dao.updateEmployee(employee);
        assertEquals("Date change not made", "Johnson", employee.getLastName());
    }

    @Test  // ADD
    public void testAddNewEmployee() {

        int before = dao.getAllEmployees().size();
        Employee newEmployee = new Employee("Phoenix", "Sally", "president", "6085551212" , "997", "phoenix@badgerwelding.com");
        dao.addEmployee(newEmployee);
        int after = dao.getAllEmployees().size();
        assertEquals("User not added correctly", before + 1, after);
    }

    @Test  // DELETE ***CHANGE - MUST EXISTS ***                                                                           65
    public void testDeleteEmployee() {

        int before = dao.getAllEmployees().size();
        dao.deleteEmployee(70);
        int after = dao.getAllEmployees().size();
        assertEquals("Delete not made", before -1, after);
    }

}