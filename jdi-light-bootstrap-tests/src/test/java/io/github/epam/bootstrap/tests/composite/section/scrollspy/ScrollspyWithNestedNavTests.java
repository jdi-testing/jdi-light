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

public class ScrollspyWithNestedNavTests extends TestsInit {
    private String itemLink = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private String navbar = "";
    private String paragraphN1 = "item-1";
    private String paragraphN2 = "item-1-1";
    private String paragraphN3 = "item-1-2";
    private String paragraphN4 = "item-2";
    private String paragraphN5 = "item-3";
    private String paragraphN6 = "item-3-1";
    private String paragraphN7 = "item-3-2";
    private String header1 = "Item 1";
    private String header2 = "Item 1-1";
    private String header3 = "Item 1-2";
    private String header4 = "Item 2";
    private String header5 = "Item 3";
    private String header6 = "Item 3-1";
    private String header7 = "Item 3-2";
    private String mainText1 = "Ex consequat commodo adipisicing exercitation aute\n" +
            "\t\t\t\t\t\t\t\t\texcepteur occaecat ullamco duis aliqua id magna ullamco eu. Do\n" +
            "\t\t\t\t\t\t\t\t\taute ipsum ipsum ullamco cillum consectetur ut et aute\n" +
            "\t\t\t\t\t\t\t\t\tconsectetur labore. Fugiat laborum incididunt tempor eu\n" +
            "\t\t\t\t\t\t\t\t\tconsequat enim dolore proident. Qui laborum do non excepteur\n" +
            "\t\t\t\t\t\t\t\t\tnulla magna eiusmod consectetur in. Aliqua et aliqua officia\n" +
            "\t\t\t\t\t\t\t\t\tquis et incididunt voluptate non anim reprehenderit adipisicing\n" +
            "\t\t\t\t\t\t\t\t\tdolore ut consequat deserunt mollit dolore. Aliquip nulla enim\n" +
            "\t\t\t\t\t\t\t\t\tveniam non fugiat id cupidatat nulla elit cupidatat commodo\n" +
            "\t\t\t\t\t\t\t\t\tvelit ut eiusmod cupidatat elit dolore.";
    private String mainText2 = "Ex consequat commodo adipisicing exercitation aute\n" +
            "\t\t\t\t\t\t\t\t\texcepteur occaecat ullamco duis aliqua id magna ullamco eu. Do\n" +
            "\t\t\t\t\t\t\t\t\taute ipsum ipsum ullamco cillum consectetur ut et aute\n" +
            "\t\t\t\t\t\t\t\t\tconsectetur labore. Fugiat laborum incididunt tempor eu\n" +
            "\t\t\t\t\t\t\t\t\tconsequat enim dolore proident. Qui laborum do non excepteur\n" +
            "\t\t\t\t\t\t\t\t\tnulla magna eiusmod consectetur in. Aliqua et aliqua officia\n" +
            "\t\t\t\t\t\t\t\t\tquis et incididunt voluptate non anim reprehenderit adipisicing\n" +
            "\t\t\t\t\t\t\t\t\tdolore ut consequat deserunt mollit dolore. Aliquip nulla enim\n" +
            "\t\t\t\t\t\t\t\t\tveniam non fugiat id cupidatat nulla elit cupidatat commodo\n" +
            "\t\t\t\t\t\t\t\t\tvelit ut eiusmod cupidatat elit dolore.";
    private String mainText3 = "Cillum nisi deserunt magna eiusmod qui eiusmod velit\n" +
            "\t\t\t\t\t\t\t\t\tvoluptate pariatur laborum sunt enim. Irure laboris mollit\n" +
            "\t\t\t\t\t\t\t\t\tconsequat incididunt sint et culpa culpa incididunt adipisicing\n" +
            "\t\t\t\t\t\t\t\t\tmagna magna occaecat. Nulla ipsum cillum eiusmod sint elit\n" +
            "\t\t\t\t\t\t\t\t\texcepteur ea labore enim consectetur in labore anim. Proident\n" +
            "\t\t\t\t\t\t\t\t\tullamco ipsum esse elit ut Lorem eiusmod dolor et eiusmod. Anim\n" +
            "\t\t\t\t\t\t\t\t\toccaecat nulla in non consequat eiusmod velit incididunt.";
    private String mainText4 = "Quis magna Lorem anim amet ipsum do mollit sit cillum\n" +
            "\t\t\t\t\t\t\t\t\tvoluptate ex nulla tempor. Laborum consequat non elit enim\n" +
            "\t\t\t\t\t\t\t\t\texercitation cillum aliqua consequat id aliqua. Esse ex\n" +
            "\t\t\t\t\t\t\t\t\tconsectetur mollit voluptate est in duis laboris ad sit ipsum\n" +
            "\t\t\t\t\t\t\t\t\tanim Lorem. Incididunt veniam velit elit elit veniam Lorem\n" +
            "\t\t\t\t\t\t\t\t\taliqua quis ullamco deserunt sit enim elit aliqua esse irure.\n" +
            "\t\t\t\t\t\t\t\t\tLaborum nisi sit est tempor laborum mollit labore officia\n" +
            "\t\t\t\t\t\t\t\t\tlaborum excepteur commodo non commodo dolor excepteur commodo.\n" +
            "\t\t\t\t\t\t\t\t\tIpsum fugiat ex est consectetur ipsum commodo tempor sunt in\n" +
            "\t\t\t\t\t\t\t\t\tproident.";
    private String mainText5 = "Quis anim sit do amet fugiat dolor velit sit ea ea do\n" +
            "\t\t\t\t\t\t\t\t\treprehenderit culpa duis. Nostrud aliqua ipsum fugiat minim\n" +
            "\t\t\t\t\t\t\t\t\tproident occaecat excepteur aliquip culpa aute tempor\n" +
            "\t\t\t\t\t\t\t\t\treprehenderit. Deserunt tempor mollit elit ex pariatur dolore\n" +
            "\t\t\t\t\t\t\t\t\tvelit fugiat mollit culpa irure ullamco est ex ullamco\n" +
            "\t\t\t\t\t\t\t\t\texcepteur.";
    private String mainText6 = "Deserunt quis elit Lorem eiusmod amet enim enim amet\n" +
            "\t\t\t\t\t\t\t\t\tminim Lorem proident nostrud. Ea id dolore anim exercitation\n" +
            "\t\t\t\t\t\t\t\t\taute fugiat labore voluptate cillum do laboris labore. Ex velit\n" +
            "\t\t\t\t\t\t\t\t\texercitation nisi enim labore reprehenderit labore nostrud ut\n" +
            "\t\t\t\t\t\t\t\t\tut. Esse officia sunt duis aliquip ullamco tempor eiusmod\n" +
            "\t\t\t\t\t\t\t\t\tdeserunt irure nostrud irure. Ullamco proident veniam laboris\n" +
            "\t\t\t\t\t\t\t\t\tea consectetur magna sunt ex exercitation aliquip minim enim\n" +
            "\t\t\t\t\t\t\t\t\tculpa occaecat exercitation. Est tempor excepteur aliquip\n" +
            "\t\t\t\t\t\t\t\t\tlaborum consequat do deserunt laborum esse eiusmod irure\n" +
            "\t\t\t\t\t\t\t\t\tproident ipsum esse qui.";
    private String mainText7 = "Labore sit culpa commodo elit adipisicing sit aliquip\n" +
            "\t\t\t\t\t\t\t\t\telit proident voluptate minim mollit nostrud aute reprehenderit\n" +
            "\t\t\t\t\t\t\t\t\tdo. Mollit excepteur eu Lorem ipsum anim commodo sint labore\n" +
            "\t\t\t\t\t\t\t\t\tLorem in exercitation velit incididunt. Occaecat consectetur\n" +
            "\t\t\t\t\t\t\t\t\tnisi in occaecat proident minim enim sunt reprehenderit\n" +
            "\t\t\t\t\t\t\t\t\texercitation cupidatat et do officia. Aliquip consequat ad\n" +
            "\t\t\t\t\t\t\t\t\tlabore labore mollit ut amet. Sit pariatur tempor proident in\n" +
            "\t\t\t\t\t\t\t\t\tveniam culpa aliqua excepteur elit magna fugiat eiusmod amet\n" +
            "\t\t\t\t\t\t\t\t\tofficia.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

/*
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
    }*/

}
