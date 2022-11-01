package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AlertsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.alertsPage;

import static io.github.com.pages.AlertsPage.basicAlerts;
import static io.github.com.pages.AlertsPage.denseAlerts;
import static io.github.com.pages.AlertsPage.dismissibleAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlertResetButton;
import static io.github.com.pages.AlertsPage.roundedAlert;
import static io.github.com.pages.AlertsPage.tileAlert;
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
        tileAlert.is().notDense();
    }

    @Test
    public void heightAlertsTest() {
        tileAlert.show();
        tileAlert.has().height(60);
    }

    @Test
    public void widthAlertsTest() {
        tileAlert.show();
        tileAlert.has().width(300);
    }

    @Test
    public void elevationAlertsTest() {
        basicAlerts.get(4).show();
        basicAlerts.get(4).is().elevated().and().elevation(24);
        basicAlerts.get(1).is().notElevated();
    }

    @Test
    public void outlinedAlertsTest() {
        denseAlerts.get(4).show();
        denseAlerts.get(4).is().outlined();
        denseAlerts.get(1).is().notOutlined();
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
        basicAlerts.get(1).is().notShaped();
    }

    @Test
    public void tileAlertsTest() {
        tileAlert.show();
        tileAlert.is().tile();
        denseAlerts.get(1).is().notTile();
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
