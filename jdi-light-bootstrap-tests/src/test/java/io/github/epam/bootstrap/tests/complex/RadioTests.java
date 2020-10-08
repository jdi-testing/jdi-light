package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.airClassOptions;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class RadioTests implements TestsInit {
    final String text = "First class";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        airClassOptions.select("First class");
    }

    @Test
    public void getValueTest() {
        assertEquals(airClassOptions.getValue(), text);
    }

    @Test
    public void selectTest() {
        airClassOptions.select("Second class");
        assertEquals(airClassOptions.getValue(), "Second class");
        airClassOptions.select("First class");
        airClassOptions.is().selected("First class");
    }

    @Test
    public void selectNumTest() {
        airClassOptions.select(ELEMENT.startIndex + 1);
        assertEquals(airClassOptions.getValue(), "Second class");
    }
    @Test
    public void selectedTest() {
        assertEquals(airClassOptions.selected(), text);
    }
    @Test
    public void valuesTest() {
        assertEquals(airClassOptions.values(), asList("First class", "Second class", "Vip class"));
    }

    @Test
    public void isValidationTest() {
        airClassOptions.is().selected("First class").and()
            .values(hasItem("Second class")).and()
            .disabled(hasItem("Vip class"))
            .enabled(not(hasItem("Vip class"))).enabled(hasItems("First class", "Second class"));
    }

    @Test
    public void assertValidationTest() {
        airClassOptions.assertThat().values(contains("First class", "Second class", "Vip class"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(airClassOptions);
    }

}
