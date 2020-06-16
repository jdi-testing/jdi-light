package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static utils.Property.SMART_LOCATORS_TO_NAME_PROPERTY;
import static utils.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static utils.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class SmartLocatorsToNameTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"camel_case", "", "0", "snakeCase", "smart_text"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"kebab-case", "camelCase", "snake_case", "PascalCase", "UPPER_SNAKE_CASE"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SMART_LOCATORS_TO_NAME_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, SMART_LOCATORS_TO_NAME_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SMART_LOCATORS_TO_NAME_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
