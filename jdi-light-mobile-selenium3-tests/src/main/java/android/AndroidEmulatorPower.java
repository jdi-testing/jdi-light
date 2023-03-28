package android;

import com.epam.jdi.light.mobile.elements.common.EmulatorPower;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(appPackage = "com.google.android.apps.nexuslauncher",
        appActivity = "com.google.android.apps.nexuslauncher.NexusLauncherActivity")
public class AndroidEmulatorPower {
    public static EmulatorPower emulatorPower;
}
