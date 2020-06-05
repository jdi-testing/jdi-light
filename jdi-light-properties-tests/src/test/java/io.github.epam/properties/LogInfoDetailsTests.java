package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.LOG_INFO_DETAILS_PROPERTY;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LogInfoDetailsTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"none", "", "0"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"NONE", "NAME", "LOCATOR", "CONTEXT", "ELEMENT"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(LOG_INFO_DETAILS_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, LOG_INFO_DETAILS_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(LOG_INFO_DETAILS_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
