package edu.matc.persistence;

import edu.matc.entity.CitiesByZip;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 3/16/17.
 */
public class CitiesByZipDaoTest extends CitiesByZipDao{
    static Logger log = Logger.getLogger(EmployeeDaoTest.class.getName());
    CitiesByZipDaoTest dao;


    @Before
    public void setup() {
        dao = new CitiesByZipDaoTest();
    }


    @Test
    public void getCitiesByZipId() throws Exception {

    }

    @Test
    public void getCityByZipCode() throws Exception {

    }

    @Test
    public void testGetAllCitiesByZip() throws Exception {

        List<CitiesByZip> cities = dao.getAllCitiesByZip();
            assertTrue(cities.size() > 0);
    }


    @Test
    public void addCitiesByZip() throws Exception {

    }

    @Test
    public void deleteCitiesByZip() throws Exception {

    }

    @Test
    public void updateCitiesByZip() throws Exception {

    }

}