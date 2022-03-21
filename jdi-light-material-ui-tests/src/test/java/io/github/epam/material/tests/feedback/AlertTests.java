package io.github.epam.material.tests.feedback;

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
    public void dialogWithDescriptionTest(int alertIndex, String titleText, String messageText) {
        alertsWithDescription.get(alertIndex).show();
        alertsWithDescription.get(alertIndex).is().displayed();
        alertsWithDescription.get(alertIndex).icon.is().displayed();
        alertsWithDescription.get(alertIndex).title.is().displayed().and().has().text(titleText);
        alertsWithDescription.get(alertIndex).has().text(Matchers.containsString(messageText));
    }

    @Test
    public void alertWithActionTest() {
        alertWithButton.show();
        alertWithButton.is().visible();
        alertWithButton.button.click();
        alertWithButton.is().notVisible();
        reopenButton.click();
        alertWithButton.is().visible();
    }

}
