package edu.matc.persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.matc.entity.BwsBlog;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/18/17.
 */
public class BwsBlogDaoTest extends BwsBlogDao {

    static Logger log = Logger.getLogger(BwsBlogDaoTest.class.getName());
    BwsBlogDaoTest dao;

    @Before
    public void setup() {
        dao = new BwsBlogDaoTest();
    }

    @Test
    public void testGetBwsBlogById() throws Exception {

    }

    @Test
    public void testGetBlogByUser() throws Exception {

    }

    @Test
    public void testGetAllBlogs() throws Exception {
        List<BwsBlog> blogs = dao.getAllBlogs();
        assertTrue(blogs.size() > 0);
    }

    @Test
    public void testAddBwsBlog() throws Exception {

    }

    @Test
    public void testDeleteBlog() throws Exception {

    }

    @Test
    public void testUpdateBlog() throws Exception {

    }

}