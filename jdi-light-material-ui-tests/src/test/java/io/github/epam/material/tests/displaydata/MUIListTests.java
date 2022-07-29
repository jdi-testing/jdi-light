package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.CustomSiteListItem;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.listPage;
import static io.github.com.pages.displaydata.MUIListPage.simpleList;
import static io.github.com.pages.displaydata.MUIListPage.iconWithTextList;
import static io.github.com.pages.displaydata.MUIListPage.simpleListLastClickInfo;
import static io.github.com.pages.displaydata.MUIListPage.checkboxList;
import static io.github.com.pages.displaydata.MUIListPage.avatarWithTextList;
import static io.github.com.pages.displaydata.MUIListPage.avatarWithTextAndIconList;
import static io.github.com.pages.displaydata.MUIListPage.listWithSwitch;
import static io.github.com.pages.displaydata.MUIListPage.pinnedSubheaderList;
import static io.github.com.pages.displaydata.MUIListPage.selectedListUpperHalf;
import static io.github.com.pages.displaydata.MUIListPage.secondaryTextCheckbox;
import static io.github.com.pages.displaydata.MUIListPage.selectedListLowerHalf;
import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;

public class MUIListTests extends TestsInit {

    @BeforeClass
    public void setup() {
        listPage.open();
        listPage.checkOpened();
    }


    @Test
    public void simpleListTests() {
        simpleList.show();
        simpleList.is().visible();
        simpleList.has().size(2);

        simpleList.item(0).has().text("List item 1");
        simpleList.item("List item 2").is().visible();

        simpleList.items().get(1).click();
        String clickedOn = simpleList.items().get(1).getText();
        simpleListLastClickInfo.has().text(format("You clicked on: %s", clickedOn));

    }

    @Test
    public void iconWithTextTests() {
        iconWithTextList.is().notEmpty();
        CustomSiteListItem item = iconWithTextList.items(CustomSiteListItem.class).get(0);
        Icon icon = item.icon();
        icon.has().css("color", Colors.GREY_600_TRANSPARENT.rgba());
    }

    @Test
    public void avatarWithTextTests() {
        avatarWithTextList.show();
        CustomSiteListItem item = avatarWithTextList.items(CustomSiteListItem.class).get(0);
        item.avatar().is().visible();
        item.asText().has().text("Single-line item");
        secondaryTextCheckbox.check();
        item.asText().has().text(containsString("Secondary text"));
    }

    @Test
    public void avatarWithTextAndIconTests() {
        avatarWithTextAndIconList.show();
        avatarWithTextAndIconList.has().size(3);

        CustomSiteListItem item = avatarWithTextAndIconList.item(1);
        item.asText().has().text("Single-line item");
        item.secondaryAction().is().visible();
        item.secondaryAction().click();
    }

    @Test
    public void selectedListTests() {
        selectedListUpperHalf.show();
        CustomSiteListItem upperItem = selectedListUpperHalf.item("Inbox").with(CustomSiteListItem.class);
        CustomSiteListItem lowerItem = selectedListLowerHalf.item("Spam").with(CustomSiteListItem.class);

        upperItem.click();
        upperItem.is().selected();
        lowerItem.is().notSelected();
        lowerItem.click();
        lowerItem.is().selected();
        upperItem.is().notSelected();

    }

    @Test
    public void checkboxListTests() {
        checkboxList.show();
        checkboxList.has().size(4);
        //first option
        CustomSiteListItem item = checkboxList.items(CustomSiteListItem.class).get(0);
        Checkbox checkbox = item.checkbox();
        checkbox.is().checked();
        checkbox.uncheck();
        checkbox.is().unchecked();

        //second option
        CustomSiteListItem item2 = checkboxList.item("Line item 2").with(CustomSiteListItem.class);
        Checkbox checkbox2 = item2.checkbox();
        checkbox2.is().unchecked();
        checkbox2.check();
        checkbox2.is().checked();

        //third option
        MUIButton item3 = checkboxList.item(2);
        Checkbox checkbox3 = new Checkbox().setCore(Checkbox.class, item3.find(".MuiCheckbox-root").base());
        checkbox3.is().unchecked();
        checkbox3.check();
        checkbox3.is().checked();
    }

    @Test
    public void listWithSwitchTests() {
        listWithSwitch.show();
        listWithSwitch.has().headers();
        CustomSiteListItem item = listWithSwitch.items(CustomSiteListItem.class).get(0);
        Switch el = new Switch().setCore(Switch.class, item.secondaryAction().find(".MuiSwitch-root").base());
        el.is().enabled();
        el.is().checked();
        el.uncheck();
        el.is().unchecked();

    }

    @Test
    public void pinnedSubheaderTests() {
        pinnedSubheaderList.show();
        pinnedSubheaderList.has().headers();
        Text header = pinnedSubheaderList.headers().get(0);
        header.has().text("I'm sticky 0");

    }
}
