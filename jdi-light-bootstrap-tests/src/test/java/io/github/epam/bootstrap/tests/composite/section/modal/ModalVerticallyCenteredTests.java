package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalVerticallyCentered;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalVerticallyCenteredTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void simple() throws InterruptedException {
        modalVerticallyCentered.modalCenterTrigger.highlight();
        Thread.sleep(1000);
        modalVerticallyCentered.modalCenterTrigger.unhighlight();

        modalVerticallyCentered.modalCenterScrollableTrigger.highlight();
        Thread.sleep(1000);
        modalVerticallyCentered.modalCenterTrigger.unhighlight();
    }

}
