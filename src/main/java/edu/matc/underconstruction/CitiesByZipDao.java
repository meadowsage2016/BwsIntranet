package edu.matc.underconstruction;

import edu.matc.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 3/16/17.
 */
public class CitiesByZipDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */
    public CitiesByZip getCitiesByZipId(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CitiesByZip city = (CitiesByZip) session.get(CitiesByZip.class, id);
        session.close();
        return city;
    }

    /** Retrieve employee by lastname
     *
     * @param zipCode Employee's first name which is the search criteria
     * @return List
     */
    public List<CitiesByZip> getCityByZipCode(String zipCode) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CitiesByZip cities = (CitiesByZip) session.get(CitiesByZip.class, zipCode);
        Criteria criteria = session.createCriteria(CitiesByZip.class);
        criteria.add(Restrictions.eq("zipCode", zipCode));
        session.close();
        return criteria.list();
    }

    /** Return a list of all cities
     *
     * @return All cities
     */
    public List<CitiesByZip> getAllCitiesByZip() {
        List<CitiesByZip> cities = new ArrayList<CitiesByZip>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cities = session.createCriteria(CitiesByZip.class).list();
        session.close();
        return cities;
    }

    public List<CitiesByZip> getCityByZip(String zipCode) {
        List<CitiesByZip> city = new ArrayList<CitiesByZip>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        city = session.createCriteria(CitiesByZip.class).list();
        session.close();
        return city;
    }

    /** save or update user
     * @param city
     * @return id of the inserted employee
     */

    public int addCitiesByZip(CitiesByZip city) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(city);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    /**
     * delete a city by id
     * @param id the city's id
     */
    public void deleteCitiesByZip(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CitiesByZip city = (CitiesByZip) session.get(CitiesByZip.class, id);
        session.beginTransaction();
        session.delete(city);
        session.getTransaction().commit();
        session.close();
    }
    public void updateCitiesByZip(CitiesByZip city) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(city);
        session.getTransaction().commit();
        session.close();
    }

}
