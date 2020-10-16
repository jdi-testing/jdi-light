package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MaterialTreeSection.checkBoxesExample;
import static io.github.com.pages.sections.MaterialTreeSection.checkBoxesTree;
import static io.github.com.pages.sections.MaterialTreeSection.dynamicExample;
import static io.github.com.pages.sections.MaterialTreeSection.dynamicTree;
import static io.github.com.pages.sections.MaterialTreeSection.flatExample;
import static io.github.com.pages.sections.MaterialTreeSection.flatTree;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.assertTrue;

public class TreeUnitTests extends TestsInit {
    private final String FRUITS = "Fruits";
    private final String FRUIT = "Fruit";
    private final String VEGETABLES = "Vegetables";
    private final String GROCERIES = "Groceries";
    private final String ORGANIC_GGS = "Organic eggs";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTreeTest() {
        dynamicExample.show();
        dynamicTree.waitExpandTree(dynamicTree.expand(FRUITS));
        assertTrue(dynamicTree.isExpanded(FRUITS) && dynamicTree.isCollapsed(VEGETABLES));
    }

    @Test
    public void expandByNameTest() {
        dynamicExample.show();
        dynamicTree.waitExpandTree(dynamicTree.expand(FRUITS));
        assertTrue(dynamicTree.isCollapsed(VEGETABLES));
    }

    @Test
    public void turnOnOffNodeItemTest() {
        checkBoxesExample.show();
        checkBoxesTree.expand(GROCERIES);
        checkBoxesTree.is().expanded(GROCERIES);
        Checkbox checkbox = checkBoxesTree.getCheckbox(1, ORGANIC_GGS);
        assertTrue(checkbox.isEnabled());
        checkbox.check();
        assertTrue(checkbox.isSelected());
        checkbox.uncheck();
        checkbox.show();
        assertTrue(!checkbox.isSelected());
    }

    @Test
    public void turnOnOffAllItemsTest() {
        checkBoxesExample.show();
        checkBoxesTree.expand(GROCERIES);
        checkBoxesTree.is().expanded(GROCERIES);
        Checkbox checkbox = checkBoxesTree.getCheckbox(0, GROCERIES);
        Checkbox checkbox1 = checkBoxesTree.getCheckbox(1, ORGANIC_GGS);
        assertTrue(checkbox.isEnabled());
        checkbox.check();
        assertTrue(checkbox.isSelected() && checkbox1.isSelected());
        checkbox.uncheck();
        assertTrue(!checkbox1.isSelected());
    }

    @Test
    public void flatByNameTest() {
        flatExample.show();
        flatTree.waitExpandTree(flatTree.expand(VEGETABLES));
        assertTrue(flatTree.isExpanded(VEGETABLES) && flatTree.isCollapsed(FRUIT));
    }
}
