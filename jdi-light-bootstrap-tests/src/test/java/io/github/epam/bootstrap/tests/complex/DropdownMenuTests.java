package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.elements.common.Alerts.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;
import static io.github.epam.test.data.Elementals.*;
import static java.util.Arrays.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class DropdownMenuTests implements TestsInit {
    final String value = "Elementals";
    
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        dropdownMenu.show();
    }

    @Test
    public void selectTest() {
        dropdownMenu.select("Air");
        validateAlert("Air clicked");
    }

    @Test
    public void selectEnumTest() {
        dropdownMenu.select(Earth);
        validateAlert("Earth clicked");
    }
    @Test
    public void selectNumTest() {
        dropdownMenu.select(2);
        validateAlert("Fire clicked");
    }
    @Test
    public void selectedTest() {
        assertEquals(dropdownMenu.getValue(), value);
        assertEquals(dropdownMenu.getText(), value);
    }

    @Test
    public void negativeDropdownTest() {
        try {
            dropdownMenu.base().waitSec(1);
            dropdownMenu.select("Unknown");
            fail("You have selected dropdownMenu that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'Unknown'. No elements with this name found"));
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(dropdownMenu.size(), 4);
    }

    @Test
    public void valuesTest() {
        List<String> values = dropdownMenu.values();
        assertEquals(values, asList("Water", "Fire", "Earth", "Air"));
    }

    @Test
    public void assertValuesTest() {
        dropdownMenu.assertThat().values(hasItem("Fire"))
            .values(hasItems("Water", "Fire", "Earth", "Air"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dropdownMenu);
    }
}
