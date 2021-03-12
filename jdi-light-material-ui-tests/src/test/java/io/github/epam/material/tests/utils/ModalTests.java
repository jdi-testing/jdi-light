package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.modalFrame;
import static io.github.com.StaticSite.serverSideModalPage;
import static io.github.com.StaticSite.simpleModalPage;
import static io.github.com.StaticSite.transitionsModalPage;

public class ModalTests extends TestsInit {

    private static final String EXPECTED_SIMPLE_TITLE = "Text in a modal";
    private static final String EXPECTED_SIMPLE_DESCRIPTION = "Duis mollis, est non commodo luctus, nisi erat porttitor ligula.";
    private static final String EXPECTED_TRANSITION_TITLE = "Transition modal";
    private static final String EXPECTED_TRANSITION_DESCRIPTION = "react-transition-group animates me.";
    private static final String EXPECTED_SERVER_TITLE = "Server-side modal";
    private static final String EXPECTED_SERVER_DESCRIPTION = "If you disable JavaScript, you will still see me.";


    @Test
    public void simpleModalTest() {
        simpleModalPage.open();

        modalFrame.buttonModal.click();
        modalFrame.simpleModalTitle.is().verifyingTitle(EXPECTED_SIMPLE_TITLE);
        modalFrame.simpleModalDescription.is().verifyingDescription(EXPECTED_SIMPLE_DESCRIPTION);
        modalFrame.innerButton.click();
        modalFrame.additionalModal.is().verifyingAdditionalModalDisplayed();
    }

    @Test
    public void transitionModalTests() {
        transitionsModalPage.open();

        modalFrame.buttonModal.click();
        modalFrame.transitionModalTitle.is().verifyingTitle(EXPECTED_TRANSITION_TITLE);
        modalFrame.transitionModalDescription.is().verifyingDescription(EXPECTED_TRANSITION_DESCRIPTION);
    }

    @Test
    public void serverSideModalTests() {
        serverSideModalPage.open();

        modalFrame.serverModalTitle.is().verifyingTitle(EXPECTED_SERVER_TITLE);
        modalFrame.serverModalDescription.is().verifyingDescription(EXPECTED_SERVER_DESCRIPTION);

    }
}
