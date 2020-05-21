package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.COMMON_CAPABILITIES_PATH;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CommonCapabilitiesPathTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "../../../ff.properties",
                "../../../common.txt",
                "C:common.properties",
                "/common.properties",
                "ff.properties"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "../../../common.properties",
                "folder/common.properties",
                "common.properties",
                "folder\\common.properties"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(COMMON_CAPABILITIES_PATH.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, COMMON_CAPABILITIES_PATH.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(COMMON_CAPABILITIES_PATH.getName(), value);
        validateProperties(properties);
    }
}
