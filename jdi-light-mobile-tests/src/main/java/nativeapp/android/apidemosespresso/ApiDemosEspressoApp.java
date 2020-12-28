package nativeapp.android.apidemosespresso;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.android.apidemosespresso.app.EspressoAppPage;


@JApp(appPackage = "io.appium.android.apis", appActivity = "io.appium.android.apis.ApiDemos")
public class ApiDemosEspressoApp {

    public static EspressoIndexPage indexPage;

    public static EspressoAppPage appPage;

}
