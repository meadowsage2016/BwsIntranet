package edu.matc.persistence;

import edu.matc.entity.BwsBlog;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/18/17.
 */
public class BwsBlogDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Get a single employee for the given id
     *
     * @param id user's id
     * @return User
     */
    public BwsBlog getBwsBlogById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        BwsBlog blog = (BwsBlog) session.get(BwsBlog.class, id);
        return blog;
    }

    /** Retrieve employee by lastname
     *
     * @param blogUser Employee's last name which is the search criteria
     * @return Employee
     */
    public List<BwsBlog> getBlogByUser(String blogUser) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(BwsBlog.class);
        criteria.add(Restrictions.eq("blogUser", blogUser));
        return criteria.list();
    }

    /** Return a list of all employees
     *
     * @return All employees
     */
    public List<BwsBlog> getAllBlogs() {
        List<BwsBlog> blogs = new ArrayList<BwsBlog>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        blogs = session.createCriteria(BwsBlog.class).list();
        return blogs;
    }


    /** save or update user
     * @param blog
     * @return id of the inserted employee
     */

    public int addBwsBlog(BwsBlog blog) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(blog);
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteBlog(int id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        BwsBlog blog = (BwsBlog) session.get(BwsBlog.class, id);
        session.beginTransaction();
        session.delete(blog);
        session.getTransaction().commit();

    }
    public void updateBlog(BwsBlog blog) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(blog);
        session.getTransaction().commit();

    }
}
