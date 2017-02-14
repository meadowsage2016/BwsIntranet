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

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */
    public Employee getEmployeeById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        return employee;
    }

    /** Retrieve employee by lastname
     *
     * @param lastName Employee's last name which is the search criteria
     * @return Employee
     */
    public List<Employee> getEmployeesByLastName(String lastName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("lastName", lastName));
        return criteria.list();
    }

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


    /** save or update user
     * @param employee
     * @return id of the inserted employee
     */

    public int addEmployee(Employee employee) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(employee);
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteEmployee(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();

    }
    public void updateEmployee(Employee employee) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(employee);
        session.getTransaction().commit();

    }

}
