package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.ListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.listItemGroupsPage;
import static io.github.com.pages.ListItemGroupsPage.activeClassListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.flatListItemGroup;

public class ListItemGroupTests extends TestsInit {
    @BeforeClass
    public void setup() {
        listItemGroupsPage.open();
        waitCondition(() -> listItemGroupsPage.isOpened());
        listItemGroupsPage.checkOpened();

    }

    @Test(description = "Test checks if list item is active or not")
    public void activeClassListItemGroupTest() {
        ListItem item = activeClassListItemGroup.items().get(0);
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
        for (int i = 0; i < expectedTitles.size(); i++) {
            activeClassListItemGroup.items().get(i).is().text(expectedTitles.get(i));
        }
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
        flatListItemGroup.show();
        flatListItemGroup.has().theme("theme--light");
    }
}
