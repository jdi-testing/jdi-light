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

public class MultiProgressTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getValueTest() {
        assertThat(multiProgressbars.value(), is("15$;45$;30$"));
    }
    @Test
    public void valuesTest() {
        assertThat(multiProgressbars.values(), hasItems("15$", "45$", "30$"));
    }
    @Test
    public void minTest() {
        assertThat(multiProgressbars.min(), is(0));
    }
    @Test
    public void maxTest() {
        assertThat(multiProgressbars.max(), is(150));
    }
    @Test
    public void isValidationTest() {
        multiProgressbars.is().displayed().enabled().value("15$;45$;30$");
        multiProgressbars.assertThat().min(0).and().max(150);
        multiProgressbars.has().min(lessThan(10))
            .and().max(greaterThan(140))
            .and().value(containsString("45$;30$"));
    }
    @Test
    public void isValuesValidationTest() {
        multiProgressbars.has().values("15$", "45$", "30$");
        multiProgressbars.assertThat().values(hasItems("15$", "30$"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(multiProgressbars);
    }
}
