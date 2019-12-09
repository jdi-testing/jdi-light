package io.github.epam.properties;

import com.epam.jdi.light.common.AdditionalPathUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.epam.jdi.light.common.Property.SCREENS_FOLDER_PROPERTY;
import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ScreensFolderTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{
                "cd;\\fd",
                "c:\\f[d",
                "C:\\Program*Files\\tests",
                "C:\\Program Files\\tests",
                ""};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{
                "C:\\my\\win\\absolute\\path",
                "D:\\tests",
                "c:\\files",
                "my/predefined/path",
                "/my/relative/path"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SCREENS_FOLDER_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, SCREENS_FOLDER_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(SCREENS_FOLDER_PROPERTY.getName(), value);
        validateProperties(properties);
    }

    @Test
    public void crossPlatformPathTests() {
        String chromePath = "";

        String os = System.getProperty("os.name");
        switch (os) {
        case "Windows 10":
             chromePath = "C:\\my\\win\\absolute\\path";
             break;
        case "Linux":
             chromePath = "~/my/relative/path";
             break;
        case "Mac OS X":
             chromePath = "my/predefined/path";
             break;
         default:
             chromePath = "C:\\my\\win\\absolute\\path";
             System.out.println("os.name = " + os);
        }
        String userdir = System.getProperty("user.dir");
        String uPath = AdditionalPathUtils.getCrossPlatformPath(chromePath);
        System.out.println("os.name = " + os);
        System.out.println("user.dir = " + userdir);
        System.out.println("Cross Platform Path = " + uPath);
    }
}
