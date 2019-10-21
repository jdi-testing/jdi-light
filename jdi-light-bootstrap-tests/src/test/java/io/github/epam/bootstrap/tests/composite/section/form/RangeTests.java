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

public class RangeTests extends TestsInit {
    private String labelText = "Example range";
    private int defaultMin = 0;
    private int defaultMax = 100;
    private int defaultStep = 1;
    private int defaultValue = 50;


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void labelTest() {
        range1.label().is().text(labelText);
        range2.label().is().text(labelText);
        range3.label().is().text(labelText);
    }

    @Test
    public void getValueTest() {
        range1.is().thumbValue(defaultValue);
        range2.is().thumbValue(3);
        range3.is().thumbValue(2.5);
    }

    @Test
    public void minTest() {
        range1.is().minValue(defaultMin);
        range2.is().minValue(defaultMin);
        range3.is().minValue(defaultMin);
    }

    @Test
    public void maxTest() {
        range1.is().maxValue(defaultMax);
        range2.is().maxValue(5);
        range1.is().maxValue(3);
    }

    @Test
    public void stepTest() {
        range1.is().step(defaultStep);
        range2.is().step(defaultStep);
        range3.is().step(0.5);
    }

    @Test
    public void setThumbValueTest() {
        range1.setThumbValue(10);
        range1.is().thumbValue(10);
        range2.setThumbValue(2);
        range2.is().thumbValue(2);
        range3.setThumbValue(5);
        range3.is().thumbValue(5);
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
}
