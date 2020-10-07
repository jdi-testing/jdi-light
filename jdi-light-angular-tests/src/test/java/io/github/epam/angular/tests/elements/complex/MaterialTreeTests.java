package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.materialTreeSection;
import static io.github.com.pages.sections.MaterialTreeSection.dynamicExample;
import static io.github.com.pages.sections.MaterialTreeSection.dynamicTree;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class MaterialTreeTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTreeTest() {
//        nestedMenuButton.is().displayed();
        dynamicExample.show();
        dynamicTree.expand(1);
        dynamicTree.isExpanded(1);
        materialTreeSection.basicTree.is().displayed();
    }

}
