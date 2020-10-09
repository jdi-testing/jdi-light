package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import nativeapp.android.ClockApp;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class MobileDeviceTests {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(ClockApp.class);
        logger.toLog("Run Application Tests");
        AppManager.launchApp();
    }

    @Test
    public void mobileRotationTest() {
        MobileDevice.rotate(new DeviceRotation(0, 0, 90));
        Assert.assertEquals(MobileDevice.getRotation().getX(), 0);
        Assert.assertEquals(MobileDevice.getRotation().getY(), 0);
        Assert.assertEquals(MobileDevice.getRotation().getZ(), 90);
    }

    @Test
    public void mobileOrientationTest() {
        MobileDevice.rotate(ScreenOrientation.LANDSCAPE);
        Assert.assertEquals(MobileDevice.getOrientation(), ScreenOrientation.LANDSCAPE);
        MobileDevice.rotate(ScreenOrientation.PORTRAIT);
        Assert.assertEquals(MobileDevice.getOrientation(), ScreenOrientation.PORTRAIT);
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
        Assert.assertEquals(MobileDevice.getLocation().getLatitude(), 49.0);
        Assert.assertEquals(MobileDevice.getLocation().getLongitude(), 123.0);
        //Assert.assertEquals(MobileDevice.getLocation().getAltitude(),10);
    }

    @Test
    public void mobileTimeTest() throws InterruptedException {
        String deviceTime = MobileDevice.getDeviceTime();
        Thread.sleep(1000);
        String deviceTimeWithFormat = MobileDevice.getDeviceTime("DD-MM-YYYY");
        Assert.assertNotEquals(deviceTime, deviceTimeWithFormat);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
