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
        MobileScreen.scrollToElementInList(IndexPage.goToViewPage);
        IndexPage.viewsPage.click();
        MobileScreen.scrollToElementInList(IndexPage.goToPopupMenuPage);
        IndexPage.popUpMenu.click();
    }

    @Test
    public void isPopupDisplayedFromSearchItem() {
        PopupPage.makePopupButton.click();
        //PopupPage.searchItem.longPress();
        PopupPage.searchItem.tap();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Search")).isExist();
    }

    @Test
    public void isPopupDisplayedFromAddItem() {
        PopupPage.makePopupButton.click();
        //PopupPage.addItem.longPress();//todo:comment
        PopupPage.addItem.tap();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Add")).isExist();
    }

    @Test
    public void isPopupDisplayedFromEditItem() {
        PopupPage.makePopupButton.click();
        //PopupPage.editItem.longPress();
        PopupPage.editItem.tap();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Edit")).isExist();
    }

    @Test
    public void isPopupDisplayedFromShareItem() {
        PopupPage.makePopupButton.click();
        //PopupPage.editItem.longPress();
        PopupPage.editItem.tap();
        //PopupPage.shareItem.longPress();
        PopupPage.shareItem.tap();
        PopupPage.screen.find(By.linkText("Clicked popup menu item Share")).isExist();
    }
}
