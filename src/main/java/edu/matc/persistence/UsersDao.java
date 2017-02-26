package edu.matc.persistence;

import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/18/17.
 */
public class UsersDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */
    public Users getUserById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Users user = (Users) session.get(Users.class, id);
        session.close();
        return user;
    }

    /** Retrieve employee by lastname
     *
     * @param userName  name which is the search criteria
     * @return Employee
     */
    public Users getUserByUserName(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("user_name", userName));
        Users userFound = (Users) criteria.uniqueResult();
        session.close();
        return userFound;
    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(Users.class).list();
        return users;
    }


    /** save or update user
     * @param user
     * @return id of the inserted employee
     */

    public int addUser(Users user) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(user);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Users user = (Users) session.get(Users.class, id);
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }
    public void updateUser(Users user) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(user);
        session.getTransaction().commit();
        session.close();

    }

}
