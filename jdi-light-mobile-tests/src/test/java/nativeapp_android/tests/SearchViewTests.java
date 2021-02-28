package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.*;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;

public class SearchViewTests extends ApiDemosTestInit {

    public static final String PLACEHOLDER_ACTION_BAR = "   Search Demo Hint";
    public static final String PLACEHOLDER_ALWAYS_EXPANDED = "Search Demo Hint";
    public static final String PLACEHOLDER_FILTER = "Cheese hunt";

    @BeforeMethod(alwaysRun = true)
    public void init() {
        MobileScreen.scrollToElementInList(IndexPage.goToViewPage);
        viewsPage.click();
        MobileScreen.scrollToElementInList(ViewsPage.searchViewPage);
        ViewsPage.searchViewPage.click();
    }

    @Test
    public void searchViewTestForActionBar() {
        SearchViewPage.actionBarPage.click();
        SearchViewActionBarPage.searchViewButton.is().iconifiedByDefault();
        SearchViewActionBarPage.searchViewButton.setExpanded();
        SearchViewActionBarPage.searchViewField.is().expanded();
        SearchViewActionBarPage.home.click();
        SearchViewActionBarPage.searchViewButton.setExpanded();
        SearchViewActionBarPage.searchViewField.has().text(PLACEHOLDER_ACTION_BAR);
        SearchViewActionBarPage.searchViewField.input("Settings");
        SearchViewActionBarPage.query.has().text("Query = Settings");
        SearchViewActionBarPage.searchViewField.clear();
        SearchViewActionBarPage.searchViewField.input("Animation");
        MobileKeyboard.pressKey(AndroidKey.ENTER);
        SearchViewActionBarPage.queryText.has().text("Animation");
    }

    @Test
    public void searchViewTestForAlwaysExpanded() {
        SearchViewPage.alwaysExpandedPage.click();
        SearchViewAlwaysExpandedPage.searchViewField.is().enabled();
        SearchViewAlwaysExpandedPage.searchViewField.has().text(PLACEHOLDER_ALWAYS_EXPANDED);
        SearchViewAlwaysExpandedPage.searchViewField.input("Google");
        SearchViewAlwaysExpandedPage.query.has().text("Query = Google");
        SearchViewAlwaysExpandedPage.crossIcon.click();
        SearchViewAlwaysExpandedPage.searchViewField.input("Yandex");
        MobileKeyboard.pressKey(AndroidKey.ENTER);
        SearchViewAlwaysExpandedPage.queryText.has().text("Yandex");
    }

    @Test
    public void searchViewTestForFilter() {
        SearchViewPage.filterPage.click();
        SearchViewFilterPage.searchViewField.is().enabled();
        SearchViewFilterPage.searchViewField.has().text(PLACEHOLDER_FILTER);
        SearchViewFilterPage.searchViewField.input("edam");
        SearchViewFilterPage.crossIcon.click();
        SearchViewFilterPage.searchViewField.input("yo");
        SearchViewFilterPage.listView.select("Olde York");
    }
}
