package edu.matc.persistence;

import edu.matc.entity.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.*;

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
        session.close();
        return employee;
    }

    /** Retrieve employee by lastname
     *
     * @param lastName Employee's first name which is the search criteria
     * @return Employee
     */
    public List<Employee> getEmployeesByLastName(String lastName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Employee> employees = new ArrayList<Employee>();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("lastName", lastName));
            employees = (List<Employee>) criteria.list();

        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
        return employees;

    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            employees = session.createCriteria(Employee.class).list();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {

            session.close();
        }
        return employees;
    }


    /** save or update user
     * @param employee
     * @return id of the inserted employee
     */

    public int addEmployee(Employee employee) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        int id = 0;

        try {
                transaction = session.beginTransaction();
                session.save(employee);
                transaction.commit();
                id=1;
            } catch (HibernateException hibernateException) {
                if (transaction != null) transaction.rollback();
                log.error("Hibernate Exception", hibernateException);
            } finally {
                session.close();
            }
            return id;
        }


    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteEmployee(int id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        try {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
    }


    public void updateEmployee(Employee employee) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            session.update(employee);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
    }
}
