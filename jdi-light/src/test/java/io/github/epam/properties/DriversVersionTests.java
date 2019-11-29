package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.DRIVERS_VERSION;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DriversVersionTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"latest", "LATES", "prelatest", "", "RELATEST", "2,31", "ten.eleven", "1.76", "2"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"LATEST", "PRELATEST", "1.23.3", "3.141.59", "4.0.0-alpha-2"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_VERSION.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, DRIVERS_VERSION.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_VERSION.getName(), value);
        validateProperties(properties);
    }

}
