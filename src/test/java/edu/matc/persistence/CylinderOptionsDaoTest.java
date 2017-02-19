package edu.matc.persistence;

import edu.matc.entity.CylinderOptions;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
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
        CylinderOptions cylinder = dao.getCylOptionById(1);
        assertEquals("Return wrong GAS", "DUMMYGASNO", cylinder.getGasNumber());

    }

    @Test
    public void testGetCylOptionByGasNumber() throws Exception {
        CylinderOptions cylinder = dao.getCylOptionByGasNumber("OX251");
        assertEquals("Gas Not Found", "OX251", cylinder.getGasNumber());
    }

    @Test
    public void testGetAllCylOptions() throws Exception {
        List<CylinderOptions> cylOptions = dao.getAllCylOptions();
        assertTrue(cylOptions.size() > 0);
    }

    @Test
    public void addCylOptions() throws Exception {
        int before = dao.getAllCylOptions().size();
        CylinderOptions cylinder = new CylinderOptions("SuesFas", "my specia mix - toxic", "HPL  SUEMX", .01, 3.65, 20.00, 9999.99);
        dao.addCylOptions(cylinder);
        int after = dao.getAllCylOptions().size();
        assertEquals("Cylinder not added correctly", before + 1, after);
    }

    @Test
    public void deleteCylOption() throws Exception {
        int before = dao.getAllCylOptions().size();
        dao.deleteCylOption(746);
        int after = dao.getAllCylOptions().size();
        assertEquals("Delete not made", before -1, after);

    }

    @Test
    public void updateCylOption() throws Exception {
        CylinderOptions cylinder = dao.getCylOptionById(747);
        Double newRent = .99;
        cylinder.setCylinderRent(newRent);
        dao.updateCylOption(cylinder);
        CylinderOptions cylinderChanged = dao.getCylOptionById(747);
        Double changedRent = cylinderChanged.getCylinderRent();
        assertEquals("Rent change not made", .99, changedRent,0);
    }

}