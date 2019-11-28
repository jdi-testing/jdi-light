package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.DRIVERS_FOLDER;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DriversFolderTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"01:/02", "", "c folder", "c:folder", "FOLDER//"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"A:/folder", "b:/Folder", "c:/folder/SUBFOLDER", "//FOLDER", "\\FoLdeR"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, DRIVERS_FOLDER.getExMsg() + " See example: https://jdi-docs.github.io/jdi-light/#driver-settings");
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER.getName(), value);
        validateProperties(properties);
    }
}
