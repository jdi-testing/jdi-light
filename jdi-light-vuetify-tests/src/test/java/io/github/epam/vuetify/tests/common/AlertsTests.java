package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import io.github.com.custom.CustomAlert;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AlertsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.alertsPage;
import static io.github.com.pages.AlertsPage.dismissibleAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlertResetButton;
import static org.hamcrest.Matchers.containsString;


public class AlertsTests extends TestsInit {
    @BeforeClass
    public void before() {
        alertsPage.open();
        waitCondition(() -> alertsPage.isOpened());
        alertsPage.checkOpened();
    }

    @Test(dataProvider = "basicAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void basicAlertsHaveProperTextAndIcon(CustomAlert basicAlertType, String alertText, String cssClassText,
                                                 String colorCssStyle, String color) {
        basicAlertType.has().text(alertText);
        basicAlertType.getIcon().has().cssClass(cssClassText);
        basicAlertType.has().css(colorCssStyle, color);
        checkBorderColor(basicAlertType, color);
    }

    @Test(dataProvider = "dismissibleAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void dismissibleAlertCouldBeClosed(String alertText) {
        dismissibleAlert.is().displayed();
        dismissibleAlert.has().text(containsString(alertText));
        dismissibleAlert.getButton().click();

        dismissibleAlert.is().hidden();
        dismissibleAlertResetButton.is().displayed();
        dismissibleAlertResetButton.click();

        dismissibleAlert.is().displayed();
        dismissibleAlert.has().text(containsString(alertText));
    }

    private void checkBorderColor(HasAssert<? extends UIAssert<?, ?>> element, String color) {
        element.has().css("border-bottom-color", color);
        element.has().css("border-left-color", color);
        element.has().css("border-right-color", color);
        element.has().css("border-top-color", color);
    }
}
