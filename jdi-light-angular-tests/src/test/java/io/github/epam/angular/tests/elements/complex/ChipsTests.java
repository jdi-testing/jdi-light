package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ChipsSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ChipsTests extends TestsInit {

    private static final String ONEFISH = "One fish";
    private static final String TWOFISH = "Two fish";
    private static final String PRIMARYFISH = "Primary fish";
    private static final String ACCENTFISH = "Accent fish";

    private static final String NONE = "none";
    private static final String PRIMARY = "Primary";
    private static final String ACCENT = "Accent";
    private static final String WARN = "Warn";

    private static final String PLACEHOLDER = "New fruit...";
    private static final String APPLE = "Apple";
    private static final String LEMON = "Lemon";
    private static final String LIME = "Lime";


    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicChipsTest() {
        basicChipsRow.show();
        basicChipsRow.is().displayed();
        basicChipsRow.is().assertChipsIsEnabled();
        basicChipsRow.clickChipsByTextValue(ONEFISH);
        basicChipsRow.clickChipsByTextValue(TWOFISH);
        basicChipsRow.clickChipsByTextValue(PRIMARYFISH);
        basicChipsRow.clickChipsByTextValue(ACCENTFISH);

        basicSelectedValue.has().text(String.format("You clicked: %s", ACCENTFISH));
    }

    @Test
    public void stackedChipsTest() {
        stackedChipsList.show();
        stackedChipsList.is().displayed();
        stackedChipsList.is().assertChipsIsEnabled();
        stackedChipsList.clickChipsByTextValue(NONE);
        stackedChipsList.clickChipsByTextValue(PRIMARY);
        stackedChipsList.clickChipsByTextValue(ACCENT);
        stackedChipsList.clickChipsByTextValue(WARN);

        stackedSelectedValue.has().text(String.format("You clicked: %s", WARN));
    }

    @Test
    public void chipsAutocompleteTest() throws InterruptedException {
        String[] expectedValuesArray = {
                "Apple", "Lemon", "Lime", "Orange", "Strawberry"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        chipsAutocompleteField.show();
        chipsAutocompleteField.is().displayed();
        chipsAutocompleteInput.is().assertChipsIsEnabled();
        chipsAutocompleteInput.has().assertChipsHasPlaceholder(PLACEHOLDER);
        chipsAutocompleteInput.has().assertChipsHasOptions(expectedValues);

        chipsAutocompleteInput.setValue(LEMON);
        chipsAutocompleteField.collapseField();
        chipsAutocompleteInput.setValue(APPLE);
        chipsAutocompleteField.collapseField();
        chipsAutocompleteInput.setValue(LIME);
        chipsAutocompleteField.collapseField();
    }

    @Test
    public void chipsWithInputTest() {
        chipsWithInputField.show();
        chipsWithInputField.is().displayed();
        chipsWithInputInput.is().assertChipsIsEnabled();
        chipsWithInputInput.has().assertChipsHasPlaceholder(PLACEHOLDER);
        chipsWithInputInput.input("Kiwi" + "\n");
        chipsWithInputInput.input("Melon");
        chipsWithInputInput.clearInputField();
        chipsWithInputInput.input("Rockmelon" + "\n");
    }
}