package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static utils.Property.EDGE_CAPABILITIES_PATH;
import static utils.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static utils.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class EdgeCapabilitiesPathTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "../../../ff.properties",
                "../../../edge.txt",
                "C:edge.properties",
                "/edge.properties",
                "ff.properties"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "../../../edge.properties",
                "folder/edge.properties",
                "edge.properties",
                "folder\\edge.properties"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(EDGE_CAPABILITIES_PATH.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, EDGE_CAPABILITIES_PATH.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(EDGE_CAPABILITIES_PATH.getName(), value);
        validateProperties(properties);
    }
}
