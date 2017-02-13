package com.matc.entity;

import edu.matc.entity.Employee;
import edu.matc.persistence.EmployeeDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * EmployeeDaoTest to test methods ib EmployeeDao Class
 *
 * @author SueHundt
 */
public class EmployeeDaoTest {

    static Logger log = Logger.getLogger(EmployeeDaoTest.class.getName());
    EmployeeDaoTest dao;

    @Before
    public void setup() {
        dao = new EmployeeDaoTest();
    }

    @Test
    public void getAllEmployees() throws Exception {

        List<Employee> employees = dao.getAllEmployees();
        assertTrue(employees.size() > 0);
    }

    @Test
    public void getEmployee() throws Exception {

        //TODO test the getUser Methods
        Employee employee = dao.getEmployee(4);
        assertEquals("Return wrong employee", "Karen", employee.getFirstName());
    }

    @Test
    public void addEmployee() throws Exception {

        // TODO test the addUser Method
        int before = dao.getAllEmployees().size();
        Employee newEmployee = new Employee("Phoenix", "Hundt", "president", 999, "6085551212");
        dao.addEmployee(newEmployee);
        int after = dao.getAllEmployees().size();
        assertEquals("User not added correctly", before + 1, after);
    }

    @Test
    public void deleteEmployee() throws Exception {

        //TODO test the update;
        int before = dao.getAllEmployees().size();
        dao.deleteEmployee(3);
        int after = dao.getAllEmployees().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test
    public void updateEmployee() throws Exception {

        //TODO test the update
        Employee employee = dao.getUser(10);
        String newName = "Johnson";
        employee.setLastName(newName);
        dao.updateEmployee(employee);
        assertEquals("Date change not made", "Johnson", employee.getLastName());
    }
}