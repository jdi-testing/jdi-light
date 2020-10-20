package nativeapp_android.tests;

import nativeapp.android.apiDemos.ActionBarPage;
import nativeapp.android.apiDemos.ActionBarUsagePage;
import nativeapp.android.apiDemos.AppPage;
import nativeapp.android.apiDemos.IndexPage;
import org.testng.annotations.Test;

public class ActionBarTests {

    @Test
    public void actionBarUsageTest() {
        IndexPage.appPage.click();
        AppPage.actionBarPage.click();
        ActionBarPage.actionBarUsagePage.click();
        ActionBarUsagePage.edit.click();
        ActionBarUsagePage.moreOptions.click();
        ActionBarUsagePage.options.select("Add");
        ActionBarUsagePage.moreOptions.click();
        ActionBarUsagePage.options.select("Share");
    }
}


