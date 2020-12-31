package nativeapp_android.tests.SystemAndroid10Tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import nativeapp.android.ClockApp;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static org.assertj.core.api.Assertions.assertThat;

public class MobileDeviceTests {

    @BeforeMethod
    public void init() {
        initMobile(ClockApp.class);
        AppManager.launchApp();
    }

    @Test
    public void mobileRotationTest() {
        MobileDevice.rotate(new DeviceRotation(0, 0, 90));
        assertThat(MobileDevice.getRotation().getX()).isEqualTo(0);
        assertThat(MobileDevice.getRotation().getY()).isEqualTo(0);
        assertThat(MobileDevice.getRotation().getZ()).isEqualTo(90);
    }

    @Test
    public void mobileOrientationTest() {
        MobileDevice.rotate(ScreenOrientation.LANDSCAPE);
        assertThat(MobileDevice.getOrientation()).isEqualTo(ScreenOrientation.LANDSCAPE);
        MobileDevice.rotate(ScreenOrientation.PORTRAIT);
        assertThat(MobileDevice.getOrientation()).isEqualTo(ScreenOrientation.PORTRAIT);
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
        assertThat(MobileDevice.getLocation().getLatitude()).isEqualTo(49.0);
        assertThat(MobileDevice.getLocation().getLongitude()).isEqualTo(123.0);
    }

    @Test
    public void mobileTimeTest() throws InterruptedException {
        String deviceTime = MobileDevice.getDeviceTime();
        getDriver().wait(3000);
        String deviceTimeWithFormat = MobileDevice.getDeviceTime("DD-MM-YYYY");
        assertThat(deviceTime).isNotEqualTo(deviceTimeWithFormat);
    }

    @Test
    public void performanceDataTest() {
        System.out.println(MobileDevice.getPerformanceDataTypes());
        System.out.println(MobileDevice.getPerformanceData("", "cpuinfo", 5));
        System.out.println(MobileDevice.getPerformanceData("", "batteryinfo", 5));
        System.out.println(MobileDevice.getPerformanceData("", "networkinfo", 5));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
