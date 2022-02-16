package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        listsPage.open();
        waitCondition(() -> listsPage.isOpened());
        listsPage.checkOpened();
    }

    @Test
    public static void denseListTest() {
        String[] expectedTitles = new String[] {"Real-Time", "Audience", "Conversions"};

        denseList.show();

        for (int listItemIndex = 1; listItemIndex <= 3; listItemIndex++) {
            denseList.select(listItemIndex);
            denseList.is().active(listItemIndex);
            denseList.has().icon(listItemIndex);
            denseList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }
    }

    @Test
    public static void disabledListTest() {
        disabledList.show();

        disabledList.is().notClickable(1);
        disabledList.is().notActive(1);

        disabledList.is().notClickable(2);
        disabledList.is().active(2);

        disabledList.is().notClickable(3);
        disabledList.is().notActive(3);
    }

    @Test
    public static void flatListTest() {
        flatList.show();

        for (int listItemIndex = 1; listItemIndex <= 3; listItemIndex++) {
            flatList.select(listItemIndex);
            flatList.is().active(listItemIndex);
            flatList.has().icon(listItemIndex);
        }
    }

    @Test
    public static void navListTest() {
        navList.show();

        navList.is().active(1);
        navList.has().icon(1);
        navList.has().title(1, "My Files");

        navList.select(2);
        navList.is().active(2);
        navList.has().icon(2);
        navList.has().title(2, "Shared with me");

        navList.select(5);
        navList.is().active(5);
        navList.has().icon(5);
        navList.has().title(5, "Offline");

        navList.select(5);
        navList.is().notActive(5);
    }

    @Test
    public static void roundedListTest() {
        roundedList.show();

        for (int listItemIndex = 1; listItemIndex <= 3; listItemIndex++) {
            roundedList.select(listItemIndex);
            roundedList.is().active(listItemIndex);
        }

        roundedList.select(3);
        roundedList.is().notActive(3);
    }

    @Test
    public static void shapedListTest() {
        shapedList.show();

        for (int listItemIndex = 1; listItemIndex <= 3; listItemIndex++) {
            shapedList.select(listItemIndex);
            shapedList.is().active(listItemIndex);
        }

        shapedList.select(3);
        shapedList.is().notActive(3);
    }

    @Test
    public static void subGroupListTest() {
        subGroupList.show();

        subGroupList.subList(1).get(1).is().displayed();
        subGroupList.subList(1).get(2).is().displayed();

        subGroupList.is().sublistHidden(2);

        subGroupList.expand(2);

        subGroupList.is().sublistShown(2);

        for (int secondSubListItemIndex = 1; secondSubListItemIndex <= 4; secondSubListItemIndex++) {
            subGroupList.subList(2).get(secondSubListItemIndex).is().displayed();
        }
    }

    @Test
    public static void threeLineListTest() {
        String[] expectedTitles = new String[] {
                "Brunch this weekend?", "Summer BBQ 4", "Oui oui", "Birthday gift", "Recipe to try"
        };

        threeLineList.show();

        for (int listItemIndex = 1; listItemIndex <= 5; listItemIndex++) {
            threeLineList.is().displayed(listItemIndex);
            threeLineList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        String[] expectedTitles = new String[] {
                "Photos", "Recipes", "Work", "Vacation itinerary", "Kitchen remodel"
        };

        twoLinesAndSubheaderList.show();

        twoLinesAndSubheaderListSubheader.get(1).is().displayed().and().text("Folders");
        twoLinesAndSubheaderListSubheader.get(2).is().displayed().and().text("Files");

        for (int listItemIndex = 1; listItemIndex <= 5; listItemIndex++) {
            twoLinesAndSubheaderList.is().displayed(listItemIndex);
            twoLinesAndSubheaderList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }
    }

    @Test
    public static void expansionListsListTest() {
        expansionListsList.show();

        expansionListsList.subList(2).get(1).has().text("Breakfast & brunch");
        expansionListsList.subList(2).get(2).has().text("New American");
        expansionListsList.subList(2).get(3).has().text("Sushi");

        String[] expectedTitles = new String[] {
                "Attractions", "Dining", "Education", "Family", "Health", "Office", "Promotions"
        };

        for (int listItemIndex = 1; listItemIndex <= 7; listItemIndex++) {
            expansionListsList.select(listItemIndex);
            expansionListsList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
            expansionListsList.has().icon(listItemIndex);
        }
    }

    @Test
    public static void actionAndItemGroupsListTest() {
        String[] expectedTitles = new String[] {
                "Content filtering", "Password", "Notifications", "Sound", "Auto-add widgets"
        };

        actionAndItemGroupsList.show();

        for (int listItemIndex = 1; listItemIndex <= 5; listItemIndex++) {
            actionAndItemGroupsList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }

        actionAndItemGroupsListCheckbox.get(1).check();
        actionAndItemGroupsListCheckbox.get(1).is().checked();

        actionAndItemGroupsListCheckbox.get(2).check();
        actionAndItemGroupsListCheckbox.get(2).is().checked();
        actionAndItemGroupsListCheckbox.get(2).uncheck();
        actionAndItemGroupsListCheckbox.get(2).is().unchecked();
    }

    @Test
    public static void actionStackListTest() {
        actionStackList.show();

        actionStackList.select(1);
        actionStackList.is().active(1);
        actionStackList.has().title(1, "Ali Connors");

        actionStackList.is().active(3);
        actionStackList.has().title(3, "Sandra Adams");

        actionStackList.has().title(5, "Britta Holt");

        actionStackList.select(5);
        actionStackList.is().active(5);

        actionStackList.select(5);
        actionStackList.is().notActive(5);
    }

    @Test
    public static void cardListListTest() {
        cardListList.show();

        cardListList.is().displayed(1);
        cardListList.has().title(1, "(650) 555-1234");
        cardListList.has().icon(1);

        cardListList.is().displayed(2);
        cardListList.has().title(2, "(323) 555-6789");

        cardListList.is().displayed(3);
        cardListList.has().title(3, "aliconnors@example.com");
        cardListList.has().icon(3);

        cardListList.is().displayed(4);
        cardListList.has().title(4, "ali_connors@example.com");

        cardListList.is().displayed(5);
        cardListList.has().title(5, "1400 Main Street");
        cardListList.has().icon(5);
    }

    @Test
    public static void simpleAvatarListListTest() {
        String[] expectedTitles = new String[] {
                "Jason Oner", "Travis Howard", "Ali Connors", "Cindy Baker"
        };

        simpleAvatarListList.show();

        for (int listItemIndex = 1; listItemIndex <= 4; listItemIndex++) {
            simpleAvatarListList.is().displayed(listItemIndex);
            simpleAvatarListList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }
    }

    @Test
    public static void singleLineListListTest() {
        String[] expectedTitles = new String[] {
                "Jason Oner", "Mike Carlson", "Cindy Baker", "Ali Connors", "Travis Howard"
        };

        singleLineListList.show();

        for (int listItemIndex = 1; listItemIndex <= 5; listItemIndex++) {
            singleLineListList.is().displayed(listItemIndex);
            singleLineListList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }
    }

    @Test
    public static void subheadingsAndDividersListTest() {
        String[] expectedTitles = new String[] {
                "Profile photo", "Show your status", "Notifications", "Sound", "Video sounds", "Invites"
        };

        subheadingsAndDividersList.show();

        for (int listItemIndex = 1; listItemIndex <= 6; listItemIndex++) {
            subheadingsAndDividersList.is().displayed(listItemIndex);
            subheadingsAndDividersList.has().title(listItemIndex, expectedTitles[listItemIndex - 1]);
        }

        subheadingsAndDividersListCheckbox.get(1).check();
        subheadingsAndDividersListCheckbox.get(1).is().checked();
        subheadingsAndDividersListCheckbox.get(1).uncheck();
        subheadingsAndDividersListCheckbox.get(1).is().unchecked();

        subheadingsAndDividersListCheckbox.get(2).check();
        subheadingsAndDividersListCheckbox.get(2).is().checked();
    }
}
