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
import static io.github.epam.test.data.GameEnum.*;
import static java.util.Arrays.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class DropdownMenuSplitTests implements TestsInit {
    final String value = "Stone/Paper/Scissors";
    
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        dropdownMenuSplit.show();
    }

    @Test
    public void selectTest() {
        dropdownMenuSplit.select("Paper");
        validateAlert("Paper clicked");
    }

    @Test
    public void selectEnumTest() {
        dropdownMenuSplit.select(Scissors);
        validateAlert("Scissors clicked");
    }
    @Test
    public void selectNumTest() {
        dropdownMenuSplit.select(1);
        validateAlert("Stone clicked");
    }
    @Test
    public void selectedTest() {
        assertEquals(dropdownMenuSplit.getValue(), value);
        assertEquals(dropdownMenuSplit.getText(), value);
    }

    @Test
    public void negativeDropdownTest() {
        try {
            dropdownMenuSplit.base().waitSec(1);
            dropdownMenuSplit.select("Unknown");
            fail("You have selected dropdownMenuSplit that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'Unknown'. No elements with this name found"));
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(dropdownMenuSplit.size(), 3);
    }

    @Test
    public void valuesTest() {
        List<String> values = dropdownMenuSplit.values();
        assertEquals(values, asList("Stone","Paper","Scissors"));
    }

    @Test
    public void assertValuesTest() {
        dropdownMenuSplit.assertThat().values(hasItem("Scissors"))
            .values(hasItems("Stone","Paper","Scissors"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dropdownMenuSplit);
    }
}
