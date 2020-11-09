package nativeapp_android.tests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apiDemos.IndexPage.*;
import static nativeapp.android.apiDemos.RadioButtonPage.*;
import static nativeapp.android.apiDemos.ViewsPage.*;


public class RadioButtonsTests extends ApiDemosTestInit {

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
        try {
            this.getRadioButtons().get("Snack").click();
            radioButtonSnack.is().selected();

            this.getRadioButtons().get("Breakfast").click();
            radioButtonBreakfast.is().selected();

            this.getRadioButtons().get("Lunch").click();
            radioButtonLunch.is().selected();

            this.getRadioButtons().get("Dinner").click();
            radioButtonDinner.is().selected();

            this.getRadioButtons().get("All of them").click();
            radioButtonAll.is().selected();
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }
    }

    private UIElement getRadioButtons() {
        return listOfButtons.find("io.appium.android.apis:id");
    }
}
