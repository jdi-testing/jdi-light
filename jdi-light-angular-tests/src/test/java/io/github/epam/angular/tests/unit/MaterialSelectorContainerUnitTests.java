package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static io.github.com.pages.sections.SelectSection.customPanelStylingSelect;
import static io.github.com.pages.sections.SelectSection.multipleSelect;
import static io.github.com.pages.sections.SelectSection.optionGroupsMatSelect;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorContainerUnitTests extends TestsInit {
    private MaterialSelectorContainer container;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        container = new MaterialSelectorContainer();
    }

    @Test
    public void displayedTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertTrue(container.isDisplayed());
        container.collapsePanel();
    }

    @Test
    public void hiddenTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        container.collapsePanel();
        assertTrue(container.isHidden());
    }

    @Test
    public void listSizeTest() {
        assertEquals(container.list().size(), new WebList(By.cssSelector("mat-option span")).size());
    }

    @Test
    public void listHtmlTest() {
        WebList webList = new WebList(By.cssSelector("mat-option span"));
        for (int i = 1; i <= container.list().size(); i++) {
            assertEquals(container.list().get(i).printHtml(), webList.get(i).printHtml());
        }
    }

    @Test
    public void selectByValueTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        container.select(TACOS);
        assertTrue(basicMatSelect.selected(TACOS));
    }

    @Test
    public void selectByIndexTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        container.select(1);
        assertTrue(basicMatSelect.selected(STEAK));
    }

    @Test
    public void multipleSelectByValuesTest() {
        multipleSelect.show();
        multipleSelect.expand();
        container.multipleSelect(MUSHROOM, PEPPERONI, TOMATO);
        assertTrue(multipleSelect.selected(MUSHROOM + ", " + PEPPERONI + ", " + TOMATO));
        multipleSelect.expand();
        container.multipleSelect(MUSHROOM, PEPPERONI, TOMATO);
    }

    @Test
    public void multipleSelectByIndexesTest() {
        multipleSelect.show();
        multipleSelect.expand();
        container.multipleSelect(1, 3, 5);
        assertTrue(multipleSelect.selected(EXTRA_CHEESE + ", " + ONION + ", " + SAUSAGE));
        multipleSelect.expand();
        container.multipleSelect(1, 3, 5);
    }

    @Test
    public void valuesTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertEquals(container.values(), Arrays.asList(STEAK, PIZZA, TACOS));
    }

    @Test
    public void getGroupsTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.getGroups(), Arrays.asList(GRASS, WATER, FIRE, PSYCHIC));
    }

    @Test
    public void getMapGroupsAndOptionsTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.getMapGroupsAndOptions(), getPokemonsMap());
    }

    @Test
    public void listEnabledTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.listEnabled(),
                     Arrays.asList("-- None --", BULBASAUR, ODDISH, BELLSPROUT, SQUIRTLE, PSYDUCK, HORSEA, MEW,
                                   MEWTWO));
    }

    @Test
    public void listDisabledTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.listDisabled(), Arrays.asList(CHARMANDER, VULPIX, FLAREON));
    }

    @Test
    public void colorTest() {
        customPanelStylingSelect.show();
        customPanelStylingSelect.select(RED);
        customPanelStylingSelect.expand();
        assertTrue(container.color(255, 0, 0, 0.5));
    }
}
