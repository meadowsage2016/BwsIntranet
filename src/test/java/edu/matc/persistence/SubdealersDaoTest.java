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
        Subdealers subdealer = dao.getSubdealerById(37);
        assertEquals("Return wrong employee", "MARELL INC", subdealer.getCustomerName());
    }

    @Test
    public void testGetsubdealerByCustomerNumber() throws Exception {
        Subdealers subdealer = dao.getsubdealerByCustomerNumber("01070");
        assertEquals("Customer Not Found", "MCFARLANE MFG CO -STORE ACCT", subdealer.getCustomerName());
    }

    @Test
    public void testGetAllSubdealers() throws Exception {
        List<Subdealers> subdealers = dao.getAllSubdealers();
        assertTrue(subdealers.size() > 0);
    }

    @Test
    public void testAddSubdealer() throws Exception {

        int before = dao.getAllSubdealers().size();
        Subdealers newSubdealer = new Subdealers("99991", "Mr Transfer", "101 South Dickinson", "PO Box 3379", "Madison", "WI", "53704", "Dane", "Delete me");
        dao.addSubdealer(newSubdealer);
        int after = dao.getAllSubdealers().size();
        assertEquals("Subdealer not added correctly", before + 1, after);
    }

    @Test
    public void testDeleteSubdealer() throws Exception {
        int before = dao.getAllSubdealers().size();
        dao.deleteSubdealer(39);
        int after = dao.getAllSubdealers().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        Subdealers subdealerToEdit = dao.getSubdealerById(10);
        String newAddress1 = "123 Johnson St";
        subdealerToEdit.setSbAddress1(newAddress1);
        dao.updateSubdealer(subdealerToEdit);
        assertEquals("Address1 change not made", "123 Johnson St", subdealerToEdit.getSbAddress1());

    }

}