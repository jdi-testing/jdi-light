package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.modalPage;
import static io.github.com.pages.utils.ModalPage.buttonModal;
import static io.github.com.pages.utils.ModalPage.modal;

public class ModalTests extends TestsInit {

    private static final String EXPECTED_DESCRIPTION = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";
    private static final int MAX_MODAL = 4;

    @BeforeMethod
    public void beforeTest() {
        modalPage.open();
        modalPage.isOpened();
    }

    @Test
    public void modalTests() {
        modal.show();
        buttonModal.click();
        for (int i = 0; i <= MAX_MODAL - 1; i++) {
            modal.is().displayed();
            modal.title().has().text("Text in a modal");
            modal.description().has().text(EXPECTED_DESCRIPTION);
            modal.find("button").click();
        }

        for (int i = 0; i <= MAX_MODAL; i++) {
            modal.close();
        }
        modal.is().hidden();
    }
}
