package io.github.epam.angular.tests.unit;

import io.github.com.pages.sections.SortingOverviewSection;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SortingOverviewUnitTests extends TestsInit {

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
    public void verifyTableIsVisible() {
        Assert.assertTrue(SortingOverviewSection.sortingOverview.getTableHeaders().isDisplayed());
    }

    @Test(enabled = false)
    public void verifyHeaderButtonDessertIsClicked() {
        SortingOverviewSection.sortingOverview.clickButtonByText(DESSERT);
        SortingOverviewSection.sortingOverview.clickButtonByText(DESSERT);
        Assert.assertTrue(SortingOverviewSection.sortingOverview.headerButtonIsClicked());
    }

    @Test(enabled = false)
    public void verifyHeaderButtonCaloriesIsClicked() {
        SortingOverviewSection.sortingOverview.clickButtonByText(CALORIES);
        SortingOverviewSection.sortingOverview.clickButtonByText(CALORIES);
        Assert.assertTrue(SortingOverviewSection.sortingOverview.headerButtonIsClicked());
    }

    @Test(enabled = false)
    public void verifyHeaderButtonFatIsClicked() {
        SortingOverviewSection.sortingOverview.clickButtonByText(FAT);
        SortingOverviewSection.sortingOverview.clickButtonByText(FAT);
        Assert.assertTrue(SortingOverviewSection.sortingOverview.headerButtonIsClicked());
    }

    @Test(enabled = false)
    public void verifyHeaderButtonCarbsIsClicked() {
        SortingOverviewSection.sortingOverview.clickButtonByText(CARBS);
        SortingOverviewSection.sortingOverview.clickButtonByText(CARBS);
        Assert.assertTrue(SortingOverviewSection.sortingOverview.headerButtonIsClicked());
    }

    @Test(enabled = false)
    public void verifyHeaderButtonProteinIsClicked() {
        SortingOverviewSection.sortingOverview.clickButtonByText(PROTEIN);
        SortingOverviewSection.sortingOverview.clickButtonByText(PROTEIN);
        Assert.assertTrue(SortingOverviewSection.sortingOverview.headerButtonIsClicked());
    }
}

