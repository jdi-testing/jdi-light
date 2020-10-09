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
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTreeTest() {
        dynamicExample.show();
        dynamicTree.expand(1);
        dynamicTree.is().displayed();
    }

    @Test
    public void expandByNameTest() {
        dynamicExample.show();
        dynamicTree.expandByName("Fruits"); // "Vegetables"
        dynamicTree.is().displayed();
    }

    @Test
    public void expandWithCheckBoxsTest() {
        checkBoxesExample.show();
        checkBoxesTree.expandByName("Groceries");  // "Reminders"
        checkBoxesTree.is().displayed();
    }

    @Test
    public void flatByNameTest() {
        flatExample.show();
        flatTree.expandByName("Vegetables");
        flatTree.is().displayed();
    }
}
