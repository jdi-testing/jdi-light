package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipGroupsPage;
import static io.github.com.pages.ChipGroupsPage.columnChipGroup;
import static io.github.com.pages.ChipGroupsPage.filterResultsChipGroup;
import static io.github.com.pages.ChipGroupsPage.mandatoryChipGroup;
import static io.github.com.pages.ChipGroupsPage.multipleChipGroup;
import static io.github.com.pages.ChipGroupsPage.productCardChipGroup;
import static io.github.com.pages.ChipGroupsPage.toothbrushCardChipGroup;

import io.github.epam.TestsInit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ChipGroupTests extends TestsInit {

    @BeforeClass
    public void before() {
        chipGroupsPage.open();
        waitCondition(() -> chipGroupsPage.isOpened());
        chipGroupsPage.checkOpened();
    }

    @Test
    public void columnChipGroupTests() {
        columnChipGroup.is().notEmpty();
        columnChipGroup.has().size(9);
    }

    @Test
    public void filterResultsChipGroupTests() {
        filterResultsChipGroup.chips().get(2).click();
        filterResultsChipGroup.chips().get(2).has().filterIconDisplayed();
    }

    @Test
    public void mandatoryChipGroupTests() {
        String chipText = "Work";
        mandatoryChipGroup.has().selectedChip(chipText);
        mandatoryChipGroup.deselect(chipText);
        // when mandatory prop is set, clicking on selected chip doesn't make it deselected
        mandatoryChipGroup.has().selectedChip(chipText);
    }

    @Test
    public void multipleChipGroupTests() {
        if (multipleChipGroup.slideGroup().nextButtonIsActive()) { multipleChipGroup.slideGroup().clickOnNextButton(); }
        multipleChipGroup.select("Art", "Tech");
        multipleChipGroup.has().selectedChip("Art");
        multipleChipGroup.has().selectedChip("Tech");
    }

    @Test
    public void productCardChipGroupTests() {
        Set<String> expectedChipTextsSet = new HashSet<>(Arrays.asList("04", "06", "08"));
        productCardChipGroup.has().chipsWithTexts(expectedChipTextsSet);
    }

    @Test
    public void toothbrushCardChipGroupTests() {
        String expectedChipText = "Extra Soft";
        toothbrushCardChipGroup.chips().get(0).is().containsText(expectedChipText);
        toothbrushCardChipGroup.chips().get(0).is().notDraggable();
    }
}
