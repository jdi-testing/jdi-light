package io.github.epam.angular.tests.elements.complex;

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

public class MaterialTreeTests extends TestsInit {
    final String FRUITS = "Fruits";
    final String FRUIT = "Fruit";
    final String VEGETABLES = "Vegetables";
    final String GROCERIES = "Groceries";
    final String ORGANIC_GGS = "Organic eggs";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTreeTest() {
        dynamicExample.show();
        dynamicTree.expand(FRUITS);
        dynamicTree.is().expanded(FRUITS).and().collapsed(VEGETABLES);
    }

    @Test
    public void expandByNameTest() {
        dynamicExample.show();
        dynamicTree.expand(FRUITS);
        dynamicTree.is().collapsed(VEGETABLES);
    }

    @Test
    public void turnOnOffNodeItemTest() {
        checkBoxesExample.show();
        checkBoxesTree.expand(GROCERIES);
        checkBoxesTree.is().expanded(GROCERIES);
        Checkbox checkbox = checkBoxesTree.getCheckbox(1, ORGANIC_GGS);
        checkbox.is().enabled();
        checkbox.check();
        checkbox.is().selected();
        checkbox.uncheck();
        checkbox.show();
        checkbox.is().deselected();
    }

    @Test
    public void turnOnOffAllItemsTest() {
        checkBoxesExample.show();
        checkBoxesTree.expand(GROCERIES);
        checkBoxesTree.is().expanded(GROCERIES);
        Checkbox checkbox = checkBoxesTree.getCheckbox(0, GROCERIES);
        Checkbox checkbox1 = checkBoxesTree.getCheckbox(1, ORGANIC_GGS);
        checkbox.is().enabled();
        checkbox.check();
        checkbox.is().selected();
        checkbox1.is().selected();
        checkbox.uncheck();
        checkbox1.is().deselected();
    }

    @Test
    public void flatByNameTest() {
        flatExample.show();
        flatTree.expand(VEGETABLES);
        flatTree.is().expanded(VEGETABLES).and().collapsed(FRUIT);
    }
}
