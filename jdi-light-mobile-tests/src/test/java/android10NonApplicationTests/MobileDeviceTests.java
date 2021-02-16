package android10NonApplicationTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class MobileDeviceTests extends ApiDemosTestInit {

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
