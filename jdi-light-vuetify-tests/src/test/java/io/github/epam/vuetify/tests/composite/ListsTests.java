package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.listsPage;
import static io.github.com.pages.ListsPage.actionAndItemGroupsGeneralList;
import static io.github.com.pages.ListsPage.denseList;
import static io.github.com.pages.ListsPage.disabledList;
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

    @Test
    public static void denseListTest() {
        denseList.show();

        // given the second item is preselected a click should deselect it
        denseList.item(2).is().active();
        denseList.item(2).click();
        denseList.item(2).is().notActive();

        String[] expectedTitles = new String[] {"Real-Time", "Audience", "Conversions"};
        for (int listItemIndex = 1; listItemIndex <= 3; listItemIndex++) {
            denseList.item(listItemIndex).click();
            denseList.item(listItemIndex).is().active();
            denseList.item(listItemIndex).is().clickable();
            denseList.item(listItemIndex).icon().is().displayed();
            denseList.item(listItemIndex).title().is().text(expectedTitles[listItemIndex - 1]);
        }
    }

    @Test
    public static void disabledListTest() {
        disabledList.show();

        disabledList.items().forEach(item -> item.is().notClickable());
    }

    @Test
    public static void subGroupListTest() {
        subGroupList.show();

        subGroupList.is().sublistCollapsed("Actions");
        subGroupList.item("Actions").click();
        subGroupList.is().sublistExpanded("Actions");

        subGroupList.is().sublistExpanded("Users");
        subGroupList.item("Users").click();
        subGroupList.is().sublistCollapsed("Users");
    }

    @Test
    public static void threeLineListTest() {
        threeLineList.show();

        String[] expectedTitles = new String[] {
                "Brunch this weekend?", "Summer BBQ 4", "Oui oui"
        };

        String[] expectedSubTitleParts = new String[] {
                "Ali Connors", "to Alex, Scott, Jennifer", "Sandra Adams"
        };

        for (int listItemIndex = 1; listItemIndex <= 3; listItemIndex++) {
            threeLineList.item(listItemIndex).has()
                    .title(expectedTitles[listItemIndex - 1]);

            threeLineList.item(listItemIndex).is()
                    .containsSubTitle(expectedSubTitleParts[listItemIndex - 1]);
        }
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        twoLinesAndSubheaderList.show();

        twoLinesAndSubheaderList.subheader(1).has().text("Folders");
        twoLinesAndSubheaderList.subheader(2).has().text("Files");
    }

    @Test
    public static void actionAndItemGroupsListTest() {
        actionAndItemGroupsGeneralList.show();

        actionAndItemGroupsGeneralList.items().forEach(item -> {
            item.checkbox().is().displayed().and().enabled().and().unchecked();

            item.checkbox().check();
            item.checkbox().is().checked();
        });
    }
}
