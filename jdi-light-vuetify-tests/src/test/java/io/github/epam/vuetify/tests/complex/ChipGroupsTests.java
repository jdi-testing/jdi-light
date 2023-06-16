package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipGroupsPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.pages.ChipGroupsPage.adjustableChipGroup;
import static io.github.com.pages.ChipGroupsPage.columnChipGroup;
import static io.github.com.pages.ChipGroupsPage.filterResultsChipGroup;
import static io.github.com.pages.ChipGroupsPage.mandatoryChipGroup;
import static io.github.com.pages.ChipGroupsPage.multipleChipGroup;
import static io.github.com.pages.ChipGroupsPage.switches;

public class ChipGroupsTests extends TestsInit {

    public static final List<String> EXPECTED_CHIP_TEXTS = Arrays.asList("Work", "Home Improvement", "Vacation",
            "Food", "Drawers", "Shopping", "Art", "Tech", "Creative Writing");

    @BeforeMethod
    public void before() {
        chipGroupsPage.open();
        waitCondition(() -> chipGroupsPage.isOpened());
        chipGroupsPage.checkOpened();
    }

    @Test(description = "Test checks number of chips in group and expected text of chips within group")
    public void textChipGroupTest() {
        columnChipGroup.show();
        columnChipGroup.has().size(EXPECTED_CHIP_TEXTS.size())
                .and().text(EXPECTED_CHIP_TEXTS);
    }

    @Test(description = "Test checks background color and main color of chips' group")
    public void colorChipGroupTest() {
        columnChipGroup.show();
        columnChipGroup.has().color(BLACK_TRANSPARENT_087.value())
                .and().backgroundColor(TRANSPARENT.value());
    }

    @Test(description = "Test checks selections within chips' group")
    public void selectChipGroupTest() {
        String vacationText = EXPECTED_CHIP_TEXTS.get(2);
        columnChipGroup.select(vacationText);
        columnChipGroup.is().selected(vacationText);
        columnChipGroup.deselect(vacationText);
        columnChipGroup.is().deselected(vacationText);
    }

    @Test(description = "Test checks that chip group is of column type")
    public void columnChipGroupTest() {
        columnChipGroup.show();
        columnChipGroup.is().column();
        mandatoryChipGroup.show();
        mandatoryChipGroup.is().notColumn();
    }

    @Test(description = "Test checks dark and light themes of groups")
    public void themeChipGroupTest() {
        adjustableChipGroup.show();
        adjustableChipGroup.has().lightTheme();
        switches.get(1).check();
        adjustableChipGroup.has().darkTheme();
    }

    @Test(description = "Test checks that max number of selected chips within a group is 1")
    public void maxNumberOfSelectionsChipGroupTest() {
        adjustableChipGroup.show();
        adjustableChipGroup.select(Arrays.asList("Work", "Home Improvement"));
        adjustableChipGroup.is().selected("Work")
                .and().deselected("Home Improvement");
    }

    @Test(description = "Test checks that element of a filter chip group is selected")
    public void selectFilterChipGroupTest() {
        String valueToSelect = "Elevator";
        ChipGroup chooseAmenitiesChipGroup = filterResultsChipGroup.get(1);
        chooseAmenitiesChipGroup.select(valueToSelect);
        chooseAmenitiesChipGroup.is().selected(valueToSelect);
        chooseAmenitiesChipGroup.getElement(valueToSelect).has().filterIconDisplayed();
    }

    @Test(description = "Test checks that elements are displayed correctly through scrolling chip group")
    public void nextPreviousIconChipGroupTest() {
        multipleChipGroup.show();
        multipleChipGroup.getElement("Work").is().displayed();
        multipleChipGroup.next().click();
        multipleChipGroup.getElement("Creative Writing").is().displayed();
        multipleChipGroup.previous().click();
        multipleChipGroup.getElement("Work").is().displayed();
    }

    @Test(description = "Test checks multiple selection within a group")
    public void multipleChipGroupTests() {
        List<String> valuesToTest = Arrays.asList(EXPECTED_CHIP_TEXTS.get(0), EXPECTED_CHIP_TEXTS.get(3),
                EXPECTED_CHIP_TEXTS.get(4));
        multipleChipGroup.show();
        multipleChipGroup.select(valuesToTest);
        multipleChipGroup.is().selected(valuesToTest);
        multipleChipGroup.deselect(valuesToTest);
        multipleChipGroup.is().deselected(valuesToTest);
    }
}
