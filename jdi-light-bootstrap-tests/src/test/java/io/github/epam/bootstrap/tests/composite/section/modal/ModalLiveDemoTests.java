package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalLiveDemo;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalLiveDemoTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void test() {
        modalLiveDemo.launchModal.click();
        modalLiveDemo.launchModal.is().text("Launch demo modal");
        modalLiveDemo.title.is().text("MODAL TITLE");
        modalLiveDemo.body.is().text("Woohoo, you're reading this text in a modal!");
        modalLiveDemo.closeButton.is().text("Close");
        modalLiveDemo.closeButton.click();
        modalLiveDemo.launchModal.click();
        modalLiveDemo.saveButton.is().text("Save changes");
        modalLiveDemo.saveButton.click();

    }
}
