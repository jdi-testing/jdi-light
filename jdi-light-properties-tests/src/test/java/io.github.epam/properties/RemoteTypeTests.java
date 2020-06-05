package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.REMOTE_TYPE_PROPERTY;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class RemoteTypeTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"browser_stack", "", "0", "browser-stack"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"sauce", "browserstack", "saucelabs", "selenium_localhost"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(REMOTE_TYPE_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, REMOTE_TYPE_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(REMOTE_TYPE_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
