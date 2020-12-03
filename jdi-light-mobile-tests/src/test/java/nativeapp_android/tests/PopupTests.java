package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.PopupPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

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
        PopupPage.searchItem.tap();
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void isPopupDisplayedFromAddItem() {
        PopupPage.makePopupButton.click();
        PopupPage.addItem.tap();
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void isPopupDisplayedFromEditItem() {
        PopupPage.makePopupButton.click();
        PopupPage.editItem.tap();
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void isPopupDisplayedFromShareItem() {
        PopupPage.makePopupButton.click();
        PopupPage.editItem.tap();
        PopupPage.shareItem.tap();
        getDriver().switchTo().alert().accept();
    }
}
