package edu.matc.persistence;

import edu.matc.entity.CylinderOptions;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sue Hundt
 */


/**
 * DAO for Cylinder Options Class
 * @author Sue Hundt
 */
public class CylinderOptionsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id cylinder Option's id
     * @return CylinderOptions
     */
    public CylinderOptions getCylOptionById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CylinderOptions cylOption = new CylinderOptions();

        try {
            cylOption = (CylinderOptions) session.get(CylinderOptions.class, id);
        } catch (HibernateException hibernateException) {
        log.error("Hibernate Exception", hibernateException);
    } finally {
        session.close();
    }
        return cylOption;
    }

    /** Retrieve Cylinder Options by Gas Number
     *
     * @param gasNumber
     * @return CylinderOptions
     */
    public CylinderOptions getCylOptionByGasNumber(String gasNumber) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CylinderOptions cylinder = new CylinderOptions();

        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(CylinderOptions.class);
            criteria.add(Restrictions.eq("gasNumber", gasNumber));
            cylinder = (CylinderOptions) criteria.uniqueResult();
        } catch (HibernateException hibernateException) {
        log.error("Hibernate Exception", hibernateException);
    } finally {
        session.close();
    }
        return cylinder;
    }

    /** Return a list of all cylOptions
     *
     * @return All cylOptions
     */
    public List<CylinderOptions> getAllCylOptions() {

        List<CylinderOptions> cylOption = new ArrayList<CylinderOptions>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            cylOption = session.createCriteria(CylinderOptions.class).list();
        }catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
        return cylOption;
    }


    /** save or update user
     * @param cylOption
     * @return id of the inserted cylOption
     */

    public int addCylOptions(CylinderOptions cylOption) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int id = 0;

        try {
            session.beginTransaction();
            id = (Integer) session.save(cylOption);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * delete a cylOptions by id
     * @param id the cylOption's id
     */
    public void deleteCylOption(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            CylinderOptions cylOption = (CylinderOptions) session.get(CylinderOptions.class, id);
            session.beginTransaction();
            session.delete(cylOption);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }

    }


    public void updateCylOption(CylinderOptions cylOption) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            session.update(cylOption);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            log.error("Hibernate Exception", hibernateException);
        } finally {
            session.close();
        }
    }
}
