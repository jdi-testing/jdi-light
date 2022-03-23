package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ListsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.listsPage;
import static io.github.com.pages.ListsPage.actionAndItemGroupsGeneralList;
import static io.github.com.pages.ListsPage.actionStackList;
import static io.github.com.pages.ListsPage.denseList;
import static io.github.com.pages.ListsPage.disabledList;
import static io.github.com.pages.ListsPage.simpleAvatarListList;
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

    @Test(dataProviderClass = ListsTestsDataProvider.class, dataProvider = "basicFunctionalityTestsData")
    public static void basicFunctionalityTest(int itemIndex, String expectedTitle) {
        ListItem itemDenseList = denseList.item(itemIndex);
        itemDenseList.show();

        itemDenseList.is().clickable();
        itemDenseList.click();
        itemDenseList.is().active();
        itemDenseList.icon().is().displayed();
        itemDenseList.title().is().text(expectedTitle);
        itemDenseList.click();
        itemDenseList.is().notActive();
    }

    @Test
    public static void disabledListTest() {
        disabledList.show();
        disabledList.items().forEach(item -> item.is().notClickable());
    }

    @Test
    public static void subGroupListTest() {
        subGroupList.show();

        subGroupList.is().sublistExpanded("Admin");
        subGroupList.item("Management").is().displayed();
        subGroupList.item("Settings").is().displayed();
        subGroupList.item("Admin").click();
        subGroupList.is().sublistCollapsed("Admin");

        subGroupList.is().sublistExpanded("Users");
        subGroupList.item("Users").click();
        subGroupList.is().sublistCollapsed("Users");
    }

    @Test
    public static void threeLineListTest() {
        ListItem item = threeLineList.item(1);
        item.show();

        item.title().has().text("Brunch this weekend?");
        item.subtitle().has().text("Ali Connors —I'll be in your neighborhood doing errands this weekend. " +
            "Do you want to hang out?");
        threeLineList.divider(1).is().horizontal();
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        twoLinesAndSubheaderList.show();

        twoLinesAndSubheaderList.subheader(1).has().text("Folders");
        twoLinesAndSubheaderList.subheader(2).has().text("Files");
        twoLinesAndSubheaderList.item(1).title().has().text("Photos");
        twoLinesAndSubheaderList.item(1).subtitle().has().text("Jan 9, 2014");
    }

    @Test
    public static void actionAndItemGroupsListTest() {
        Checkbox itemCheckbox = actionAndItemGroupsGeneralList.item(1).checkbox();
        itemCheckbox.show();

        itemCheckbox.is().displayed().and().enabled().and().unchecked();
        itemCheckbox.check();
        itemCheckbox.is().checked();
    }

    @Test
    public static void actionStackListTest() {
        ListItem itemAction = actionStackList.item(1);
        itemAction.show();

        itemAction.is().clickable();
        itemAction.click();
        itemAction.is().active();
        itemAction.icon().is().type("mdi-star");
        itemAction.click();
        itemAction.is().notActive();
        itemAction.icon().is().type("mdi-star-outline");
    }

    @Test
    public static void avatarListTest() {
        ListItem itemAvatar = simpleAvatarListList.item(1);
        itemAvatar.show();
        itemAvatar.avatar().is().displayed();
    }
}
