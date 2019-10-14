package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.com.sections.modal.Modal;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                        modalVerticallyCentered.dismissModal1Close,
                        modalVerticallyCentered.modal1,
                        "modal-vertical-content-1"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
                        modalVerticallyCentered.modal2,
                        "modal-vertical-content-2"
                }
        };
    }

    @DataProvider
    public Object[][] modalCssData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.dismissModal1Close,
                        modalVerticallyCentered.modalCenterBg,
                        "modal-vertical-content-1",
                        "modal-dialog-centered"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
                        modalVerticallyCentered.modalCenterScrollableBg,
                        "modal-vertical-content-2",
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
                        "modal-vertical-content-1"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
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
                        modalVerticallyCentered.dismissModal1Cross,
                        "modal-vertical-content-1"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Close,
                        modalVerticallyCentered.dismissModal2Cross,
                        "modal-vertical-content-2"
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
                                            Button dismissButton,
                                            Modal modal,
                                            String modalId) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalId)));

        modal.is().displayed();

        dismissButton.show();
        dismissButton.click();

        modal.is().hidden();
    }

    @Test(dataProvider = "modalCssData")
    public void modalCssTest(Button showButton,
                             Button dismissButton,
                             Modal modal,
                             String modalCss,
                             String modalBgCss) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalCss)));

        modal.core().hasClass(modalBgCss);

        dismissButton.show();
        dismissButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(modalCss)));
    }

    @Test(dataProvider = "modalVerticalAlignmentData")
    public void modalVerticalAlignmentTest(Button showButton,
                                           Button dismissButton,
                                           String modalId) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalId)));

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

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(modalId)));
    }

    @Test(dataProvider = "modalDismissData")
    public void modalDismissTest(Button showButton,
                                 Button dismissButton1,
                                 Button dismissButton2,
                                 String modalId) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalId)));

        dismissButton1.show();
        dismissButton1.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(modalId)));

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalId)));

        dismissButton2.show();
        dismissButton2.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(modalId)));
    }

}
