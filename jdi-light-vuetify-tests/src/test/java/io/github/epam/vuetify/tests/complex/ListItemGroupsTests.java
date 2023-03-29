package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.ListItemGroups;
import io.github.com.dataproviders.ListItemGroupDataProvider;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.listItemGroupsPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.pages.ListItemGroupsPage.activeClassListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.flatListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.mandatoryListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.multipleListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.selectionControlsListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.withSubgroupListItemGroup;

public class ListItemGroupsTests extends TestsInit {
    @BeforeClass
    public static void setup() {
        listItemGroupsPage.open();
        waitCondition(() -> listItemGroupsPage.isOpened());
        listItemGroupsPage.checkOpened();

    }

    @Test(description = "Test checks if list item is active or not")
    public void activeClassListItemGroupTest() {
        for (int element = 1; element <= activeClassListItemGroup.size(); element++) {
            activeClassListItemGroup.get(element).click();
            activeClassListItemGroup.get(element).is().active();
            activeClassListItemGroup.get(element).click();
            activeClassListItemGroup.get(element).is().notActive();
        }
    }

    @Test(description = "Test checks if list item has border or not")
    public void borderListItemGroupTest() {
        for (int element = 1; element <= activeClassListItemGroup.size(); element++) {
            activeClassListItemGroup.get(element).click();
            activeClassListItemGroup.get(element).has().border();
            activeClassListItemGroup.get(element).click();
            activeClassListItemGroup.get(element).has().noBorder();
        }
    }

    @Test(description = "Test checks list items texts")
    public void textListItemGroupTest() {
        List<String> expectedTitles = Arrays.asList("Wifi", "Bluetooth", "Data Usage");
        for (int element = 1; element <= expectedTitles.size(); element++) {
            activeClassListItemGroup.get(element).is().containsText(expectedTitles.get(element - 1));
        }
    }

    @Test(description = "Test checks that list item group is mandatory : Mandatory (y/n)", dataProvider = "listItemGroupsDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
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

    @Test(description = "Test checks that list item group is multiple : Multiple (y/n)", dataProvider = "listItemGroupsDataProvider", dataProviderClass = ListItemGroupDataProvider.class)
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

    @Test(description = "Test checks if list item group is flat or not")
    public void flatListItemGroupTest() {
        flatListItemGroup.get(1).show();
        flatListItemGroup.get(1).is().flat();
        selectionControlsListItemGroup.get(1).show();
        selectionControlsListItemGroup.get(1).is().notFlat();
    }

    @Test(description = "Test checks that list item group has icon")
    public void iconListItemGroup() {
        flatListItemGroup.get(1).show();
        flatListItemGroup.forEach(e -> e.has().icon());
    }

    @Test(description = "Test checks list item group's color : Color")
    public void colorListItemGroup() {
        withSubgroupListItemGroup.get(1).show();
        withSubgroupListItemGroup.get(1).has().color(BLACK_TRANSPARENT_087.value());
        withSubgroupListItemGroup.get(1).has().backgroundColor(TRANSPARENT.value());
    }

    @Test(description = "Test checks list item group's theme : Theme (dark/light)")
    public void themeListItemGroup() {
        activeClassListItemGroup.get(1).show();
        activeClassListItemGroup.get(1).has().darkTheme();
        withSubgroupListItemGroup.get(1).show();
        withSubgroupListItemGroup.get(1).has().lightTheme();
    }

    @Test(description = "Test checks if list item group has subgroups : Sub-group (y/n)")
    public void subgroupListItemGroup() {
        withSubgroupListItemGroup.get(1).show();
        int numberOfSubgroups = (int) withSubgroupListItemGroup.stream().filter(ListItemGroups::isSubgroup).count();
        jdiAssert(numberOfSubgroups, Matchers.greaterThan(0), "Element has no subgroups");
        withSubgroupListItemGroup.get(1).is().notSubGroup();
        withSubgroupListItemGroup.get(4).is().subGroup();
        selectionControlsListItemGroup.get(1).show();
        numberOfSubgroups = (int) selectionControlsListItemGroup.stream().filter(ListItemGroups::isSubgroup).count();
        jdiAssert(numberOfSubgroups, Matchers.equalTo(0), "Element has subgroups");
    }

    @Test(description = "Test checks if list item group is no-action or not : No-action (y/n)")
    public void noActionListItemGroup() {
        withSubgroupListItemGroup.get(1).show();
        int numberOfNoActionItems = (int) withSubgroupListItemGroup.stream().filter(ListItemGroups::isNoAction).count();
        jdiAssert(numberOfNoActionItems, Matchers.greaterThan(0), "Element has no no-action items");
        withSubgroupListItemGroup.get(1).is().notNoAction();
        withSubgroupListItemGroup.get(4).is().noAction();
        selectionControlsListItemGroup.get(1).show();
        numberOfNoActionItems = (int) selectionControlsListItemGroup.stream().filter(ListItemGroups::isNoAction).count();
        jdiAssert(numberOfNoActionItems, Matchers.equalTo(0), "Element has no-action items");
    }
}
