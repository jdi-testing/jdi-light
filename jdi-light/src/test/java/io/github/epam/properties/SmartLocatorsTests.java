package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.SMART_LOCATORS;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class SmartLocatorsTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"", "ui=%s", "%s", "#%s;[ui=%d]", "[#name=%s]", "#%s, [ui=%s], [qa=%s]"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"#%s", "#%s;[ui=%s]", "[ui=%s]", "[qa=%s]", "[name=%s]", "[ui=%s],#%s,[qa=%s]", "#%s,[name=%s],[ui=%s]"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SMART_LOCATORS.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, SMART_LOCATORS.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SMART_LOCATORS.getName(), value);
        validateProperties(properties);
    }

}
