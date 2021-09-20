package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Breadcrumbs;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.function.Predicate;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.breadcrumbsPage;
import static io.github.com.pages.BreadcrumbsPage.backwardSlashedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.dashedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.dottedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.forwardSlashedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.greaterSignBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.itemSlotsBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.largeBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.mdiChevronRightBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.mdiForwardBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.semicolonBreadcrumbs;

public class BreadcrumbsTests extends TestsInit {

    @BeforeClass
    public void before() {
        breadcrumbsPage.open();
        breadcrumbsPage.checkOpened();
    }

    @Test
    public void dividersTypeTest() {
        dashedBreadcrumbs.is().displayed();
        dashedBreadcrumbs.has().size(3);
        dashedBreadcrumbs.items().has().size(3);
        dashedBreadcrumbs.dividers().has().size(2);

        assertDivider(dashedBreadcrumbs, correctSymbol("-"));
        assertDivider(forwardSlashedBreadcrumbs, correctSymbol("/"));
        assertDivider(backwardSlashedBreadcrumbs, correctSymbol("\\"));
        assertDivider(dottedBreadcrumbs, correctSymbol("."));
        assertDivider(semicolonBreadcrumbs, correctSymbol(";"));
        assertDivider(greaterSignBreadcrumbs, correctSymbol(">"));
    }

    @Test
    public void largeBreadcrumbsTest() {
        largeBreadcrumbs.is().displayed();
        largeBreadcrumbs.has().cssClass("v-breadcrumbs--large");
        largeBreadcrumbs.has().css("font-size", "16px");
    }

    @Test
    public void iconBreadcrumbsTest() {
        assertDivider(mdiForwardBreadcrumbs, correctIcon("mdi-forward"));
        assertDivider(mdiChevronRightBreadcrumbs, correctIcon("mdi-chevron-right"));
    }

    @Test
    public void itemSlotBreadcrumbsTest() {
        itemSlotsBreadcrumbs.is().displayed();
        itemSlotsBreadcrumbs.has().size(3);
        itemSlotsBreadcrumbs.dividers().has().size(2);
        itemSlotsBreadcrumbs.items().has().values("DASHBOARD", "LINK 1", "LINK 2");
        jdiAssert(itemSlotsBreadcrumbs.selected("DASHBOARD"), Matchers.is(false));
        jdiAssert(itemSlotsBreadcrumbs.selected("LINK 2"), Matchers.is(true));
    }

    protected Predicate<UIElement> correctSymbol(String symbol) {
        // checks that inner text is equal to the symbol
        return e -> e.text().equals(symbol);
    }

    protected Predicate<UIElement> correctIcon(String iconClass) {
        // finds icon tag and checks that the element has the following iconClass
        return e -> e.find("i").hasClass(iconClass);
    }

    @JDIAction("Assert that '{0}' dividers satisfy a predicate '{1}'")
    private void assertDivider(Breadcrumbs breadcrumbs, Predicate<? super UIElement> predicate) {
        // checks if all dividers of the breadcrumbs are satisfied the following predicate
        jdiAssert(breadcrumbs.dividers().all(predicate::test), Matchers.is(true));
    }
}
