package jdisite.utils;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.driver.get.DriverData.*;

public class DriverUtils {
    public static WebDriver DRIVER;

    public static void runChromeDriver() {
        WebDriverFactory.useDriver(DRIVER_NAME);
        DRIVER = WebDriverFactory.getDriver();
    }
}
