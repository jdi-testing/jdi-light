package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ChipsSection.autocompleteChipsList;
import static io.github.com.pages.sections.ChipsSection.basicChipsRow;
import static io.github.com.pages.sections.ChipsSection.basicSelectedValue;
import static io.github.com.pages.sections.ChipsSection.chipsAutocompleteField;
import static io.github.com.pages.sections.ChipsSection.chipsWithInputField;
import static io.github.com.pages.sections.ChipsSection.chipsAutocompleteInput;
import static io.github.com.pages.sections.ChipsSection.chipsWithInputInput;
import static io.github.com.pages.sections.ChipsSection.chipsWithInputList;
import static io.github.com.pages.sections.ChipsSection.stackedChipsList;
import static io.github.com.pages.sections.ChipsSection.stackedSelectedValue;
import static io.github.com.pages.sections.SliderSection.matSliderConfigurable;
import static io.github.com.pages.sections.SliderSection.sliderConfigurableVertical;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChipsUnitTests extends TestsInit {

    private static final String ONEFISH = "One fish";
    private static final String TWOFISH = "Two fish";
    private static final String PRIMARYFISH = "Primary fish";
    private static final String ACCENTFISH = "Accent fish";

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
        assertTrue(basicSelectedValue.isDisplayed());
        assertTrue(stackedChipsList.isDisplayed());
        assertTrue(stackedSelectedValue.isDisplayed());
        assertTrue(chipsAutocompleteField.isDisplayed());
        assertTrue(chipsAutocompleteInput.isDisplayed());
        assertTrue(autocompleteChipsList.isDisplayed());
        assertTrue(chipsWithInputField.isDisplayed());
        assertTrue(chipsWithInputInput.isDisplayed());
        assertTrue(chipsWithInputList.isDisplayed());
    }

    @Test
    public void basicChipsHasTextTest() {
        basicChipsRow.clickChipsByTextValue(ONEFISH);
        Assert.assertTrue(basicChipsRow.chipsHasText(ONEFISH));
        basicChipsRow.clickChipsByTextValue(TWOFISH);
        Assert.assertTrue(basicChipsRow.chipsHasText(TWOFISH));
        basicChipsRow.clickChipsByTextValue(PRIMARYFISH);
        Assert.assertTrue(basicChipsRow.chipsHasText(PRIMARYFISH));
        basicChipsRow.clickChipsByTextValue(ACCENTFISH);
        Assert.assertTrue(basicChipsRow.chipsHasText(ACCENTFISH));
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
        assertEquals(chipsWithInputInput.getPlaceholderForChips(), PLACEHOLDER);
    }

    @Test
    public void chipsAutocompleteGetValuesTest() {
        String expectedValuesArray[] = {"Apple", "Lemon", "Lime", "Orange", "Strawberry"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        assertEquals(chipsAutocompleteInput.options(), expectedValues);
    }
}
