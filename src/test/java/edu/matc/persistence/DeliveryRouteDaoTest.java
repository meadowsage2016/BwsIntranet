package edu.matc.persistence;

import edu.matc.entity.DeliveryRoute;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/18/17.
 */
public class DeliveryRouteDaoTest extends DeliveryRouteDao {


    static Logger log = Logger.getLogger(DeliveryRouteDaoTest.class.getName());
    DeliveryRouteDaoTest dao;

    @Before
    public void setup() {
        dao = new DeliveryRouteDaoTest();
    }

    @Test
    public void testGetDeliveryRouteById() throws Exception {

    }

    @Test
    public void testGetDeliveryRouteByCityOrBusiness() throws Exception {

    }

    @Test
    public void testGetAllDeliveryRoutes() throws Exception {
        List<DeliveryRoute> routes = dao.getAllDeliveryRoutes();
        assertTrue(routes.size() > 0);
    }

    @Test
    public void testAddDeliveryRoute() throws Exception {

    }

    @Test
    public void testDeleteDeliveryRoute() throws Exception {

    }

    @Test
    public void testUpdateDeliveryRoute() throws Exception {

    }

}