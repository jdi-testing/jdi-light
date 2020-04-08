package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;
import static com.epam.jdi.light.common.PropertyValidationUtils.*;
import static org.testng.Assert.*;

public class DomainTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "https://",
                "https://!jdi-testing.github.io/jdi-light/",
                "0123./",
                "zeroonetwothree",
                "http://goog#le.com",
                "http://google.com\\backslash\\url",
                "localhost:8",
                "http://localhost:8"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "http://jdi-testing.github.io/jdi-light/",
                "jdi-testing.github.io/jdi-light/",
                "https://jdi-testing.github.io/jdi-light",
                "jdi-testing.github.io",
                "jdi.io",
                "localhost:8080",
                "localhost:80",
                "www.google.ru",
                "http://10.1.21.0:8080"};
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
            assertEquals(expMessage, DOMAIN_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DOMAIN_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
