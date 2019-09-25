package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardHorizontal;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class CardHorizontalTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String titleText = "WOLVERINE";
    private String mainText = "Wolverine is a fictional character appearing in American comic books published by Marvel" +
            " Comics, mostly in association with the X-Men. He is a mutant who possesses animal-keen senses, enhanced" +
            " physical capabilities, powerful regenerative ability known as a healing factor, and three retractable" +
            " claws in each hand. Wolverine has been depicted variously as a member of the X-Men, Alpha Flight," +
            " and the Avengers.";
    private String smallText = "The character appeared in #180 (1974)";
    private String imageSrc = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    private String imageTitle = "Wolverine icon";

    @Test
    public void getTitleTextTest() {
        assertEquals(cardHorizontal.title.getText(), titleText);
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardHorizontal.mainText.getText(), mainText);
    }

    @Test
    public void getSmallTextTest() {
        assertEquals(cardHorizontal.smallText.getText(), smallText);
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardHorizontal.image.src(), imageSrc);
    }

    @Test
    public void isValidationTest() {
        cardHorizontal.title.is().text(is(titleText));
        cardHorizontal.mainText.is().text(is(mainText));
        cardHorizontal.smallText.is().displayed()
                .and().text(is(smallText))
                .core()
                .css("font-size", is("11.2px"))
                .tag(is("small"));
        cardHorizontal.colMd4.is().displayed()
                .and().core()
                .cssClass("col-md-4");
        cardHorizontal.colMd8.is().displayed()
                .and().core()
                .cssClass("col-md-8");
        //cardHorizontal.image.unhighlight();
        cardHorizontal.image.is().displayed()
                .and().src(is(imageSrc))
                /*.width(is(91))
                .height(is(146))*/
                .core()
                .attr("title", imageTitle);
        cardHorizontal.image.unhighlight();
        cardHorizontal.image.assertThat().width(is(91));
        cardHorizontal.image.assertThat().height(is(146));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardHorizontal.title);
        baseValidation(cardHorizontal.mainText);
        baseValidation(cardHorizontal.smallText);
        baseValidation(cardHorizontal.image);
    }
}
