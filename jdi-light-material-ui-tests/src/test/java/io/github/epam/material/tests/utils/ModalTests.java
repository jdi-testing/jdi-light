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
            modal.is().visible();
            modal.title().has().text("Text in a modal");
            modal.has().text(EXPECTED_TEXT);
            modal.find("button").click();
        }

        for (int i = 0; i <= 4; i++) {
            modal.close();
        }
        modal.is().notVisible();
    }
}
