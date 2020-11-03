package android;

import com.epam.jdi.light.mobile.elements.common.EmulatorPower;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(appPackage = "com.android.launcher3",
        appActivity = "com.android.launcher3.Launcher")
public class AndroidEmulatorPower {
    public static EmulatorPower emulatorPower;
}
