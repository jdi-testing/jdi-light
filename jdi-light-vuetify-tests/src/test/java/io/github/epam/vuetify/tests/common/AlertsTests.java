package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Alert;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AlertsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.alertsPage;

import static io.github.com.pages.AlertsPage.alertsWithProps;
import static io.github.com.pages.AlertsPage.basicAlerts;
import static io.github.com.pages.AlertsPage.denseAlerts;
import static io.github.com.pages.AlertsPage.dismissibleAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlertResetButton;
import static io.github.com.pages.AlertsPage.prominentErrorAlert;
import static io.github.com.pages.AlertsPage.roundedAlert;
import static io.github.com.pages.AlertsPage.tileAlert;


public class AlertsTests extends TestsInit {
    @BeforeClass
    public void before() {
        alertsPage.open();
        waitCondition(() -> alertsPage.isOpened());
        alertsPage.checkOpened();
    }

    @Test(dataProvider = "colorAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class,
            description = "Test checks appropriate colors of alert")
    public void colorAlertsTest(int index, String color, String backgroundColor) {
        basicAlerts.get(index).show();
        basicAlerts.get(index).has().color(color).and().backgroundColor(backgroundColor);
    }

    @Test(description = "Test checks themes of alerts: dark/light")
    public void themeAlertsTest() {
        basicAlerts.get(1).show();
        basicAlerts.get(1).has().darkTheme();
        denseAlerts.get(4).has().lightTheme();
    }

    @Test(description = "Test checks that element is dense")
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
        tileAlert.has().height(60)
                .and().heightLessThan(100)
                .and().heightGreaterThan(50);
    }

    @Test(description = "Test checks width of an alert in different ways")
    public void widthAlertsTest() {
        tileAlert.show();
        tileAlert.has().width(300)
                .and().widthLessThan(500)
                .and().widthGreaterThan(200);
    }

    @Test(description = "Test checks elevation of an alert")
    public void elevationAlertsTest() {
        basicAlerts.get(4).show();
        basicAlerts.get(4).is().elevated()
                .and().has().elevation(24);
        basicAlerts.get(1).is().notElevated();
    }

    @Test(description = "Test checks alert is outlined or not")
    public void outlinedAlertsTest() {
        denseAlerts.get(4).show();
        denseAlerts.get(4).is().outlined();
        denseAlerts.get(1).is().notOutlined();
    }

    @Test(description = "Test checks alert is rounded")
    public void roundedAlertsTest() {
        roundedAlert.show();
        roundedAlert.is().rounded();
    }

    @Test(description = "Test checks alert is shaped or not")
    public void shapedAlertsTest() {
        basicAlerts.get(3).show();
        basicAlerts.get(3).is().shaped();
        basicAlerts.get(1).is().notShaped();
    }

    @Test(description = "Test checks alert is a tile or not")
    public void tileAlertsTest() {
        tileAlert.show();
        tileAlert.is().tile();
        denseAlerts.get(1).is().notTile();
    }

    @Test(description = "Test checks alert has styled text")
    public void textStyledAlertsTest() {
        denseAlerts.get(2).show();
        denseAlerts.get(2).is().styledText();
    }

    @Test(dataProvider = "textAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class,
            description = "Test checks text within alert element")
    public void textAlertsTest(int index, String alertText) {
        basicAlerts.get(index).show();
        basicAlerts.get(index).has().text(alertText);
    }

    @Test(description = "Test checks that alert is dismissible or not")
    public void dismissibleAlertTest() {
        dismissibleAlert.is().displayed()
                .and().dismissible();
        dismissibleAlert.closeButton().click();
        dismissibleAlert.is().hidden();
        dismissibleAlertResetButton.is().displayed();
        dismissibleAlertResetButton.click();
        dismissibleAlert.is().displayed();
        basicAlerts.get(1).is().notDismissible();
    }

    @Test(description = "Test checks alert is prominent or not")
    public void prominentAlertTest() {
        prominentErrorAlert.show();
        prominentErrorAlert.is().prominent();
        dismissibleAlert.is().notProminent();
    }

    @Test(dataProvider = "borderAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class,
            description = "Test checks alert's borders")
    public void borderAlertTest(int index, String borderValue) {
        Alert alertWithProp = alertsWithProps.get(index);
        alertWithProp.show();
        alertWithProp.has().border()
                .and().border(borderValue)
                .and().noColoredBorder();
    }

    @Test(description = "Test checks alert has no borders")
    public void noBorderAlertTest() {
        basicAlerts.get(1).show();
        basicAlerts.get(1).has().noBorder();
    }

    @Test(dataProvider = "typeAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class,
            description = "Test checks different types of alert")
    public void typeAlertTest(int index, String type) {
        basicAlerts.get(index).show();
        basicAlerts.get(index).has().type(type);
    }
}
