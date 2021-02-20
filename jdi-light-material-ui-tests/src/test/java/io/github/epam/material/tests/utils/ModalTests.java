package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.modalFrame;
import static io.github.com.StaticSite.simpleModalPage;
import static io.github.com.StaticSite.springModalPage;
import static io.github.com.StaticSite.transitionsModalPage;

public class ModalTests extends TestsInit {

    private String expectedSimpleDescription = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";
    private String expectedTransitionDescription = "react-transition-group animates me.";



    @Test
    public void simpleModalTest() {
        simpleModalPage.shouldBeOpened();

        modalFrame.modal.is().simpleAssertEnabled();
        modalFrame.modal.clickOn();
        modalFrame.modal.is().isSimpleModalPageOpened();
        modalFrame.modal.is().simpleModalDescription(expectedSimpleDescription);
    }

    @Test
    public void transitionModalTest() {
        transitionsModalPage.shouldBeOpened();

        modalFrame.modal.is().isTransitionModalEnabled();
        modalFrame.modal.clickOn();
        modalFrame.modal.is().isTransitionModalOpened();
        modalFrame.modal.is().transitionModalDescription(expectedTransitionDescription);
    }

    @Test
    public void springModalTest() {
        springModalPage.shouldBeOpened();

        modalFrame.modal.is().isSpringModalEnabled();
        modalFrame.modal.clickOn();
        modalFrame.modal.is().isSpringModalOpened();
        modalFrame.modal.is().springModalDescription(expectedTransitionDescription);
    }
}
