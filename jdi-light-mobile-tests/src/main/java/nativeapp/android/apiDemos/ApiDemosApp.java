package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.android.SeekBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(appPackage = "io.appium.android.apis", appActivity = "io.appium.android.apis.ApiDemos")
public class ApiDemosApp {
    public static IndexPage indexPage;
    public static ViewsPage viewsPage;
    public static ButtonsPage buttonsPage;

    public static AnimationPage animationPage;

    public static CheckboxesPage checkboxesPage;
    public static SeekBarPage seekBarPage;

}
