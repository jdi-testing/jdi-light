package io.github.epam.material.tests.feedback;

import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.material.elements.utils.enums.Severity;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import io.github.epam.test.data.AlertDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.alertPage;
import static io.github.com.pages.feedback.AlertPage.*;

public class AlertTests extends TestsInit {

    private static final Timer TIMER = new Timer(16000L);

    @BeforeMethod
    public void before() {
        alertPage.open();
        alertPage.isOpened();
    }

    @Test(dataProvider = "alertsWithDescriptionTestData", dataProviderClass = AlertDataProvider.class)
    public void alertsWithDescriptionTest(int alertIndex, String titleText, String messageText, Severity alertClass) {
        Alert alert = alertsWithDescription.get(alertIndex);
        alert.show();
        alert.is().displayed();
        alert.icon().is().displayed();
        alert.is().title(titleText);
        alert.has().text(Matchers.endsWith(messageText))
                .and().severity(alertClass);
    }

    @Test
    public void alertWithActionTest() {
        alertWithButton.show();
        alertWithButton.is().visible();
        alertWithButton.buttonAction().click();
        TIMER.wait(() -> alertWithButton.is().notVisible());
        reopenButton.click();
        alertWithButton.is().visible();
    }

    @Test(dataProvider = "alertsWitVariantsTestData", dataProviderClass = AlertDataProvider.class)
    public void alertsWithVariantsTest(int alertIndex, String messageText, Severity alertClass) {
        Alert alert = variantsAlerts.get(alertIndex);
        alert.show();
        alert.is().displayed();
        alert.icon().is().displayed();
        alert.is().hasNoTitle();
        alert.has().text(Matchers.endsWith(messageText))
                .and().severity(alertClass);
    }
}
