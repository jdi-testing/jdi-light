package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.com.sections.card.CardWithHeaderAndFooter;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithGridMarkup;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class CardWithGridMarkupTests extends TestsInit {

    private String textTitleCardWithGridMarkup11 = "TITLE";
    private String textTitleCardWithGridMarkup12 = "TITLE";
    private String textTitleCardWithGridMarkup21 = "TITLE";
    private String textTitleCardWithGridMarkup22 = "TITLE";

    private String textParagraphCardWithGridMarkup11 = "1st row 1st cell";
    private String textParagraphCardWithGridMarkup12 = "1st row 2nd cell";
    private String textParagraphCardWithGridMarkup21 = "2nd row 1st cell";
    private String textParagraphCardWithGridMarkup22 = "2nd row 2nd cell";


    private String textButtonCardWithGridMarkup11 = "Click me";
    private String textButtonCardWithGridMarkup12 = "Click me";
    private String textButtonCardWithGridMarkup21 = "Click me";
    private String textButtonCardWithGridMarkup22 = "Click me";

    private String textAlert = "Button Clicked!";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationCardWithGridMarkup11Test() {
        CardWithHeaderAndFooter cardWithGridMarkup11 = cardWithGridMarkup.listCard.get(1);
        baseValidation(cardWithGridMarkup);
        baseValidation(cardWithGridMarkup11);
        baseValidation(cardWithGridMarkup11.title);
        baseValidation(cardWithGridMarkup11.paragraph);
        baseValidation(cardWithGridMarkup11.button);
    }

    @Test
    public void baseValidationCardWithGridMarkup12Test() {
        CardWithHeaderAndFooter cardWithGridMarkup12 = cardWithGridMarkup.listCard.get(2);
        baseValidation(cardWithGridMarkup12);
        baseValidation(cardWithGridMarkup12.title);
        baseValidation(cardWithGridMarkup12.paragraph);
        baseValidation(cardWithGridMarkup12.button);
    }

    @Test
    public void baseValidationCardWithGridMarkup21Test() {
        CardWithHeaderAndFooter cardWithGridMarkup21 = cardWithGridMarkup.listCard.get(3);
        baseValidation(cardWithGridMarkup21);
        baseValidation(cardWithGridMarkup21.title);
        baseValidation(cardWithGridMarkup21.paragraph);
        baseValidation(cardWithGridMarkup21.button);
    }

    @Test
    public void baseValidationCardWithGridMarkup22Test() {
        CardWithHeaderAndFooter cardWithGridMarkup22 = cardWithGridMarkup.listCard.get(4);
        baseValidation(cardWithGridMarkup22);
        baseValidation(cardWithGridMarkup22.title);
        baseValidation(cardWithGridMarkup22.paragraph);
        baseValidation(cardWithGridMarkup22.button);
    }

    //test title
    @Test
    public void getTitleTextCardWithGridMarkup11Test() {
        cardWithGridMarkup.listCard.get(1).title.is().text(textTitleCardWithGridMarkup11);
    }

    @Test
    public void getTitleTextCardWithGridMarkup12Test() {
        cardWithGridMarkup.listCard.get(2).title.is().text(textTitleCardWithGridMarkup12);
    }

    @Test
    public void getTitleTextCardWithGridMarkup21Test() {
        cardWithGridMarkup.listCard.get(3).title.is().text(textTitleCardWithGridMarkup21);
    }

    @Test
    public void getTitleTextCardWithGridMarkup22Test() {
        cardWithGridMarkup.listCard.get(4).title.is().text(textTitleCardWithGridMarkup22);
    }
    
    //test paragraph
    @Test
    public void getParagraphTextCardWithGridMarkup11Test() {
        cardWithGridMarkup.listCard.get(1).paragraph.is().text(textParagraphCardWithGridMarkup11);
    }

    @Test
    public void getParagraphTextCardWithGridMarkup12Test() {
        cardWithGridMarkup.listCard.get(2).paragraph.is().text(textParagraphCardWithGridMarkup12);
    }

    @Test
    public void getParagraphTextCardWithGridMarkup21Test() {
        cardWithGridMarkup.listCard.get(3).paragraph.is().text(textParagraphCardWithGridMarkup21);
    }

    @Test
    public void getParagraphTextCardWithGridMarkup22Test() {
        cardWithGridMarkup.listCard.get(4).paragraph.is().text(textParagraphCardWithGridMarkup22);
    }

    //test button
    @Test
    public void getButtonTextCardWithGridMarkup11Test() {
        cardWithGridMarkup.listCard.get(1).button.is().text(textButtonCardWithGridMarkup11);
        cardWithGridMarkup.listCard.get(1).button.click();
        validateAlert(is(textAlert));
        cardWithGridMarkup.listCard.get(1).button.is()
                .enabled()
                .displayed();
    }

    @Test
    public void getButtonTextCardWithGridMarkup12Test() {
        cardWithGridMarkup.listCard.get(1).button.is().text(textButtonCardWithGridMarkup12);
        cardWithGridMarkup.listCard.get(1).button.click();
        validateAlert(is(textAlert));
        cardWithGridMarkup.listCard.get(1).button.is()
                .enabled()
                .displayed();
    }

    @Test
    public void getButtonTextCardWithGridMarkup21Test() {
        cardWithGridMarkup.listCard.get(2).button.is().text(textButtonCardWithGridMarkup21);
        cardWithGridMarkup.listCard.get(2).button.click();
        validateAlert(is(textAlert));
        cardWithGridMarkup.listCard.get(2).button.is()
                .enabled()
                .displayed();
    }

    @Test
    public void getButtonTextCardWithGridMarkup22Test() {
        cardWithGridMarkup.listCard.get(3).button.is().text(textButtonCardWithGridMarkup22);
        cardWithGridMarkup.listCard.get(3).button.click();
        validateAlert(is(textAlert));
        cardWithGridMarkup.listCard.get(3).button.is()
                .enabled()
                .displayed();
    }
}
