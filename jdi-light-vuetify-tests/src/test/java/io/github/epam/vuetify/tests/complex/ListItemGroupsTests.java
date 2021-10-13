package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.listItemGroupsPage;
import static io.github.com.pages.ListItemGroupsPage.activeClassListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.flatListListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.mandatoryListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.multipleListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.selectionControlsListItemGroup;
import static io.github.com.pages.ListItemGroupsPage.selectionControlsListItemGroupCheckbox;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListItemGroupsTests extends TestsInit {
    @BeforeClass
    public static void setup() {
        listItemGroupsPage.open();
    }

    @Test
    public static void activeClassListItemGroupTest() {

        int elemIndex = 1;
        String[] expectedTitles = {"Wifi", "Bluetooth", "Data Usage"};

        for (String expectedTitle : expectedTitles) {
            activeClassListItemGroup.select(elemIndex);
            jdiAssert(activeClassListItemGroup.isActive(elemIndex), Matchers.is(true));
            jdiAssert(activeClassListItemGroup.hasIcon(elemIndex), Matchers.is(true));
            jdiAssert(activeClassListItemGroup.hasTitle(elemIndex, expectedTitle), Matchers.is(true));
            activeClassListItemGroup.select(elemIndex);
            jdiAssert(activeClassListItemGroup.isInactivate(elemIndex), Matchers.is(true));

            elemIndex++;
        }
    }

    @Test
    public static void mandatoryListItemGroupTest() {

        for (int element = 1; element < 4; element++) {
            mandatoryListItemGroup.select(element);
            jdiAssert(mandatoryListItemGroup.isActive(element), Matchers.is(true));
            mandatoryListItemGroup.select(element);
            jdiAssert(mandatoryListItemGroup.isInactivate(element), Matchers.is(false));
        }

        for (int element = 1; element < 4; element++) {
            mandatoryListItemGroup.select(element);
        }

        jdiAssert(mandatoryListItemGroup.isActive(3), Matchers.is(true));
        jdiAssert(mandatoryListItemGroup.isInactivate(1), Matchers.is(true));
        jdiAssert(mandatoryListItemGroup.isInactivate(2), Matchers.is(true));
    }

    @Test
    public static void multipleListItemGroupsTest() {
        for (int element = 1; element < 4; element++) {
            if (multipleListItemGroup.isInactivate(element)) {
                multipleListItemGroup.select(element);
            }
        }

        for (int element = 1; element < 4; element++) {
            jdiAssert(multipleListItemGroup.isActive(element), Matchers.is(true));
        }

        for (int element = 1; element < 4; element++) {
            multipleListItemGroup.select(element);
            jdiAssert(multipleListItemGroup.isInactivate(element), Matchers.is(true));
        }
    }


    @Test
    public static void flatListListItemGroupTest() {

        for (int element = 1; element < 4; element++) {
            flatListListItemGroup.select(element);
            jdiAssert(flatListListItemGroup.isActive(element), Matchers.is(true));
            jdiAssert(flatListListItemGroup.hasIcon(element), Matchers.is(true));
            flatListListItemGroup.select(element);
            jdiAssert(flatListListItemGroup.isInactivate(element), Matchers.is(true));
        }
    }

    @Test
    public static void selectionControlsListItemGroupTest() {
        int elemIndex = 1;
        String[] expectedTitles = {"Dog Photos", "Cat Photos", "Potatoes", "Carrots"};

        for (String expectedTitle : expectedTitles) {

            jdiAssert(selectionControlsListItemGroup.hasTitle(elemIndex, expectedTitle), Matchers.is(true));
            selectionControlsListItemGroupCheckbox.get(elemIndex).check();
            selectionControlsListItemGroupCheckbox.get(elemIndex).is().checked();
            selectionControlsListItemGroupCheckbox.get(elemIndex).uncheck();
            selectionControlsListItemGroupCheckbox.get(elemIndex).is().unchecked();

            elemIndex++;
        }

        for (int element = 1; element < 5; element++) {
            selectionControlsListItemGroupCheckbox.get(element).check();
        }
        for (int element = 1; element < 5; element++) {
            selectionControlsListItemGroupCheckbox.get(element).is().checked();
        }
    }
}
