package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalScrollingLongContent;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalScrollingLongContentTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {modalScrollingLongContent.buttonLongScroll, modalScrollingLongContent.modalLong},
                {modalScrollingLongContent.buttonLongScrollable, modalScrollingLongContent.modalScrollable}
        };
    }

    @Test
    public void baseValidationTest() {
        baseValidation(modalScrollingLongContent);
        baseValidation(modalScrollingLongContent.buttonLongScroll);
        baseValidation(modalScrollingLongContent.buttonLongScrollable);
    }

    @Test(dataProvider = "listData")
    public void isValidationTest(Button showModal, Modal modal) {
        showModal.click();
        modal.is().displayed();
        modal.title.is().text("MODAL TITLE");
        modal.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("modal")
                .hasClass("show")
                .attr("role", "dialog")
                .attr("aria-modal", "true")
                .tag("div");
        modal.button.click();
        modal.core().waitSec(2);
        modal.is().disappear();
    }
}
