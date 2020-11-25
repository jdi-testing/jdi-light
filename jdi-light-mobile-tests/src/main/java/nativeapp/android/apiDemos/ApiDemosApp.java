package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.android.apiDemos.animation.AnimationPage;
import nativeapp.android.apiDemos.animation.CheckboxesPage;
import nativeapp.android.apiDemos.app.ActionBarDisplayOptionsPage;
import nativeapp.android.apiDemos.app.ActionBarPage;
import nativeapp.android.apiDemos.app.ActionBarUsagePage;
import nativeapp.android.apiDemos.app.AppPage;
import nativeapp.android.apiDemos.app.NotificationPage;
import nativeapp.android.apiDemos.app.StatusBarPage;
import nativeapp.android.apiDemos.views.ButtonsPage;
import nativeapp.android.apiDemos.views.RatingBarPage;
import nativeapp.android.apiDemos.views.SearchViewActionBarPage;
import nativeapp.android.apiDemos.views.SearchViewAlwaysExpandedPage;
import nativeapp.android.apiDemos.views.SearchViewFilterPage;
import nativeapp.android.apiDemos.views.SearchViewPage;
import nativeapp.android.apiDemos.views.SeekBarPage;
import nativeapp.android.apiDemos.views.TextFieldsPage;
import nativeapp.android.apiDemos.views.ViewsPage;

@JApp(appPackage = "io.appium.android.apis", appActivity = "io.appium.android.apis.ApiDemos")
public class ApiDemosApp {

    public static IndexPage indexPage;

    public static ViewsPage viewsPage;

    public static ButtonsPage buttonsPage;

    public static RatingBarPage ratingBarPage;

    public static AnimationPage animationPage;

    public static CheckboxesPage checkboxesPage;

    public static SeekBarPage seekBarPage;

    public static SearchViewPage searchViewPage;

    public static SearchViewActionBarPage searchViewActionBarPage;

    public static SearchViewAlwaysExpandedPage searchViewAlwaysExpandedPage;

    public static SearchViewFilterPage searchViewFilterPage;

    public static TextFieldsPage textFieldsPage;

    public static AppPage appPage;

    public static NotificationPage notificationPage;

    public static StatusBarPage statusBarPage;

    public static ActionBarPage actionBarPage;

    public static ActionBarUsagePage actionBarUsagePage;

    public static ActionBarDisplayOptionsPage actionBarDisplayOptionsPage;
}
