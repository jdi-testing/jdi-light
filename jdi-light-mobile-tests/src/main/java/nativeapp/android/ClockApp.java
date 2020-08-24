package nativeapp.android;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(appPackage = "com.google.android.deskclock", appActivity = "com.android.deskclock.DeskClock")
public class ClockApp {
    public static Alarm alarm;
}
