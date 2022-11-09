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

    @Test
    public void textChipGroupTest() {
        columnChipGroup.show();
        columnChipGroup.has().size(EXPECTED_CHIP_TEXTS.size());
        columnChipGroup.has().text(EXPECTED_CHIP_TEXTS);
    }

    @Test
    public void colorChipGroupTest() {
        columnChipGroup.show();
        columnChipGroup.has().color(BLACK_TRANSPARENT_087.value());
    }

    @Test
    public void selectChipGroupTest() {
        String vacationText = EXPECTED_CHIP_TEXTS.get(2);
        columnChipGroup.select(vacationText);
        columnChipGroup.is().selected(vacationText);
        columnChipGroup.deselect(vacationText);
        columnChipGroup.is().deselected(vacationText);
    }

    @Test
    public void columnChipGroupTest() {
        columnChipGroup.show();
        columnChipGroup.is().column();
    }

    @Test
    public void themeChipGroupTest() {
        adjustableChipGroup.show();
        adjustableChipGroup.has().lightTheme();
        switches.get(1).check();
        adjustableChipGroup.has().darkTheme();
    }

    @Test
    public void maxNumberOfSelectionsChipGroupTest() {
        adjustableChipGroup.show();
        adjustableChipGroup.select(Arrays.asList("Work", "Home Improvement"));
        adjustableChipGroup.is().selected("Work");
        adjustableChipGroup.is().deselected("Home Improvement");
    }

    @Test
    public void selectFilterChipGroupTest() {
        String valueToSelect = "Elevator";
        ChipGroup chooseAmenitiesChipGroup = filterResultsChipGroup.get(1);
        chooseAmenitiesChipGroup.select(valueToSelect);
        chooseAmenitiesChipGroup.is().selected(valueToSelect);
        chooseAmenitiesChipGroup.getElement(valueToSelect).has().filterIconDisplayed();
    }

    @Test
    public void nextPreviousIconChipGroupTest() {
        multipleChipGroup.show();
        multipleChipGroup.getElement("Work").is().displayed();
        multipleChipGroup.next().click();
        multipleChipGroup.getElement("Creative Writing").is().displayed();
        multipleChipGroup.previous().click();
        multipleChipGroup.getElement("Work").is().displayed();
    }

    @Test
    public void multipleChipGroupTests() {
        List<String> valuesToTest = Arrays.asList(EXPECTED_CHIP_TEXTS.get(0), EXPECTED_CHIP_TEXTS.get(3),
                EXPECTED_CHIP_TEXTS.get(4));
        multipleChipGroup.show();
        multipleChipGroup.select(valuesToTest);
        multipleChipGroup.is().selected(valuesToTest);
        multipleChipGroup.deselect(valuesToTest);
        multipleChipGroup.is().deselected(valuesToTest);
    }

    @Test
    public void mandatoryChipGroupTest() {
        String chipText = EXPECTED_CHIP_TEXTS.get(0);
        mandatoryChipGroup.show();
        mandatoryChipGroup.select(chipText);
        mandatoryChipGroup.is().selected(chipText);
        mandatoryChipGroup.deselect(chipText);
        mandatoryChipGroup.is().selected(chipText);
    }
}
