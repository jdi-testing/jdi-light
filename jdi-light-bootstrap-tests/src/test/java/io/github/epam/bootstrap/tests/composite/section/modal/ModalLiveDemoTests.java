package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalLiveDemo;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;


public class ModalLiveDemoTests extends TestsInit {

    private String launchButtonText = "Launch demo modal";
    private String titleText = "MODAL TITLE";
    private String bodyText = "Woohoo, you're reading this text in a modal!";
    private String saveButtonText = "Save changes";
    private String closeButtonText = "Close";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void modalContentGetTextTest() {
        assertEquals(modalLiveDemo.launchModal.getText(), launchButtonText);
        modalLiveDemo.launchModal.click();
        assertEquals(modalLiveDemo.modalContent.title.getText(), titleText);
        assertEquals(modalLiveDemo.body.getText(), bodyText);
        assertEquals(modalLiveDemo.saveButton.getText(), saveButtonText);
        assertEquals(modalLiveDemo.closeButton.getText(), closeButtonText);
        modalLiveDemo.closeButton.click();
    }

    @Test
    public void saveAndCloseButtonsTest() {
        modalLiveDemo.launchModal.click();
        modalLiveDemo.modalContent.is().displayed();
        modalLiveDemo.saveButton.click();
        modalLiveDemo.modalContent.is().displayed();
        modalLiveDemo.closeButton.click();
        modalLiveDemo.modalContent.is().hidden();
    }

    @Test
    public void closeXButtonTest() {
        modalLiveDemo.launchModal.click();
        modalLiveDemo.modalContent.is().displayed();
        modalLiveDemo.closeX.click();
        modalLiveDemo.modalContent.is().hidden();
    }

    @Test
    public void isValidationTest() {
        modalLiveDemo.launchModal.is()
                .displayed()
                .enabled()
                .text(launchButtonText)
                .core().tag("button");
        modalLiveDemo.launchModal.click();
        modalLiveDemo.saveButton.is()
                .displayed()
                .enabled()
                .text(saveButtonText)
                .core().tag("button");
        modalLiveDemo.closeButton.is()
                .displayed()
                .enabled()
                .text(closeButtonText)
                .core().tag("button");
        modalLiveDemo.closeX.is()
                .displayed()
                .enabled()
                .core().tag("button");
        modalLiveDemo.modalContent.close();
    }

    @Test
    public void baseValidations() {
        baseValidation(modalLiveDemo.launchModal);
        modalLiveDemo.launchModal.click();
        baseValidation(modalLiveDemo.modalContent.title);
        baseValidation(modalLiveDemo.body);
        baseValidation(modalLiveDemo.saveButton);
        baseValidation(modalLiveDemo.closeButton);
        baseValidation(modalLiveDemo.closeX);
        modalLiveDemo.modalContent.close();
    }
}
