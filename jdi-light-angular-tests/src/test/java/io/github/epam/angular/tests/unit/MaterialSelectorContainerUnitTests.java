package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.*;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorContainerUnitTests extends TestsInit {
    private MaterialSelectorContainer container;
    private String[] multiOptions = new String[3];
    private int[] multiSelect = new int[3];

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.open();
        container = new MaterialSelectorContainer();
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
        container.select(ELEMENT.startIndex);
        assertTrue(basicMatSelect.selected(STEAK));
    }

    @Test
    public void multipleSelectByValuesTest() {
        multipleSelect.show();
        multipleSelect.expand();
        multiOptions[0] = MUSHROOM;
        multiOptions[1] = PEPPERONI;
        multiOptions[2] = TOMATO;
        container.multipleSelect(multiOptions);
        assertTrue(multipleSelect.selected(multiOptions[0] + ", " + multiOptions[1] + ", " + multiOptions[2]));
    }

    @Test
    public void multipleSelectByIndexesTest() {
        multipleSelect.show();
        multipleSelect.expand();
        multiSelect = new int[] {1, 3, 5};
        container.multipleSelect(multiSelect);
        assertTrue(multipleSelect.selected(EXTRA_CHEESE + ", " + ONION + ", " + SAUSAGE));
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
