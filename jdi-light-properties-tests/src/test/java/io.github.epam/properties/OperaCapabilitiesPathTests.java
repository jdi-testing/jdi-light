package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static utils.Property.OPERA_CAPABILITIES_PATH;
import static utils.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static utils.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class OperaCapabilitiesPathTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "../../../ff.properties",
                "../../../opera.txt",
                "C:opera.properties",
                "/opera.properties",
                "ff.properties"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "../../../opera.properties",
                "folder/opera.properties",
                "opera.properties",
                "folder\\opera.properties"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(OPERA_CAPABILITIES_PATH.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, OPERA_CAPABILITIES_PATH.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(OPERA_CAPABILITIES_PATH.getName(), value);
        validateProperties(properties);
    }
}
