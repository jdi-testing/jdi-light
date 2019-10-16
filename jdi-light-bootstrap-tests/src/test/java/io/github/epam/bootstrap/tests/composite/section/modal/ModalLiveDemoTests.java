package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import io.github.epam.bootstrap.tests.BaseValidations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalLiveDemo;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalLiveDemoTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(priority = 3)
    public void bodyTextTest() {
        modalLiveDemo.launchModal.base().waitSec(5);
        modalLiveDemo.launchModal.is().text("Launch demo modal");
        modalLiveDemo.launchModal.click();
        modalLiveDemo.title.is().text("MODAL TITLE");
        modalLiveDemo.body.is().text("Woohoo, you're reading this text in a modal!");
        modalLiveDemo.saveButton.is().text("Save changes");
        modalLiveDemo.closeButton.is().text("Close");
        modalLiveDemo.closeButton.click();
    }


    //$(By.className."ldo)).").is.display
    @Test(priority = 2)
    public void buttonsInBodyTest() {
        modalLiveDemo.launchModal.click();
        //modalLiveDemo.title.is().displayed();
        modalLiveDemo.title.is().displayed();
        modalLiveDemo.saveButton.click();
        modalLiveDemo.title.is().displayed();
        modalLiveDemo.closeButton.click();
        modalLiveDemo.title.is().hidden();
    }

    @Test(priority = 1)
    public void closeXTest() {
        modalLiveDemo.launchModal.click();
//        modalLiveDemo.core().waitSec(2);
        //modalLiveDemo.modalContent.title.is().displayed();
        modalLiveDemo.modalContent.is().displayed();
        modalLiveDemo.closeX.click();
//        modalLiveDemo.title.is().hidden();
        modalLiveDemo.modalContent.is().hidden();
    }

    @Test(priority = 4)
    public void isValidationTest() {
        refresh();
        modalLiveDemo.launchModal.is().displayed().enabled().text("Launch demo modal");
        modalLiveDemo.launchModal.click();
        modalLiveDemo.saveButton.is().displayed().enabled().text("Save changes");
        modalLiveDemo.closeButton.is().displayed().enabled().text("Close");
        modalLiveDemo.closeX.is().displayed().enabled();
        modalLiveDemo.closeX.click();
    }

    @Test
    public void baseValidation() {
        BaseValidations.baseValidation(modalLiveDemo.launchModal);
        modalLiveDemo.launchModal.click();
        BaseValidations.baseValidation(modalLiveDemo.title);
        BaseValidations.baseValidation(modalLiveDemo.body);
        BaseValidations.baseValidation(modalLiveDemo.saveButton);
        BaseValidations.baseValidation(modalLiveDemo.closeButton);
        BaseValidations.baseValidation(modalLiveDemo.closeX);
        modalLiveDemo.closeX.click();
    }
}
