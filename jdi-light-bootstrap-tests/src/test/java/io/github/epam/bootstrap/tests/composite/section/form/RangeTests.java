package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.range1;
import static io.github.com.pages.BootstrapPage.range2;
import static io.github.com.pages.BootstrapPage.range3;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.testng.Assert.assertEquals;

public class RangeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(range1.labelText(), "Example range");
    }

    @Test
    public void getValueTest() {
        assertEquals(range1.thumbValue(), 50);
    }

    @Test
    public void minTest() {
        assertEquals(range2.min(), "0");
    }
    @Test
    public void maxTest() {
        assertEquals(range2.max(), "5");
    }

    @Test
    public void stepTest() {
        assertEquals(range1.step(), "5");
    }

    @Test
    public void setThumbValueTest() {
        range1.setThumbValue(10);
        assertEquals(range1.thumbValue(), 10);
    }

    @Test
    public void isValidationTest() {
        range3.is().enabled();
        range3.is().minValue(0);
        range3.is().maxValue(5);
//        range3.is().step(0.5);
        range3.is().thumbValue(greaterThanOrEqualTo(0));
        range3.is().thumbValue(lessThanOrEqualTo(5));
//        range1.is().thumbValue(is(2));
    }

    @Test
    public void labelTest() {
        assertEquals(range1.label().getText(), "Example range");
        range1.label().is().text(containsString("range"));
        range1.label().assertThat().text(equalToIgnoringCase("example range"));
    }

    @Test
    public void assertValidationTest() {
        range1.is().thumbValue(greaterThan(0));
        range1.is().thumbValue(lessThan(200));
        range1.is().thumbValue(50);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(range1);
    }
}


//значение полей в Double