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
        ListItem adminItem = subGroupList.item("Admin");
        ListItem actionsItem = subGroupList.item("Actions");
        ListItem usersItem = subGroupList.item("Users");
        subGroupList.show();

        subGroupList.is().size(6);
        usersItem.is().expanded();
        adminItem.is().displayed().and().expanded();
        actionsItem.is().displayed();
        subGroupList.item("Management").is().displayed();
        subGroupList.item("Settings").is().displayed();

        usersItem.click();
        usersItem.is().collapsed();
        adminItem.is().hidden();
        actionsItem.is().hidden();
        subGroupList.is().size(2);
    }

    @Test
    public static void threeLineListTest() {
        ListItem item = threeLineList.item(1);
        item.show();

        threeLineList.has().cssClass("v-list--three-line");
        item.title().has().text("Brunch this weekend?");
        item.subtitle().has().text("Ali Connors —I'll be in your neighborhood doing errands this weekend. "
            + "Do you want to hang out?");
        threeLineList.divider(1).is().horizontal();
        item.avatar().is().displayed();
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        twoLinesAndSubheaderList.show();

        twoLinesAndSubheaderList.has().cssClass("v-list--two-line");
        twoLinesAndSubheaderList.subheader(1).has().text("Folders");
        twoLinesAndSubheaderList.subheader(2).has().text("Files");
        twoLinesAndSubheaderList.item(1).title().has().text("Photos");
        twoLinesAndSubheaderList.item(1).subtitle().has().text("Jan 9, 2014");
    }

    @Test
    public static void actionAndItemGroupsListTest() {
        ListItem item = actionAndItemGroupsGeneralList.item(1);
        Checkbox itemCheckbox = item.checkbox();
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

    @Test
    public static void actionStackListTest() {
        ListItem item = actionStackList.item(1);
        item.show();

        item.actionText().is().text("15 min");
        item.is().clickable();
        item.click();
        item.is().active();
        item.icon().is().type("mdi-star");
        item.click();
        item.is().notActive();
        item.icon().is().type("mdi-star-outline");
    }
}
