package io.github.epam.material.tests.feedback;

import com.epam.jdi.light.material.elements.feedback.Alert;
import io.github.epam.TestsInit;
import io.github.epam.test.data.AlertDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.alertPage;
import static io.github.com.pages.feedback.AlertPage.alertWithButton;
import static io.github.com.pages.feedback.AlertPage.alertsWithDescription;
import static io.github.com.pages.feedback.AlertPage.reopenButton;

public class AlertTests extends TestsInit {

    @BeforeMethod
    public void before() {
        alertPage.open();
        alertPage.isOpened();
    }

    @Test(dataProvider = "alertsWithDescriptionTestData", dataProviderClass = AlertDataProvider.class)
    public void alertsWithDescriptionTest(int alertIndex, String titleText, String messageText, String alertClass) {
        Alert alert = alertsWithDescription.get(alertIndex);
        alert.show();
        alert.is().displayed();
        alert.icon().is().displayed();
        alert.title().is().displayed().and().has().text(titleText);
        alert.has().text(Matchers.containsString(messageText))
                .and().cssClass(alertClass);
    }

    @Test
    public void alertWithActionTest() {
        alertWithButton.show();
        alertWithButton.is().visible();
        alertWithButton.button().click();
        alertWithButton.is().notVisible();
        reopenButton.click();
        alertWithButton.is().visible();
    }
}
