package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.nestedNav;
import static io.github.com.pages.BootstrapPage.scrollSpyWithNestedNav;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.bootstrap.tests.composite.section.navs.ClickVerification.newWindowTitleCheck;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class ScrollspyWithNestedNavTests extends TestsInit {
    public static final String ATTR_NAME_HREF = "href";
    public static final String ATTR_NAME_ID = "id";
    public static final String ATTR_NAME_DATA_SPY = "data-spy";
    public static final String ATTR_NAME_DATA_TARGET = "data-target";
    public static final String ATTR_NAME_DATA_OFFSET = "data-offset";
    public static final String CLASS_NAME_NAVBAR_BRAND = "navbar-brand";
    public static final String CLASS_NAME_NAV_NAV_PILLS_FLEX_COLUMN = "nav nav-pills flex-column";
    public static final String CLASS_NAME_SCROLLSPY_EXAMPLE_2 = "scrollspy-example-2";
    public static final String CLASS_NAME_ACTIVE = "active";
    public static final String CLASS_NAME_NAV_LINK = "nav-link";
    public static final String CLASS_NAME_NAV_LINK_ACTIVE = "nav-link active";
    public static final String CLASS_NAME_NAV_LINK_ML_3_MY_1_ACTIVE = "nav-link ml-3 my-1 active";
    public static final String CLASS_NAME_NAV_LINK_ML_3_MY_1 = "nav-link ml-3 my-1";
    public static final String ATTR_VALUE_SCROLL = "scroll";
    public static final String ATTR_VALUE_NAVBAR_EXAMPLE_3 = "#navbar-example3";
    public static final String ATTR_VALUE_0 = "0";

    private String itemLink = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private String navbarLink = "https://getbootstrap.com/docs/4.3/components/scrollspy/#example-with-nested-nav";
    private String navbarText = "Navbar";
    private String pageTitle = "Scrollspy · Bootstrap";
    private String paragraphN1 = "item-1";
    private String paragraphN11 = "item-1-1";
    private String paragraphN12 = "item-1-2";
    private String paragraphN2 = "item-2";
    private String paragraphN3 = "item-3";
    private String paragraphN31 = "item-3-1";
    private String paragraphN32 = "item-3-2";
    private String header1 = "Item 1";
    private String header11 = "Item 1-1";
    private String header12 = "Item 1-2";
    private String header2 = "Item 2";
    private String header3 = "Item 3";
    private String header31 = "Item 3-1";
    private String header32 = "Item 3-2";
    private String mainText1 = "Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur labore. Fugiat laborum incididunt tempor eu consequat enim dolore proident. Qui laborum do non excepteur nulla magna eiusmod consectetur in. Aliqua et aliqua officia quis et incididunt voluptate non anim reprehenderit adipisicing dolore ut consequat deserunt mollit dolore. Aliquip nulla enim veniam non fugiat id cupidatat nulla elit cupidatat commodo velit ut eiusmod cupidatat elit dolore.";
    private String mainText11 = "Amet tempor mollit aliquip pariatur excepteur commodo do ea cillum commodo Lorem et occaecat elit qui et. Aliquip labore ex ex esse voluptate occaecat Lorem ullamco deserunt. Aliqua cillum excepteur irure consequat id quis ea. Sit proident ullamco aute magna pariatur nostrud labore. Reprehenderit aliqua commodo eiusmod aliquip est do duis amet proident magna consectetur consequat eu commodo fugiat non quis. Enim aliquip exercitation ullamco adipisicing voluptate excepteur minim exercitation minim minim commodo adipisicing exercitation officia nisi adipisicing. Anim id duis qui consequat labore adipisicing sint dolor elit cillum anim et fugiat.";
    private String mainText12 = "Cillum nisi deserunt magna eiusmod qui eiusmod velit voluptate pariatur laborum sunt enim. Irure laboris mollit consequat incididunt sint et culpa culpa incididunt adipisicing magna magna occaecat. Nulla ipsum cillum eiusmod sint elit excepteur ea labore enim consectetur in labore anim. Proident ullamco ipsum esse elit ut Lorem eiusmod dolor et eiusmod. Anim occaecat nulla in non consequat eiusmod velit incididunt.";
    private String mainText2 = "Quis magna Lorem anim amet ipsum do mollit sit cillum voluptate ex nulla tempor. Laborum consequat non elit enim exercitation cillum aliqua consequat id aliqua. Esse ex consectetur mollit voluptate est in duis laboris ad sit ipsum anim Lorem. Incididunt veniam velit elit elit veniam Lorem aliqua quis ullamco deserunt sit enim elit aliqua esse irure. Laborum nisi sit est tempor laborum mollit labore officia laborum excepteur commodo non commodo dolor excepteur commodo. Ipsum fugiat ex est consectetur ipsum commodo tempor sunt in proident.";
    private String mainText3 = "Quis anim sit do amet fugiat dolor velit sit ea ea do reprehenderit culpa duis. Nostrud aliqua ipsum fugiat minim proident occaecat excepteur aliquip culpa aute tempor reprehenderit. Deserunt tempor mollit elit ex pariatur dolore velit fugiat mollit culpa irure ullamco est ex ullamco excepteur.";
    private String mainText31 = "Deserunt quis elit Lorem eiusmod amet enim enim amet minim Lorem proident nostrud. Ea id dolore anim exercitation aute fugiat labore voluptate cillum do laboris labore. Ex velit exercitation nisi enim labore reprehenderit labore nostrud ut ut. Esse officia sunt duis aliquip ullamco tempor eiusmod deserunt irure nostrud irure. Ullamco proident veniam laboris ea consectetur magna sunt ex exercitation aliquip minim enim culpa occaecat exercitation. Est tempor excepteur aliquip laborum consequat do deserunt laborum esse eiusmod irure proident ipsum esse qui.";
    private String mainText32 = "Labore sit culpa commodo elit adipisicing sit aliquip elit proident voluptate minim mollit nostrud aute reprehenderit do. Mollit excepteur eu Lorem ipsum anim commodo sint labore Lorem in exercitation velit incididunt. Occaecat consectetur nisi in occaecat proident minim enim sunt reprehenderit exercitation cupidatat et do officia. Aliquip consequat ad labore labore mollit ut amet. Sit pariatur tempor proident in veniam culpa aliqua excepteur elit magna fugiat eiusmod amet officia.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        refresh();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, itemLink + paragraphN1, header1, paragraphN1, mainText1},
                {2, itemLink + paragraphN11, header11, paragraphN11, mainText11},
                {3, itemLink + paragraphN12, header12, paragraphN12, mainText12},
                {4, itemLink + paragraphN2, header2, paragraphN2, mainText2},
                {5, itemLink + paragraphN3, header3, paragraphN3, mainText3},
                {6, itemLink + paragraphN31, header31, paragraphN31, mainText31},
                {7, itemLink + paragraphN32, header32, paragraphN32, mainText32}
        };
    }

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, paragraphN1, header1, mainText1},
                {2, paragraphN11, header11, mainText11},
                {3, paragraphN12, header12, mainText12},
                {4, paragraphN2, header2, mainText2},
                {5, paragraphN3, header3, mainText3},
                {6, paragraphN31, header31, mainText31},
                {7, paragraphN32, header32, mainText32}
        };
    }

    @DataProvider
    public Object[][] focusCheck() {
        return new Object[][]{
                {1, 1, CLASS_NAME_NAV_LINK_ACTIVE, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1, 4, CLASS_NAME_NAV_LINK, 5, CLASS_NAME_NAV_LINK, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1},
                {2, 1, CLASS_NAME_NAV_LINK_ACTIVE, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1_ACTIVE, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1, 4, CLASS_NAME_NAV_LINK, 5, CLASS_NAME_NAV_LINK, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1},
                {3, 1, CLASS_NAME_NAV_LINK_ACTIVE, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1_ACTIVE, 4, CLASS_NAME_NAV_LINK, 5, CLASS_NAME_NAV_LINK, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1},
                {4, 1, CLASS_NAME_NAV_LINK, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1, 4, CLASS_NAME_NAV_LINK_ACTIVE, 5, CLASS_NAME_NAV_LINK, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1},
                {5, 1, CLASS_NAME_NAV_LINK, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1, 4, CLASS_NAME_NAV_LINK, 5, CLASS_NAME_NAV_LINK_ACTIVE, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1},
                {6, 1, CLASS_NAME_NAV_LINK, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1, 4, CLASS_NAME_NAV_LINK, 5, CLASS_NAME_NAV_LINK_ACTIVE, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1_ACTIVE, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1},
                {7, 1, CLASS_NAME_NAV_LINK, 2, CLASS_NAME_NAV_LINK_ML_3_MY_1, 3, CLASS_NAME_NAV_LINK_ML_3_MY_1, 4, CLASS_NAME_NAV_LINK, 5, CLASS_NAME_NAV_LINK_ACTIVE, 6, CLASS_NAME_NAV_LINK_ML_3_MY_1, 7, CLASS_NAME_NAV_LINK_ML_3_MY_1_ACTIVE}
        };
    }
    @DataProvider
    public Object[][] itemsCheck() {
        return new Object[][]{
                {1}, {2}, {3}, {4}, {5}, {6}, {7}
        };
    }

    @Test(dataProvider = "listData", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        nestedNav.navItemLink.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(header))
                .value(is(header))
                .attr(ATTR_NAME_HREF, is(link));

        scrollSpyWithNestedNav.header.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr(ATTR_NAME_ID, is(paragraph));

        scrollSpyWithNestedNav.mainText.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));
    }

    @Test
    public void isValidationTests() {
        nestedNav.navItemLink.is().size(7);
        nestedNav.navGroup.is().size(3);
        scrollSpyWithNestedNav.mainText.is().size(7);
        scrollSpyWithNestedNav.header.is().size(7);

        nestedNav.navbarLink.is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_HREF, is(navbarLink))
                .value(is(navbarText))
                .text(is(navbarText))
                .cssClass(CLASS_NAME_NAVBAR_BRAND);

        for (UIElement element : nestedNav.navGroup.list()) {
            element.is()
                    .core()
                    .displayed()
                    .enabled()
                    .cssClass(CLASS_NAME_NAV_NAV_PILLS_FLEX_COLUMN);
        }

        scrollSpyWithNestedNav.is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_DATA_SPY, is(ATTR_VALUE_SCROLL))
                .attr(ATTR_NAME_DATA_TARGET, is(ATTR_VALUE_NAVBAR_EXAMPLE_3))
                .attr(ATTR_NAME_DATA_OFFSET, is(ATTR_VALUE_0))
                .cssClass(CLASS_NAME_SCROLLSPY_EXAMPLE_2);
    }

    @Test(dataProvider = "itemsCheck")
    public void linkClickableFocusTests(int index) {
        nestedNav.navItemLink.get(1).click();

        int y_header_start = scrollSpyWithNestedNav.header.get(1).core().getRect().y;

        nestedNav.navItemLink.get(index).highlight();
        nestedNav.navItemLink.get(index).click();

        int y_header_current = scrollSpyWithNestedNav.header.get(index).core().getRect().y;

        if (index != 7) {
            assertThat(y_header_start, is(y_header_current - 6));
        } else {
            assertThat(y_header_start, is(y_header_current - 92));
        }

        nestedNav.navItemLink.get(index).unhighlight();
    }


    @Test(dataProvider = "focusCheck")
    public void highlightFocusedItemsTests(int itemToClick,
                                           int index_1, String class_1,
                                           int index_2, String class_2,
                                           int index_3, String class_3,
                                           int index_4, String class_4,
                                           int index_5, String class_5,
                                           int index_6, String class_6,
                                           int index_7, String class_7) {
        List<Integer> elementsIndex = Arrays.asList(index_1, index_2, index_3, index_4, index_5, index_6, index_7);
        List<String> elementsClass = Arrays.asList(class_1, class_2, class_3, class_4, class_5, class_6, class_7);
        int classIndex = 0;

        nestedNav.navItemLink.get(itemToClick).highlight();
        nestedNav.navItemLink.get(itemToClick).click();

        for (int elIndex : elementsIndex) {
            nestedNav.navItemLink.get(elIndex).is()
                    .core()
                    .displayed()
                    .enabled()
                    .cssClass(elementsClass.get(classIndex));
            classIndex++;
        }

        nestedNav.navItemLink.get(itemToClick).unhighlight();
    }

    @Test(dataProvider = "itemsCheck")
    public void paragraphClickableTests(int index) {
        scrollSpyWithNestedNav.mainText.get(index).highlight();

        scrollSpyWithNestedNav.scrollParagraph(nestedNav.navItemLink, index, CLASS_NAME_ACTIVE);

        assertTrue(nestedNav.navItemLink.get(index).hasClass(CLASS_NAME_ACTIVE));
        nestedNav.navItemLink.get(index).unhighlight();
    }

    @Test
    public void navbarLinkClickableTests() {
        nestedNav.navbarLink.click();
        newWindowTitleCheck(pageTitle);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(scrollSpyWithNestedNav);
        baseValidation(nestedNav);
    }
}
