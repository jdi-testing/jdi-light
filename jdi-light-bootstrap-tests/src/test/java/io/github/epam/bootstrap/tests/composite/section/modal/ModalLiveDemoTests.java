package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalLiveDemo;
import static io.github.com.pages.BootstrapPage.modalLiveDemoLaunchButton;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;


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
    public void modalContentTextTest() {
        modalLiveDemoLaunchButton.is().text(is(launchButtonText));
        modalLiveDemoLaunchButton.click();
        modalLiveDemo.title.is().text(is(titleText));
        modalLiveDemo.body.is().text(is(bodyText));
        modalLiveDemo.saveButton.is().text(is(saveButtonText));
        modalLiveDemo.closeButton.is().text(is(closeButtonText));
        modalLiveDemo.close();
    }

    @Test
    public void saveAndCloseButtonsTest() {
        modalLiveDemoLaunchButton.click();
        modalLiveDemo.is().displayed();
        modalLiveDemo.saveButton.click();
        modalLiveDemo.is().displayed();
        modalLiveDemo.closeButton.click();
        modalLiveDemo.is().hidden();
    }

    @Test
    public void closeXButtonTest() {
        modalLiveDemoLaunchButton.click();
        modalLiveDemo.is().displayed();
        modalLiveDemo.closeX.click();
        modalLiveDemo.is().hidden();
    }

    @Test
    public void isValidationTest() {
        modalLiveDemoLaunchButton.is()
                .displayed()
                .enabled()
                .text(launchButtonText)
                .core().tag("button");
        modalLiveDemoLaunchButton.click();
        modalLiveDemo.title.is()
                .enabled()
                .text(titleText);
        modalLiveDemo.body.is()
                .enabled()
                .text(bodyText);
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
        modalLiveDemo.close();
    }

    @Test
    public void baseValidations() {
        baseValidation(modalLiveDemoLaunchButton);
        modalLiveDemoLaunchButton.click();
        baseValidation(modalLiveDemo.title);
        baseValidation(modalLiveDemo.body);
        baseValidation(modalLiveDemo.saveButton);
        baseValidation(modalLiveDemo.closeButton);
        baseValidation(modalLiveDemo.closeX);
        modalLiveDemo.close();
    }
}
