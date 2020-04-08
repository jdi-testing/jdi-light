package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;
import static com.epam.jdi.light.common.PropertyValidationUtils.*;
import static org.testng.Assert.*;

public class DriverRemoteUrlTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "https://",
                "https://!remote.driver.com/wd/hub/",
                "0123./",
                "zeroonetwothree",
                "http://remo#te.com",
                "http://remote.com\\backslash\\url",
                "localhost:8",
                "http://10.1.21.0:8",
                ""};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "http://remote.driver.com/wd/hub/",
                "https://remote.driver.com/wd/hub/",
                "remote-driver.com/wd/hub/",
                "remote.driver.com",
                "remote.com",
                "localhost:8080",
                "localhost:80/wd/hub",
                "http://localhost:8080",
                "10.1.21.0:8080",
                "www.remote.ru",
                "http://10.1.21.0:8080"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVER_REMOTE_URL_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, DRIVER_REMOTE_URL_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVER_REMOTE_URL_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
