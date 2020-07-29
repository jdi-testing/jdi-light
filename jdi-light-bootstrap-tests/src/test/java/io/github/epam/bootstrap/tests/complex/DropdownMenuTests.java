package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.common.Alerts.validateAndAcceptAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenu;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.Elementals.Earth;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

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
        validateAndAcceptAlert("Air clicked");
    }

    @Test
    public void selectEnumTest() {
        dropdownMenu.select(Earth);
        validateAndAcceptAlert("Earth clicked");
    }
    @Test
    public void selectNumTest() {
        dropdownMenu.select(2);
        validateAndAcceptAlert("Fire clicked");
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
