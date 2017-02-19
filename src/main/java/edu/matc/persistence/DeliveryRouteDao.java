package edu.matc.persistence;

import edu.matc.entity.DeliveryRoute;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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
        DeliveryRoute route = (DeliveryRoute) session.get(DeliveryRoute.class, id);
        return route;
    }

    /** Retrieve employee by lastname
     *
     * @param deliveryCityOrBusiness Employee's last name which is the search criteria
     * @return Employee
     */
    public List<DeliveryRoute> getDeliveryRouteByCityOrBusiness(String deliveryCityOrBusiness) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(DeliveryRoute.class);
        criteria.add(Restrictions.eq("deliveryCityOrBusiness", deliveryCityOrBusiness));
        return criteria.list();
    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<DeliveryRoute> getAllDeliveryRoutes() {
        List<DeliveryRoute> routes = new ArrayList<DeliveryRoute>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        routes = session.createCriteria(DeliveryRoute.class).list();
        return routes;
    }


    /** save or update user
     * @param route
     * @return id of the inserted employee
     */

    public int addDeliveryRoute(DeliveryRoute route) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(route);
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteDeliveryRoute(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        DeliveryRoute route = (DeliveryRoute) session.get(DeliveryRoute.class, id);
        session.beginTransaction();
        session.delete(route);
        session.getTransaction().commit();

    }
    public void updateDeliveryRoute(DeliveryRoute route) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(route);
        session.getTransaction().commit();

    }

}
