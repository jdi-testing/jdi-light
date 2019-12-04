package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.ELEMENT_SEARCH_STRATEGY;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ElementSearchStrategyTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"strct", "s0ft", "visible", "", "any,  single"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"strict", "soft", "visible, multiple", "any, single", "any,single"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(ELEMENT_SEARCH_STRATEGY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, ELEMENT_SEARCH_STRATEGY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(ELEMENT_SEARCH_STRATEGY.getName(), value);
        validateProperties(properties);
    }

}
