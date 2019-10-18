package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.embeddedVideoModal;
import static io.github.com.pages.BootstrapPage.modalEmbeddedVideoButton;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalEmbeddingVideoTests extends TestsInit {

    private final static String VIDEO_TITLE = "Forget about Selenium. May the JDI Light force be with you";
    private final static String VIDEO_URL = "https://www.youtube.com/watch?v=lw4g9ItC7Sc";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        refresh();
    }

    @Test
    public void baseValidationTest() {
        modalEmbeddedVideoButton.click();
        embeddedVideoModal.waitFor().displayed();
        baseValidation(embeddedVideoModal);
        baseValidation(embeddedVideoModal.getVideoModalFrame().getVideoTitle());
        baseValidation(embeddedVideoModal.getVideoModalFrame().getPlayButton());

    }

    @Test
    public void videoTitleTest() {
        modalEmbeddedVideoButton.click();
        embeddedVideoModal.getVideoModalFrame().getVideoTitle().is()
                .displayed()
                .enabled()
                .ref(VIDEO_URL)
                .text(VIDEO_TITLE);
    }

    @Test
    public void playVideoTest() {
        modalEmbeddedVideoButton.click();
        embeddedVideoModal.getVideoModalFrame().getPlayButton().click();
        embeddedVideoModal.getVideoModalFrame().getProgressBar().assertThat()
                .displayed()
                .attr("aria-valuenow", Matchers.matchesPattern("[1-9]{1}[0-9]*"));
    }


}
