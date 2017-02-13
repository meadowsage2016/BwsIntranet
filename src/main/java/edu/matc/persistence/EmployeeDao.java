package edu.matc.persistence;

import edu.matc.entity.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO for Employee Class
 * @author Sue Hundt
 */
public class EmployeeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        employees = session.createCriteria(Employee.class).list();
        return employees;
    }

    /** Get a single user for the given id
     *
     * @param id user's id
     * @return User
     */
    public Employee getEmployee(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        return employee;
    }

    /** Retrieve users by lastname
     *
     * @param lastName User's last name which is the search criteria
     * @return Employee
     */
    public List<Employee> getEmployeesByLastName(String lastName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("lastName", lastName));
        return criteria.list();
    }

    /** save or update user
     * @param employee
     * @return id of the inserted employee
     */

    public int save(Employee employee) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(employee);
        session.getTransaction().commit();
        return id;
    }



}
