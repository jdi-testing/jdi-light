package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

public class ScrollspyWithNestedNavTests extends TestsInit {
    private String itemLink = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private String navbarLink = "https://getbootstrap.com/docs/4.3/components/scrollspy/#example-with-nested-nav";
    private String navbarText = "Navbar";
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
    }
   /* nestedNav;
    scrollspyWithNestedNav;*/

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

    @Test(dataProvider = "listData", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        refresh();

        nestedNav.navbarLink.is()
                .core()
                .displayed()
                .enabled()
                .attr("href", is(navbarLink))
                .value(is(navbarText))
                .text(is(navbarText))
                .cssClass("navbar-brand");
          //      .attr("color","rgba(0,0,0,.9)"); //rgba(0,0,0,.9) Color Hex
/*

        nestedNav.navGroup.get(index).is()
                .core()
                .displayed()
                .enabled()
                .cssClass("nav nav-pills flex-column");
*/

        nestedNav.navItemLink.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(header)
                .value(header)
                .attr("href", link);

        scrollspyWithNestedNav.header.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(header.toUpperCase())
                .value(header.toUpperCase())
                .attr("id", paragraph);

        scrollspyWithNestedNav.mainText.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(mainText)
                .value(mainText);

/*        nestedNav.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .attr("href", is(link))
                .value(is(header))
                .text(is(header));

        if (index == 1) nestedNav.get(index)
                .is()
                .cssClass("list-group-item list-group-item-action active")
                .css("background-color", "rgba(0, 123, 255, 1)") //#007bff Color Hex
                .css("border-color", "rgb(0, 123, 255)"); //#007bff Color Hex
        else nestedNav.get(index)
                .is()
                .cssClass("list-group-item list-group-item-action")
                .css("background-color", "rgba(255, 255, 255, 1)"); //#fff Color Hex

        scrollspyWithNestedNav.is()
                .core()
                .displayed()
                .enabled()
                .attr("data-spy", is("scroll"))
                .attr("data-target", is("#list-example"))
                .attr("data-offset", is("0"))
                .cssClass("scrollspy-example");

        scrollspyWithNestedNav.header.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr("id", is(paragraph));

        scrollspyWithNestedNav.mainText.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));*/
    }

 /*   @Test
    public void isValidationTests() {
        scrollspyWithNestedNav.header.is()
                .size(4);
        scrollspyWithNestedNav.mainText.is()
                .size(4);
        nestedNav.is()
                .size(4);
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableTests(int index, String paragraph, String header, String mainText) {
        refresh();
        int y_Start = scrollspyWithNestedNav.header.get(1).core().getLocation().y + 4;
        nestedNav.get(index).highlight();
        nestedNav.get(index).click();

        int y_Current = scrollspyWithNestedNav.header.get(index).core().getLocation().y;

        nestedNav.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .cssClass("list-group-item list-group-item-action active")
                .css("background-color", "rgba(0, 123, 255, 1)");//#007bff Color Hex
        scrollspyWithNestedNav.header.get(index).is()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .core().attr("id", is(paragraph));

        scrollspyWithNestedNav.mainText.get(index).is()
                .text(is(mainText))
                .value(is(mainText));

        assertEquals(y_Start, y_Current);
        nestedNav.get(index).unhighlight();
    }

    @Test(dataProvider = "clickValidate")
    public void paragraphClickableTests(int index, String paragraph, String header, String mainText) {
        refresh();
        scrollspyWithNestedNav.mainText.get(index).highlight();
        scrollspyWithNestedNav.mainText.get(index).show();

        if (nestedNav.get(index).core().hasClass("list-group-item list-group-item-action"))
            scrollspyWithNestedNav.header.get(index+1).show();

        nestedNav.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .cssClass("list-group-item list-group-item-action active")
                .css("background-color", "rgba(0, 123, 255, 1)")//#007bff Color Hex
                .css("border-color", "rgb(0, 123, 255)");//#007bff Color Hex

        nestedNav.get(index).unhighlight();
    }

    public void baseValidationTest() {
        baseValidation(scrollspyWithNestedNav);
        baseValidation(nestedNav);
    }*/

}
