package io.github.epam.vuetify.tests.common;

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
//    @BeforeClass
//    public void before() {
//        alertsPage.open();
//        waitCondition(() -> alertsPage.isOpened());
//        alertsPage.checkOpened();
//    }

//    @Test(dataProvider = "colorAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
//    public void colorAlertsTest(int index, String color, String backgroundColor) {
//        basicAlerts.get(index).show();
//        basicAlerts.get(index).has().color(color).and().backgroundColor(backgroundColor);
//    }

//    @Test
//    public void themeAlertsTest() {
//        basicAlerts.get(1).show();
//        basicAlerts.get(1).has().darkTheme();
//        denseAlerts.get(4).has().lightTheme();
//    }
//
//    @Test
//    public void denseAlertsTest() {
//        denseAlerts.forEach(denseAlert -> {
//            denseAlert.show();
//            denseAlert.is().dense();
//        });
//        tileAlert.is().notDense();
//    }
//
//    @Test
//    public void heightAlertsTest() {
//        tileAlert.show();
//        tileAlert.has().height(60);
//        tileAlert.has().heightLessThan(100);
//        tileAlert.has().heightGreaterThan(50);
//    }
//
//    @Test
//    public void widthAlertsTest() {
//        tileAlert.show();
//        tileAlert.has().width(300);
//        tileAlert.has().widthLessThan(500);
//        tileAlert.has().widthGreaterThan(200);
//    }
//
//    @Test
//    public void elevationAlertsTest() {
//        basicAlerts.get(4).show();
//        basicAlerts.get(4).is().elevated().and().has().elevation(24);
//        basicAlerts.get(1).is().notElevated();
//    }
//
//    @Test
//    public void outlinedAlertsTest() {
//        denseAlerts.get(4).show();
//        denseAlerts.get(4).is().outlined();
//        denseAlerts.get(1).is().notOutlined();
//    }
//
//    @Test
//    public void roundedAlertsTest() {
//        roundedAlert.show();
//        roundedAlert.is().rounded();
//    }
//
//    @Test
//    public void shapedAlertsTest() {
//        basicAlerts.get(3).show();
//        basicAlerts.get(3).is().shaped();
//        basicAlerts.get(1).is().notShaped();
//    }
//
//    @Test
//    public void tileAlertsTest() {
//        tileAlert.show();
//        tileAlert.is().tile();
//        denseAlerts.get(1).is().notTile();
//    }
//
//    @Test
//    public void textStyledAlertsTest() {
//        denseAlerts.get(2).show();
//        denseAlerts.get(2).is().styledText();
//    }
//
//    @Test(dataProvider = "textAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
//    public void textAlertsTest(int index, String alertText) {
//        basicAlerts.get(index).show();
//        basicAlerts.get(index).has().text(alertText);
//    }
//
//    @Test()
//    public void dismissibleAlertTest() {
//        dismissibleAlert.is().displayed();
//        dismissibleAlert.is().dismissible();
//        dismissibleAlert.closeButton().click();
//        dismissibleAlert.is().hidden();
//        dismissibleAlertResetButton.is().displayed();
//        dismissibleAlertResetButton.click();
//        dismissibleAlert.is().displayed();
//        basicAlerts.get(1).is().notDismissible();
//    }
//
//    @Test
//    public void prominentAlertTest() {
//        prominentErrorAlert.show();
//        prominentErrorAlert.is().prominent();
//        dismissibleAlert.is().notProminent();
//    }
//
//    @Test(dataProvider = "borderAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
//    public void borderAlertTest(int index, String borderValue) {
//        alertsWithProps.get(index).show();
//        alertsWithProps.get(index).has().border();
//        alertsWithProps.get(index).has().border(borderValue);
//        alertsWithProps.get(index).has().noColoredBorder();
//    }
//
//    @Test
//    public void noBorderAlertTest() {
//        basicAlerts.get(1).show();
//        basicAlerts.get(1).has().noBorder();
//    }
//
//    @Test(dataProvider = "typeAlertsTestsData", dataProviderClass = AlertsTestsDataProvider.class)
//    public void typeAlertTest(int index, String type) {
//        basicAlerts.get(index).show();
//        basicAlerts.get(index).has().type(type);
//    }
}
