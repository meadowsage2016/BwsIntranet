package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/19/17.
 */
public class UserRolesDaoTest extends UserRolesDao {

    static Logger log = Logger.getLogger(BwsBlogDaoTest.class.getName());
    UserRolesDaoTest dao;

    @Before
    public void setup() {
        dao = new UserRolesDaoTest();
    }

    @Test // GET BY ID                                                                                                1
    public void testGetUserRoleById() throws Exception {
        UserRoles userRole = dao.getUserRoleById(4);
        assertEquals("Return wrong User", "admin", userRole.getUser_name());
    }

    @Test  // GET BY ROLE_NAME                                    ADMINISTRATOR
    public void testGetUserRoleByUserRoleName() throws Exception {
        List<UserRoles> userRoleFound = dao.getUserRoleByUserRoleName("administrator");
        assertEquals("2 Administrators Not Found", 2, userRoleFound.size());
    }

    @Test  //  GET ALL
    public void testGetAllUserRoles() throws Exception {
        List<UserRoles> userRoles = dao.getAllUserRoles();
        assertTrue(userRoles.size() > 0);
    }

    @Test  // ADD
    public void testAddUserRole() throws Exception {
        int before = dao.getAllUserRoles().size();
        UserRoles newUserRole = new UserRoles("Maggie3", "registered-user");
        dao.addUserRole(newUserRole);
        int after = dao.getAllUserRoles().size();
        assertEquals("User not added correctly", before + 1, after);
    }

    @Test  //   DELETE  ***CHANGE - MUST EXISTS ***                                                                  7
    public void testDeleteUserRole() throws Exception {
        int before = dao.getAllUserRoles().size();
        dao.deleteUserRole(7);
        int after = dao.getAllUserRoles().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test
    public void testUpdateUserRole() throws Exception {
        UserRoles userRoleToEdit = dao.getUserRoleById(2);
        String roleChange = "registered-user";
        userRoleToEdit.setRole_name(roleChange);
        dao.updateUserRole(userRoleToEdit);
        assertEquals("Role change not made", "registered-user", userRoleToEdit.getRole_name());
    }

}