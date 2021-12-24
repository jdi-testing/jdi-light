package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.com.StaticSite.listPage;
import static io.github.com.pages.displaydata.ListPage.avatarWithTextAndIconList;
import static io.github.com.pages.displaydata.ListPage.avatarWithTextList;
import static io.github.com.pages.displaydata.ListPage.checkboxList;
import static io.github.com.pages.displaydata.ListPage.denseCheckbox;
import static io.github.com.pages.displaydata.ListPage.iconWithTextList;
import static io.github.com.pages.displaydata.ListPage.listWithSwitch;
import static io.github.com.pages.displaydata.ListPage.pinnedSubheaderList;
import static io.github.com.pages.displaydata.ListPage.secondaryTextCheckbox;
import static io.github.com.pages.displaydata.ListPage.selectedListLowerHalf;
import static io.github.com.pages.displaydata.ListPage.selectedListUpperHalf;
import static io.github.com.pages.displaydata.ListPage.simpleList;
import static io.github.com.pages.displaydata.ListPage.simpleListLastClickInfo;
import static io.github.com.pages.displaydata.ListPage.textOnlyList;
import static java.lang.String.format;

public class ListTests extends TestsInit {

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
    public void textOnlyListTests() {
        textOnlyList.is().notDense();
        denseCheckbox.check();
        textOnlyList.is().dense();
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
        selectedListUpperHalf.selectItemByText("Inbox");
        selectedListUpperHalf.getItemByText("Inbox").is().selected();
        selectedListLowerHalf.selectItemByText("Spam");
        selectedListUpperHalf.getItemByText("Inbox").is().notSelected();
        selectedListLowerHalf.getItemByText("Spam").is().selected();
    }

    @Test
    public void checkboxListTests() {
        checkboxList.items().get(0).is().checked();
        checkboxList.items().get(0).checkbox().uncheck();
        checkboxList.items().get(0).is().unchecked();
        checkboxList.items().get(0).secondaryActionButton().click(); // should not affect primary checkbox
        checkboxList.items().get(0).is().unchecked();

        checkboxList.items().get(1).checkbox().check(); // checking item by interacting with checkbox
        checkboxList.items().get(1).is().checked();

        checkboxList.items().get(2).click(); // checking item by clicking its primary area
        checkboxList.items().get(2).is().checked();
    }

    @Test
    public void listWithSwitchTests() {
        Set<String> expectedItems = Stream.of("Wi-Fi", "Bluetooth")
                .collect(Collectors.toCollection(HashSet::new));
        listWithSwitch.has().itemsWithTexts(expectedItems);

        listWithSwitch.items().get(0).secondaryActionSwitch().is().turnedOn();
        listWithSwitch.items().get(0).secondaryActionSwitch().turnOff();
        listWithSwitch.items().get(0).secondaryActionSwitch().is().turnedOff();
    }

    @Test
    public void pinnedSubheaderTests() {
        pinnedSubheaderList.nestedLists().get(0).subheaders().get(0).has().cssClass("MuiListSubheader-sticky");
        pinnedSubheaderList.nestedLists().get(0).subheaders().get(0).has().text("I'm sticky 0");

        pinnedSubheaderList.nestedLists().get(4).items().get(1).has().text("Item 1");
    }
}
