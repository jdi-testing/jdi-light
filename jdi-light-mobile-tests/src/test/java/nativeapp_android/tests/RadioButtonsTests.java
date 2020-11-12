package nativeapp_android.tests;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apiDemos.IndexPage.*;
import static nativeapp.android.apiDemos.RadioButtonPage.*;
import static nativeapp.android.apiDemos.ViewsPage.*;


public class RadioButtonsTests extends ApiDemosTestInit {

    protected UIElement buttonsList;
    protected String listOfButtons = "io.appium.android.apis:id";

    public RadioButtonsTests() {
        buttonsList = new UIElement();
        buttonsList.core().setLocator(listOfButtons);
    }

    @BeforeMethod
    public void initSteps() {
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Views']");
        viewsPage.click();
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Radio Group']");
        radioGroupViewPage.click();
    }

    @Test
    public void isRadioButtonsExist() {
        radioButtonSnack.is().hidden();
        radioButtonBreakfast.is().hidden();
        radioButtonLunch.is().hidden();
        radioButtonDinner.is().hidden();
        radioButtonAll.is().hidden();
    }

    @Test
    public void clickOverAllRadioButtons() {
        radioButtonSnack.click();
        radioButtonSnack.is().selected();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296728");

        radioButtonBreakfast.click();
        radioButtonBreakfast.is().selected();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296319");

        radioButtonLunch.click();
        radioButtonLunch.is().selected();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296544");

        radioButtonDinner.click();
        radioButtonDinner.is().selected();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296401");

        radioButtonAll.click();
        radioButtonAll.is().selected();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296294");
    }

    @Test
    public void verifyThatButtonsNotSelected() {
        radioButtonSnack.click();
        radioButtonSnack.is().selected();
        logChose.is().displayed();

        radioButtonBreakfast.is().deselected();
        radioButtonLunch.is().deselected();
        radioButtonDinner.is().deselected();
        radioButtonAll.is().deselected();
    }

    @Test
    public void getButtonByText() {
        UIElement menuElements = buttonsList.find("/snack");
        menuElements.click();
        radioButtonSnack.is().selected();
    }

    @Test
    public void clickOverAllItemsByText() {
         allItemsInMenu.core().get().findElements(By.className("android.widget.RadioButton"))
                 .stream()
                 .filter(element -> element.getText().equals("Snack"))
                 .findAny().get().click();
    }


    @Test
    public void clickByText() {
        allItemsInMenu.finds(By.className("android.widget.RadioButton")).foreach(e -> e.find(By.id("io.appium.android.apis:id/snack")).click());
    }
}
