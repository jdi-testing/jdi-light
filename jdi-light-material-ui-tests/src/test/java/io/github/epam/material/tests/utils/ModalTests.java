package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.modalPage;
import static io.github.com.pages.utils.ModalPage.*;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/modal/
 */
public class ModalTests extends TestsInit {
    private static final String EXPECTED_TEXT = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";

    @BeforeMethod
    public void beforeTest() {
        modalPage.open();
    }

    @Test
    public void modalTests() {
        for (int modalCounter = 1; modalCounter < 3; modalCounter++) {
            buttonModal.get(modalCounter).click();
            modalTexts.get(modalCounter).has().text(EXPECTED_TEXT);
        }
        for (int modalCounter = 3; modalCounter > 1; modalCounter--) {
            buttonModal.get(modalCounter).core().click(-200, -100);
        }
    }
}
