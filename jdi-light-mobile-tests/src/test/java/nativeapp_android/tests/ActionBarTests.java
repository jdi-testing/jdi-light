package nativeapp_android.tests;

import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.app.ActionBarDisplayOptionsPage;
import nativeapp.android.apidemos.app.ActionBarPage;
import nativeapp.android.apidemos.app.ActionBarUsagePage;
import nativeapp.android.apidemos.app.AppPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionBarTests extends ApiDemosTestInit {

    public static final String PLACEHOLDER = "Search…";

    @BeforeMethod
    public void init() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.actionBarUsagePage.click();
    }

    @Test
    public void actionBarUsagePageSearchTest() {
        ActionBarUsagePage.searchButton.setExpanded();
        ActionBarUsagePage.searchVield.is().enabled();
        ActionBarUsagePage.searchVield.has().text(PLACEHOLDER);
        ActionBarUsagePage.searchVield.input("Internet");
        ActionBarUsagePage.text.has().text("Query so far: Internet");
        ActionBarUsagePage.clearQuery.click();
    }

    @Test
    public void actionBarUsagePageEditTest() {
        ActionBarUsagePage.edit.is().enabled();
        ActionBarUsagePage.edit.click();
        ActionBarUsagePage.text.is().displayed();
    }

    @Test
    public void actionBarUsagePageMoreOptionsTest() {
        ActionBarUsagePage.moreOptions.is().enabled();
        ActionBarUsagePage.moreOptions.click();
        ActionBarUsagePage.listView.selectOption("Sort");
        ActionBarUsagePage.listView.selectOption("Alphabetically");
        ActionBarUsagePage.text.is().displayed();
    }

    @Test
    public void displayOptionsPageMoreOptionsTest() {
        ActionBarDisplayOptionsPage.moreOptions.is().enabled();
        ActionBarDisplayOptionsPage.moreOptions.click();
        ActionBarDisplayOptionsPage.listView.selectOption("Menu Item");
    }
}


