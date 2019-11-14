package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multiplebarsProgress;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ProgressMultipleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void test() {
        multiplebarsProgress.barsList.get(1).is().color("dfd");
//        multiplebarsProgress.get(0).is().color("dfds");
      /*  Progress df = (Progress)multiplebarsProgress.get(1);
        multiplebarsProgress.(Progress)get(1).has().color("dfsf");*/
    }
}
