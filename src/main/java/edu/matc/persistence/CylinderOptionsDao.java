package edu.matc.persistence;

import edu.matc.entity.CylinderOptions;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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
        CylinderOptions cylOption = (CylinderOptions) session.get(CylinderOptions.class, id);
        return cylOption;
    }

    /** Retrieve Cylinder Options by Gas Number
     *
     * @param gasNumber
     * @return CylinderOptions
     */
    public CylinderOptions getCylOptionByGasNumber(String gasNumber) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CylinderOptions.class);
        criteria.add(Restrictions.eq("gasNumber", gasNumber));
        CylinderOptions cylinder = (CylinderOptions) criteria.uniqueResult();
        return cylinder;
    }

    /** Return a list of all cylOptions
     *
     * @return All cylOptions
     */
    public List<CylinderOptions> getAllCylOptions() {
        List<CylinderOptions> cylOption = new ArrayList<CylinderOptions>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cylOption = session.createCriteria(CylinderOptions.class).list();
        return cylOption;
    }


    /** save or update user
     * @param cylOption
     * @return id of the inserted cylOption
     */

    public int addCylOptions(CylinderOptions cylOption) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(cylOption);
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a cylOptions by id
     * @param id the cylOption's id
     */
    public void deleteCylOption(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CylinderOptions cylOption = (CylinderOptions) session.get(CylinderOptions.class, id);
        session.beginTransaction();
        session.delete(cylOption);
        session.getTransaction().commit();

    }

    public void updateCylOption(CylinderOptions cylOption) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(cylOption);
        session.getTransaction().commit();

    }

}
