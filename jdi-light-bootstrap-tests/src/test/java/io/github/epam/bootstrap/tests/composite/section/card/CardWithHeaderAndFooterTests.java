package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class CardWithHeaderAndFooterTests extends TestsInit {


    private String textTitleCardWithHeader = "SPECIAL TITLE TREATMENT";
    private String textTitleCardWithHeaderAndFooterQuote;
    private String textTitleCardWithHeaderAndFooter = "SPECIAL TITLE TREATMENT";

    private String textParagraphCardWithHeader = "With supporting text below as a natural lead-in to additional content.";
    private String textParagraphCardWithHeaderAndFooterQuote = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.";
    private String textParagraphCardWithHeaderAndFooter = "With supporting text below as a natural lead-in to additional content.";

    private String textButtonCardWithHeader = "Click Me!";
    private String textButtonCardWithHeaderAndFooterQuote;
    private String textButtonCardWithHeaderAndFooter = "Click Me!";

    private String textHeaderCardWithHeader = "FEATURED";
    private String textHeaderCardWithHeaderAndFooterQuote = "Quote";
    private String textHeaderCardWithHeaderAndFooter = "Featured";

    private String textFooterCardWithHeader;
    private String textFooterCardWithHeaderAndFooterQuote = "Someone famous in Source Title";
    private String textFooterCardWithHeaderAndFooter = "2 days ago";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationCardWithHeaderTest() {
        baseValidation(cardWithHeader);
    }

    @Test
    public void baseValidationCardWithHeaderAndFooterQuoteTest() {
        baseValidation(cardWithHeaderAndFooterQuote);
    }

    @Test
    public void baseValidationCardWithHeaderAndFooterTest() {
        baseValidation(cardWithHeaderAndFooter);
    }


    @Test
    public void getTitleTextCardWithHeaderTest() {

    }

    @Test
    public void getTitleTextCardWithHeaderAndFooterTest() {
        assertEquals(cardWithHeaderAndFooter.title.getText(), textTitleCardWithHeaderAndFooter);
    }

    




     r

}
