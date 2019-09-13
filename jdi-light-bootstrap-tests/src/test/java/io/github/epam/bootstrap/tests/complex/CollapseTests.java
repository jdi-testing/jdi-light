package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CollapseTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String text = "Anim pariatur cliche reprehenderit.";

    @Test
    public void collapseLinkTest() {

    }

//    @Test
//    public void collapseButtonTest() {
//        collapseBtn.toggle();
//        assertTrue(collapseBtn.isExpanded());
//        assertTrue(collapseBtnText.getText().contains(text));
//    }
}
