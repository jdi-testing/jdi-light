package nativeapp_android.tests;

import nativeapp.android.apiDemos.ActionBarDisplayOptionsPage;
import nativeapp.android.apiDemos.ActionBarPage;
import nativeapp.android.apiDemos.ActionBarUsagePage;
import nativeapp.android.apiDemos.AppPage;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

public class ActionBarTests extends ApiDemosTestInit {

    public static final String PLACEHOLDER = "Search…";

    @Test
    public void actionBarUsagePageSearchTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.actionBarUsagePage.click();
        ActionBarUsagePage.searchButton.is().iconifiedByDefault();
        ActionBarUsagePage.searchButton.setExpanded();
        ActionBarUsagePage.searchVield.is().enabled();
        ActionBarUsagePage.searchVield.has().text(PLACEHOLDER);
        ActionBarUsagePage.searchVield.input("Internet");
        ActionBarUsagePage.text.has().text("Query so far: Internet");
        ActionBarUsagePage.clearQuery.click();
        ActionBarUsagePage.searchButton.isIconified();
    }

    @Test
    public void actionBarUsagePageEditTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.actionBarUsagePage.click();
        ActionBarUsagePage.edit.is().enabled();
        ActionBarUsagePage.edit.click();
        ActionBarUsagePage.text.is().displayed();
    }

    @Test
    public void actionBarUsagePageMoreOptionsTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.actionBarUsagePage.click();
        ActionBarUsagePage.moreOptions.is().enabled();
        ActionBarUsagePage.moreOptions.click();
        ActionBarUsagePage.listView.selectOption("Sort");
        ActionBarUsagePage.listView.selectOption("Alphabetically");
        ActionBarUsagePage.text.is().displayed();
    }

    @Test
    public void displayOptionsPageMoreOptionsTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.displayOptionsPage.click();
        ActionBarDisplayOptionsPage.moreOptions.is().enabled();
        ActionBarDisplayOptionsPage.moreOptions.click();
        ActionBarDisplayOptionsPage.listView.selectOption("Menu Item");
    }

    @Test
    public void displayOptionsPageDisplayHomeAsUpTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.displayOptionsPage.click();
        ActionBarDisplayOptionsPage.displayHomeAsUp.is().enabled();
        ActionBarDisplayOptionsPage.displayHomeAsUp.click();
        ActionBarDisplayOptionsPage.navigateUp.is().displayed();
    }

    @Test
    public void displayOptionsPageDisplayShowHomeAndDisplayUseLogoTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.displayOptionsPage.click();
        ActionBarDisplayOptionsPage.displayShowHome.is().enabled();
        ActionBarDisplayOptionsPage.displayShowHome.click();
        ActionBarDisplayOptionsPage.imageView.is().displayed();
        ActionBarDisplayOptionsPage.displayUseLogo.is().enabled();
        ActionBarDisplayOptionsPage.displayUseLogo.click();
        ActionBarDisplayOptionsPage.imageView.is().displayed();
    }

    @Test
    public void displayOptionsPageDisplayShowTitleAndDisplayShowCustomAndCycleCustomGravityTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.displayOptionsPage.click();
        ActionBarDisplayOptionsPage.displayShowTitle.is().enabled();
        ActionBarDisplayOptionsPage.displayShowTitle.click();
        ActionBarDisplayOptionsPage.textView.is().hidden();
        ActionBarDisplayOptionsPage.displayShowCustom.is().enabled();
        ActionBarDisplayOptionsPage.displayShowCustom.click();
        ActionBarDisplayOptionsPage.customView.is().displayed();
        ActionBarDisplayOptionsPage.cycleCustomViewGravity.is().enabled();
        ActionBarDisplayOptionsPage.cycleCustomViewGravity.click();
    }

    @Test
    public void displayOptionsPageNavigationTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.displayOptionsPage.click();
        ActionBarDisplayOptionsPage.navigation.is().enabled();
        ActionBarDisplayOptionsPage.navigation.click();
        ActionBarDisplayOptionsPage.horizontalScrollView.is().displayed();
        ActionBarDisplayOptionsPage.horizontalScrollView.selectOption("TAB 1");
    }
}


