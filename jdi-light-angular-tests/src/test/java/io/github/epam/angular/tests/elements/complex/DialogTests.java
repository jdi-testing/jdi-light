package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.dialog;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

// TODO Move to the new page
@Ignore
public class DialogTests extends TestsInit {

    @BeforeClass(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        dialog.show();
    }

    @Test
    public void basicDialogTest() {
        dialog.sendKeysToNameFormField("EPAM Systems");
        dialog.open();
        dialog.is().opened();
        dialog.is().nameText("EPAM Systems");
        dialog.sendKeysToAnswerFormField("Lion");
        dialog.submitAnswer();
        dialog.is().closed();
        dialog.is().answerText("Lion");
    }
}
