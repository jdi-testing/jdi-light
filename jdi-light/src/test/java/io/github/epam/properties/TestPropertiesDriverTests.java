package io.github.epam.properties;

import com.epam.jdi.light.common.TestPropertiesParser;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TestPropertiesDriverTests {

    private TestPropertiesParser testPropertiesParser;
    private String filePath = "";

    private List<String> drivers = new ArrayList<>();
    private String driverFolder;

    @BeforeSuite
    public void setUp() {

         testPropertiesParser = new TestPropertiesParser(filePath);

         drivers.add("chrome");
         drivers.add("ie");
         drivers.add("firefox");

         driverFolder = "";
    }

    @Test
    public void driverTest() {

        Assert.assertTrue(drivers.contains(testPropertiesParser.getValue("driver")));
    }

    @Test
    public void driverFolderTest() {

        Assert.assertTrue(driverFolder.equals(testPropertiesParser.getValue("drivers.folder")));
    }

    @Test
    public void driverVersionTest() {

        Assert.assertTrue(testPropertiesParser.checkRegEx(testPropertiesParser.getValue("driver.version"), ""));
    }
}
