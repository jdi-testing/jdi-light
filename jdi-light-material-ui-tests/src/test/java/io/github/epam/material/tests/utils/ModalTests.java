package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.modalFrame;
import static io.github.com.StaticSite.serverSideModalPage;
import static io.github.com.StaticSite.transitionsModalPage;

public class ModalTests extends TestsInit {

    private static final String EXPECTED_TRANSITION_TITLE = "Transition modal";
    private static final String EXPECTED_TRANSITION_DESCRIPTION = "react-transition-group animates me.";
    private static final String EXPECTED_SERVER_TITLE = "Server-side modal";
    private static final String EXPECTED_SERVER_DESCRIPTION = "If you disable JavaScript, you will still see me.";

    @Test
    public void transitionModalTests() {
        transitionsModalPage.open();

        modalFrame.buttonModal.click();
        modalFrame.transitionModal.is().titleEquals(EXPECTED_TRANSITION_TITLE);
        modalFrame.transitionModal.is().descriptionEquals(EXPECTED_TRANSITION_DESCRIPTION);
    }

    @Test
    public void serverSideModalTests() {
        serverSideModalPage.open();

        modalFrame.serverModal.is().titleEquals(EXPECTED_SERVER_TITLE);
        modalFrame.serverModal.is().descriptionEquals(EXPECTED_SERVER_DESCRIPTION);

    }
}
