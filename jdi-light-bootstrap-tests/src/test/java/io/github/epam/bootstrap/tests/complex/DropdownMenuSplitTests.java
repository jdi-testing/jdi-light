package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static com.epam.jdi.light.elements.common.Alerts.validateAndAcceptAlert;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenuSplit;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.GameEnum.Scissors;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

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
        validateAndAcceptAlert("Paper clicked");
    }

    @Test
    public void selectEnumTest() {
        dropdownMenuSplit.select(Scissors);
        validateAndAcceptAlert("Scissors clicked");
    }
    @Test
    public void selectNumTest() {
        dropdownMenuSplit.select(ELEMENT.startIndex);
        validateAndAcceptAlert("Stone clicked");
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
            assertThat(safeException(ex), containsString("Failed to get 'Unknown' in list 'Dropdown Menu Split list'. No elements with this name found"));
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
