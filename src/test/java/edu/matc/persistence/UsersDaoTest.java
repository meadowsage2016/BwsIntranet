package edu.matc.persistence;

import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/18/17.
 */
public class UsersDaoTest extends UsersDao {


    static Logger log = Logger.getLogger(BwsBlogDaoTest.class.getName());
    UsersDaoTest dao;

    @Before
    public void setup() {
        dao = new UsersDaoTest();
    }

    @Test
    public void testGetUserById() throws Exception {

    }

    @Test
    public void testGetUserByUserName() throws Exception {

    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testAddUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }

}