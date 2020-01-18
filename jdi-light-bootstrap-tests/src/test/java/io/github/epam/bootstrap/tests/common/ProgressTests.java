package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProgressTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        progressbar.show();
        resetProgress.click();
    }

    @Test
    public void getValueTest() {
        assertThat(progressbar.value(), is("25%"));
    }
    @Test
    public void dynamicValueTest() {
        increaseProgress.click();
        assertThat(progressbar.value(), is("30%"));
        resetProgress.click();
        decreaseProgress.click();
        assertThat(progressbar.value(), is("20%"));
    }
    @Test
    public void minTest() {
        assertThat(progressbar.min(), is(0));
    }
    @Test
    public void maxTest() {
        assertThat(progressbar.max(), is(100));
    }
    @Test
    public void isValidationTest() {
        progressbar.is().displayed().enabled().value("25%");
        progressbar.assertThat().min(0).and().max(100);
        progressbar.has().min(lessThan(10))
            .and().max(greaterThan(90))
            .and().value(containsString("25"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progressbar);
    }
}
