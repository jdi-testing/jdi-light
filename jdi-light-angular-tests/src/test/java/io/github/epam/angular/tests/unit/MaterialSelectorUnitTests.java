package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.PIZZA;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.TACOS;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void expandedTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertTrue(basicMatSelect.isExpanded());
        basicMatSelect.collapse();
    }

    @Test
    public void collapsedTest() {
        basicMatSelect.show();
        basicMatSelect.collapse();
        assertTrue(basicMatSelect.isCollapsed());
    }

    @Test
    public void selectByValueTest() {
        basicMatSelect.show();
        basicMatSelect.select(PIZZA);
        assertEquals(basicMatSelect.selected(), PIZZA);
    }

    @Test
    public void selectByIndexTest() {
        basicMatSelect.show();
        basicMatSelect.select(TACOS);
        assertTrue(basicMatSelect.selected(TACOS));
    }
}
