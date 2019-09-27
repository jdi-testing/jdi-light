package io.github.epam.bootstrap.tests.composite.section.card;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithGridMarkup;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class CardWithGridMarkupTests {

    private static String headerTextCardWithGridMarkup11 = "TITLE";
    private static String headerTextCardWithGridMarkup12 = "TITLE";
    private static String headerTextCardWithGridMarkup21 = "TITLE";
    private static String headerTextCardWithGridMarkup22 = "TITLE";

    private static String paragraphTextCardWithGridMarkup11 = "1st row 1st cell";
    private static String paragraphTextCardWithGridMarkup12 = "1st row 2nd cell";
    private static String paragraphTextCardWithGridMarkup21 = "2nd row 1st cell";
    private static String paragraphTextCardWithGridMarkup22 = "2nd row 2nd cell";

    private static String buttonTextCardWithGridMarkup11 = "Click me";
    private static String buttonTextCardWithGridMarkup12 = "Click me";
    private static String buttonTextCardWithGridMarkup21 = "Click me";
    private static String buttonTextCardWithGridMarkup22 = "Click me";



    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationCardWithHeaderTest() {
        baseValidation(cardWithGridMarkup.get(0));
    }


//test titles
    @Test
    public void getTitleTextCardWithGridMarkup11Test() {
        cardWithGridMarkup.get(0).title.is().text(headerTextCardWithGridMarkup11);
    }
    @Test
    public void getTitleTextCardWithGridMarkup12Test() {
        cardWithGridMarkup.get(1).title.is().text(headerTextCardWithGridMarkup12);
    }
    @Test
    public void getTitleTextCardWithGridMarkup21Test() {
        cardWithGridMarkup.get(2).title.is().text(headerTextCardWithGridMarkup21);
    }
    @Test
    public void getTitleTextCardWithGridMarkup22Test() {
        cardWithGridMarkup.get(3).title.is().text(headerTextCardWithGridMarkup22);
    }

//test paragraph
    @Test
    public void getParagraphTextCardWithGridMarkup11Test() {
        cardWithGridMarkup.get(0).paragraph.is().text(paragraphTextCardWithGridMarkup11);
    }
    @Test
    public void getParagraphTextCardWithGridMarkup12Test() {
        cardWithGridMarkup.get(1).paragraph.is().text(paragraphTextCardWithGridMarkup12);
    }
    @Test
    public void getParagraphTextCardWithGridMarkup21Test() {
        cardWithGridMarkup.get(2).paragraph.is().text(paragraphTextCardWithGridMarkup21);
    }
    @Test
    public void getParagraphTextCardWithGridMarkup22Test() {
        cardWithGridMarkup.get(3).paragraph.is().text(paragraphTextCardWithGridMarkup22);
    }

 //test button
    @Test
    public void getButtonTextCardWithGridMarkup11Test() {
        cardWithGridMarkup.get(0).button.is().text(buttonTextCardWithGridMarkup11);
    }
    @Test
    public void getButtonTextCardWithGridMarkup12Test() {
        cardWithGridMarkup.get(1).button.is().text(buttonTextCardWithGridMarkup12);
    }
    @Test
    public void getButtonTextCardWithGridMarkup21Test() {
        cardWithGridMarkup.get(2).button.is().text(buttonTextCardWithGridMarkup21);
    }
    @Test
    public void getButtonTextCardWithGridMarkup22Test() {
        cardWithGridMarkup.get(3).button.is().text(buttonTextCardWithGridMarkup22);
    }




}
