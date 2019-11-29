package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.DRIVERS_VERSION;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DriversVersionTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"latest", "LATES", "prelatest", "", "RELATEST", "2,31", "1.23"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"LATEST", "1.23.1", "PRELATEST", "33.44.55"};
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
            assertEquals(expMessage, DRIVERS_VERSION.getExMsg() + " See example: https://jdi-docs.github.io/jdi-light/#driver-settings");
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_VERSION.getName(), value);
        validateProperties(properties);
    }
}
