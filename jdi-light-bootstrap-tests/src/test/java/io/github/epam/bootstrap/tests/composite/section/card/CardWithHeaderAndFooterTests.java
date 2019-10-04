package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithHeader;
import static io.github.com.pages.BootstrapPage.cardWithHeaderAndFooterQuote;
import static io.github.com.pages.BootstrapPage.cardWithHeaderAndFooter;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

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

    //test title
    @Test
    public void getTitleTextCardWithHeaderTest() {
        cardWithHeader.title.is().text(textTitleCardWithHeader);
    }

    @Test
    public void getTitleTextCardWithHeaderAndFooterTest() {
        cardWithHeaderAndFooter.title.is().text(textTitleCardWithHeaderAndFooter);
    }

    //test paragraph
    @Test
    public void getParagraphTextCardWithHeaderTest() {
        cardWithHeader.paragraph.is().text(textParagraphCardWithHeader);
    }

    @Test
    public void getParagraphTextCardWithHeaderAndFooterQuoteTest() {
        cardWithHeaderAndFooterQuote.paragraph.is().text(textParagraphCardWithHeaderAndFooterQuote);
    }

    @Test
    public void getParagraphTextCardWithHeaderAndFooterTest() {
        cardWithHeaderAndFooter.paragraph.is().text(textParagraphCardWithHeaderAndFooter);
    }

    //test button
    @Test
    public void getButtonTextCardWithHeaderTest() {
        cardWithHeader.button.is().text(textButtonCardWithHeader);
    }

    @Test
    public void getButtonTextCardWithHeaderAndFooterTest() {
        cardWithHeaderAndFooter.button.is().text(textButtonCardWithHeaderAndFooter);
    }

    //test header
    @Test
    public void getHeaderTextCardWithHeaderTest() {
        cardWithHeader.header.is().text(textHeaderCardWithHeader);
    }

    @Test
    public void getHeaderTextCardWithHeaderAndFooterQuoteTest() {
        cardWithHeaderAndFooterQuote.header.is().text(textHeaderCardWithHeaderAndFooterQuote);
    }

    @Test
    public void getHeaderTextCardWithHeaderAndFooterTest() {
        cardWithHeaderAndFooter.header.is().text(textHeaderCardWithHeaderAndFooter);
    }

    //test footer
    @Test
    public void getFooterTextCardWithHeaderTest() {
        cardWithHeader.footer.is().notAppear();
    }

    @Test
    public void getFooterTextCardWithHeaderAndFooterQuoteTest() {
        cardWithHeaderAndFooterQuote.footer.is().text(textFooterCardWithHeaderAndFooterQuote);
    }

    @Test
    public void getFooterTextCardWithHeaderAndFooterTest() {
        cardWithHeaderAndFooter.footer.is().text(textFooterCardWithHeaderAndFooter);
    }

    @Test
    public void clickButtonCardWithHeaderTest() {
        cardWithHeader.button.click();
        validateAlert(is("Button Clicked!"));
        cardWithHeader.button.is()
                .enabled()
                .displayed();
    }
}