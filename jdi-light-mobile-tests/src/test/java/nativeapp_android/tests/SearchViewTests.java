package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.SearchViewActionBarPage;
import nativeapp.android.apidemos.views.SearchViewAlwaysExpandedPage;
import nativeapp.android.apidemos.views.SearchViewFilterPage;
import nativeapp.android.apidemos.views.SearchViewPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class SearchViewTests extends ApiDemosTestInit {

    public static final String PLACEHOLDER_ActionBar = "   Search Demo Hint";
    public static final String PLACEHOLDER_AlwaysExpanded = "Search Demo Hint";
    public static final String PLACEHOLDER_Filter = "Cheese hunt";

    @Test
    public void searchViewTestForActionBar() {
        IndexPage.viewsPage.click();
        MobileScreen.scrollDown(3300);
        ViewsPage.searchViewPage.click();
        SearchViewPage.actionBarPage.click();
        SearchViewActionBarPage.searchViewButton.is().iconifiedByDefault();
        SearchViewActionBarPage.searchViewButton.setExpanded();
        SearchViewActionBarPage.searchViewField.is().expanded();
        SearchViewActionBarPage.home.click();
        SearchViewActionBarPage.searchViewButton.isIconified();
        SearchViewActionBarPage.searchViewButton.setExpanded();
        SearchViewActionBarPage.searchViewField.has().text(PLACEHOLDER_ActionBar);
        SearchViewActionBarPage.searchViewField.input("Settings");
        SearchViewActionBarPage.query.has().text("Query = Settings");
        SearchViewActionBarPage.searchViewField.clear();
        SearchViewActionBarPage.searchViewField.input("Animation");
        MobileKeyboard.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
        SearchViewActionBarPage.queryText.has().text("Animation");
    }

    @Test
    public void searchViewTestForAlwaysExpanded() {
        IndexPage.viewsPage.click();
        MobileScreen.scrollDown(3300);
        ViewsPage.searchViewPage.click();
        SearchViewPage.alwaysExpandedPage.click();
        SearchViewAlwaysExpandedPage.searchViewField.is().enabled();
        SearchViewAlwaysExpandedPage.searchViewField.has().text(PLACEHOLDER_AlwaysExpanded);
        SearchViewAlwaysExpandedPage.searchViewField.input("Google");
        SearchViewAlwaysExpandedPage.query.has().text("Query = Google");
        SearchViewAlwaysExpandedPage.crossIcon.click();
        SearchViewAlwaysExpandedPage.searchViewField.input("Yandex");
        MobileKeyboard.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
        SearchViewAlwaysExpandedPage.queryText.has().text("Yandex");
    }

    @Test
    public void searchViewTestForFilter() {

        IndexPage.viewsPage.click();
        MobileScreen.scrollDown(3300);
        ViewsPage.searchViewPage.click();
        SearchViewPage.filterPage.click();
        SearchViewFilterPage.searchViewField.is().enabled();
        SearchViewFilterPage.searchViewField.has().text(PLACEHOLDER_Filter);
        SearchViewFilterPage.searchViewField.input("edam");
        SearchViewFilterPage.crossIcon.click();
        SearchViewFilterPage.searchViewField.input("yo");
        SearchViewFilterPage.listView.select("Olde York");
    }
}
