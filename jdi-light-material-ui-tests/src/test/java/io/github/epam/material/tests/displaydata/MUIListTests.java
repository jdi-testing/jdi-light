package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.MUIList;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.com.StaticSite.listPage;
import static io.github.com.pages.displaydata.MUIListPage.avatarWithTextAndIconList;
import static io.github.com.pages.displaydata.MUIListPage.avatarWithTextList;
import static io.github.com.pages.displaydata.MUIListPage.checkboxList;
import static io.github.com.pages.displaydata.MUIListPage.iconWithTextList;
import static io.github.com.pages.displaydata.MUIListPage.listWithSwitch;
import static io.github.com.pages.displaydata.MUIListPage.pinnedSubheaderList;
import static io.github.com.pages.displaydata.MUIListPage.secondaryTextCheckbox;
import static io.github.com.pages.displaydata.MUIListPage.selectedListLowerHalf;
import static io.github.com.pages.displaydata.MUIListPage.selectedListUpperHalf;
import static io.github.com.pages.displaydata.MUIListPage.simpleList;
import static io.github.com.pages.displaydata.MUIListPage.simpleListLastClickInfo;
import static java.lang.String.format;

public class MUIListTests extends TestsInit {

    @BeforeClass
    public void setup() {
        listPage.open();
        listPage.checkOpened();
    }

    @Test
    public void simpleListTests() {
        simpleList.items().get(0).click();
        String firstItemText = simpleList.items().get(0).getText();
        simpleListLastClickInfo.has().text(format("You clicked on: %s", firstItemText));

        simpleList.items().get(1).click();
        String secondItemText = simpleList.items().get(1).getText();
        simpleListLastClickInfo.has().text(format("You clicked on: %s", secondItemText));
    }

    @Test
    public void iconWithTextTests() {
        iconWithTextList.is().notEmpty();
        iconWithTextList.items().get(0).icon().is().notColored();
    }

    @Test
    public void avatarWithTextTests() {
        secondaryTextCheckbox.check();
        avatarWithTextList.items().get(0).has().secondaryText("Secondary text");
    }

    @Test
    public void avatarWithTextAndIconTests() {
        avatarWithTextAndIconList.has().size(3);

        // Both text() and primaryText() assertions are equivalent for items with properly marked sub-elements
        avatarWithTextAndIconList.items().get(0).has().text("Single-line item");
        avatarWithTextAndIconList.items().get(0).has().primaryText("Single-line item");
    }

    @Test
    public void selectedListTests() {
        selectedListUpperHalf.show();
        selectedListUpperHalf.item("Inbox").click();
        selectedListUpperHalf.item("Inbox").is().selected();
        selectedListLowerHalf.item("Spam").click();
        selectedListUpperHalf.item("Inbox").is().notSelected();
        selectedListLowerHalf.item("Spam").is().selected();
    }

    @Test
    public void checkboxListTests() {
        checkboxList.show();
        java.util.List<MUIListItem> listItems = checkboxList.items();
        listItems.get(0).is().checked();
        listItems.get(0).checkbox().uncheck();
        listItems.get(0).is().unchecked();
        listItems.get(0).secondaryActionButton().click(); // should not affect primary checkbox
        listItems.get(0).is().unchecked();

        listItems.get(1).checkbox().check(); // checking item by interacting with checkbox
        listItems.get(1).is().checked();

        listItems.get(2).click(); // checking item by clicking its primary area
        listItems.get(2).is().checked();
    }

    @Test
    public void listWithSwitchTests() {
        listWithSwitch.show();
        Set<String> expectedItems = Stream.of("Wi-Fi", "Bluetooth")
                .collect(Collectors.toCollection(HashSet::new));
        listWithSwitch.has().itemsWithTexts(expectedItems);
        java.util.List<MUIListItem> listItems = listWithSwitch.items();
        listItems.get(0).secondaryActionSwitch().is().checked();
        listItems.get(0).secondaryActionSwitch().uncheck();
        listItems.get(0).secondaryActionSwitch().is().unchecked();
    }

    @Test
    public void pinnedSubheaderTests() {
        pinnedSubheaderList.show();
        java.util.List<MUIList> nestedLists = pinnedSubheaderList.nestedLists();
        nestedLists.get(0).subheaders().get(0).has().cssClass("MuiListSubheader-sticky");
        nestedLists.get(0).subheaders().get(0).has().text("I'm sticky 0");

        nestedLists.get(4).items().get(1).has().text("Item 1");
    }
}
