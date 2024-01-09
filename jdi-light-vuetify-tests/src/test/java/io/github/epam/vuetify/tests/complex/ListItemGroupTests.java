package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroup;
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

public class ListItemGroupTests extends TestsInit {
    @BeforeClass
    public void setup() {
        listItemGroupsPage.open();
        waitCondition(() -> listItemGroupsPage.isOpened());
        listItemGroupsPage.checkOpened();

    }

    @Test(description = "Test checks if list item is active or not")
    public void activeClassListItemGroupTest() {
        ListItem item = activeClassListItemGroup.items().get(1);
        item.click();
        item.is().active();
        item.click();
        item.is().notActive();
    }

    @Test(description = "Test checks if list item has border or not")
    public void borderListItemGroupTest() {
        ListItem item = activeClassListItemGroup.items().get(2);
        item.click();
        item.has().border();
        item.click();
        item.has().noBorder();
    }

    @Test(description = "Test checks list items texts")
    public void textListItemGroupTest() {
        List<String> expectedTitles = Arrays.asList("Wifi", "Bluetooth", "Data Usage");
        for (int element = 1; element <= expectedTitles.size(); element++) {
            activeClassListItemGroup.get(element).is().containsText(expectedTitles.get(element - 1));
        }
    }

    @Test(description = "Test checks if list item group is flat or not")
    public void flatListItemGroupTest() {
        flatListItemGroup.show();
        flatListItemGroup.is().flat();
        selectionControlsListItemGroup.show();
        selectionControlsListItemGroup.is().notFlat();
    }

    @Test(description = "Test checks that list item group has icon")
    public void iconListItemGroup() {
        flatListItemGroup.show();
        flatListItemGroup.items().stream().forEach(e -> e.has().icon());
    }

    @Test(description = "Test checks list item group's theme : Theme (dark/light)")
    public void themeListItemGroup() {
        activeClassListItemGroup.show();
        activeClassListItemGroup.has().theme("theme--dark");
        withSubgroupListItemGroup.show();
        withSubgroupListItemGroup.has().theme("theme--light");
    }

    @Test(description = "Test checks if list item group has subgroups : Sub-group (y/n)")
    public void subgroupListItemGroup() {
        withSubgroupListItemGroup.get(1).show();
        int numberOfSubgroups = (int) withSubgroupListItemGroup.stream().filter(ListItemGroup::isSubgroup).count();
        jdiAssert(numberOfSubgroups, Matchers.greaterThan(0), "Element has no subgroups");
        withSubgroupListItemGroup.get(1).is().notSubGroup();
        withSubgroupListItemGroup.get(4).is().subGroup();
        selectionControlsListItemGroup.get(1).show();
        numberOfSubgroups = (int) selectionControlsListItemGroup.stream().filter(ListItemGroup::isSubgroup).count();
        jdiAssert(numberOfSubgroups, Matchers.equalTo(0), "Element has subgroups");
    }

    @Test(description = "Test checks if list item group is no-action or not : No-action (y/n)")
    public void noActionListItemGroup() {
        withSubgroupListItemGroup.get(1).show();
        int numberOfNoActionItems = (int) withSubgroupListItemGroup.stream().filter(ListItemGroup::isNoAction).count();
        jdiAssert(numberOfNoActionItems, Matchers.greaterThan(0), "Element has no no-action items");
        withSubgroupListItemGroup.get(1).is().notNoAction();
        withSubgroupListItemGroup.get(4).is().noAction();
        selectionControlsListItemGroup.get(1).show();
        numberOfNoActionItems = (int) selectionControlsListItemGroup.stream().filter(ListItemGroup::isNoAction).count();
        jdiAssert(numberOfNoActionItems, Matchers.equalTo(0), "Element has no-action items");
    }
}
