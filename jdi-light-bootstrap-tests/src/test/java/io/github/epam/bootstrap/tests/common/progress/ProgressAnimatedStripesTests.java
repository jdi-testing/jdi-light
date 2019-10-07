package io.github.epam.bootstrap.tests.common.progress;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressAnimated;
import static io.github.com.pages.BootstrapPage.progressBaseWidth50;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.AssertJUnit.assertEquals;

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
    public void AnimationTest() {
        assertEquals(progressAnimated.core().css("animation-name"), "progress-bar-stripes");
    }

    @Test
    public void getColorTest() {
        assertEquals(progressAnimated.getColor(), "rgba(0, 123, 255, 1)");
    }

    @Test
    public void isValidationTest() {
        progressAnimated.is()
                .animated("progress-bar-stripes")
                .color("rgba(0, 123, 255, 1)");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progressAnimated);
    }

}
