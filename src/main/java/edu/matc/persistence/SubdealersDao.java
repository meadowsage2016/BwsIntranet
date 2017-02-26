package edu.matc.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import edu.matc.entity.Subdealers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/18/17.
 */
public class SubdealersDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */
    public Subdealers getSubdealerById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Subdealers subdealer = (Subdealers) session.get(Subdealers.class, id);
        session.close();
        return subdealer;
    }

    /** Retrieve employee by lastname
     *
     * @param customerNumber Employee's last name which is the search criteria
     * @return Employee
     */
    public Subdealers getsubdealerByCustomerNumber(String customerNumber) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Subdealers.class);
        criteria.add(Restrictions.eq("customerNumber", customerNumber));
        Subdealers subdealer = (Subdealers) criteria.uniqueResult();
        session.close();
        return subdealer;
    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<Subdealers> getAllSubdealers() {
        List<Subdealers> subdealers = new ArrayList<Subdealers>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        subdealers = session.createCriteria(Subdealers.class).list();
        session.close();
        return subdealers;
    }


    /** save or update user
     * @param subdealer
     * @return id of the inserted employee
     */

    public int addSubdealer(Subdealers subdealer) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(subdealer);
        session.getTransaction().commit();
        session.close();
        return id;

    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteSubdealer(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Subdealers subdealer = (Subdealers) session.get(Subdealers.class, id);
        session.beginTransaction();
        session.delete(subdealer);
        session.getTransaction().commit();
        session.close();

    }
    public void updateSubdealer(Subdealers subdealer) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(subdealer);
        session.getTransaction().commit();
        session.close();
    }

}
