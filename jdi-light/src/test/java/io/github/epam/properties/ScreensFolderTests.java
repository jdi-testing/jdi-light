package io.github.epam.properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Properties;
import java.util.regex.Matcher;

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

    public static String getCrossPlatformPath(String path) {
        return path.replaceAll("[\\\\|/]", Matcher.quoteReplacement(File.separator));
    }

    @Test
    public void crossPlatformPathTests() {
        String chromePath = "";
        System.getProperties().list(System.out);

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
        String uPath = getCrossPlatformPath(chromePath);
        System.out.println("os.name = " + os);
        System.out.println("Cross Platform Path = " + uPath);
    }
}
