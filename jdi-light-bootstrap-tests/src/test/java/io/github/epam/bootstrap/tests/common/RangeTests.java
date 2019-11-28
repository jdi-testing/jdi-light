package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.range1;
import static io.github.com.pages.BootstrapPage.range2;
import static io.github.com.pages.BootstrapPage.range3;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class RangeTests extends TestsInit {
    private String labelText = "Example range";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(range1);
        range1.unhighlight();
        baseValidation(range2);
        range2.unhighlight();
        baseValidation(range3);
        range3.unhighlight();
    }

    @Test
    public void labelTest() {
        range1.label().is().text(labelText);
        range2.label().is().text(labelText);
        range3.label().is().text(labelText);
    }

    @Test
    public void getValueTest() {
        range1.is().value(50);
        range2.is().value(3);
        range3.is().value(2.5);
    }

    @Test
    public void minTest() {
        range2.is().minValue(0);
        range3.is().minValue(0);
    }

    @Test
    public void maxTest() {
        range2.is().maxValue(5);
        range3.is().maxValue(5);
    }

    @Test
    public void stepTest() {
        range3.is().step(0.5);
    }

    @Test
    public void setValueTest() {
        range3.hover();
        range1.setValue(10.0);
        range1.is().value(10);
        range1.setValue(50);
        range2.setValue(2);
        range2.is().value(2);
        range2.setValue(3);
        range3.setValue(5);
        range3.is().value(5);
        range3.setValue(2.5);
    }
}
