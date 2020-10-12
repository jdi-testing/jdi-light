package io.github.epam.angular.tests.elements.complex;

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
    final String fruits = "Fruits";
    final String fruit = "Fruit";
    final String vegetables = "Vegetables";
    final String groceries = "Groceries";
    final String reminders = "Reminders";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTreeTest() {
        dynamicExample.show();
        dynamicTree.expand(fruits);
        dynamicTree.is().expanded(fruits).and().collapsed(vegetables);
    }

    @Test
    public void expandByNameTest() {
        dynamicExample.show();
        dynamicTree.expand(fruits);
        dynamicTree.is().collapsed(vegetables);
    }

    @Test
    public void expandWithCheckBoxsTest() {
        checkBoxesExample.show();
        checkBoxesTree.expand(groceries);  // "Reminders"
        checkBoxesTree.is().expanded(groceries);
    }

    @Test
    public void flatByNameTest() {
        flatExample.show();
        flatTree.expand(vegetables);
        flatTree.is().expanded(vegetables).and().collapsed(fruit);
    }
}
