package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupForScrollSpy;
import static io.github.com.pages.BootstrapPage.scrollSpyWithListGroup;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Olga Ivanova on 01.10.2019
 * Email: olga_ivanova@epam.com;
 */

public class ScrollSpyWithListGroupTests extends TestsInit {
    public static final String ATTR_NAME_HREF = "href";
    public static final String ATTR_NAME_DATA_SPY = "data-spy";
    public static final String ATTR_NAME_DATA_TARGET = "data-target";
    public static final String ATTR_NAME_DATA_OFFSET = "data-offset";
    public static final String ATTR_NAME_ID = "id";
    public static final String CLASS_NAME_LIST_GROUP_ITEM_LIST_GROUP_ITEM_ACTION_ACTIVE = "list-group-item list-group-item-action active";
    public static final String CLASS_NAME_LIST_GROUP_ITEM_LIST_GROUP_ITEM_ACTION = "list-group-item list-group-item-action";
    public static final String CLASS_NAME_SCROLLSPY_EXAMPLE = "scrollspy-example";
    public static final String CLASS_NAME_ACTIVE = "active";
    public static final String CSS_NAME_BACKGROUND_COLOR = "background-color";
    public static final String CSS_NAME_BORDER_COLOR = "border-color";
    public static final String ATTR_VALUE_SCROLL = "scroll";
    public static final String ATTR_VALUE_LIST_EXAMPLE = "#list-example";
    public static final String ATRR_VALUE_0 = "0";
    private String itemLink = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private String paragraphN1 = "list-item-1";
    private String paragraphN2 = "list-item-2";
    private String paragraphN3 = "list-item-3";
    private String paragraphN4 = "list-item-4";
    private String header1 = "Item 1";
    private String header2 = "Item 2";
    private String header3 = "Item 3";
    private String header4 = "Item 4";
    private String mainText1 = "Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur labore. Fugiat laborum incididunt tempor eu consequat enim dolore proident. Qui laborum do non excepteur nulla magna eiusmod consectetur in. Aliqua et aliqua officia quis et incididunt voluptate non anim reprehenderit adipisicing dolore ut consequat deserunt mollit dolore. Aliquip nulla enim veniam non fugiat id cupidatat nulla elit cupidatat commodo velit ut eiusmod cupidatat elit dolore.";
    private String mainText2 = "Quis magna Lorem anim amet ipsum do mollit sit cillum voluptate ex nulla tempor. Laborum consequat non elit enim exercitation cillum aliqua consequat id aliqua. Esse ex consectetur mollit voluptate est in duis laboris ad sit ipsum anim Lorem. Incididunt veniam velit elit elit veniam Lorem aliqua quis ullamco deserunt sit enim elit aliqua esse irure. Laborum nisi sit est tempor laborum mollit labore officia laborum excepteur commodo non commodo dolor excepteur commodo. Ipsum fugiat ex est consectetur ipsum commodo tempor sunt in proident.";
    private String mainText3 = "Quis anim sit do amet fugiat dolor velit sit ea ea do reprehenderit culpa duis. Nostrud aliqua ipsum fugiat minim proident occaecat excepteur aliquip culpa aute tempor reprehenderit. Deserunt tempor mollit elit ex pariatur dolore velit fugiat mollit culpa irure ullamco est ex ullamco excepteur.";
    private String mainText4 = "Quis anim sit do amet fugiat dolor velit sit ea ea do reprehenderit culpa duis. Nostrud aliqua ipsum fugiat minim proident occaecat excepteur aliquip culpa aute tempor reprehenderit. Deserunt tempor mollit elit ex pariatur dolore velit fugiat mollit culpa irure ullamco est ex ullamco excepteur.. Deserunt tempor mollit elit ex pariatur dolore velit fugiat mollit culpa irure ullamco est ex ullamco excepteur.";

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
                {2, itemLink + paragraphN2, header2, paragraphN2, mainText2},
                {3, itemLink + paragraphN3, header3, paragraphN3, mainText3},
                {4, itemLink + paragraphN4, header4, paragraphN4, mainText4}
        };
    }

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, paragraphN1, header1, mainText1},
                {2, paragraphN2, header2, mainText2},
                {3, paragraphN3, header3, mainText3},
                {4, paragraphN4, header4, mainText4}
        };
    }

    @DataProvider
    public Object[][] itemsCheck() {
        return new Object[][]{
                {1}, {2}, {3}, {4}
        };
    }

    @Test(dataProvider = "listData", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        listGroupForScrollSpy.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_HREF, is(link))
                .value(is(header))
                .text(is(header));

        if (index == 1) {
            listGroupForScrollSpy.get(index)
                    .is()
                    .cssClass(CLASS_NAME_LIST_GROUP_ITEM_LIST_GROUP_ITEM_ACTION_ACTIVE)
                    .css(CSS_NAME_BACKGROUND_COLOR, "rgba(0, 123, 255, 1)") //#007bff Color Hex
                    .css(CSS_NAME_BORDER_COLOR, "rgb(0, 123, 255)"); //#007bff Color Hex
        }
        else {
            listGroupForScrollSpy.get(index)
                    .is()
                    .cssClass(CLASS_NAME_LIST_GROUP_ITEM_LIST_GROUP_ITEM_ACTION)
                    .css(CSS_NAME_BACKGROUND_COLOR, "rgba(255, 255, 255, 1)"); //#fff Color Hex
        }

        scrollSpyWithListGroup.is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_DATA_SPY, is(ATTR_VALUE_SCROLL))
                .attr(ATTR_NAME_DATA_TARGET, is(ATTR_VALUE_LIST_EXAMPLE))
                .attr(ATTR_NAME_DATA_OFFSET, is(ATRR_VALUE_0))
                .cssClass(CLASS_NAME_SCROLLSPY_EXAMPLE);

        scrollSpyWithListGroup.header.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr(ATTR_NAME_ID, is(paragraph));

        scrollSpyWithListGroup.mainText.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));
    }

    @Test
    public void isValidationTests() {
        scrollSpyWithListGroup.header.is().size(4);
        scrollSpyWithListGroup.mainText.is().size(4);
        listGroupForScrollSpy.is().size(4);
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableTests(int index, String paragraph, String header, String mainText) {
        int y_Start = scrollSpyWithListGroup.header.get(1).core().getLocation().y + 4;
        listGroupForScrollSpy.get(index).highlight();
        listGroupForScrollSpy.get(index).click();

        int y_Current = scrollSpyWithListGroup.header.get(index).core().getLocation().y;

        listGroupForScrollSpy.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .cssClass(ScrollSpyWithListGroupTests.CLASS_NAME_LIST_GROUP_ITEM_LIST_GROUP_ITEM_ACTION_ACTIVE)
                .css(ScrollSpyWithListGroupTests.CSS_NAME_BACKGROUND_COLOR, "rgba(0, 123, 255, 1)");//#007bff Color Hex

        scrollSpyWithListGroup.header.get(index).is()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .core().attr(ATTR_NAME_ID, is(paragraph));

        scrollSpyWithListGroup.mainText.get(index).is()
                .text(is(mainText))
                .value(is(mainText));

        assertEquals(y_Start, y_Current);
        listGroupForScrollSpy.get(index).unhighlight();
    }

    @Test(dataProvider = "itemsCheck")
    public void paragraphClickableTests(int index) {
        scrollSpyWithListGroup.mainText.get(index).highlight();

        scrollSpyWithListGroup.scrollParagraph(listGroupForScrollSpy, index, CLASS_NAME_ACTIVE);

        listGroupForScrollSpy.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .cssClass(CLASS_NAME_LIST_GROUP_ITEM_LIST_GROUP_ITEM_ACTION_ACTIVE)
                .css(CSS_NAME_BACKGROUND_COLOR, "rgba(0, 123, 255, 1)")//#007bff Color Hex
                .css(CSS_NAME_BORDER_COLOR, "rgb(0, 123, 255)");//#007bff Color Hex

        listGroupForScrollSpy.get(index).unhighlight();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(scrollSpyWithListGroup);
        for (UIElement element : listGroupForScrollSpy.list()) {
            baseValidation(element);
        }
    }
}
