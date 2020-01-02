package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.sections.modal.ModalWithButtons;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.sectionModalLongScrolling;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
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
                {sectionModalLongScrolling.buttonLongScroll, sectionModalLongScrolling.modalLong},
                {sectionModalLongScrolling.buttonLongScrollable, sectionModalLongScrolling.modalScrollable}
        };
    }

    @Test(dataProvider = "listData")
    public void isValidationTest(Button showModal, ModalWithButtons modal) {
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
        modal.close();
        modal.is().disappear();
    }

    @Test(dataProvider = "listData")
    public void bottomButtonsTest(Button showModal, ModalWithButtons modal) {
        showModal.click();
        modal.is().displayed();
        modal.bottomSave();
        modal.bottomClose();
        modal.is().disappear();
    }

    @Test
    public void isModalDialogScrollable() {
        sectionModalLongScrolling.buttonLongScrollable.click();
        sectionModalLongScrolling.modalScrollable.is().displayed();
        sectionModalLongScrolling.modalScrollable.find("div.modal-dialog")
                .is().hasClass("modal-dialog-scrollable");
        sectionModalLongScrolling.modalScrollable.close();
        sectionModalLongScrolling.modalScrollable.is().disappear();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(sectionModalLongScrolling);
        baseValidation(sectionModalLongScrolling.buttonLongScroll);
        baseValidation(sectionModalLongScrolling.buttonLongScrollable);
    }
}
