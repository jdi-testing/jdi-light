package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.Alerts;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardExample;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;


/**
 * Created by Aleksandr Khmelinin on 13.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardExampleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String titleText = "CARD TITLE";
    private String mainText = "Some quick example text to build" +
            " on the card title and make up the bulk of the card's content.";
    private String alertText = "Card Button Clicked!";
    private String imageSrc = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    private String imageAlt = "image";
    private String buttonText = "Click Me!";

    @Test
    public void getTitleTextTest() {
        assertEquals(cardExample.title.getText(), titleText);
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardExample.text.getText(), mainText);
    }

    @Test
    public void clickTest() {
        cardExample.button.click();
        Alerts.validateAlert(is(alertText));
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardExample.image.src(), imageSrc);
    }
    @Test
    public void getAltTest() {
        assertEquals(cardExample.image.alt(), imageAlt);
    }

    @Test
    public void isValidationTest() {
        cardExample.image.is().src(is(imageSrc));
        cardExample.image.is().alt(is(imageAlt));
//        THIS DOESN'T WORK
//        cardExample.image.assertThat().width(is(86));
//        cardExample.image.assertThat().height(is(137));
//        WHILE THIS ONE DOES
        assertThat(cardExample.image.width(), is(86));
        assertThat(cardExample.image.width(), is(137));

        cardExample.title.is().text(is(titleText));
        cardExample.text.is().text(is(mainText));
        cardExample.button.is().displayed()
                .and().text(is(buttonText))
                .core()
                .attr("type", "submit")
                .tag(is("button"));
        cardExample.button.is().enabled();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardExample.title);
        baseValidation(cardExample.text);
        baseValidation(cardExample.button);
        baseValidation(cardExample.image);
    }
}