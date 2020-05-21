package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.CHROME_CAPABILITIES_PATH;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ChromeCapabilitiesPathTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "../../../ff.properties",
                "C:chrome.properties",
                "C:/directory/chrome.properties",
                "/chrome.properties",
                "ff.properties"
        };
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "chrome.properties",
                "directory/chrome.properties"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(CHROME_CAPABILITIES_PATH.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, CHROME_CAPABILITIES_PATH.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(CHROME_CAPABILITIES_PATH.getName(), value);
        validateProperties(properties);
    }
}
