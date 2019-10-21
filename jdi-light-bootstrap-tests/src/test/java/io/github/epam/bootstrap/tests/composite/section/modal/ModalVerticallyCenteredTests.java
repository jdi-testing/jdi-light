package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalVerticallyCentered;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
                        modalVerticallyCentered.modal1,
                        "modal-dialog-centered"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
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
                        modalVerticallyCentered.modal1
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
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

        modal.is().displayed();

        modal.close();

        modal.is().hidden();
    }

    @Test(dataProvider = "modalCssData")
    public void modalCssTest(Button showButton,
                             Modal modal,
                             String modalBgCss) {
        showButton.show();
        showButton.click();

        modal.childs().get(1).is().hasClass(modalBgCss);

        modal.close();
    }

    @Test(dataProvider = "modalVerticalAlignmentData")
    public void modalVerticalAlignmentTest(Button showButton,
                                           Modal modal) {
        showButton.show();
        showButton.click();

        showButton.core().waitFor().hidden();

        boolean execResult = WebDriverFactory.jsExecute(
                "var modal = document.getElementById('" + modal.childs().get(2).getAttribute("id") + "');" +
                        "var modalTop = modal.getBoundingClientRect().top;" +
                        "var modalBottom = window.innerHeight - modal.getBoundingClientRect().bottom;" +
                        "return modalTop == modalBottom;"
        );

        assertThat(execResult, is(true));

        modal.close();

        showButton.core().waitFor().displayed();
    }

}
