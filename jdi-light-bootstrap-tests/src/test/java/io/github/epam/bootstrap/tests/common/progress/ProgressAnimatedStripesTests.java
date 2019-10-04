package io.github.epam.bootstrap.tests.common.progress;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressAnimated;
import static io.github.com.pages.BootstrapPage.progressBaseWidth50;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 4.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class ProgressAnimatedStripesTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }


    @Test
    public void isAnimatedTest() {
        System.out.println(progressAnimated.is().animated());
        progressAnimated.is().animated();
        progressAnimated.is().core().css("animation-play-state", is("running"));
    }

    @Test
    public void isAnimateddTest() {
        System.out.println(progressBaseWidth50.is().animated());
        progressBaseWidth50.is().animated();
    }

    @Test
    public void isAnimatdeddTest() {
        progressBaseWidth50.is().core().css("animation-play-state", is("running"));
    }
}
