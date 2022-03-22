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

    @Test(dataProviderClass = ListsTestsDataProvider.class, dataProvider = "denseListTestsData")
    public static void denseListTest(int itemIndex, String expectedTitle) {
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

        subGroupList.is().sublistCollapsed("Actions");
        subGroupList.item("Actions").click();
        subGroupList.is().sublistExpanded("Actions");

        subGroupList.is().sublistExpanded("Users");
        subGroupList.item("Users").click();
        subGroupList.is().sublistCollapsed("Users");
    }

    @Test(dataProviderClass = ListsTestsDataProvider.class, dataProvider = "threeLineListTestsData")
    public static void threeLineListTest(int itemIndex, String title, String subTitlePart) {
        ListItem item = threeLineList.item(itemIndex);
        item.show();

        item.has().title(title);
        item.is().containsSubTitle(subTitlePart);
    }

    @Test
    public static void twoLinesAndSubheaderListTest() {
        twoLinesAndSubheaderList.show();

        twoLinesAndSubheaderList.subheader(1).has().text("Folders");
        twoLinesAndSubheaderList.subheader(2).has().text("Files");
    }

    @Test(dataProviderClass = ListsTestsDataProvider.class, dataProvider = "actionAndItemGroupsListTestsData")
    public static void actionAndItemGroupsListTest(int itemIndex) {
        Checkbox itemCheckbox = actionAndItemGroupsGeneralList.item(itemIndex).checkbox();
        itemCheckbox.show();

        itemCheckbox.is().displayed().and().enabled().and().unchecked();
        itemCheckbox.check();
        itemCheckbox.is().checked();
    }
}
