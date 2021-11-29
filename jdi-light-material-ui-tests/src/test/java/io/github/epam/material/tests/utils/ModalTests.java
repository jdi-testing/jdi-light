package io.github.epam.material.tests.utils;

import com.epam.jdi.light.material.elements.utils.Modal;
import static io.github.com.StaticSite.modalPage;
import static io.github.com.pages.utils.ModalPage.buttonModal;
import static io.github.com.pages.utils.ModalPage.modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalTests extends TestsInit {
    private static final String EXPECTED_TEXT = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";
    private static final String NEW_MODAL = "div:not([aria-hidden='true']) div.jss2";

    @BeforeMethod
    public void beforeTest() {
        modalPage.open();
    }

    @Test
    public void modalTests() {

        Modal innerModal = new Modal().setCore(Modal.class, modal.core().setLocator(NEW_MODAL));

        buttonModal.click();
        modal.is().visible();
        modal.title().has().text("Text in a modal");
        modal.has().text(EXPECTED_TEXT);

        for (int i = 0; i <= 3; i++) {
            innerModal.find("button").click();
            innerModal.is().visible();
            innerModal.title().has().text("Text in a modal");
            innerModal.has().text(EXPECTED_TEXT);
        }

        for (int i = 0; i <= 4; i++) {
            modal.close();
        }
        modal.is().notVisible();
    }
}
