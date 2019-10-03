package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupForScrollspy;
import static io.github.com.pages.BootstrapPage.scrollspyWithListGroup;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Olga Ivanova on 01.10.2019
 * Email: olga_ivanova@epam.com;
 */

public class ScrollspyWithListGroupTests extends TestsInit {
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

    @Test(dataProvider = "listData", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        refresh();
        listGroupForScrollspy.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .attr("href", is(link))
                .value(is(header))
                .text(is(header));

        if (index == 1) listGroupForScrollspy.get(index)
                .is()
                .cssClass("list-group-item list-group-item-action active")
                .css("background-color", "rgba(0, 123, 255, 1)") //#007bff Color Hex
                .css("border-color", "rgb(0, 123, 255)"); //#007bff Color Hex
        else listGroupForScrollspy.get(index)
                .is()
                .cssClass("list-group-item list-group-item-action")
                .css("background-color", "rgba(255, 255, 255, 1)"); //#fff Color Hex

        scrollspyWithListGroup.is()
                .core()
                .displayed()
                .enabled()
                .attr("data-spy", is("scroll"))
                .attr("data-target", is("#list-example"))
                .attr("data-offset", is("0"))
                .cssClass("scrollspy-example");

        scrollspyWithListGroup.header.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr("id", is(paragraph));

        scrollspyWithListGroup.mainText.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));
    }

    @Test
    public void isValidationTests() {
        scrollspyWithListGroup.header.is()
                .size(4);
        scrollspyWithListGroup.mainText.is()
                .size(4);
            listGroupForScrollspy.is()
                .size(4);
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableTests(int index, String paragraph, String header, String mainText) {
        refresh();
        int y_Start = scrollspyWithListGroup.header.get(1).core().getLocation().y + 4;
        listGroupForScrollspy.get(index).highlight();
        listGroupForScrollspy.get(index).click();

        int y_Current = scrollspyWithListGroup.header.get(index).core().getLocation().y;

        listGroupForScrollspy.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .cssClass("list-group-item list-group-item-action active")
                .css("background-color", "rgba(0, 123, 255, 1)");//#007bff Color Hex
        scrollspyWithListGroup.header.get(index).is()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .core().attr("id", is(paragraph));

        scrollspyWithListGroup.mainText.get(index).is()
                .text(is(mainText))
                .value(is(mainText));

        assertEquals(y_Start, y_Current);
        listGroupForScrollspy.get(index).unhighlight();
    }

    @Test(dataProvider = "clickValidate")
    public void paragraphClickableTests(int index, String paragraph, String header, String mainText) {
        refresh();
        scrollspyWithListGroup.mainText.get(index).highlight();
        scrollspyWithListGroup.mainText.get(index).show();

       if (listGroupForScrollspy.get(index).core().hasClass("list-group-item list-group-item-action"))
           scrollspyWithListGroup.header.get(index+1).show();

        listGroupForScrollspy.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .cssClass("list-group-item list-group-item-action active")
                .css("background-color", "rgba(0, 123, 255, 1)")//#007bff Color Hex
                .css("border-color", "rgb(0, 123, 255)");//#007bff Color Hex

        listGroupForScrollspy.get(index).unhighlight();
    }

    public void baseValidationTest() {
        baseValidation(scrollspyWithListGroup);
        baseValidation(listGroupForScrollspy);
    }
}
