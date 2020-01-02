package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardCenterTextAlignment;
import static io.github.com.pages.BootstrapPage.cardLeftTextAlignment;
import static io.github.com.pages.BootstrapPage.cardRightTextAlignment;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Zaur Bibilov on 23.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class CardTextAlignmentTests extends TestsInit {

    // Texts to check
    private String buttonText = "Click Me!";
    private String alertText = "Button Clicked!";
    private String titleText = "SPECIAL TITLE TREATMENT";
    private String descriptionText = "With supporting text below as a natural lead-in to additional content.";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTextTest() {
        cardLeftTextAlignment.highlight();
        assertEquals(cardLeftTextAlignment.cardTitle.getText(), titleText);
        cardCenterTextAlignment.highlight();
        assertEquals(cardCenterTextAlignment.cardTitle.getText(), titleText);
        cardRightTextAlignment.highlight();
        assertEquals(cardRightTextAlignment.cardTitle.getText(), titleText);
    }

    @Test
    public void descriptionTextTest() {
        cardLeftTextAlignment.highlight();
        assertEquals(cardLeftTextAlignment.cardDescription.getText(), descriptionText);
        cardCenterTextAlignment.highlight();
        assertEquals(cardCenterTextAlignment.cardDescription.getText(), descriptionText);
        cardRightTextAlignment.highlight();
        assertEquals(cardRightTextAlignment.cardDescription.getText(), descriptionText);
    }

    @Test
    public void buttonTextTest() {
        cardLeftTextAlignment.highlight();
        cardLeftTextAlignment.cardButton.is().text(is(buttonText));
        cardCenterTextAlignment.highlight();
        cardCenterTextAlignment.cardButton.is().text(is(buttonText));
        cardRightTextAlignment.highlight();
        cardRightTextAlignment.cardButton.is().text(is(buttonText));
    }

    @Test
    public void clickTest() {
        cardLeftTextAlignment.highlight();
        cardLeftTextAlignment.cardButton.click();
        validateAlert(is(alertText));

        cardCenterTextAlignment.highlight();
        cardCenterTextAlignment.cardButton.click();
        validateAlert(is(alertText));

        cardRightTextAlignment.highlight();
        cardRightTextAlignment.cardButton.click();
        validateAlert(is(alertText));
    }

    @Test
    public void isValidationTest() {
        cardLeftTextAlignment.highlight();
        cardLeftTextAlignment.cardTitle.is().text(is(titleText));
        cardLeftTextAlignment.cardDescription.is().text(is(descriptionText));
        cardLeftTextAlignment.cardButton.is().displayed()
                .and().text(is(buttonText))
                .core()
                .attr("onclick", "alert('Button Clicked!');")
                .tag(is("button"));
        cardLeftTextAlignment.cardButton.is().enabled();

        cardCenterTextAlignment.highlight();
        cardCenterTextAlignment.cardTitle.is().text(is(titleText));
        cardCenterTextAlignment.cardDescription.is().text(is(descriptionText));
        cardCenterTextAlignment.cardButton.is().displayed()
                .and().text(is(buttonText))
                .core()
                .attr("onclick", "alert('Button Clicked!');")
                .tag(is("button"));
        cardCenterTextAlignment.cardButton.is().enabled();

        cardRightTextAlignment.highlight();
        cardRightTextAlignment.cardTitle.is().text(is(titleText));
        cardRightTextAlignment.cardDescription.is().text(is(descriptionText));
        cardRightTextAlignment.cardButton.is().displayed()
                .and().text(is(buttonText))
                .core()
                .attr("onclick", "alert('Button Clicked!');")
                .tag(is("button"));
        cardRightTextAlignment.cardButton.is().enabled();
    }

    @Test
    public void baseValidationTest() {
        cardLeftTextAlignment.highlight();
        baseValidation(cardLeftTextAlignment.cardTitle);
        baseValidation(cardLeftTextAlignment.cardDescription);
        baseValidation(cardLeftTextAlignment.cardButton);

        cardCenterTextAlignment.highlight();
        baseValidation(cardCenterTextAlignment.cardTitle);
        baseValidation(cardCenterTextAlignment.cardDescription);
        baseValidation(cardCenterTextAlignment.cardButton);

        cardRightTextAlignment.highlight();
        baseValidation(cardRightTextAlignment.cardTitle);
        baseValidation(cardRightTextAlignment.cardDescription);
        baseValidation(cardRightTextAlignment.cardButton);
    }

}
