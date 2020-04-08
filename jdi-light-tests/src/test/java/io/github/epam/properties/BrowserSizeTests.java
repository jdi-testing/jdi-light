package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;
import static com.epam.jdi.light.common.PropertyValidationUtils.*;
import static org.testng.Assert.*;

public class BrowserSizeTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"maximize", "MAXIMIZE1234x1234", "99x99", "", "1024x", "1000.56x1024", "0x0", "10000x10000",
                "1000x10000", "1000x99", "10abc20x100", "MAXIMIZE 1234x1234"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"MAXIMIZE", "1536x864", "1366x768", "1920x1080", "360x640", "100x100", "9999x9999"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(BROWSER_SIZE_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, BROWSER_SIZE_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(BROWSER_SIZE_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
