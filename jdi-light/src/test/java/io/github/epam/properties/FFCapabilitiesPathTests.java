package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.FF_CAPABILITIES_PATH;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class FFCapabilitiesPathTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"../../../chrome.properties",
                            "../../../ff.txt",
                            "C:ff.properties"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"../../../ff.properties",
                "../ff.properties",
                "../directory/ff.properties"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(FF_CAPABILITIES_PATH.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, FF_CAPABILITIES_PATH.getExMsg() + " See example: https://jdi-docs.github.io/jdi-light/#driver-settings");
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(FF_CAPABILITIES_PATH.getName(), value);
        validateProperties(properties);
    }

}
