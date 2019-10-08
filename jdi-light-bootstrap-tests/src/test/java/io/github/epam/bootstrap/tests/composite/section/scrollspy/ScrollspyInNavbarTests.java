package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.nestedNav;
import static io.github.com.pages.BootstrapPage.scrollspyWithNestedNav;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class ScrollspyInNavbarTests extends TestsInit {
    private String itemLink = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private String navbarLink = "https://getbootstrap.com/docs/4.3/components/scrollspy/#example-in-navbar";
    private String navbarText = "Navbar";
    private String pageTitle = "Scrollspy · Bootstrap";

    private String paragraphFat = "fat";//@
    private String paragraphMdo = "mdo";//@
    private String paragraphOne = "one";
    private String paragraphTwo = "two";
    private String paragraphThree = "three";
    private String dropdown = "Dropdown";

    private String headerFat = "fat";
    private String headerMdo = "mdo";
    private String headerOne = "one";
    private String headerTwo = "two";
    private String headerThree = "three";

    private String mainTextFat = "";
    private String mainTextMdo = "";
    private String mainTextOne = "";
    private String mainTextTwo = "";
    private String mainTextThree = "";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, itemLink + paragraphFat, headerFat, paragraphFat, mainTextFat},
                {2, itemLink + paragraphMdo, headerMdo, paragraphMdo, mainTextMdo},
                {3, itemLink + paragraphOne, headerOne, paragraphOne, mainTextOne},
                {4, itemLink + paragraphTwo, headerTwo, paragraphTwo, mainTextTwo},
                {5, itemLink + paragraphThree, headerThree, paragraphThree, mainTextThree}
        };
    }

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, paragraphFat, headerFat, mainTextFat},
                {2, paragraphMdo, headerMdo, mainTextMdo},
                {3, paragraphOne, headerOne, mainTextOne},
                {4, paragraphTwo, headerTwo, mainTextTwo},
                {5, paragraphThree, headerThree, mainTextThree}
        };
    }

    @DataProvider
    public Object[][] itemsCheck() {
        return new Object[][]{
                {1}, {2}, {3}, {4}, {5}
        };
    }

/*    @Test(dataProvider = "listData", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        refresh();

        nestedNav.navItemLink.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(header))
                .value(is(header))
                .attr("href", is(link));

        scrollspyWithNestedNav.header.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr("id", is(paragraph));

        scrollspyWithNestedNav.mainText.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));
    }*/

/*    @Test
    public void isValidationTests() {
        nestedNav.navItemLink.is().size(7);
        nestedNav.navGroup.is().size(3);
        scrollspyWithNestedNav.mainText.is().size(7);
        scrollspyWithNestedNav.header.is().size(7);

        nestedNav.navbarLink.is()
                .core()
                .displayed()
                .enabled()
                .attr("href", is(navbarLink))
                .value(is(navbarText))
                .text(is(navbarText))
                .cssClass("navbar-brand");

        for (UIElement element: nestedNav.navGroup.list())
        {
            element.is()
                    .core()
                    .displayed()
                    .enabled()
                    .cssClass("nav nav-pills flex-column");
        }

        scrollspyWithNestedNav.is()
                .core()
                .displayed()
                .enabled()
                .attr("data-spy", is("scroll"))
                .attr("data-target", is("#navbar-example3"))
                .attr("data-offset", is("0"))
                .cssClass("scrollspy-example-2");
    }*/

/*    @Test(dataProvider = "clickValidate")
    public void linkClickableTests(int index, String paragraph, String header, String mainText) {
        refresh();
        nestedNav.navItemLink.get(index)
                .is()
                .core()
                .displayed()
                .enabled();

        scrollspyWithNestedNav.header.get(index).is()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .core().attr("id", is(paragraph));

        scrollspyWithNestedNav.mainText.get(index).is()
                .text(is(mainText))
                .value(is(mainText));

        nestedNav.navItemLink.get(index).unhighlight();
    }*/

/*    @Test
    public void navbarLinkClickableTests() {
        nestedNav.navbarLink.click();

        switchToWindow(2);

        assertThat(WebPage.getTitle(), is(pageTitle));

        closeWindow();
        switchToWindow(1);
    }*/

/*    @Test(dataProvider = "itemsCheck")
    public void linkClickableFocusTests(int index) {
        refresh();
        nestedNav.navItemLink.get(1).click();

        int y_header_start = scrollspyWithNestedNav.header.get(1).core().getRect().y;

        nestedNav.navItemLink.get(index).highlight();
        nestedNav.navItemLink.get(index).click();

        int y_header_current = scrollspyWithNestedNav.header.get(index).core().getRect().y;

        if (index!=7)
            assertThat(y_header_start, is(y_header_current - 6));
        else
            assertThat(y_header_start, is(y_header_current - 92));

        nestedNav.navItemLink.get(index).unhighlight();
    }*/

/*    @Test
    public void highlightFocusedItemsTests() {
        nestedNav.navItemLink.get(7).highlight();
        nestedNav.navItemLink.get(7).click();

        for (int i = 1; i <= nestedNav.navItemLink.size(); i++) {
            if (i != 7 && i != 5) {
                assertTrue(nestedNav.navItemLink.get(i).hasClass("nav-link"));
                assertFalse(nestedNav.navItemLink.get(i).hasClass("active"));
            }
        }

        nestedNav.navItemLink.get(7).is()
                .core()
                .displayed()
                .enabled()
                .cssClass("nav-link ml-3 my-1 active");

        nestedNav.navItemLink.get(5).is()
                .core()
                .displayed()
                .enabled()
                .cssClass("nav-link active");

        nestedNav.navItemLink.get(7).unhighlight();
    }*/

/*    @Test(dataProvider = "itemsCheck")
    public void paragraphClickableTests(int index) {
        refresh();
        scrollspyWithNestedNav.mainText.get(index).highlight();
        scrollspyWithNestedNav.mainText.get(index).show();

        if (!nestedNav.navItemLink.get(index).core().hasClass("active") &&
                index < nestedNav.navItemLink.size())
            scrollspyWithNestedNav.header.get(index+1).show();

        assertTrue(nestedNav.navItemLink.get(index).hasClass("active"));
        nestedNav.navItemLink.get(index).unhighlight();
    }*/

/*    @Test
    public void baseValidationTest() {
        baseValidation(scrollspyWithNestedNav);
        baseValidation(nestedNav);
    }*/

}
