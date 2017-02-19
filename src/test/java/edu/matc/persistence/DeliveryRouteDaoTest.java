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
        DeliveryRoute route = dao.getDeliveryRouteById(4);
        assertEquals("Return wrong route", "BARABOO", route.getDeliveryCityOrBusiness());
    }

    @Test
    public void testGetDeliveryRouteByCityOrBusiness() throws Exception {
        DeliveryRoute route = dao.getDeliveryRouteByCityOrBusiness("RICHLAND CENTER");
        assertEquals("CITY Not Found", "RICHLAND CENTER", route.getDeliveryCityOrBusiness());
    }

    @Test
    public void testGetAllDeliveryRoutes() throws Exception {
        List<DeliveryRoute> routes = dao.getAllDeliveryRoutes();
        assertTrue(routes.size() > 0);
    }

    @Test
    public void testAddDeliveryRoute() throws Exception {
        int before = dao.getAllDeliveryRoutes().size();
        DeliveryRoute cylinder = new DeliveryRoute("Home", "Saturday", "Weekly");
        dao.addDeliveryRoute(cylinder);
        int after = dao.getAllDeliveryRoutes().size();
        assertEquals("Route not added correctly", before + 1, after);
    }

    @Test
    public void testDeleteDeliveryRoute() throws Exception {
        int before = dao.getAllDeliveryRoutes().size();
        dao.deleteDeliveryRoute(88);
        int after = dao.getAllDeliveryRoutes().size();
        assertEquals("Delete not made", before -1, after);
    }

    @Test
    public void testUpdateDeliveryRoute() throws Exception {
        DeliveryRoute route = dao.getDeliveryRouteById(87);
        String newDay = "Never";
        route.setDeliveryDay(newDay);
        dao.updateDeliveryRoute(route);
        DeliveryRoute routeChanged = dao.getDeliveryRouteById(87);
        String changedRoute = routeChanged.getDeliveryDay();
        assertEquals("Route change not made", "Never", changedRoute);
    }

}