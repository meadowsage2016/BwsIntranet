package edu.matc.persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.matc.entity.BwsBlog;

import java.time.LocalDate;
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
        BwsBlog blog = dao.getBwsBlogById(1);
        assertEquals("Return wrong user", "admin", blog.getBlogUser());
    }

    @Test
    public void testGetBlogByUser() throws Exception {
        List<BwsBlog> blogUserName = dao.getBlogByUser("admin");
        assertEquals("User Not Found", 8, blogUserName.size());
    }

    @Test
    public void testGetAllBlogs() throws Exception {
        List<BwsBlog> blogs = dao.getAllBlogs();
        assertTrue(blogs.size() > 0);
    }

    @Test
    public void testAddBwsBlog() throws Exception {
        int before = dao.getAllBlogs().size();
        BwsBlog newBlog = new BwsBlog("Sue","Guess  who is president?");
        dao.addBwsBlog(newBlog);
        int after = dao.getAllBlogs().size();
        assertEquals("Blog not added correctly", before + 1, after);
    }

    @Test
    public void testDeleteBlog() throws Exception {
        int before = dao.getAllBlogs().size();
        dao.deleteBlog(23);
        int after = dao.getAllBlogs().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test
    public void testUpdateBlog() throws Exception {
        BwsBlog blog = dao.getBwsBlogById(10);
        String newblogText = "You are not a dandy!!!";
        blog.setBlogText(newblogText);
        dao.updateBlog(blog);
        assertEquals("Blog change not made", "You are not a dandy!!!", blog.getBlogText());

    }

}