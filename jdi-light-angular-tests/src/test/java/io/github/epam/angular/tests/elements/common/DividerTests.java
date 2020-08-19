package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.dividerSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class DividerTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicDividerTest() {
        dividerSection.itemsList.is().size(3);
        dividerSection.itemsContent.is().size(3);
        dividerSection.itemsDivider.is().size(2);

        for (UIElement e : dividerSection.itemsList ) {
            e.is().displayed();
        }

        for (Text e : dividerSection.itemsContent) {
            e.is().displayed();
        }

        for (UIElement e : dividerSection.itemsDivider) {
            e.is().displayed();
        }
    }

    @Test
    public void dividerItemsTextTest() {
        dividerSection.itemsContent.list().get(1).is().text("Item 1");
        dividerSection.itemsContent.list().get(2).is().text("Item 2");
        dividerSection.itemsContent.list().get(3).is().text("Item 3");
    }
}
