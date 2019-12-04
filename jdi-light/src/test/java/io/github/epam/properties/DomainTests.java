package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.DOMAIN_PROPERTY;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DomainTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "https://",
                "https://!jdi-testing.github.io/jdi-light/",
                "0123./",
                "zeroonetwothree",};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "https://jdi-testing.github.io/jdi-light/",
                "jdi-testing.github.io/jdi-light/",
                "https://jdi-testing.github.io/jdi-light",
                "jdi-testing.github.io",
                "jdi.io",
                "localhost:8080"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DOMAIN_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, DOMAIN_PROPERTY.getExMsg() + " See example: https://jdi-docs.github.io/jdi-light/#driver-settings");
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DOMAIN_PROPERTY.getName(), value);
        validateProperties(properties);
    }

}

