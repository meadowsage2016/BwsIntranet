package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/18/17.
 */
public class UserRolesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */
    public UserRoles getUserRoleById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRoles userRoles = (UserRoles) session.get(UserRoles.class, id);
        return userRoles;
    }

    /** Retrieve employee by lastname
     *
     * @param userRoleName  name which is the search criteria
     * @return Employee
     */
    public List<UserRoles> getUserRoleByUserRoleName(String userRoleName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserRoles.class);
        criteria.add(Restrictions.eq("role_name", userRoleName));
        session.close();
        return criteria.list();
    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<UserRoles> getAllUserRoles() {
        List<UserRoles> userRoles = new ArrayList<UserRoles>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        userRoles = session.createCriteria(UserRoles.class).list();
        session.close();
        return userRoles;
    }


    /** save or update user
     * @param userRole
     * @return id of the inserted employee
     */

    public int addUserRole(UserRoles userRole) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(userRole);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUserRole(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRoles userRole = (UserRoles) session.get(UserRoles.class, id);
        session.beginTransaction();
        session.delete(userRole);
        session.getTransaction().commit();
        session.close();

    }
    public void updateUserRole(UserRoles userRole) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(userRole);
        session.getTransaction().commit();
        session.close();

    }

}
