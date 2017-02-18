package edu.matc.persistence;

import edu.matc.entity.CylinderOptions;
import edu.matc.persistence.CylinderOptionsDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sue Hundt
 */
public class CylinderOptionsDaoTest extends CylinderOptionsDao {

    static Logger log = Logger.getLogger(CylinderOptionsDaoTest.class.getName());
    CylinderOptionsDaoTest dao;

    @Before
    public void setup() {
        dao = new CylinderOptionsDaoTest();
    }


    @Test
    public void testGetCylOptionById() throws Exception {

    }

    @Test
    public void testGetCylOptionByGasNumber() throws Exception {

    }

    @Test
    public void testGetAllCylOptions() throws Exception {
        List<CylinderOptions> cylOptions = dao.getAllCylOptions();
        assertTrue(cylOptions.size() > 0);
    }

    @Test
    public void addCylOptions() throws Exception {

    }

    @Test
    public void deleteCylOption() throws Exception {

    }

    @Test
    public void updateCylOption() throws Exception {

    }

}