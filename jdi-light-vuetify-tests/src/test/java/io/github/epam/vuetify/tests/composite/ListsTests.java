package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.vuetify.elements.common.Checkbox;
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

        verifyDenseListElement(1, "Real-Time");
        verifyDenseListElement(2, "Audience");
        verifyDenseListElement(3, "Conversions");
    }

    private static void verifyDenseListElement(int itemIndex, String expectedTitle) {
        denseList.item(itemIndex).click();
        denseList.item(itemIndex).is().active();
        denseList.item(itemIndex).is().clickable();
        denseList.item(itemIndex).icon().is().displayed();
        denseList.item(itemIndex).title().is().text(expectedTitle);
    }

    @Test
    public static void disabledListTest() {
        disabledList.show();

        disabledList.item(1).is().notClickable();
        disabledList.item(2).is().notClickable();
        disabledList.item(3).is().notClickable();
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

        verifyThreeLineListElement(1, "Brunch this weekend?", "Ali Connors");
        verifyThreeLineListElement(2, "Summer BBQ 4", "to Alex, Scott, Jennifer");
        verifyThreeLineListElement(3, "Oui oui", "Sandra Adams");
    }

    private static void verifyThreeLineListElement(int itemIndex, String expectedTitle,
            String expectedSubTitlePart) {
        threeLineList.item(itemIndex).has().title(expectedTitle);
        threeLineList.item(itemIndex).is().containsSubTitle(expectedSubTitlePart);
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        twoLinesAndSubheaderList.show();

        twoLinesAndSubheaderList.subheader(1).has().text("Folders");
        twoLinesAndSubheaderList.subheader(2).has().text("Files");
    }

    @Test
    public static void actionAndItemGroupsListTest() {
        waitCondition(() -> actionAndItemGroupsGeneralList.isExist());
        actionAndItemGroupsGeneralList.show();

        verifyActionAndItemGroupsListElement(1);
        verifyActionAndItemGroupsListElement(2);
        verifyActionAndItemGroupsListElement(3);
    }

    private static void verifyActionAndItemGroupsListElement(int itemIndex) {
        Checkbox itemCheckbox = actionAndItemGroupsGeneralList.item(itemIndex).checkbox();

        itemCheckbox.is().displayed().and().enabled().and().unchecked();

        itemCheckbox.check();
        itemCheckbox.is().checked();
    }
}
