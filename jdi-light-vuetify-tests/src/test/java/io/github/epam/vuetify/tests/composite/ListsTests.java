package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.listsPage;
import static io.github.com.pages.ListsPage.actionAndItemGroupsGeneralList;
import static io.github.com.pages.ListsPage.actionStackList;
import static io.github.com.pages.ListsPage.darkList;
import static io.github.com.pages.ListsPage.denseList;
import static io.github.com.pages.ListsPage.disabledList;
import static io.github.com.pages.ListsPage.elevatedLists;
import static io.github.com.pages.ListsPage.flatList;
import static io.github.com.pages.ListsPage.navList;
import static io.github.com.pages.ListsPage.roundedList;
import static io.github.com.pages.ListsPage.shapedList;
import static io.github.com.pages.ListsPage.subGroupList;
import static io.github.com.pages.ListsPage.threeLineList;
import static io.github.com.pages.ListsPage.twoLinesAndSubheaderList;

public class ListsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        listsPage.open();
        waitCondition(() -> listsPage.isOpened());
        listsPage.checkOpened();
    }

    @Test(description = "Test checks if list is active or not")
    public static void activeListTest() {
        for (int i = 1; i <= denseList.size(); i++) {
            ListItem itemDenseList = denseList.item(i);
            itemDenseList.show();
            itemDenseList.click();
            itemDenseList.is().active();
            itemDenseList.click();
            itemDenseList.is().notActive();
        }
    }

    @Test(description = "Test checks if list is disabled or not")
    public static void disabledEnabledListTest() {
        disabledList.show();
        disabledList.items().forEach(item -> item.is().notClickable());
        disabledList.is().disabled();
        denseList.show();
        denseList.is().enabled();
    }

    @Test(description = "Test checks if list is clickable or not")
    public static void clickableListTest() {
        denseList.show();
        denseList.item(1).is().clickable();
    }

    @Test(description = "Test shows how to test list with subgroups")
    public static void subGroupListTest() {
        subGroupList.show();
        ListItem adminItem = subGroupList.item("Admin");
        ListItem actionsItem = subGroupList.item("Actions");
        ListItem usersItem = subGroupList.item("Users");

        subGroupList.has().size(6).and().groupSize(3);
        usersItem.is().expanded();
        adminItem.is().displayed().and().expanded();
        actionsItem.is().displayed();
        subGroupList.item("Management").is().displayed();
        subGroupList.item("Settings").is().displayed();
        subGroupList.group("Users").is().expanded().and().active();
        subGroupList.group("Actions").is().collapsed().and().notActive();

        usersItem.click();
        usersItem.is().collapsed();
        adminItem.is().hidden();
        actionsItem.is().hidden();
        subGroupList.has().size(2);
    }

    @Test(description = "Test checks list's texts")
    public static void textListTest() {
        ListItem item = threeLineList.item(1);
        item.show();
        item.title().has().text("Brunch this weekend?");
        item.subtitle().has().text("Ali Connors —I'll be in your neighborhood doing errands this weekend. "
            + "Do you want to hang out?");

        item.has().title("Brunch this weekend?")
                .and().subtitle("Ali Connors —I'll be in your neighborhood doing errands this weekend. "
                        + "Do you want to hang out?");

        twoLinesAndSubheaderList.show();
        twoLinesAndSubheaderList.subheader(1).has().text("Folders");
        twoLinesAndSubheaderList.subheader(2).has().text("Files");
        twoLinesAndSubheaderList.item(1).title().has().text("Photos");
        twoLinesAndSubheaderList.item(1).subtitle().has().text("Jan 9, 2014");
    }

    @Test(description = "Test checks that list is two/three lines")
    public static void twoThreeLinesListTest() {
        threeLineList.show();
        threeLineList.has().cssClass("v-list--three-line");
        twoLinesAndSubheaderList.show();
        twoLinesAndSubheaderList.has().cssClass("v-list--two-line");
    }

    @Test(description = "Test checks that list has dividers")
    public static void hasDividerLinesListTest() {
        threeLineList.show();
        threeLineList.divider(1).is().horizontal();
        threeLineList.has().dividersSize(4);
    }

    @Test(description = "Test shows haw to test lists with checkboxes")
    public static void checkboxListTest() {
        ListItem item = actionAndItemGroupsGeneralList.item(1);
        VueCheckbox itemCheckbox = item.checkbox();
        item.show();
        item.is().clickable().and().notActive();
        itemCheckbox.is().displayed().and().enabled().and().unchecked();
        itemCheckbox.check();
        itemCheckbox.is().checked();
        item.is().active();
        item.click();
        item.is().notActive();
        itemCheckbox.is().unchecked();
    }

    @Test(description = "Test checks list's icon types")
    public static void iconsListTest() {
        ListItem item = actionStackList.item(1);
        item.show();
        item.actionText().has().text("15 min");
        item.is().clickable();
        item.click();
        item.is().active();
        item.icon().has().type("mdi-star");
        item.click();
        item.is().notActive();
        item.icon().has().type("mdi-star-outline");
    }

    @Test(description = "Test checks list's theme")
    public void themeListsTest() {
        darkList.show();
        darkList.has().darkTheme();
        elevatedLists.get(1).show();
        elevatedLists.get(1).has().lightTheme();
    }

    @Test(description = "Test checks if list is elevated or not")
    public void elevationListsTest() {
        elevatedLists.get(2).show();
        elevatedLists.get(2).is().elevated().and().elevation(8);
        navList.is().notElevated();
    }

    @Test(description = "Test checks if list is dense or not")
    public void denseListsTest() {
        denseList.show();
        denseList.is().dense();
        disabledList.show();
        disabledList.is().notDense();
    }

    @Test(description = "Test checks if list is flat or not")
    public void flatListsTest() {
        flatList.show();
        flatList.is().flat();
        darkList.show();
        darkList.is().notFlat();
    }

    @Test(description = "Test checks if list is rounded or not")
    public void roundedListsTest() {
        roundedList.show();
        roundedList.is().rounded();
        shapedList.show();
        shapedList.is().notRounded();
    }

    @Test(description = "Test checks if list is shaped or not")
    public void shapedListsTest() {
        shapedList.show();
        shapedList.is().shaped();
        roundedList.show();
        roundedList.is().notShaped();
    }
}
