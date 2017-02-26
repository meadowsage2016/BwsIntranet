package gov.oldWeather;

import junit.framework.TestCase;

/**
 * Created by student on 2/25/17.
 */
public class NdfdXMLBindingStubTest extends TestCase {
    public void testLatLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String response = binding.latLonListZipCode("53711");

        assertEquals("Result did not match expected value", "???", response);
    }

}