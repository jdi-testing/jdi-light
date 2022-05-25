package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.MUIContainerListItem;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.listPage;
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
        listPage.simpleList.show();
        listPage.simpleList.is().visible();
        listPage.simpleList.has().size(2);

        listPage.simpleList.item(0).has().text("List item 1");
        listPage.simpleList.item("List item 2").is().visible();

        listPage.simpleList.items().get(1).click();
        String clickedOn = listPage.simpleList.items().get(1).getText();
        listPage.simpleListLastClickInfo.has().text(format("You clicked on: %s", clickedOn));

    }

    @Test
    public void iconWithTextTests() {
        listPage.iconWithTextList.is().notEmpty();
        MUIContainerListItem item = listPage.iconWithTextList.items(MUIContainerListItem.class).get(0);
        Icon icon = item.icon();
        icon.has().css("color", Colors.GREY_600_TRANSPARENT.rgba());
    }

    @Test
    public void avatarWithTextTests() {
        listPage.avatarWithTextList.show();
        MUIContainerListItem item = listPage.avatarWithTextList.items(MUIContainerListItem.class).get(0);
        item.avatar().is().visible();
        item.asText().has().text("Single-line item");
        listPage.secondaryTextCheckbox.check();
        item.asText().has().text(containsString("Secondary text"));
    }

    @Test
    public void avatarWithTextAndIconTests() {
        listPage.avatarWithTextAndIconList.show();
        listPage.avatarWithTextAndIconList.has().size(3);

        MUIContainerListItem item = listPage.avatarWithTextAndIconList.item(1);
        item.asText().has().text("Single-line item");
        item.secondaryAction().is().visible();
        item.secondaryAction().click();
    }

    @Test
    public void selectedListTests() {
        listPage.selectedListUpperHalf.show();
        MUIContainerListItem upperItem = listPage.selectedListUpperHalf.item("Inbox").with(MUIContainerListItem.class);
        MUIContainerListItem lowerItem = listPage.selectedListLowerHalf.item("Spam").with(MUIContainerListItem.class);

        upperItem.click();
        upperItem.is().selected();
        lowerItem.is().notSelected();
        lowerItem.click();
        lowerItem.is().selected();
        upperItem.is().notSelected();

    }

    @Test
    public void checkboxListTests() {
        listPage.checkboxList.show();
        listPage.checkboxList.has().size(4);
        //first option
        MUIContainerListItem item = listPage.checkboxList.items(MUIContainerListItem.class).get(0);
        Checkbox checkbox = item.checkbox();
        checkbox.is().checked();
        checkbox.uncheck();
        checkbox.is().unchecked();

        //second option
        MUIContainerListItem item2 = listPage.checkboxList.item("Line item 2").with(MUIContainerListItem.class);
        Checkbox checkbox2 = item2.checkbox();
        checkbox2.is().unchecked();
        checkbox2.check();
        checkbox2.is().checked();

        //third option
        MUIButton item3 = listPage.checkboxList.item(2);
        Checkbox checkbox3 = new Checkbox().setCore(Checkbox.class, item3.find(".MuiCheckbox-root").base());
        checkbox3.is().unchecked();
        checkbox3.check();
        checkbox3.is().checked();
    }

    @Test
    public void listWithSwitchTests() {
        listPage.listWithSwitch.show();
        listPage.listWithSwitch.has().headers();
        MUIContainerListItem item = listPage.listWithSwitch.items(MUIContainerListItem.class).get(0);
        Switch el = new Switch().setCore(Switch.class, item.secondaryAction().find(".MuiSwitch-root").base());
        el.is().enabled();
        el.is().checked();
        el.uncheck();
        el.is().unchecked();

    }

    @Test
    public void pinnedSubheaderTests() {
        listPage.pinnedSubheaderList.show();
        listPage.pinnedSubheaderList.has().headers();
        Text header = listPage.pinnedSubheaderList.headers().get(0);
        header.has().text("I'm sticky 0");

    }
}
