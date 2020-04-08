package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;
import static com.epam.jdi.light.common.PropertyValidationUtils.*;
import static org.testng.Assert.*;

public class DriversFolderTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "../../folder",
                "..\\..\\folder",
                "",
                "c folder",
                "c:folder",
                "FOLDER//",
                "/unix/folder/relative",
                "/unix/folder/slashattheend/",
                "folder"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "C:/unixfolder",
                "C:/unix/subfolder",
                "C:\\win\\subfolder",
                "C:\\winfolder",
                "C:\\win\\folder\\slashattheend\\"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, DRIVERS_FOLDER_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}
