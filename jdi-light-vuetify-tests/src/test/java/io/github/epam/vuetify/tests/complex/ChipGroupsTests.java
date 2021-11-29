package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static io.github.com.StaticSite.chipGroupsPage;
import static io.github.com.pages.ChipGroupsPage.columnChipGroup;
import static io.github.com.pages.ChipGroupsPage.filterResultsChipGroup;
import static io.github.com.pages.ChipGroupsPage.mandatoryChipGroup;
import static io.github.com.pages.ChipGroupsPage.mandatoryGroupButtonBack;
import static io.github.com.pages.ChipGroupsPage.mandatoryGroupButtonNext;
import static io.github.com.pages.ChipGroupsPage.multipleChipGroup;
import static io.github.com.pages.ChipGroupsPage.multipleGroupButtonBack;
import static io.github.com.pages.ChipGroupsPage.multipleGroupButtonNext;
import static io.github.com.pages.ChipGroupsPage.productCardChipGroup;
import static io.github.com.pages.ChipGroupsPage.shirtBlouseAddToCartButton;
import static io.github.com.pages.ChipGroupsPage.shirtBlouseText;
import static io.github.com.pages.ChipGroupsPage.toothbrushAddToCardButton;
import static io.github.com.pages.ChipGroupsPage.toothbrushCardChipGroup;
import static io.github.com.pages.ChipGroupsPage.toothbrushText;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroups;
import com.epam.jdi.tools.Timer;
import io.github.com.dataproviders.ChipGroupsDataProviders;
import io.github.epam.TestsInit;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ChipGroupsTests extends TestsInit {

    @BeforeClass
    public void before() {
        chipGroupsPage.open();
    }

    @Test(dataProvider = "columnChipGroupDataProvider", dataProviderClass = ChipGroupsDataProviders.class)
    public void columnChipsTest(List<String> chipsLabels) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                columnChipGroup.size() != 0);
        for (int i = 1; i <= chipsLabels.size(); i++) {
            columnChipGroup.get(i).click();
            columnChipGroup.get(i).is().containsText(chipsLabels.get(i - 1));
        }
    }

    @Test(dataProvider = "chooseAmenitiesAndNeighborhoodsDataProvider",
            dataProviderClass = ChipGroupsDataProviders.class)
    public void filterResultsChipGroupTest(List<String> chooseAmenitiesAndNeighborhoods) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                filterResultsChipGroup.size() != 0);
        for (int i = 1; i <= chooseAmenitiesAndNeighborhoods.size(); i++) {
            filterResultsChipGroup.get(i).click();
            filterResultsChipGroup.get(i).is().containsText(chooseAmenitiesAndNeighborhoods.get(i - 1));
            if (chipIsSelected(filterResultsChipGroup.get(i))) {
                filterResultsChipGroup.get(1).has().filter();
            } else {
                filterResultsChipGroup.get(i).has().notFilter();
            }
        }
    }

    @Test
    public void mandatoryChipGroupTest() {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                mandatoryChipGroup.size() != 0);

        jdiAssert(mandatoryGroupButtonBack.get(1).isClickable(),
                Matchers.is(false));

        do {
            mandatoryGroupButtonNext.select(1);
        } while (mandatoryGroupButtonNext.get(1).isClickable());

        mandatoryChipGroup.get(6).click();
        assertSelected(mandatoryChipGroup.get(6));
        mandatoryChipGroup.get(6).is().containsText("Tech");

        jdiAssert(mandatoryGroupButtonNext.get(1).isClickable(),
                Matchers.is(false));

        do {
            mandatoryGroupButtonBack.select(1);
        } while (mandatoryGroupButtonBack.get(1).isClickable());

        mandatoryChipGroup.get(2).click();
        assertSelected(mandatoryChipGroup.get(2));
        mandatoryChipGroup.get(2).is().containsText("Home Improvement");
    }

    @Test(dataProvider = "columnChipGroupDataProvider", dataProviderClass = ChipGroupsDataProviders.class)
    public void multipleChipGroupTest(List<String> chipsLabels) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                multipleChipGroup.size() != 0);

        jdiAssert(multipleGroupButtonBack.get(1).isClickable(),
                Matchers.is(false));

        do {
            multipleGroupButtonNext.select(1);
        } while (multipleGroupButtonNext.get(1).isClickable());

        multipleChipGroup.get(7).click();
        assertSelected(multipleChipGroup.get(7));
        multipleChipGroup.get(7).is().containsText("Creative Writing");

        jdiAssert(multipleGroupButtonNext.get(1).isClickable(),
                Matchers.is(false));

        do {
            multipleGroupButtonBack.select(1);
        } while (multipleGroupButtonBack.get(1).isClickable());

        int itemNumber = 0;
        do {
            multipleChipGroup.get(++itemNumber).click();
            assertSelected(multipleChipGroup.get(itemNumber));
            multipleChipGroup.get(itemNumber).is().containsText(chipsLabels.get(itemNumber - 1));
        } while (itemNumber < multipleChipGroup.size());
    }

    @Test(dataProvider = "selectSizeShirtBlouseDataProvider", dataProviderClass = ChipGroupsDataProviders.class)
    public void productCardChipGroupTest(List<String> sizes) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                productCardChipGroup.size() != 0);
        for (int i = 1; i <= sizes.size(); i++) {
            productCardChipGroup.get(i).click();
            productCardChipGroup.get(i).is().containsText(sizes.get(i - 1));
        }
        shirtBlouseAddToCartButton.click();

        shirtBlouseText.has().title("Shirt Blouse\n$44.50");
        shirtBlouseText.content().has().text(containsString("Our blouses are available"));
    }


    @Test(dataProvider = "selectTypeToothbrushDataProvider", dataProviderClass = ChipGroupsDataProviders.class)
    public void toothbrushCardChipGroupTest(List<String>  types) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                toothbrushCardChipGroup.size() != 0);
        for (int i = 1; i <= types.size(); i++) {
            toothbrushCardChipGroup.get(i).click();
            toothbrushCardChipGroup.get(i).is().containsText(types.get(i - 1));
        }
        toothbrushAddToCardButton.click();

        toothbrushText.has().title("Toothbrush\n$4.99");
        toothbrushText.content().has().text(containsString("Our company takes pride"));
    }

    @JDIAction("Assert that '{0}' is selected")
    private void assertSelected(ChipGroups chip) {
        chip.has().cssClass("v-chip--active");
    }


    @JDIAction("Verify '{name}' is active")
    public boolean chipIsSelected(ChipGroups chip) {
        return chip.hasClass("v-chip--active");
    }

}
