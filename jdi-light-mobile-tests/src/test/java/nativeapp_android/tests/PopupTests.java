package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.PopupPage;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Views']");
        IndexPage.viewsPage.click();
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Popup Menu']");
        IndexPage.popUpMenu.click();
    }

    @Test
    public void isPopupDisplayedFromSearchItem() {
        PopupPage.makePopupButton.click();
        PopupPage.searchItem.longPress();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Search")).is().hidden();
    }

    @Test
    public void isPopupDisplayedFromAddItem() {
        PopupPage.makePopupButton.click();
        PopupPage.addItem.longPress();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Add")).is().hidden();
    }

    @Test
    public void isPopupDisplayedFromEditItem() {
        PopupPage.makePopupButton.click();
        PopupPage.editItem.longPress();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Edit")).is().hidden();
    }

    @Test
    public void isPopupDisplayedFromShareItem() {
        PopupPage.makePopupButton.click();
        PopupPage.editItem.longPress();
        PopupPage.shareItem.longPress();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Share")).is().hidden();
    }
}
