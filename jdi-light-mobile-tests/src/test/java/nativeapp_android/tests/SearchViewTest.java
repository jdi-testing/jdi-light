package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp.android.apiDemos.SearchViewActionBarPage;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.SearchViewPage;
import nativeapp.android.apiDemos.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;


public class SearchViewTest extends ApiDemosTestInit {

    public static final String PLACEHOLDER = "   Search Demo Hint";

    @Test
    public void searchViewTest() {
    IndexPage.viewsPage.click();
    ViewsPage.searchViewPage.base().driver().findElement(MobileBy.
            AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                    ".scrollIntoView(new UiSelector().text(\"Search View\"));")).click();
    SearchViewPage.actionBarPage.click();
    SearchViewActionBarPage.searchViewButton.is().iconifiedByDefault();
    SearchViewActionBarPage.searchViewButton.setExpanded();
    SearchViewActionBarPage.searchViewField.is().searchViewExpanded();
    SearchViewActionBarPage.home.click();
    SearchViewActionBarPage.searchViewButton.isIconified();
    SearchViewActionBarPage.searchViewButton.setExpanded();
    SearchViewActionBarPage.searchViewField.has().searchViewText(PLACEHOLDER);
    SearchViewActionBarPage.searchViewField.input("Settings");
    SearchViewActionBarPage.query.has().searchViewText("Query = Settings");
    SearchViewActionBarPage.searchViewField.clear();
    SearchViewActionBarPage.searchViewField.input("Animation");
    MobileKeyboard.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
    SearchViewActionBarPage.queryText.has().searchViewText("Animation");
    }
}



