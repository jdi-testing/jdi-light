package androidtests.emulatorpower;

import io.appium.java_client.android.AndroidBatteryInfo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static android.AndroidEmulatorPower.emulatorPower;
import static io.appium.java_client.android.PowerACState.OFF;
import static io.appium.java_client.android.PowerACState.ON;

public class EmulatorPowerTest extends EmulatorPowerInit {
    @DataProvider
    public Object[][] capacity() {
        return new Object[][]{
                {0},
                {45},
                {76},
                {100},
        };
    }

    @Test(dataProvider = "capacity")
    public void setPowerCapacityTest(int capacity) {
        emulatorPower.setPowerCapacity(capacity);
        List<List<Object>> listOfData = emulatorPower.getPerformanceData(
                "com.google.android.apps.nexuslauncher", "batteryinfo", 5);
        int getCapacity = Integer.valueOf(listOfData.get(1).get(0).toString());
        Assert.assertEquals(getCapacity, capacity);
    }

    @Test
    public void setPowerACTest() {
        emulatorPower.setPowerAC(ON);
        Assert.assertSame(emulatorPower.getStatusChargingAndroid(),
                AndroidBatteryInfo.BatteryState.CHARGING);
        emulatorPower.setPowerAC(OFF);
        Assert.assertSame(emulatorPower.getStatusChargingAndroid(),
                AndroidBatteryInfo.BatteryState.NOT_CHARGING);
    }
}
