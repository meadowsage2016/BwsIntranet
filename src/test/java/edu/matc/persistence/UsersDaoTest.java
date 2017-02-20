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
        Users user = dao.getUserById(3);
        assertEquals("Return wrong User", "Sue", user.getUser_name());

    }

    @Test
    public void testGetUserByUserName() throws Exception {
        Users userFound = dao.getUserByUserName("admin");
        assertEquals("User Not Found", "admin", userFound.getUser_name());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testAddUser() throws Exception {
        int before = dao.getAllUsers().size();
        Users newSubdealer = new Users("Maggie", "maggie");
        dao.addUser(newSubdealer);
        int after = dao.getAllUsers().size();
        assertEquals("User not added correctly", before + 1, after);
    }

    @Test
    public void testDeleteUser() throws Exception {
        int before = dao.getAllUsers().size();
        dao.deleteUser(5);
        int after = dao.getAllUsers().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test
    public void testUpdateUser() throws Exception {
        Users userToEdit = dao.getUserById(4);
        String passwordChange = "password";
        userToEdit.setUser_pass(passwordChange);
        dao.updateUser(userToEdit);
        assertEquals("Password change not made", "password", userToEdit.getUser_pass());

    }

}