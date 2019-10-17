package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.StaticSite.videoModalFrame;
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
        baseValidation(embeddedVideoModal);
        baseValidation(videoModalFrame.getVideoTitle());
        baseValidation(videoModalFrame.getPlayButton());
    }

    @Test
    public void videoTitleTest() {
        modalEmbeddedVideoButton.click();
        videoModalFrame.getVideoTitle().is()
                .ref(VIDEO_URL)
                .text(VIDEO_TITLE);
    }

    @Test
    public void playVideoTest() throws InterruptedException {
        modalEmbeddedVideoButton.click();
        videoModalFrame.getPlayButton().click();
        videoModalFrame.getProgressBar().waitFor().displayed();
        Thread.sleep(5000);
        videoModalFrame.getProgressBar().is().attr("aria-valuenow", Matchers.matchesPattern("[1-9]{1}[0-9]*"));
    }

}
