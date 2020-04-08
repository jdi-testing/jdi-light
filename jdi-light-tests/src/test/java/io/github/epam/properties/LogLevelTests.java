package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;
import static com.epam.jdi.light.common.PropertyValidationUtils.*;
import static org.testng.Assert.*;

public class LogLevelTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"ERR", "error", "1", "off", "all", ""};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"OFF", "FATAL", "ERROR", "WARNING", "STEP", "INFO", "DEBUG", "TRACE", "ALL"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(LOG_LEVEL_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, LOG_LEVEL_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(LOG_LEVEL_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
