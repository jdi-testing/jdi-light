package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.android.apidemos.animation.AnimationPage;
import nativeapp.android.apidemos.animation.CheckboxesPage;
import nativeapp.android.apidemos.app.AppPage;
import nativeapp.android.apidemos.app.NotificationPage;
import nativeapp.android.apidemos.app.StatusBarPage;
import nativeapp.android.apidemos.views.ButtonsPage;
import nativeapp.android.apidemos.views.PhotosPage;
import nativeapp.android.apidemos.views.RatingBarPage;
import nativeapp.android.apidemos.views.SearchViewActionBarPage;
import nativeapp.android.apidemos.views.SearchViewAlwaysExpandedPage;
import nativeapp.android.apidemos.views.SearchViewFilterPage;
import nativeapp.android.apidemos.views.SearchViewPage;
import nativeapp.android.apidemos.views.SeekBarPage;
import nativeapp.android.apidemos.views.TextFieldsPage;
import nativeapp.android.apidemos.views.ViewsPage;

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

    public static PhotosPage photosPage;
}
