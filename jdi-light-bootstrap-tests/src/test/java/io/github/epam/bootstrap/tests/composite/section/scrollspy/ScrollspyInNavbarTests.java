package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarWithDropdown;
import static io.github.com.pages.BootstrapPage.scrollspyInNavbar;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.bootstrap.tests.composite.section.navs.ClickVerification.newWindowTitleCheck;
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

    private String paragraphFat = "fat";
    private String paragraphMdo = "mdo";
    private String dropdown = "Dropdown";

    private String paragraphOne = "one";
    private String paragraphTwo = "two";
    private String paragraphThree = "three";

    private String headerFat = "fat";
    private String headerMdo = "mdo";
    private String headerOne = "one";
    private String headerTwo = "two";
    private String headerThree = "three";

    private String mainTextFat = "Ad leggings keytar, brunch id art party dolor labore. Pitchfork yr enim lo-fi before they sold out qui. Tumblr farm-to-table bicycle rights whatever. Anim keffiyeh carles cardigan. Velit seitan mcsweeney's photo booth 3 wolf moon irure. Cosby sweater lomo jean shorts, williamsburg hoodie minim qui you probably haven't heard of them et cardigan trust fund culpa biodiesel wes anderson aesthetic. Nihil tattooed accusamus, cred irony biodiesel keffiyeh artisan ullamco consequat.";
    private String mainTextMdo = "Veniam marfa mustache skateboard, adipisicing fugiat velit pitchfork beard. Freegan beard aliqua cupidatat mcsweeney's vero. Cupidatat four loko nisi, ea helvetica nulla carles. Tattooed cosby sweater food truck, mcsweeney's quis non freegan vinyl. Lo-fi wes anderson +1 sartorial. Carles non aesthetic exercitation quis gentrify. Brooklyn adipisicing craft beer vice keytar deserunt.";
    private String mainTextOne = "Occaecat commodo aliqua delectus. Fap craft beer deserunt skateboard ea. Lomo bicycle rights adipisicing banh mi, velit ea sunt next level locavore single-origin coffee in magna veniam. High life id vinyl, echo park consequat quis aliquip banh mi pitchfork. Vero VHS est adipisicing. Consectetur nisi DIY minim messenger bag. Cred ex in, sustainable delectus consectetur fanny pack iphone.";
    private String mainTextTwo = "In incididunt echo park, officia deserunt mcsweeney's proident master cleanse thundercats sapiente veniam. Excepteur VHS elit, proident shoreditch +1 biodiesel laborum craft beer. Single-origin coffee wayfarers irure four loko, cupidatat terry richardson master cleanse. Assumenda you probably haven't heard of them art party fanny pack, tattooed nulla cardigan tempor ad. Proident wolf nesciunt sartorial keffiyeh eu banh mi sustainable. Elit wolf voluptate, lo-fi ea portland before they sold out four loko. Locavore enim nostrud mlkshk brooklyn nesciunt.";
    private String mainTextThree = "Ad leggings keytar, brunch id art party dolor labore. Pitchfork yr enim lo-fi before they sold out qui. Tumblr farm-to-table bicycle rights whatever. Anim keffiyeh carles cardigan. Velit seitan mcsweeney's photo booth 3 wolf moon irure. Cosby sweater lomo jean shorts, williamsburg hoodie minim qui you probably haven't heard of them et cardigan trust fund culpa biodiesel wes anderson aesthetic. Nihil tattooed accusamus, cred irony biodiesel keffiyeh artisan ullamco consequat. Keytar twee blog, culpa messenger bag marfa whatever delectus food truck. Sapiente synth id assumenda. Locavore sed helvetica cliche irony, thundercats you probably haven't heard of them consequat hoodie gluten-free lo-fi fap aliquip. Labore elit placeat before they sold out, terry richardson proident brunch nesciunt quis cosby sweater pariatur keffiyeh ut helvetica artisan. Cardigan craft beer seitan readymade velit. VHS chambray laboris tempor veniam. Anim mollit minim commodo ullamco thundercats.";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        refresh();
    }

    @DataProvider
    public Object[][] navMenu() {
        return new Object[][]{
                {1, itemLink + paragraphFat, "@" + headerFat, paragraphFat, mainTextFat},
                {2, itemLink + paragraphMdo, "@" + headerMdo, paragraphMdo, mainTextMdo},
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
                {1, headerFat}, {2, headerMdo}, {3, headerOne}, {4, headerTwo}, {5, headerThree}
        };
    }

    @Test(dataProvider = "navMenu", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        if (index < 3) {
            navbarWithDropdown.navItemLink.get(index).is()
                    .core()
                    .displayed()
                    .enabled()
                    .text(is(header))
                    .value(is(header))
                    .attr("href", is(link));
        }
        if (index >= 3) {
            navbarWithDropdown.dropdownMenu.expand();
            navbarWithDropdown.dropdownMenu.list().get(header).is()
                    .core()
                    .displayed()
                    .enabled()
                    .text(is(header))
                    .value(is(header))
                    .attr("href", is(link));
        }
        scrollspyInNavbar.header.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr("id", is(paragraph));

        scrollspyInNavbar.mainText.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));
    }

    @Test
    public void isValidationTests() {
        navbarWithDropdown.navItemLink.get(3).is().text(dropdown);
        navbarWithDropdown.navItemLink.get(3).is().value(dropdown);
        navbarWithDropdown.navItemLink.is().size(3);
        navbarWithDropdown.navGroup.is().size(3);

        navbarWithDropdown.dropdownMenu.expand();
        navbarWithDropdown.dropdownMenu.is().size(3);

        navbarWithDropdown.find(By.className("dropdown-divider")).is()
                .core()
                .displayed()
                .enabled()
                .attr("role", "separator");

        scrollspyInNavbar.mainText.is().size(5);
        scrollspyInNavbar.header.is().size(5);

        navbarWithDropdown.navbarLink.is()
                .core()
                .displayed()
                .enabled()
                .attr("href", is(navbarLink))
                .value(is(navbarText))
                .text(is(navbarText))
                .cssClass("navbar-brand");

        for (UIElement element : navbarWithDropdown.navGroup.list()) {
            element.is()
                    .core()
                    .displayed()
                    .enabled()
                    .hasClass("nav-item");
        }

        scrollspyInNavbar.is()
                .core()
                .displayed()
                .enabled()
                .attr("data-spy", is("scroll"))
                .attr("data-target", is("#navbar-example2"))
                .attr("data-offset", is("0"))
                .cssClass("scrollspy-example");
    }

    @Test(dataProvider = "itemsCheck")
    public void linkClickableFocusTests(int index, String header) {
        navbarWithDropdown.dropdownMenu.expand();
        navbarWithDropdown.navItemLink.get(1).click();
        navbarWithDropdown.dropdownMenu.expand();

        int y_header_start = scrollspyInNavbar.header.get(1).core().getRect().y;
        if (index < 3)
            navbarWithDropdown.navItemLink.get(index).click();
        else
            navbarWithDropdown.dropdownMenu.list().get(header).click();

        int y_header_current = scrollspyInNavbar.header.get(index).core().getRect().y;
        assertThat(y_header_start, is(y_header_current));
    }

