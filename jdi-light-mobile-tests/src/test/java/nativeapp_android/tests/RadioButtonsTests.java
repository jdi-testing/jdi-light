package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.RadioButtonsPage.buttonClear;
import static nativeapp.android.apidemos.views.RadioButtonsPage.logChose;
import static nativeapp.android.apidemos.views.ViewsPage.radioGroupViewPage;

public class RadioButtonsTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Views']");
        viewsPage.click();
        MobileScreen.scrollDownToXpath("//android.widget.TextView[@content-desc='Radio Group']");
        radioGroupViewPage.click();
    }

    @Test
    public void clickOverAllRadioButtons() {
        getItemByText("Snack").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296728");

        getItemByText("Breakfast").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296319");

        getItemByText("Lunch").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296544");

        getItemByText("Dinner").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296401");

        getItemByText("All of them").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296294");
    }

    @Test
    public void verifyThatButtonsNotSelected() {
        getItemByText("All of them").click();
        logChose.is().displayed();
        logChose.is().text("You have selected: 2131296294");

        buttonClear.click();
        logChose.is().text("You have selected: (none)");
    }

    private WebElement getItemByText(String item) {
        return  getDriver().findElements(By.className("android.widget.RadioButton"))
                .stream()
                .filter(element -> element.getText().equals(item))
                .findAny().get();
    }
}