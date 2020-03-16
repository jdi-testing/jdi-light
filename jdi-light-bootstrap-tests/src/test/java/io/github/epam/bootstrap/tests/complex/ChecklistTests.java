package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.*;
import static java.util.Arrays.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class ChecklistTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkNumbers.check(text);
    }
    String text = "1";

    @Test
    public void getValueTest() {
        assertEquals(checkNumbers.getValue(), text);
    }

    @Test
    public void checkTest() {
        checkNumbers.check("2");
        assertEquals(checkNumbers.checked(), asList("2"));
    }
    @Test
    public void checkTwoTest() {
        checkNumbers.check("1", "2");
        assertEquals(checkNumbers.checked(), asList("1", "2"));
    }
    @Test
    public void uncheckTest() {
        checkNumbers.check("3", "4");
        checkNumbers.uncheck("3");
        checkNumbers.is().checked(hasSize(3));
        checkNumbers.is().checked(hasItems("1", "2", "4"));
    }
    @Test
    public void uncheckTwoTest() {
        checkNumbers.check("3", "4");
        checkNumbers.uncheck("3", "4");
        checkNumbers.is().checked(hasSize(2));
        checkNumbers.is().checked(hasItems("1", "2"));
    }
    @Test
    public void selectTest() {
        checkNumbers.select("2");
        assertEquals(checkNumbers.checked(), asList("1", "2"));
    }
    @Test
    public void selectTwoTest() {
        checkNumbers.select("2", "1");
        assertEquals(checkNumbers.checked(), asList("2"));
    }
    @Test
    public void uncheckEnumTest() {
        checkNumbers.check("3", "4");
        checkNumbers.uncheck("3");
        checkNumbers.is().checked(hasSize(3));
        checkNumbers.is().checked(hasItems("1", "2", "4"));
    }
    @Test
    public void uncheckEnumTwoTest() {
        checkNumbers.check("3", "4");
        checkNumbers.uncheck("3", "4");
        checkNumbers.is().checked(hasSize(2));
        checkNumbers.is().checked(hasItems("1", "2"));
    }
    @Test
    public void checkNumTest() {
        checkNumbers.check(4);
        assertEquals(checkNumbers.checked(), asList("4"));
    }
    @Test
    public void checkNumTwoTest() {
        checkNumbers.check(1, 4);
        assertEquals(checkNumbers.checked(), asList("1", "4"));
    }
    @Test
    public void uncheckNumTest() {
        checkNumbers.checkAll();
        checkNumbers.uncheck(1);
        checkNumbers.is().checked(hasSize(3));
        checkNumbers.is().checked(hasItems("2", "3", "4"));
    }
    @Test
    public void uncheckNumTwoTest() {
        checkNumbers.checkAll();
        checkNumbers.uncheck(1, 4);
        checkNumbers.is().checked(hasSize(2));
        checkNumbers.is().checked(hasItems("2", "3"));
    }
    @Test
    public void selectNumTest() {
        checkNumbers.select(4);
        assertEquals(checkNumbers.checked(), asList("1", "4"));
    }
    @Test
    public void selectNumTwoTest() {
        checkNumbers.select(1, 4);
        assertEquals(checkNumbers.checked(), asList("4"));
    }

    @Test
    public void selectedTest() {
        assertEquals(checkNumbers.selected(), text);
    }

    @Test
    public void disabledTest() {
        try {
            checkNumbers.select("Disabled");
            fail("Click on disabled element should throw exception");
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("Can't perform click. Element is disabled"));
        }
        assertEquals(checkNumbers.selected(), text);
    }

    @Test
    public void isValidationTest() {
        checkNumbers.is().displayed().selected("1");
        checkNumbers.assertThat().values(hasItem("3"))
            .disabled(hasItem("Disabled"))
            .enabled(not(hasItem("Disabled")))
            .enabled(hasItems("2", "3"));
    }

    @Test
    public void assertValidationTest() {
        checkNumbers.assertThat().values(containsInAnyOrder(
        "1", "2", "3", "4", "Disabled"));
    }

    @Test
    public void uncheckAllTest() {
        checkNumbers.check("3", "4");
        checkNumbers.uncheckAll();
        checkNumbers.is().checked(hasSize(0));
    }
    @Test
    public void checkAllTest() {
        checkNumbers.checkAll();
        checkNumbers.is().checked(hasSize(4));
        checkNumbers.is().checked(hasItems("1", "2", "3", "4"));
    }
}
