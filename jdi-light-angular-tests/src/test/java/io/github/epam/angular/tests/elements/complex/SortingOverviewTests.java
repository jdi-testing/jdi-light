package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.AngularPage.sortingOverviewSection;
import static io.github.com.pages.sections.SortingOverviewSection.sortingOverview;
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
        sortingOverview.is().tableIsVisible();
    }

    @Test
    public void sortingTableByFirstColumn() {
        sortingOverview.clickButtonByText(DESSERT);
        sortingOverview.clickButtonByText(DESSERT);
        sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableBySecondColumn() {
        sortingOverview.clickButtonByText(CALORIES);
        sortingOverview.clickButtonByText(CALORIES);
        sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableByThirdColumn() {
        sortingOverview.clickButtonByText(FAT);
        sortingOverview.clickButtonByText(FAT);
        sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableByFourthColumn() {
        sortingOverview.clickButtonByText(CARBS);
        sortingOverview.clickButtonByText(CARBS);
        sortingOverview.is().arrowButtonClicked();
    }

    @Test
    public void sortingTableByFifthColumn() {
        sortingOverview.clickButtonByText(PROTEIN);
        sortingOverview.clickButtonByText(PROTEIN);
        sortingOverview.is().arrowButtonClicked();
    }
}
