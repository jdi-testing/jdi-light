package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.angular.elements.enums.AngularColors;
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
import static io.github.com.pages.ChipsPage.avatarChips;
import static io.github.com.pages.ChipsPage.basicChips;
import static io.github.com.pages.ChipsPage.disabledChips;
import static io.github.com.pages.ChipsPage.errorChips;
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

    @Test(description = "Test verifies that chip group is selectable")
    public void basicChipsTest() {
        basicChips.show();
        basicChips.is().displayed();
        basicChips.selectByText(TWOFISH);
        basicChips.selectByText(PRIMARYFISH);
        basicChips.selectByText(WARNFISH);

        ChipsPage.basicSelectedValue.has().text(format("You clicked: %s", WARNFISH));
    }

    @Test(description = "Test verifies that chip group is vertical")
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

    @Test(description = "Test check chips colors")
    public void chipsColorTest() {
        stackedChips.show();
        stackedChips.is().displayed();
        stackedChips.getElement(PRIMARY).is().color(AngularColors.MAT_PRIMARY);
        stackedChips.getElement(ACCENT).is().color(AngularColors.MAT_ACCENT);
        stackedChips.getElement(WARN).is().color(AngularColors.MAT_WARN);
    }

    @Test(description = "Test checks the operation of the autocomplete in chips group")
    public void chipsAutocompleteTest() {
        String[] expectedValuesArray = {
                "Apple", "Lemon", "Lime", "Orange", "Strawberry"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);

        autocompleteChips.show();
        autocompleteChips.is().displayed();
        autocompleteChips.has().placeholder("New Fruit...");
        autocompleteChips.has().options(expectedValues);

        autocompleteChips.select(LEMON);
        autocompleteChips.collapseField();
        autocompleteChips.is().hasElement(LEMON);
        autocompleteChips.select(APPLE);
        autocompleteChips.collapseField();
        autocompleteChips.is().hasElement(APPLE);
    }

    @Test(description = "Test checks the input field in chips group")
    public void chipsWithInputTest() {
        inputChips.show();
        inputChips.is().displayed();
        inputChips.has().placeholder(PLACEHOLDER);
        inputChips.input("Kiwi" + "\n");
        inputChips.input("Melon");
        inputChips.clearInputField();
        inputChips.input("Rockmelon" + "\n");
        inputChips.is().hasElement("Kiwi");
        inputChips.is().hasElement("Rockmelon");
    }

    @Test(description = "Test checks that chips can be removed")
    public void chipsRemovableTest() {
        inputChips.show();
        inputChips.is().displayed();
        inputChips.getElement("Lemon").is().removable();
        inputChips.getElement("Lemon").close();
    }

    @Test(description = "Test checks that chips can be focused")
    public void chipFocusedTest() {
        inputChips.show();
        inputChips.is().displayed();
        inputChips.getElement("Apple").click();
        inputChips.getElement("Apple").is().focused();
        inputChips.getElement("Lime").click();
        inputChips.getElement("Lime").is().focused();
    }

    @Test(description = "Test checks that chips has avatar image")
    public void chipAvatarTest() {
        String expectedSrc = "https://material.angular.io/assets/img/examples/shiba1.jpg";
        avatarChips.show();
        avatarChips.getElement("Dog one").leadingIcon().is().src(expectedSrc);
    }

    @Test(description = "Test checks that chips can be disabled")
    public void chipDisabledTest() {
        disabledChips.show();
        disabledChips.is().displayed();
        disabledChips.is().disabled();
    }

    @Test(description = "Test checks chips multiply selection")
    public void chipsMultipleSelectionTest() {
        multipleChips.show();
        multipleChips.is().displayed();
        multipleChips.is().multiselectable();
        multipleChips.selectByText("multiple color none");
        multipleChips.selectByText("multiple color Primary");
        multipleChips.getElement("multiple color none").is().selected();
        multipleChips.getElement("multiple color Primary").is().selected();
    }

    @Test(description = "Test checks that chips has error state")
    public void chipsErrorState() {
        errorChips.show();
        errorChips.is().displayed();
        errorChips.input("Kiwi" + "\n");
        errorChips.has().errorState();
    }
}