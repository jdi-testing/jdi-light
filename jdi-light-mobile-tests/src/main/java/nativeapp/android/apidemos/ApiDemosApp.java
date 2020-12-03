package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import nativeapp.android.apidemos.animation.AnimationPage;
import nativeapp.android.apidemos.animation.CheckboxesPage;
import nativeapp.android.apidemos.app.ActionBarDisplayOptionsPage;
import nativeapp.android.apidemos.app.ActionBarPage;
import nativeapp.android.apidemos.app.ActionBarUsagePage;
import nativeapp.android.apidemos.app.AppPage;
import nativeapp.android.apidemos.app.NotificationPage;
import nativeapp.android.apidemos.app.StatusBarPage;
import nativeapp.android.apidemos.views.*;
import nativeapp.android.apidemos.app.FragmentPage;
import nativeapp.android.apidemos.app.ContextMenuPage;

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

    public static DateWidgetsPage dateWidgetsPage;

    public static DatePickerPage datePickerPage;

    public static RadialPickerPage radialPickerPage;

    public static PickerPage pickerPage;

    public static FragmentPage fragmentPage;

    public static ContextMenuPage contextMenuPage;

    public static ProgressBarPage progressBarPage;

    public static SpinnerPage spinnerPage;

    public static ExpandableListPage expandableListPage;

    public static TabsPage tabsPage;

    public static PopupPage popupPage;

    public static GalleryPage galleryPage;

    public static ImageSwitcherPage imageSwitcherPage;

}
