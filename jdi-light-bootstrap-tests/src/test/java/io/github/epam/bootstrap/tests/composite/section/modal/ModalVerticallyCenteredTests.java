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

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalVerticallyCentered;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalVerticallyCenteredTests extends TestsInit {

    @DataProvider
    public Object[][] modalContentData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.dismissModal1Trigger,
                        modalVerticallyCentered.modalContent1,
                        "modal-vertical-content-1"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Trigger,
                        modalVerticallyCentered.modalContent2,
                        "modal-vertical-content-2"
                }
        };
    }

    @DataProvider
    public Object[][] modalCssData() {
        return new Object[][]{
                {
                        modalVerticallyCentered.modalCenterTrigger,
                        modalVerticallyCentered.dismissModal1Trigger,
                        modalVerticallyCentered.modalCenterBg,
                        "modal-vertical-content-1",
                        "modal-dialog-centered"
                },

                {
                        modalVerticallyCentered.modalCenterScrollableTrigger,
                        modalVerticallyCentered.dismissModal2Trigger,
                        modalVerticallyCentered.modalCenterScrollableBg,
                        "modal-vertical-content-2",
                        "modal-dialog-centered"
                }
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "modalContentData")
    public void modalBasicFunctionalityTest(Button showButton,
                                         Button dismissButton,
                                         Modal modal,
                                         String modalId)
    {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalId)));

        modal.is().displayed();

        dismissButton.show();
        dismissButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(modalId)));

        modal.is().hidden();
    }

    @Test(dataProvider = "modalCssData")
    public void modalCssTest(Button showButton,
                             Button dismissButton,
                             Modal modal,
                             String modalCss,
                             String modalBgCss)
    {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        showButton.show();
        showButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modalCss)));

        modal.core().hasClass(modalBgCss);

        dismissButton.show();
        dismissButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(modalCss)));
    }

    @Test
    public void modalCenteredTest() {

    }

}
