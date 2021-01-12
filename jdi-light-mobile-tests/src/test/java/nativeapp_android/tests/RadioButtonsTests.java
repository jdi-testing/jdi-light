package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.init.MobileUIFactory.$;
import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.RadioButtonsPage.*;
import static nativeapp.android.apidemos.views.ViewsPage.radioGroupViewPage;

public class RadioButtonsTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Views']");
        viewsPage.click();
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Radio Group']"); //todo: scroll to element?
        radioGroupViewPage.click();
    }

    @Test
    public void clickOverAllRadioButtons() {
        $(radioButton, "Snack").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296728");

        $(radioButton, "Breakfast").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296319");

        $(radioButton, "Lunch").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296544");

        $(radioButton, "Dinner").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296401");

        $(radioButton, "All of them").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296294");
    }

    @Test
    public void verifyThatButtonsNotSelected() {
        $(radioButton, "All of them").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296294");

        buttonClear.click();
        logChose.is().text("You have selected: (none)");

        $(radioButton, "Dinner").click();
        logChose.is().text("You have selected: 2131296401");
    }
}