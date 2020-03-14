package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MultiProgressTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        multiProgressbar.show();
    }

    @Test
    public void getValueTest() {
        assertThat(multiProgressbar.value(), is("15$;45$;30$"));
    }

    @Test
    public void valuesTest() {
        assertThat(multiProgressbar.values(), hasItems("15$", "45$", "30$"));
    }

    @Test
    public void minTest() {
        assertThat(multiProgressbar.min(), is(0));
    }

    @Test
    public void maxTest() {
        assertThat(multiProgressbar.max(), is(150));
    }

    @Test
    public void isValidationTest() {
        multiProgressbar.is().displayed().enabled().value("15$;45$;30$");
        multiProgressbar.assertThat().min(0).and().max(150);
        multiProgressbar.has().min(lessThan(10))
            .and().max(greaterThan(140))
            .and().value(containsString("45$;30$"));
    }

    @Test
    public void isValuesValidationTest() {
        multiProgressbar.has().values("15$", "45$", "30$");
        multiProgressbar.assertThat().values(hasItems("15$", "30$"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(multiProgressbar);
    }
}
