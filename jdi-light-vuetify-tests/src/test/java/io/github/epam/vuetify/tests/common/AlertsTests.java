package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AlertsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.alertsPage;

import static io.github.com.pages.AlertsPage.*;
import static org.hamcrest.Matchers.containsString;


public class AlertsTests extends TestsInit {
    @BeforeClass
    public void before() {
        alertsPage.open();
        waitCondition(() -> alertsPage.isOpened());
        alertsPage.checkOpened();
    }

    @Test(dataProvider = "colorAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void colorAlertsTest(int index, String color, String backgroundColor) {
        basicAlerts.get(index).show();
        basicAlerts.get(index).has().color(color).and().backgroundColor(backgroundColor);
    }

    @Test
    public void themeAlertsTest() {
        basicAlerts.get(1).show();
        basicAlerts.get(1).has().darkTheme();
    }

    @Test
    public void denseAlertsTest() {
        denseAlerts.forEach(denseAlert -> {
            denseAlert.show();
            denseAlert.is().dense();
        });
    }

    @Test
    public void heightAlertsTest() {
        dismissibleAlert.show();
        dismissibleAlert.has().height(104);
    }

    @Test
    public void widthAlertsTest() {
        dismissibleAlert.show();
        dismissibleAlert.has().width(1136);
    }

    @Test
    public void elevationAlertsTest() {
        basicAlerts.get(4).show();
        basicAlerts.get(4).is().elevated().and().elevation(24);
    }

    @Test
    public void outlinedAlertsTest() {
        denseAlerts.get(4).show();
        denseAlerts.get(4).is().outlined();
    }

    @Test
    public void roundedAlertsTest() {
        roundedAlert.show();
        roundedAlert.is().rounded();
    }

    @Test
    public void shapedAlertsTest() {
        basicAlerts.get(3).show();
        basicAlerts.get(3).is().shaped();
    }

    @Test
    public void tileAlertsTest() {
        tileAlert.show();
        tileAlert.is().tile();
    }

    @Test
    public void textStyledAlertsTest() {
        denseAlerts.get(2).show();
        denseAlerts.get(2).is().textStyled();
    }

    @Test(dataProvider = "basicAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
    public void basicAlertsHaveProperTextAndIcon(int index, String alertText, String cssClassText) {
        basicAlerts.get(index).has().text(alertText);
        basicAlerts.get(index).icon().has().cssClass(cssClassText);
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
}
