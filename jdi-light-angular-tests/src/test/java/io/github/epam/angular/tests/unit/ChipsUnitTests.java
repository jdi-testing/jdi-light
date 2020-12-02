package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ChipsSection.basicChipsRow;
import static io.github.com.pages.sections.ChipsSection.chipsAutocompleteInput;
import static io.github.com.pages.sections.ChipsSection.chipsWithInputInput;
import static io.github.com.pages.sections.ChipsSection.stackedChipsList;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChipsUnitTests extends TestsInit {

    private static final String ONEFISH = "One fish";
    private static final String NONE = "none";
    private static final String PRIMARY = "Primary";
    private static final String ACCENT = "Accent";
    private static final String WARN = "Warn";
    private static final String PLACEHOLDER = "New fruit...";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void isChipsDisplayedTest() {
        assertTrue(basicChipsRow.isDisplayed());
    }

    @Test
    public void basicChipsHasTextTest() {
        basicChipsRow.clickChipsByTextValue(ONEFISH);
        Assert.assertTrue(basicChipsRow.chipsHasText(ONEFISH));
    }

    @Test
    public void stackedChipsHasTextTest() {
        stackedChipsList.clickChipsByTextValue(NONE);
        Assert.assertTrue(stackedChipsList.chipsHasText(NONE));
        stackedChipsList.clickChipsByTextValue(PRIMARY);
        Assert.assertTrue(stackedChipsList.chipsHasText(PRIMARY));
        stackedChipsList.clickChipsByTextValue(ACCENT);
        Assert.assertTrue(stackedChipsList.chipsHasText(ACCENT));
        stackedChipsList.clickChipsByTextValue(WARN);
        Assert.assertTrue(stackedChipsList.chipsHasText(WARN));
    }

    @Test
    public void chipsHasPlaceholderTest() {
        assertEquals(chipsAutocompleteInput.getPlaceholderForChips(), PLACEHOLDER);
    }

    @Test
    public void chipsAutocompleteGetValuesTest() {
        String[] expectedValuesArray = {"Apple", "Lemon", "Lime", "Orange", "Strawberry"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        assertEquals(chipsAutocompleteInput.options(), expectedValues);
    }

    @Test
    public void clearInputFieldTest() {
        chipsWithInputInput.input("Melon");
        chipsWithInputInput.clearInputField();
        Assert.assertTrue(chipsWithInputInput.isEmpty());
    }
}
