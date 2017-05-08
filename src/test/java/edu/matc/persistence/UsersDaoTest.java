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

    @Test  // GET BY ID                                                                                               3
    public void testGetUserById() throws Exception {
        Users user = dao.getUserById(1);
        assertEquals("Return wrong User", "admin", user.getUser_name());

    }

    @Test  // GET BY USER NAME                                                                                    ADMIN
    public void testGetUserByUserName() throws Exception {
        Users userFound = dao.getUserByUserName("admin");
        assertEquals("User Not Found", "admin", userFound.getUser_name());
    }

    @Test  // GET ALL
    public void testGetAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test  // ADD  ***CHANGE - MUST BE UNIQUE ****
    public void testAddUser() throws Exception {
        int before = dao.getAllUsers().size();
        Users newSubdealer = new Users("Maggie5", "maggie");
        dao.addUser(newSubdealer);
        int after = dao.getAllUsers().size();
        assertEquals("User not added correctly", before + 1, after);
    }

    @Test  //  DELETE   *** CHANGE - MUST EXISTS  ***                                              7
    public void testDeleteUser() throws Exception {
        int before = dao.getAllUsers().size();
        dao.deleteUser(6);
        int after = dao.getAllUsers().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test  // UPDATE  *************CHANGE - MUST EXISTS **********                                    3
    public void testUpdateUser() throws Exception {
        Users userToEdit = dao.getUserById(5);
        String passwordChange = "password";
        userToEdit.setUser_pass(passwordChange);
        dao.updateUser(userToEdit);
        assertEquals("Password change not made", "password", userToEdit.getUser_pass());

    }

}