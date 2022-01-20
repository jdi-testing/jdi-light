package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.listItemGroupsPage;
import static io.github.com.pages.ListItemGroupsPage.activeClassListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.flatListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.mandatoryListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.multipleListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.selectionControlsListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.selectionControlsListItemGroupCheckbox;

import io.github.com.dataproviders.ListItemGroupDataProvider;
import io.github.epam.TestsInit;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListItemGroupsTests extends TestsInit {
    @BeforeClass
    public static void setup() {
        listItemGroupsPage.open();
        waitCondition(() -> listItemGroupsPage.isOpened());
        listItemGroupsPage.checkOpened();

    }

    @Test(dataProvider = "listItemGroupsDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
    public void activeClassListItemGroupTest(List<String> expectedTitles) {
        for (int element = 1; element <= expectedTitles.size(); element++) {
            activeClassListItemGroup.get(element).click();
            activeClassListItemGroup.get(element).is().active();
            activeClassListItemGroup.get(element).has().icon();
            activeClassListItemGroup.get(element).is().containsText(expectedTitles.get(element - 1));
            activeClassListItemGroup.get(element).has().border();
            activeClassListItemGroup.get(element).click();
            activeClassListItemGroup.get(element).is().notActive();
            activeClassListItemGroup.get(element).has().notBorder();
        }
    }

    @Test(dataProvider = "listItemGroupsDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
    public void mandatoryListItemGroupTest(List<String> expectedTitles) {
        for (int element = 1; element <= expectedTitles.size(); element++) {
            mandatoryListItemGroup.get(element).click();
            mandatoryListItemGroup.get(element).is().active();
            mandatoryListItemGroup.get(element).click();
            mandatoryListItemGroup.get(element).is().active();
        }
        for (int element = 1; element <= expectedTitles.size(); element++) {
            mandatoryListItemGroup.get(element).click();
        }
    }

    @Test(dataProvider = "listItemGroupsDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
    public void multipleListItemGroupsTest(List<String> expectedTitles) {
        for (int element = 1; element <= expectedTitles.size(); element++) {
            if (!multipleListItemGroup.get(element).isActive()) {
                multipleListItemGroup.get(element).click();
            }
            multipleListItemGroup.get(element).is().active();
        }
        for (int element = 1; element <= expectedTitles.size(); element++) {
            multipleListItemGroup.get(element).click();
            multipleListItemGroup.get(element).is().notActive();
        }
    }

    @Test(dataProvider = "listItemGroupsDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
    public void flatListItemGroupTest(List<String> expectedTitles) {
        for (int element = 1; element <= expectedTitles.size(); element++) {
            flatListItemGroup.get(element).click();
            flatListItemGroup.get(element).is().active();
            flatListItemGroup.get(element).has().icon();
            flatListItemGroup.get(element).click();
            flatListItemGroup.get(element).is().notActive();
        }
    }

    @Test(dataProvider = "selectionControlsListDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
    public void selectionControlsListItemGroupTest(List<String> titlesInCheckboxes) {
        for (int element = 1; element <= titlesInCheckboxes.size(); element++) {
            selectionControlsListItemGroup.get(element).is().containsText(titlesInCheckboxes.get(element - 1));
            selectionControlsListItemGroupCheckbox.get(element).check();
            selectionControlsListItemGroupCheckbox.get(element).is().checked();
            selectionControlsListItemGroupCheckbox.get(element).uncheck();
            selectionControlsListItemGroupCheckbox.get(element).is().unchecked();
        }
        for (int element = 1; element <= titlesInCheckboxes.size(); element++) {
            selectionControlsListItemGroupCheckbox.get(element).check();
            selectionControlsListItemGroupCheckbox.get(element).is().checked();
        }
    }
}
