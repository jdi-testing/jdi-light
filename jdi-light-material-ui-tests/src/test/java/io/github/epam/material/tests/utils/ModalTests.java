package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.modalPage;
import static io.github.com.pages.utils.ModalPage.buttonModal;
import static io.github.com.pages.utils.ModalPage.modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalTests extends TestsInit {
    private static final String EXPECTED_TEXT = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";

    @BeforeMethod
    public void beforeTest() {
        modalPage.open();
    }

    @Test
    public void modalTests() {
        buttonModal.click();
        for (int i = 0; i <= 3; i++) {
            modal.open().is().visible();
            modal.has().title("Text in a modal").and().text(EXPECTED_TEXT);
        }
        for (int i = 0; i <= 4; i++) {
            modal.close();
        }
        modal.is().notVisible();
    }
}
