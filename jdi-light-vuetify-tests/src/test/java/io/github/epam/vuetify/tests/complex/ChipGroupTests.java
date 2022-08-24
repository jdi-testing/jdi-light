package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.ChipGroup;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipGroupsPage;
import static io.github.com.pages.ChipGroupsPage.columnChipGroup;
import static io.github.com.pages.ChipGroupsPage.filterResultsChipGroup;
import static io.github.com.pages.ChipGroupsPage.mandatoryChipGroup;
import static io.github.com.pages.ChipGroupsPage.multipleChipGroup;
import static io.github.com.pages.ChipGroupsPage.productCardChipGroup;

public class ChipGroupTests extends TestsInit {

    public static final List<String> EXPECTED_CHIP_TEXTS = Arrays.asList("Work", "Home Improvement", "Vacation", "Food", "Drawers", "Shopping", "Art", "Tech", "Creative Writing");

    @BeforeMethod
    public void before() {
        chipGroupsPage.open();
        waitCondition(() -> chipGroupsPage.isOpened());
    }

    @Test
    public void columnChipGroupTests() {
        columnChipGroup.show();

        columnChipGroup.has().size(EXPECTED_CHIP_TEXTS.size());
        columnChipGroup.is().containsTexts(EXPECTED_CHIP_TEXTS);

        String vacationText = EXPECTED_CHIP_TEXTS.get(2);
        columnChipGroup.select(vacationText);
        columnChipGroup.is().selected(vacationText);

        columnChipGroup.deselect(vacationText);
        columnChipGroup.is().deselected(vacationText);

        String shoppingText = EXPECTED_CHIP_TEXTS.get(5);
        columnChipGroup.select(shoppingText);
        columnChipGroup.is().selected(shoppingText);

        String artText = EXPECTED_CHIP_TEXTS.get(6);
        columnChipGroup.select(artText);
        columnChipGroup.is().deselected(shoppingText)
                .is().selected(artText);
    }

    @Test
    public void amenitiesFilterResultsChipGroupTests() {
        List<String> expectedAmenityTexts = Arrays.asList("Elevator", "Washer / Dryer", "Fireplace", "Wheelchair access", "Dogs ok", "Cats ok");

        ChipGroup chooseAmenitiesChipGroup = filterResultsChipGroup.get(1);

        chooseAmenitiesChipGroup.has().size(expectedAmenityTexts.size());
        chooseAmenitiesChipGroup.is().containsTexts(expectedAmenityTexts);

        chooseAmenitiesChipGroup.is().selected(expectedAmenityTexts.get(1))
                .is().selected(expectedAmenityTexts.get(4));

        chooseAmenitiesChipGroup.chipByText(expectedAmenityTexts.get(3)).click();
        chooseAmenitiesChipGroup.chipByText(expectedAmenityTexts.get(3)).has().filterIconDisplayed();

    }

    @Test
    public void neighborhoodsFilterResultsChipGroupTests() {
        List<String> expectedNeighborhoodTexts = Arrays.asList("Snowy Rock Place", "Honeylane Circle", "Donna Drive", "Elaine Street", "Court Street", "Kennedy Park");

        ChipGroup neighborhoodsChipGroup = filterResultsChipGroup.get(2);

        neighborhoodsChipGroup.has().size(expectedNeighborhoodTexts.size());
        neighborhoodsChipGroup.is().containsTexts(expectedNeighborhoodTexts);

        neighborhoodsChipGroup.is().selected(expectedNeighborhoodTexts.get(1));

        neighborhoodsChipGroup.chipByText(expectedNeighborhoodTexts.get(3)).click();
        neighborhoodsChipGroup.chipByText(expectedNeighborhoodTexts.get(3)).has().filterIconDisplayed();
    }

    @Test
    public void mandatoryChipGroupTests() {
        mandatoryChipGroup.show();

        String workText = EXPECTED_CHIP_TEXTS.get(0);
        mandatoryChipGroup.is().selected(workText);

        mandatoryChipGroup.deselect(workText);
        // when mandatory prop is set, clicking on selected chip doesn't make it deselected
        mandatoryChipGroup.is().selected(workText);
    }

    @Test
    public void multipleChipGroupTests() {
        multipleChipGroup.show();

        String workText = EXPECTED_CHIP_TEXTS.get(0);
        String foodText = EXPECTED_CHIP_TEXTS.get(3);
        String drawersText = EXPECTED_CHIP_TEXTS.get(4);

        multipleChipGroup.select(workText, foodText, drawersText);
        multipleChipGroup.is().selected(workText);
        multipleChipGroup.is().selected(foodText);
        multipleChipGroup.is().selected(drawersText);

        multipleChipGroup.deselect(workText, foodText, drawersText);
        multipleChipGroup.is().deselected(workText);
        multipleChipGroup.is().deselected(foodText);
        multipleChipGroup.is().deselected(drawersText);
    }

    @Test
    public void productCardChipGroupTests() {
        List<String> productCardChipTexts = Arrays.asList("04", "06", "08", "10", "12", "14");

        productCardChipGroup.show();

        productCardChipGroup.has().size(productCardChipTexts.size());
        productCardChipGroup.is().containsTexts(productCardChipTexts);
        productCardChipGroup.is().selected(productCardChipTexts.get(2));

        productCardChipGroup.select(productCardChipTexts.get(0));
        productCardChipGroup.is().deselected(productCardChipTexts.get(2))
                .is().selected(productCardChipTexts.get(0));
    }
}
