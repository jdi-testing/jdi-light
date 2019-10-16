package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalVerticallyCentered;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class ModalVerticallyCenteredTests extends TestsInit {

    @DataProvider
    public Object[][] modalBasicData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.modal1
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.modal2
                }
        };
    }

    @DataProvider
    public Object[][] modalCssData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.dismissModal1Close,
                        modalVerticallyCentered.modal1,
                        "modal-dialog-centered"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
                        modalVerticallyCentered.modal2,
                        "modal-dialog-centered"
                }
        };
    }

    @DataProvider
    public Object[][] modalVerticalAlignmentData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.dismissModal1Close,
                        "button:nth-of-type(1)",
                        "modal-vertical-content-1"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
                        "button:nth-of-type(2)",
                        "modal-vertical-content-2"
                }
        };
    }

    @DataProvider
    public Object[][] modalDismissData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.dismissModal1Close,
                        modalVerticallyCentered.modal1
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
                        modalVerticallyCentered.modal2
                }
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "modalBasicData")
    public void modalBasicFunctionalityTest(Button showButton,
                                            Modal modal) {
        showButton.show();
        showButton.click();

        modal.core().waitFor().displayed();

        modal.is().displayed();

        modal.close();

        modal.core().waitFor().hidden();

        modal.is().hidden();
    }

    @Test(dataProvider = "modalCssData")
    public void modalCssTest(Button showButton,
                             Button dismissButton,
                             Modal modal,
                             String modalBgCss) {
        showButton.show();
        showButton.click();

        modal.childs().get(0).is().hasClass(modalBgCss);

        dismissButton.show();
        dismissButton.click();
    }

    @Test(dataProvider = "modalVerticalAlignmentData")
    public void modalVerticalAlignmentTest(Button showButton,
                                           Button dismissButton,
                                           String waiterSelector,
                                           String modalId) {
        showButton.show();
        showButton.click();

        $(waiterSelector).waitFor().hidden();

        long modalTop = WebDriverFactory.jsExecute(
                "var modal = document.getElementById('" + modalId + "');" +
                        "return modal.getBoundingClientRect().top;"
        );
        long modalBottom = WebDriverFactory.jsExecute(
                "var modal = document.getElementById('" + modalId + "');" +
                        "return window.innerHeight - modal.getBoundingClientRect().bottom;"
        );

        assertEquals(modalTop, modalBottom);

        dismissButton.show();
        dismissButton.click();
    }

    @Test(dataProvider = "modalDismissData")
    public void modalDismissTest(Button showButton,
                                 Button dismissButton1,
                                 Modal modal) {
        showButton.show();
        showButton.click();

        modal.waitFor().displayed();

        dismissButton1.show();
        dismissButton1.click();

        showButton.show();
        showButton.click();

        modal.show();
        modal.close();
    }

}
