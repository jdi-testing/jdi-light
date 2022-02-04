package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.itemGroupsPage;
import static io.github.com.pages.ItemGroupsPage.activeClassItemGroup;
import static io.github.com.pages.ItemGroupsPage.mandatoryItemGroup;
import static io.github.com.pages.ItemGroupsPage.selectionItemGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ItemGroupsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        itemGroupsPage.open();
        waitCondition(() -> itemGroupsPage.isOpened());
        itemGroupsPage.checkOpened();

    }

    @Test
    public void singleItemGroupTest() {
        activeClassItemGroup.select(1);
        activeClassItemGroup.has().selected(1);

        activeClassItemGroup.select(2);
        activeClassItemGroup.has().selected(2).and().notSelected(1);

        activeClassItemGroup.select(2);
        activeClassItemGroup.has().notSelected(2);
    }

    @Test
    public void mandatoryItemGroupTest() {
        mandatoryItemGroup.select(1);
        mandatoryItemGroup.has().selected(1);

        mandatoryItemGroup.select(1);
        mandatoryItemGroup.has().selected(1);
    }

    @Test
    public void selectionItemGroupTest() {
        selectionItemGroup.itemIcon(1).has().type("mdi-heart-outline");
        selectionItemGroup.check(1);
        selectionItemGroup.itemIcon(1).has().type("mdi-heart");

        selectionItemGroup.uncheck(2);
        selectionItemGroup.itemIcon(2).has().type("mdi-heart-outline");
        selectionItemGroup.itemIcon(2).click();
        selectionItemGroup.itemIcon(2).has().type("mdi-heart");

        selectionItemGroup.has().selected(1).and().selected(2);
    }
}
