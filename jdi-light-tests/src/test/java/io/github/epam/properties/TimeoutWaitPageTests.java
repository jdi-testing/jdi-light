package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;
import static com.epam.jdi.light.common.PropertyValidationUtils.*;
import static org.testng.Assert.*;

public class TimeoutWaitPageTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"-1", "1000", "01", "", "1.1", "10,11", "ten"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"0", "1", "998", "999"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(TIMEOUT_WAIT_PAGE_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, TIMEOUT_WAIT_PAGE_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(TIMEOUT_WAIT_PAGE_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
