package edu.matc.persistence;

import edu.matc.entity.Subdealers;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/18/17.
 */
public class SubdealersDaoTest extends SubdealersDao {

    static Logger log = Logger.getLogger(EmployeeDaoTest.class.getName());
    SubdealersDaoTest dao;

    @Before
    public void setup() {
        dao = new SubdealersDaoTest();
    }

    @Test
    public void testGetSubdealerById() throws Exception {

    }

    @Test
    public void testGetsubdealerByLastName() throws Exception {

    }

    @Test
    public void testGetAllSubdealers() throws Exception {
        List<Subdealers> subdealers = dao.getAllSubdealers();
        assertTrue(subdealers.size() > 0);
    }

    @Test
    public void testAddSubdealer() throws Exception {

    }

    @Test
    public void testDeleteSubdealer() throws Exception {

    }

    @Test
    public void testUpdateEmployee() throws Exception {

    }

}