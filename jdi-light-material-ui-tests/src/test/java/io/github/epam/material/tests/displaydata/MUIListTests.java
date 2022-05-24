package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.displaydata.*;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.Switch;
import io.github.com.custom.elements.MUIContainerListItem;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.listPage;
import static io.github.com.pages.displaydata.MUIListPage.*;
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

        simpleList.item(1).has().text("List item 1");
        simpleList.item("List item 2").is().visible();

        simpleList.items().get(1).click();
        String firstItemText = simpleList.items().get(1).getText();
        simpleListLastClickInfo.has().text(format("You clicked on: %s", firstItemText));

    }

    @Test
    public void iconWithTextTests() {
        iconWithTextList.is().notEmpty();
        MUIContainerListItem item = iconWithTextList.items(MUIContainerListItem.class).get(0);
        Icon icon = item.icon();
        icon.has().css("color", Colors.GREY_600_TRANSPARENT.rgba());
    }

    @Test
    public void avatarWithTextTests() {
        avatarWithTextList.show();
        MUIContainerListItem item = avatarWithTextList.items(MUIContainerListItem.class).get(0);
        item.avatar().is().visible();
        item.asText().has().text("Single-line item");
        secondaryTextCheckbox.check();
        item.asText().has().text(containsString("Secondary text"));
    }

    @Test
    public void avatarWithTextAndIconTests() {
        avatarWithTextAndIconList.show();
        avatarWithTextAndIconList.has().size(3);

        MUIContainerListItem item = avatarWithTextAndIconList.item(1);
        item.asText().has().text("Single-line item");
        item.secondaryAction().is().visible();
    }

    @Test
    public void selectedListTests() {
        selectedListUpperHalf.show();
        MUIContainerListItem upperItem = selectedListUpperHalf.item("Inbox").with(MUIContainerListItem.class);
        MUIContainerListItem lowerItem = selectedListLowerHalf.item("Spam").with(MUIContainerListItem.class);

        upperItem.click();
        upperItem.has().cssClass("Mui-selected");
        lowerItem.click();
        lowerItem.has().cssClass("Mui-selected");

    }

    @Test
    public void checkboxListTests() {
        checkboxList.show();
        checkboxList.has().size(4);
        MUIContainerListItem item = checkboxList.items(MUIContainerListItem.class).get(0);
        Checkbox checkbox = new Checkbox().setCore(Checkbox.class, item.icon().find(".MuiCheckbox-root").base());
        checkbox.is().checked();
        checkbox.uncheck();
        checkbox.is().unchecked();
    }

    @Test
    public void listWithSwitchTests() {
        listWithSwitch.show();
        listWithSwitch.has().headers();
        MUIContainerListItem item = listWithSwitch.items(MUIContainerListItem.class).get(0);
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
        UIElement header = pinnedSubheaderList.headers().get(1);
        header.has().text("I'm sticky 0");

    }
}
