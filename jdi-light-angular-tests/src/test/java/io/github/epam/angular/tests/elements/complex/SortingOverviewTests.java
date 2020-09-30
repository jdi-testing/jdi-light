package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.AngularPage.sortingOverviewSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static io.github.com.StaticSite.angularPage;

public class SortingOverviewTests extends TestsInit {

    private static final String DESSERT = "Dessert (100g)";
    private static final String CALORIES = "Calories";
    private static final String FAT = "Fat (g)";
    private static final String CARBS = "Carbs (g)";
    private static final String PROTEIN = "Protein (g)";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void tableIsVisible() {
        sortingOverviewSection.sortingOverview.is().tableIsVisible();
    }

    @Test
    public void sortingTableByFirstColumn() {
        sortingOverviewSection.sortingOverview.clickButtonByText(DESSERT);
        sortingOverviewSection.sortingOverview.clickButtonByText(DESSERT);
        sortingOverviewSection.sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableBySecondColumn() {
        sortingOverviewSection.sortingOverview.clickButtonByText(CALORIES);
        sortingOverviewSection.sortingOverview.clickButtonByText(CALORIES);
        sortingOverviewSection.sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableByThirdColumn() {
        sortingOverviewSection.sortingOverview.clickButtonByText(FAT);
        sortingOverviewSection.sortingOverview.clickButtonByText(FAT);
        sortingOverviewSection.sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableByFourthColumn() {
        sortingOverviewSection.sortingOverview.clickButtonByText(CARBS);
        sortingOverviewSection.sortingOverview.clickButtonByText(CARBS);
        sortingOverviewSection.sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableByFifthColumn() {
        sortingOverviewSection.sortingOverview.clickButtonByText(PROTEIN);
        sortingOverviewSection.sortingOverview.clickButtonByText(PROTEIN);
        sortingOverviewSection.sortingOverview.is().arrowButtonClicked();
    }
}
