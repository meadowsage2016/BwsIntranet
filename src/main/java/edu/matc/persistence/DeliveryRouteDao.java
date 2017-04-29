package edu.matc.persistence;

import edu.matc.entity.DeliveryRoute;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/18/17.
 */
public class DeliveryRouteDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */

    public DeliveryRoute getDeliveryRouteById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        DeliveryRoute route = new DeliveryRoute();

        try {
            route = (DeliveryRoute) session.get(DeliveryRoute.class, id);
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
        return route;

    }

      /** Retrieve
     *
     * @param deliveryCityOrBusiness Employee's last name which is the search criteria
     * @return Employee
     */
    public DeliveryRoute getDeliveryRouteByCityOrBusiness(String deliveryCityOrBusiness) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        DeliveryRoute route = new DeliveryRoute();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(DeliveryRoute.class);
            criteria.add(Restrictions.eq("deliveryCityOrBusiness", deliveryCityOrBusiness));
            route = (DeliveryRoute) criteria.uniqueResult();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }

        return route;
    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<DeliveryRoute> getAllDeliveryRoutes() {
        List<DeliveryRoute> routes = new ArrayList<DeliveryRoute>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            routes = session.createCriteria(DeliveryRoute.class).list();
        } catch  (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }

        return routes;
    }


    /** save or update user
     * @param route
     * @return id of the inserted employee
     */

    public int addDeliveryRoute(DeliveryRoute route) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int id = 0;
        try {
            session.beginTransaction();
            id = (Integer) session.save(route);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
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
    public void deleteDeliveryRoute(int id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            DeliveryRoute route = (DeliveryRoute) session.get(DeliveryRoute.class, id);
            session.beginTransaction();
            session.delete(route);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }

    }
    public void updateDeliveryRoute(DeliveryRoute route) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
    }

}
