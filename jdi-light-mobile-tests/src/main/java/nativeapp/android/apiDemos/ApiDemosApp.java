package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.android.apiDemos.Animation.AnimationPage;
import nativeapp.android.apiDemos.Animation.CheckboxesPage;
import nativeapp.android.apiDemos.App.ActionBarDisplayOptionsPage;
import nativeapp.android.apiDemos.App.ActionBarPage;
import nativeapp.android.apiDemos.App.ActionBarUsagePage;
import nativeapp.android.apiDemos.App.AppPage;
import nativeapp.android.apiDemos.App.NotificationPage;
import nativeapp.android.apiDemos.App.StatusBarPage;
import nativeapp.android.apiDemos.Views.ButtonsPage;
import nativeapp.android.apiDemos.Views.RatingBarPage;
import nativeapp.android.apiDemos.Views.SearchViewActionBarPage;
import nativeapp.android.apiDemos.Views.SearchViewAlwaysExpandedPage;
import nativeapp.android.apiDemos.Views.SearchViewFilterPage;
import nativeapp.android.apiDemos.Views.SearchViewPage;
import nativeapp.android.apiDemos.Views.SeekBarPage;
import nativeapp.android.apiDemos.Views.TextFieldsPage;
import nativeapp.android.apiDemos.Views.ViewsPage;

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

    public static ProgressBarPage progressBarPage;
}
