package io.github.epam.angular.tests.elements.complex;

import io.github.com.pages.ChipsPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.ChipsPage.autocompleteChips;
import static io.github.com.pages.ChipsPage.basicChips;
import static io.github.com.pages.ChipsPage.disabledChips;
import static io.github.com.pages.ChipsPage.inputChips;
import static io.github.com.pages.ChipsPage.multipleChips;
import static io.github.com.pages.ChipsPage.stackedChips;
import static io.github.com.pages.ChipsPage.stackedSelectedValue;

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

    @BeforeMethod
    public void before() {
        chipsPage.open();
        waitCondition(() -> chipsPage.isOpened());
        chipsPage.checkOpened();
    }

    @Test
    public void basicChipsTest() {
        basicChips.show();
        basicChips.is().displayed();
        basicChips.selectByText(TWOFISH);
        basicChips.selectByText(PRIMARYFISH);
        basicChips.selectByText(WARNFISH);

        ChipsPage.basicSelectedValue.has().text(format("You clicked: %s", WARNFISH));
    }

    @Test
    public void stackedChipsTest() {
        stackedChips.show();
        stackedChips.is().displayed();
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
        autocompleteChips.is().displayed();
        autocompleteChips.has().assertChipsHasPlaceholder("New Fruit...");
        autocompleteChips.has().assertChipsHasOptions(expectedValues);

        autocompleteChips.setValue(LEMON);
        autocompleteChips.collapseField();
        autocompleteChips.is().hasElement(LEMON);
        autocompleteChips.setValue(APPLE);
        autocompleteChips.collapseField();
        autocompleteChips.is().hasElement(APPLE);
        autocompleteChips.setValue(LIME);
        autocompleteChips.collapseField();
        autocompleteChips.is().hasElement(LIME);
    }

    @Test
    public void chipsWithInputTest() {
        inputChips.show();
        inputChips.is().displayed();
        inputChips.has().assertChipsHasPlaceholder(PLACEHOLDER);
        inputChips.input("Kiwi" + "\n");
        inputChips.input("Melon");
        inputChips.clearInputField();
        inputChips.input("Rockmelon" + "\n");
        inputChips.is().hasElement("Kiwi");
        inputChips.is().hasElement("Rockmelon");
    }

    @Test
    public void chipsRemovableTest() {
        inputChips.show();
        inputChips.is().displayed();
        inputChips.getElement("Lemon").is().removable();
        inputChips.getElement("Lemon").close();
        inputChips.getElement("Lemon");
    }

    @Test
    public void chipDisabledTest() {
        disabledChips.groupElements().get(0).is().disabled();
        disabledChips.groupElements().get(1).is().disabled();
        disabledChips.groupElements().get(2).is().disabled();

    }

    @Test
    public void chipsMultipleSelectionTest() {
        multipleChips.show();
        multipleChips.is().displayed();
        multipleChips.is().multiselectable();
        multipleChips.selectByText("multiple color none");
        multipleChips.selectByText("multiple color Primary");
        multipleChips.getElement("multiple color none").is().selected();
        multipleChips.getElement("multiple color Primary").is().selected();
    }
}