package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.modalFrame;
import static io.github.com.StaticSite.serverSideModalPage;
import static io.github.com.StaticSite.simpleModalPage;
import static io.github.com.StaticSite.transitionsModalPage;

public class ModalTests extends TestsInit {

    private static final String expectedSimpleTitle = "Text in a modal";
    private static final String expectedSimpleDescription = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";
    private static final String expectedTransitionTitle = "Transition modal";
    private static final String expectedTransitionDescription = "react-transition-group animates me.";
    private static final String expectedServerTitle = "Server-side modal";
    private static final String expectedServerDescription = "If you disable JavaScript, you will still see me.";


    @Test
    public void simpleModalTest() {
        simpleModalPage.open();

        modalFrame.buttonModal.clickModalButton();
        modalFrame.modal.is().verifyingSimpleTitle(expectedSimpleTitle);
        modalFrame.modal.is().verifyingSimpleDescription(expectedSimpleDescription);
    }

    @Test
    public void transitionModalTests() {
        transitionsModalPage.open();

        modalFrame.buttonModal.clickModalButton();
        modalFrame.modal.is().verifyingTransitionTitle(expectedTransitionTitle);
        modalFrame.modal.is().verifyingTransitionDescription(expectedTransitionDescription);
    }

    @Test
    public void serverSideModalTests() {
        serverSideModalPage.open();

        modalFrame.modal.is().verifyingServerTitle(expectedServerTitle);
        modalFrame.modal.is().verifyingServerDescription(expectedServerDescription);

    }
}