/*   @Test
    public void highlightFocusedItemsTests() {
       navbarWithDropdown.dropdownMenu.expand();

       navbarWithDropdown.navItemLink.get(7).highlight();
       navbarWithDropdown.navItemLink.get(7).click();

        for (int i = 1; i <= nestedNav.navItemLink.size(); i++) {
            if (i != 7 && i != 5) {
                assertTrue(nestedNav.navItemLink.get(i).hasClass("nav-link"));
                assertFalse(nestedNav.navItemLink.get(i).hasClass("active"));
            }
        }

        navbarWithDropdown.navItemLink.get(7).is()
                .core()
                .displayed()
                .enabled()
                .cssClass("nav-link ml-3 my-1 active");

        navbarWithDropdown.navItemLink.get(5).is()
                .core()
                .displayed()
                .enabled()
                .cssClass("nav-link active");

        navbarWithDropdown.navItemLink.get(7).unhighlight();
    }*/

   @Test(dataProvider = "itemsCheck")
        public void paragraphClickableTests(int index, String header) {
            scrollspyInNavbar.mainText.get(index).highlight();
            scrollspyInNavbar.mainText.get(index).show();

            if (!navbarWithDropdown.navItemLink.get(index).core().hasClass("active") &&
                    index < navbarWithDropdown.navItemLink.size())
                scrollspyInNavbar.header.get(index+1).show();

            assertTrue(navbarWithDropdown.navItemLink.get(index).hasClass("active"));
            navbarWithDropdown.navItemLink.get(index).unhighlight();
        }

    @Test
    public void navbarLinkClickableTests() {
        navbarWithDropdown.navbarLink.click();
        newWindowTitleCheck(pageTitle);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(scrollspyInNavbar);
        baseValidation(navbarWithDropdown);
    }
}