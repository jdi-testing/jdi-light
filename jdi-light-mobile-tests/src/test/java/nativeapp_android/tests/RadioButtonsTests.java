package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.RadioButtonsPage.*;
import static nativeapp.android.apidemos.views.ViewsPage.radioGroupViewPage;

public class RadioButtonsTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        MobileScreen.scrollToElementInList(viewsPage);
        viewsPage.click();
        MobileScreen.scrollToElementInList(radioGroupViewPage);
        radioGroupViewPage.click();
    }

    @Test
    public void clickOverAllRadioButtons() {
        radioButton.select(1);
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296728");
//
//        radioButton.select("Breakfast");
//        logChose.is().displayed();
//        logChose.is().text("You have selected: 2131296319");
//
//        radioButton.select("Lunch");
//        logChose.is().displayed();
//        logChose.is().text("You have selected: 2131296544");
//
//        radioButton.select("Dinner");
//        logChose.is().displayed();
//        logChose.is().text("You have selected: 2131296401");
//
//        radioButton.select("All of Them");
//        logChose.is().displayed();
//        logChose.is().text("You have selected: 2131296294");
//    }
//
//    @Test
//    public void verifyThatButtonsNotSelected() {
//        radioButton.select("All of Them");
//        logChose.is().displayed();
//        logChose.is().text("You have selected: 2131296294");
//
//        buttonClear.click();
//        logChose.is().text("You have selected: (none)");
//
//        radioButton.select("Dinner");
//        logChose.is().text("You have selected: 2131296401");
    }
}