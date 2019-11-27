package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.SCREENS_FOLDER;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ScreensFolderTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"cd;\\fd", "c:\\f[d", "C:\\Program*Files\\tests", "C:\\Program Files\\tests"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"C:\\my\\win\\absolute\\path", "D:\\tests", "c:\\files", "my/predefined/path",
                "/my/relative/path", "C:\\my\\win\\absolute\\path"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SCREENS_FOLDER.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, SCREENS_FOLDER.getExMsg() + " See example: https://jdi-docs.github.io/jdi-light/#driver-settings");
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SCREENS_FOLDER.getName(), value);
        validateProperties(properties);
    }
}
