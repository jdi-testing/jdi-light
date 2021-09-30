package io.github.epam.vuetify.tests.common;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.listsPage;
import static io.github.com.pages.ListsPage.actionAndItemGroupsList;
import static io.github.com.pages.ListsPage.actionAndItemGroupsListCheckbox;
import static io.github.com.pages.ListsPage.actionStackList;
import static io.github.com.pages.ListsPage.cardListList;
import static io.github.com.pages.ListsPage.denseList;
import static io.github.com.pages.ListsPage.disabledList;
import static io.github.com.pages.ListsPage.expansionListsList;
import static io.github.com.pages.ListsPage.flatList;
import static io.github.com.pages.ListsPage.navList;
import static io.github.com.pages.ListsPage.roundedList;
import static io.github.com.pages.ListsPage.shapedList;
import static io.github.com.pages.ListsPage.simpleAvatarListList;
import static io.github.com.pages.ListsPage.singleLineListList;
import static io.github.com.pages.ListsPage.subGroupList;
import static io.github.com.pages.ListsPage.subheadingsAndDividersList;
import static io.github.com.pages.ListsPage.subheadingsAndDividersListCheckbox;
import static io.github.com.pages.ListsPage.threeLineList;
import static io.github.com.pages.ListsPage.twoLinesAndSubheaderList;
import static io.github.com.pages.ListsPage.twoLinesAndSubheaderListSubheader;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ListsTests extends TestsInit {

    @BeforeSuite
    public static void setup() {
        listsPage.open();
    }

    @Test
    public static void denseListTest() {
        denseList.select(1);
        jdiAssert(denseList.isActive(1), Matchers.is(true));
        jdiAssert(denseList.hasIcon(1), Matchers.is(true));
        jdiAssert(denseList.hasTitle(1, "Real-Time"), Matchers.is(true));

        denseList.select(2);
        jdiAssert(denseList.isActive(2), Matchers.is(true));
        jdiAssert(denseList.hasIcon(2), Matchers.is(true));
        jdiAssert(denseList.hasTitle(2, "Audience"), Matchers.is(true));

        denseList.select(3);
        jdiAssert(denseList.isActive(3), Matchers.is(true));
        jdiAssert(denseList.hasIcon(3), Matchers.is(true));
        jdiAssert(denseList.hasTitle(3, "Conversions"), Matchers.is(true));
    }

    @Test
    public static void disabledListTest() {
        jdiAssert(disabledList.get(1).isClickable(), Matchers.is(false));
        jdiAssert(disabledList.get(2).isClickable(), Matchers.is(false));
        jdiAssert(disabledList.get(3).isClickable(), Matchers.is(false));
        jdiAssert(disabledList.isInactivate(1), Matchers.is(true));
        jdiAssert(disabledList.isInactivate(3), Matchers.is(true));
        jdiAssert(disabledList.isActive(2), Matchers.is(true));
    }

    @Test
    public static void flatListTest() {
        flatList.select(1);
        jdiAssert(flatList.isActive(1), Matchers.is(true));
        jdiAssert(flatList.hasIcon(1), Matchers.is(true));
        flatList.select(2);
        jdiAssert(flatList.isActive(2), Matchers.is(true));
        jdiAssert(flatList.hasIcon(2), Matchers.is(true));
        flatList.select(3);
        jdiAssert(flatList.isActive(3), Matchers.is(true));
        jdiAssert(flatList.hasIcon(3), Matchers.is(true));
    }

    @Test
    public static void navListTest() {
        jdiAssert(navList.isActive(1), Matchers.is(true));
        jdiAssert(navList.hasIcon(1), Matchers.is(true));
        jdiAssert(navList.hasTitle(1, "My Files"), Matchers.is(true));

        navList.select(2);
        jdiAssert(navList.isActive(2), Matchers.is(true));
        jdiAssert(navList.hasIcon(2), Matchers.is(true));
        jdiAssert(navList.hasTitle(2, "Shared with me"), Matchers.is(true));

        navList.select(5);
        jdiAssert(navList.isActive(5), Matchers.is(true));
        jdiAssert(navList.hasIcon(5), Matchers.is(true));
        jdiAssert(navList.hasTitle(5, "Offline"), Matchers.is(true));

        navList.select(5);
        jdiAssert(navList.isInactivate(5), Matchers.is(true));
    }

    @Test
    public static void roundedListTest() {
        roundedList.select(1);
        jdiAssert(roundedList.isActive(1), Matchers.is(true));
        roundedList.select(2);
        jdiAssert(roundedList.isActive(2), Matchers.is(true));
        roundedList.select(3);
        jdiAssert(roundedList.isActive(3), Matchers.is(true));
        roundedList.select(3);
        jdiAssert(roundedList.isInactivate(3), Matchers.is(true));
    }

    @Test
    public static void shapedListTest() {
        shapedList.select(1);
        jdiAssert(shapedList.isActive(1), Matchers.is(true));
        shapedList.select(2);
        jdiAssert(shapedList.isActive(2), Matchers.is(true));
        shapedList.select(3);
        jdiAssert(shapedList.isActive(3), Matchers.is(true));
        shapedList.select(3);
        jdiAssert(shapedList.isInactivate(3), Matchers.is(true));
    }

    @Test
    public static void subGroupListTest() {
        subGroupList.getSubList(1).select(1);
        subGroupList.getSubList(1).select(2);
        subGroupList.getSubList(2).select(1);
        subGroupList.getSubList(2).select(2);
        subGroupList.getSubList(2).select(3);
        subGroupList.getSubList(2).select(4);
    }

    @Test
    public static void threeLineListTest() {
        jdiAssert(threeLineList.get(1).isDisplayed(), Matchers.is(true));
        jdiAssert(threeLineList.hasTitle(1, "Brunch this weekend?"), Matchers.is(true));
        jdiAssert(threeLineList.get(2).isDisplayed(), Matchers.is(true));
        jdiAssert(threeLineList.hasTitle(2, "Summer BBQ 4"), Matchers.is(true));
        jdiAssert(threeLineList.get(3).isDisplayed(), Matchers.is(true));
        jdiAssert(threeLineList.hasTitle(3, "Oui oui"), Matchers.is(true));
        jdiAssert(threeLineList.get(4).isDisplayed(), Matchers.is(true));
        jdiAssert(threeLineList.hasTitle(4, "Birthday gift"), Matchers.is(true));
        jdiAssert(threeLineList.get(5).isDisplayed(), Matchers.is(true));
        jdiAssert(threeLineList.hasTitle(5, "Recipe to try"), Matchers.is(true));
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        twoLinesAndSubheaderListSubheader.get(1).is().displayed().and().text("Folders");
        jdiAssert(twoLinesAndSubheaderList.get(1).isDisplayed(), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.hasTitle(1, "Photos"), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.get(2).isDisplayed(), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.hasTitle(2, "Recipes"), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.get(3).isDisplayed(), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.hasTitle(3, "Work"), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.get(4).isDisplayed(), Matchers.is(true));

        twoLinesAndSubheaderListSubheader.get(2).is().displayed().and().text("Files");
        jdiAssert(twoLinesAndSubheaderList.hasTitle(4, "Vacation itinerary"), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.get(5).isDisplayed(), Matchers.is(true));
        jdiAssert(twoLinesAndSubheaderList.hasTitle(5, "Kitchen remodel"), Matchers.is(true));
    }

    @Test
    public static void expansionListsListTest() {
        jdiAssert(expansionListsList.getSubList(2).get(1).getText().equals("Breakfast & brunch"), Matchers.is(true));
        jdiAssert(expansionListsList.getSubList(2).get(2).getText().equals("New American"), Matchers.is(true));
        jdiAssert(expansionListsList.getSubList(2).get(3).getText().equals("Sushi"), Matchers.is(true));

        expansionListsList.select(1);
        jdiAssert(expansionListsList.hasTitle(1, "Attractions"), Matchers.is(true));
        jdiAssert(expansionListsList.hasIcon(1), Matchers.is(true));

        expansionListsList.select(3);
        jdiAssert(expansionListsList.hasTitle(3, "Education"), Matchers.is(true));
        jdiAssert(expansionListsList.hasIcon(3), Matchers.is(true));

        expansionListsList.select(4);
        jdiAssert(expansionListsList.hasTitle(4, "Family"), Matchers.is(true));
        jdiAssert(expansionListsList.hasIcon(4), Matchers.is(true));

        expansionListsList.select(5);
        jdiAssert(expansionListsList.hasTitle(5, "Health"), Matchers.is(true));
        jdiAssert(expansionListsList.hasIcon(5), Matchers.is(true));

        expansionListsList.select(6);
        jdiAssert(expansionListsList.hasTitle(6, "Office"), Matchers.is(true));
        jdiAssert(expansionListsList.hasIcon(6), Matchers.is(true));

        expansionListsList.select(7);
        jdiAssert(expansionListsList.hasTitle(7, "Promotions"), Matchers.is(true));
        jdiAssert(expansionListsList.hasIcon(7), Matchers.is(true));
    }

    @Test
    public static void actionAndItemGroupsListTest() {
        jdiAssert(actionAndItemGroupsList.hasTitle(1, "Content filtering"), Matchers.is(true));
        jdiAssert(actionAndItemGroupsList.hasTitle(2, "Password"), Matchers.is(true));

        jdiAssert(actionAndItemGroupsList.hasTitle(3, "Notifications"), Matchers.is(true));
        actionAndItemGroupsListCheckbox.get(1).check();
        actionAndItemGroupsListCheckbox.get(1).is().checked();

        jdiAssert(actionAndItemGroupsList.hasTitle(4, "Sound"), Matchers.is(true));
        actionAndItemGroupsListCheckbox.get(2).check();
        actionAndItemGroupsListCheckbox.get(2).is().checked();
        actionAndItemGroupsListCheckbox.get(2).uncheck();
        actionAndItemGroupsListCheckbox.get(2).is().unchecked();

        jdiAssert(actionAndItemGroupsList.hasTitle(5, "Auto-add widgets"), Matchers.is(true));
    }

    @Test
    public static void actionStackListTest() {
        actionStackList.select(1);
        jdiAssert(actionStackList.isActive(1), Matchers.is(true));
        jdiAssert(actionStackList.hasTitle(1, "Ali Connors"), Matchers.is(true));

        jdiAssert(actionStackList.isActive(3), Matchers.is(true));
        jdiAssert(actionStackList.hasTitle(3, "Sandra Adams"), Matchers.is(true));

        actionStackList.select(5);
        jdiAssert(actionStackList.isActive(5), Matchers.is(true));
        jdiAssert(actionStackList.hasTitle(5, "Britta Holt"), Matchers.is(true));
        actionStackList.select(5);
        jdiAssert(actionStackList.isInactivate(5), Matchers.is(true));
    }

    @Test
    public static void cardListListTest() {
        jdiAssert(cardListList.get(1).isDisplayed(), Matchers.is(true));
        jdiAssert(cardListList.hasTitle(1, "(650) 555-1234"), Matchers.is(true));
        jdiAssert(cardListList.hasIcon(1), Matchers.is(true));

        jdiAssert(cardListList.get(2).isDisplayed(), Matchers.is(true));
        jdiAssert(cardListList.hasTitle(2, "(323) 555-6789"), Matchers.is(true));

        jdiAssert(cardListList.get(3).isDisplayed(), Matchers.is(true));
        jdiAssert(cardListList.hasTitle(3, "aliconnors@example.com"), Matchers.is(true));
        jdiAssert(cardListList.hasIcon(3), Matchers.is(true));

        jdiAssert(cardListList.get(4).isDisplayed(), Matchers.is(true));
        jdiAssert(cardListList.hasTitle(4, "ali_connors@example.com"), Matchers.is(true));

        jdiAssert(cardListList.get(5).isDisplayed(), Matchers.is(true));
        jdiAssert(cardListList.hasTitle(5, "1400 Main Street"), Matchers.is(true));
        jdiAssert(cardListList.hasIcon(5), Matchers.is(true));
    }

    @Test
    public static void simpleAvatarListListTest() {
        jdiAssert(simpleAvatarListList.get(1).isDisplayed(), Matchers.is(true));
        jdiAssert(simpleAvatarListList.hasTitle(1, "Jason Oner"), Matchers.is(true));
        jdiAssert(simpleAvatarListList.get(2).isDisplayed(), Matchers.is(true));
        jdiAssert(simpleAvatarListList.hasTitle(2, "Travis Howard"), Matchers.is(true));
        jdiAssert(simpleAvatarListList.get(3).isDisplayed(), Matchers.is(true));
        jdiAssert(simpleAvatarListList.hasTitle(3, "Ali Connors"), Matchers.is(true));
        jdiAssert(simpleAvatarListList.get(4).isDisplayed(), Matchers.is(true));
        jdiAssert(simpleAvatarListList.hasTitle(4, "Cindy Baker"), Matchers.is(true));
    }

    @Test
    public static void singleLineListListTest() {
        jdiAssert(singleLineListList.get(1).isDisplayed(), Matchers.is(true));
        jdiAssert(singleLineListList.hasTitle(1, "Jason Oner"), Matchers.is(true));

        jdiAssert(singleLineListList.get(2).isDisplayed(), Matchers.is(true));
        jdiAssert(singleLineListList.hasTitle(2, "Mike Carlson"), Matchers.is(true));

        jdiAssert(singleLineListList.get(3).isDisplayed(), Matchers.is(true));
        jdiAssert(singleLineListList.hasTitle(3, "Cindy Baker"), Matchers.is(true));

        jdiAssert(singleLineListList.get(4).isDisplayed(), Matchers.is(true));
        jdiAssert(singleLineListList.hasTitle(4, "Ali Connors"), Matchers.is(true));

        jdiAssert(singleLineListList.get(5).isDisplayed(), Matchers.is(true));
        jdiAssert(singleLineListList.hasTitle(5, "Travis Howard"), Matchers.is(true));
    }

    @Test
    public static void subheadingsAndDividersListTest() {
        jdiAssert(subheadingsAndDividersList.get(1).isDisplayed(), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.hasTitle(1, "Profile photo"), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.get(2).isDisplayed(), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.hasTitle(2, "Show your status"), Matchers.is(true));

        jdiAssert(subheadingsAndDividersList.get(3).isDisplayed(), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.hasTitle(3, "Notifications"), Matchers.is(true));
        subheadingsAndDividersListCheckbox.get(1).check();
        subheadingsAndDividersListCheckbox.get(1).is().checked();
        subheadingsAndDividersListCheckbox.get(1).uncheck();
        subheadingsAndDividersListCheckbox.get(1).is().unchecked();

        jdiAssert(subheadingsAndDividersList.get(4).isDisplayed(), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.hasTitle(4, "Sound"), Matchers.is(true));
        subheadingsAndDividersListCheckbox.get(2).check();
        subheadingsAndDividersListCheckbox.get(2).is().checked();

        jdiAssert(subheadingsAndDividersList.get(5).isDisplayed(), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.hasTitle(5, "Video sounds"), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.get(6).isDisplayed(), Matchers.is(true));
        jdiAssert(subheadingsAndDividersList.hasTitle(6, "Invites"), Matchers.is(true));
    }
}
