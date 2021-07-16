package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static utils.Property.SMART_SEARCH_PROPERTY;
import static utils.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static utils.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class SmartSearchTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"onlyUI", "", "0", "only_ui"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"false", "onlyui", "uiandelements", "always"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SMART_SEARCH_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, SMART_SEARCH_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SMART_SEARCH_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
