package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.itemGroupsPage;
import static io.github.com.pages.ItemGroupsPage.activeClassItemGroup;
import static io.github.com.pages.ItemGroupsPage.chipsItemGroup;
import static io.github.com.pages.ItemGroupsPage.mandatoryItemGroup;
import static io.github.com.pages.ItemGroupsPage.multipleItemGroup;
import static io.github.com.pages.ItemGroupsPage.selectionItemGroup;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ItemGroupsTests extends TestsInit {

    @BeforeClass
    public void setup() {
        itemGroupsPage.open();
        waitCondition(() -> itemGroupsPage.isOpened());
        itemGroupsPage.checkOpened();

    }

    @Test(description="Test checks items default feature: 'single', we have only one item--active at a time, "
        + "but all items may be not active")
    public void singleItemGroupTest() {
        // Check that when 1st item  selected, other items are not selected
        activeClassItemGroup.select(1);
        activeClassItemGroup.is().selected(1);
        activeClassItemGroup.has().notSelected(2)
                            .and().notSelected(3);

        // Check that when 2nd item  selected, 1st becomes not selected, other items remain not selected
        activeClassItemGroup.select(2);
        activeClassItemGroup.has().selected(2)
                            .and().notSelected(1)
                            .and().notSelected(3);

        //Check that if we select the item that was already selected then it becomes not selected,
        // other items remain not selected
        activeClassItemGroup.select(2);
        activeClassItemGroup.has().notSelected(2)
                            .and().notSelected(1)
                            .and().notSelected(3);
    }
    @Test(description="Test checks item group selecting")
    public void activeClassTests() {
        activeClassItemGroup.select(1);

        activeClassItemGroup.items().get(1).has().text("Active");
        activeClassItemGroup.select(2);
        activeClassItemGroup.has().selected(2).and().notSelected(1);
    }
    @Test(description="Test checks items feature: 'mandatory', i.e. only one item is always chosen")
    public void mandatoryItemGroupTest() {
        //Check that if we select already item--active element it stays selected
        mandatoryItemGroup.select(1);
        mandatoryItemGroup.has().selected(1).and().notSelected(2)
                .and().notSelected(3);

        //Check that if we select next item it becomes 'selected' and all other items become 'not selected'
        mandatoryItemGroup.select(2);
        mandatoryItemGroup.has().selected(2)
                .and().notSelected(1)
                .and().notSelected(3);

        //Check theme of the group
        mandatoryItemGroup.is().lightTheme();
    }

    @Test(description="Test checks items feature: 'multiple', i.e. several items can be chosen")
    public void multipleItemGroupTest() {
        //Before we select any item all items are 'not selected'
        multipleItemGroup.has().notSelected(1)
                         .and().notSelected(2)
                         .and().notSelected(3);

        //We select items with indexes 1 and 2. Check that #1 and #2 selected, #3 is not selected
        multipleItemGroup.select(1);
        multipleItemGroup.select(2);
        multipleItemGroup.has().selected(1)
                         .and().has().selected(2)
                         .and().has().notSelected(3);

        //We select items with indexes 1 and 2 once again(=deselect). Check that all three items are not selected again.
        multipleItemGroup.select(1);
        multipleItemGroup.select(2);
        multipleItemGroup.has().notSelected(1)
                         .and().notSelected(2)
                         .and().notSelected(3);

        //Check theme of the group
        multipleItemGroup.is().lightTheme();
    }

    @Test(description="Test checks items feature: 'icon' and its type, and two types of selection")
    public void selectionItemGroupTest() {
        selectionItemGroup.is().displayed();
        selectionItemGroup.has().notSelected(1).and().notSelected(2);

        //1st option - we can click on item and make it item--active. And it will change the icon type.
        selectionItemGroup.itemIcon(1).has().type("mdi-heart-outline");
        selectionItemGroup.itemIcon(1).click();
        selectionItemGroup.itemIcon(1).has().type("mdi-heart");

        //2nd option - we can click on icon, and it will change icon type. And it will make item--active
        selectionItemGroup.itemIcon(2).has().type("mdi-heart-outline");
        selectionItemGroup.itemIcon(2).click();
        selectionItemGroup.itemIcon(2).has().type("mdi-heart");

        //Check that after 1st and 2nd options both items are selected(=v-item--active)
        selectionItemGroup.has().selected(1).and().selected(2);

        //Check theme of the group
        selectionItemGroup.is().lightTheme();
    }

    // @todo #5048 Selected elements should be retrieved bu the methods and the content is checked
    @Test(description="Test checks item group feature: 'max'(Sets a maximum number of selections that can be made)")
    public void maxChipsItemGroupTest() {
        //On our test-site max=3
        chipsItemGroup.has().subheader(Matchers.is("Tags"));
        chipsItemGroup.is().displayed();
        chipsItemGroup.items().forEach(HasClick::click);
        chipsItemGroup.selected().has().size(3);
    }
}
