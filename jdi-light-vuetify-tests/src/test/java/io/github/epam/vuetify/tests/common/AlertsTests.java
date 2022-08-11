package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AlertsTestsDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Nullable;

import static com.epam.jdi.light.elements.base.Conditions.visible;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.alertsPage;
import static io.github.com.pages.AlertsPage.dismissibleAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlertResetButton;
import static io.github.com.pages.AlertsPage.transitionAlertToggleButton;
import static io.github.com.pages.AlertsPage.transitionAlert;
import static org.hamcrest.Matchers.containsString;


public class AlertsTests extends TestsInit {
    @BeforeClass
    public void before() {
        alertsPage.open();
        waitCondition(() -> alertsPage.isOpened());
        alertsPage.checkOpened();
    }

    @Test(dataProvider = "basicAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void basicAlertsHaveProperTextAndIcon(Alert basicAlertType, String alertText, String cssClassText,
                                                 String colorCssStyle, String color, @Nullable String shape) {
        basicAlertType.has().text(alertText);
        basicAlertType.icon().has().cssClass(cssClassText);
        basicAlertType.has().css(colorCssStyle, color);
        checkBorderColor(basicAlertType, color);
        if (shape != null) basicAlertType.has().classValue(Matchers.containsString(shape));
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

    @Test(dataProvider = "prominentAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void prominentAlertsTest(Alert prominentAlertType, String cssClassText, String iconCssText) {
        prominentAlertType.show();
        prominentAlertType.shouldBe(visible);
        prominentAlertType.has().classValue(Matchers.containsString(cssClassText));
        prominentAlertType.icon().has().classValue(Matchers.containsString(iconCssText));
    }

    @Test(dataProvider = "denseAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void denseAlertsTest(Alert denseAlertType, String cssText, String cssClassText, String cssType, String cssColor) {
        denseAlertType.show();
        denseAlertType.shouldBe(visible);
        denseAlertType.has().text(cssText);
        denseAlertType.icon().has().classValue(Matchers.containsString(cssClassText));
        denseAlertType.has().css(cssType, cssColor);
    }

    @Test(dataProvider = "outlinedAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void outlinedAlertsTest(Alert outlinedAlertType, String cssClassText, String cssType, String cssColor) {
        outlinedAlertType.show();
        outlinedAlertType.shouldBe(visible);
        outlinedAlertType.has().classValue(Matchers.containsString(cssClassText));
        outlinedAlertType.has().css(cssType, cssColor);
        if (outlinedAlertType.hasIcon()) outlinedAlertType.icon().has().classValue(Matchers.containsString(cssClassText));
    }

    @Test(dataProvider = "borderAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void borderAlertsTest(Alert borderAlertType, String cssText, String cssBorder, String cssType, String cssColor) {
        borderAlertType.show();
        borderAlertType.shouldBe(visible);
        borderAlertType.has().classValue(Matchers.containsString(cssBorder));
        borderAlertType.has().text(cssText);
        borderAlertType.has().css(cssType, cssColor);
    }

    @Test(dataProvider = "transitionAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void transitionAlertsTest(String attrName, String attrValue, String buttonName) {
        transitionAlertToggleButton.show();
        transitionAlertToggleButton.has().text(buttonName);
        transitionAlertToggleButton.click();
        waitCondition(() -> transitionAlert.isNotVisible());
        transitionAlert.has().attr(attrName, Matchers.containsString(attrValue));
    }

    private void checkBorderColor(HasAssert<? extends UIAssert<?, ?>> element, String color) {
        element.has().css("border-bottom-color", color);
        element.has().css("border-left-color", color);
        element.has().css("border-right-color", color);
        element.has().css("border-top-color", color);
    }
}
