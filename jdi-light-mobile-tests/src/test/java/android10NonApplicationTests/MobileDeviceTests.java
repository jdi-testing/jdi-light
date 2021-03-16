package android10NonApplicationTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import nativeapp_android.ApiDemosTestInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class MobileDeviceTests extends ApiDemosTestInit {

    @Test
    public void mobileRotationTest() {
        MobileDevice.rotate(new DeviceRotation(0, 0, 90));
        jdiAssert(MobileDevice.getRotation().getX(), Matchers.is(0));
        jdiAssert(MobileDevice.getRotation().getY(), Matchers.is(0));
        jdiAssert(MobileDevice.getRotation().getZ(), Matchers.is(90));
    }

    @Test
    public void mobileOrientationTest() {
        MobileDevice.rotate(ScreenOrientation.LANDSCAPE);
        jdiAssert(MobileDevice.getOrientation(), Matchers.is(ScreenOrientation.LANDSCAPE));
        MobileDevice.rotate(ScreenOrientation.PORTRAIT);
        jdiAssert(MobileDevice.getOrientation(), Matchers.is(ScreenOrientation.PORTRAIT));
    }

    @Test
    public void mobileLockTest() {
        MobileDevice.lockDevice();
        MobileDevice.unlockDevice();
        MobileDevice.lockDevice(Duration.ofSeconds(2));
    }

    @Test
    public void mobileLocationTest() {
        MobileDevice.setLocation(new Location(49, 123, 10));
        jdiAssert(MobileDevice.getLocation().getLatitude(), Matchers.is(49.0));
        jdiAssert(MobileDevice.getLocation().getLongitude(), Matchers.is(123.0));
    }

    @Test
    public void performanceDataTest() {
        logger.info("Performace data types %s", MobileDevice.getPerformanceDataTypes());
        logger.info("CPU info %s",
                MobileDevice.getPerformanceData("", "cpuinfo", 5));
        logger.info("Battery info",
                MobileDevice.getPerformanceData("", "batteryinfo", 5));
        logger.info("Network info %s",
                MobileDevice.getPerformanceData("", "networkinfo", 5));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
