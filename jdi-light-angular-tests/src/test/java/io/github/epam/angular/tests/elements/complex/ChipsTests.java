package io.github.epam.angular.tests.elements.complex;

import io.github.com.pages.ChipsPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.ChipsPage.autocompleteChips;
import static io.github.com.pages.ChipsPage.basicChips;
import static io.github.com.pages.ChipsPage.inputChips;
import static io.github.com.pages.ChipsPage.multipleChips;
import static io.github.com.pages.ChipsPage.stackedChips;
import static io.github.com.pages.ChipsPage.stackedSelectedValue;
import static io.github.com.pages.sections.ChipsSection.chipsAutocompleteField;
import static io.github.com.pages.sections.ChipsSection.chipsAutocompleteInput;
import static io.github.com.pages.sections.ChipsSection.chipsWithInputInput;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

// TODO Move to the new page
//@Ignore
public class ChipsTests extends TestsInit {

    private static final String ONEFISH = "One fish";
    private static final String TWOFISH = "Two fish";
    private static final String PRIMARYFISH = "Primary fish";
    private static final String WARNFISH = "Warn fish";

    private static final String NONE = "none";
    private static final String PRIMARY = "Primary";
    private static final String ACCENT = "Accent";
    private static final String WARN = "Warn";

    private static final String PLACEHOLDER = "New fruit...";
    private static final String APPLE = "Apple";
    private static final String LEMON = "Lemon";
    private static final String LIME = "Lime";


//    @BeforeMethod(alwaysRun = true)
//    public void before() {
//        shouldBeLoggedIn();
//        angularPage.shouldBeOpened();
//    }

    @BeforeClass
    public void before() {
        chipsPage.open();
        waitCondition(() -> chipsPage.isOpened());
        chipsPage.checkOpened();
    }

    @Test
    public void basicChipsTest() {
        basicChips.show();
//        basicChips.is().displayed();
//        basicChips.is().assertChipsIsEnabled();
//        basicChips.selectByText(ONEFISH);
        basicChips.selectByText(TWOFISH);
        basicChips.selectByText(PRIMARYFISH);
        basicChips.selectByText(WARNFISH);

        ChipsPage.basicSelectedValue.has().text(format("You clicked: %s", WARNFISH));
    }

    @Test
    public void stackedChipsTest() {
        stackedChips.show();
//        stackedChipsList.is().displayed();
//        stackedChipsList.is().assertChipsIsEnabled();
        stackedChips.is().vertical();
        stackedChips.selectByText(NONE);
        stackedChips.selectByText(PRIMARY);
        stackedChips.selectByText(ACCENT);
        stackedChips.selectByText(WARN);

        stackedSelectedValue.has().text(format("You clicked: %s", WARN));
    }

    @Test
    public void chipsAutocompleteTest() {
        String[] expectedValuesArray = {
                "Apple", "Lemon", "Lime", "Orange", "Strawberry"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        autocompleteChips.show();

//        autocompleteChips.is().disabled();
//        chipsAutocompleteField.is().displayed();
//        chipsAutocompleteInput.is().assertChipsIsEnabled();
//        autocompleteChips.has().assertChipsHasPlaceholder(PLACEHOLDER);
//        autocompleteChips.has().assertChipsHasOptions(expectedValues);

        autocompleteChips.setValue(LEMON);
//        chipsAutocompleteField.collapseField();
//        chipsAutocompleteInput.setValue(APPLE);
//        chipsAutocompleteField.collapseField();
//        chipsAutocompleteInput.setValue(LIME);
//        chipsAutocompleteField.collapseField();


    }

    @Test
    public void chipsWithInputTest() {
        inputChips.show();
        chipsWithInputInput.is().displayed();
//        inputChips.is().assertChipsIsEnabled();
        inputChips.has().assertChipsHasPlaceholder(PLACEHOLDER);
        inputChips.input("Kiwi" + "\n");
        inputChips.input("Melon");
        inputChips.clearInputField();
        inputChips.input("Rockmelon" + "\n");
    }


    @Test
    public void mult() {
        multipleChips.show();
//        multipleChips.is().displayed();
//        multipleChips.is().multiselectable();
    }
//
//    @Test
//    public void testTest() {
//        basicChips.getChipsByIndex(1).click();
//        ChipsPage.basicSelectedValue.has().text(format("You clicked: %s", ONEFISH));
//        System.out.println("Hello world!");
//        System.out.println(basicChips.getText());
//    }
}