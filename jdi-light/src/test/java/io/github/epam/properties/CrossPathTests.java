package io.github.epam.properties;

import com.epam.jdi.light.common.AdditionalPathUtils;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.epam.jdi.light.common.Property.*;

public class CrossPathTests {
    private final String osName = System.getProperty("os.name");
    private final String DRIVER_PATH = "~/my/relative/path";
    private final String CHROME_CAPABILITIES = "~/src/test/resources";
    private final String FF_CAPABILITIES = "~/src/test/resources";
    private final String IE_CAPABILITIES = "~/src/test/resources";
    private final String SCREEN_FOLDER = "~/my/relative/path";

    @Test
    public void crossPlatformPathTests() {
        Properties properties = new Properties();
        properties.setProperty(DRIVERS_FOLDER_PROPERTY.getName(), AdditionalPathUtils.getCrossPlatformPath(DRIVER_PATH));
        properties.setProperty(CHROME_CAPABILITIES_PATH.getName(), AdditionalPathUtils.getCrossPlatformPath(CHROME_CAPABILITIES));
        properties.setProperty(FF_CAPABILITIES_PATH.getName(), AdditionalPathUtils.getCrossPlatformPath(FF_CAPABILITIES));
        properties.setProperty(IE_CAPABILITIES_PATH.getName(), AdditionalPathUtils.getCrossPlatformPath(IE_CAPABILITIES));
        properties.setProperty(SCREENS_FOLDER_PROPERTY.getName(), AdditionalPathUtils.getCrossPlatformPath(SCREEN_FOLDER));

        System.out.println("current system: " + osName);
        String userdir = System.getProperty("user.dir");
        System.out.println("user.dir = " + userdir);
        System.out.println(DRIVERS_FOLDER_PROPERTY.getName() + " = " + userdir + properties.getProperty(DRIVERS_FOLDER_PROPERTY.getName()).substring(1));
        System.out.println(CHROME_CAPABILITIES_PATH.getName() + " = " + userdir + properties.getProperty(CHROME_CAPABILITIES_PATH.getName()).substring(1));
        System.out.println(FF_CAPABILITIES_PATH.getName() + " = " + userdir + properties.getProperty(FF_CAPABILITIES_PATH.getName()).substring(1));
        System.out.println(IE_CAPABILITIES_PATH.getName() + " = " + userdir + properties.getProperty(IE_CAPABILITIES_PATH.getName()).substring(1));
        System.out.println(SCREENS_FOLDER_PROPERTY.getName() + " = " + userdir + properties.getProperty(SCREENS_FOLDER_PROPERTY.getName()).substring(1));
    }
}
