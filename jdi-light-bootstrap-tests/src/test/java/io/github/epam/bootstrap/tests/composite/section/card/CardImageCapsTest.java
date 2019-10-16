package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import io.github.epam.test.data.CardImageData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardImageOnBottom;
import static io.github.com.pages.BootstrapPage.cardImageOnTop;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class CardImageCapsTest extends TestsInit {

    private CardImageData topCardData;
    private CardImageData bottomCardData;

    @BeforeClass
    public void setupData() {
        topCardData = new CardImageData.Builder().build();
        bottomCardData = new CardImageData.Builder()
                .srcAttr("https://jdi-testing.github.io/jdi-light/images/punisher.jpg")
                .altAttr("...")
                .height(137)
                .build();
    }
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getMainTextTest() {
        assertEquals(cardImageOnTop.text.getText(), topCardData.getText());
        assertEquals(cardImageOnBottom.text.getText(), bottomCardData.getText());
    }

    @Test
    public void availabilityTest() {
        cardImageOnTop.text.is()
                .displayed()
                .enabled();
        cardImageOnBottom.image.is()
                .displayed()
                .enabled();
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardImageOnTop.image.src(), topCardData.getSrcAttr());
        assertEquals(cardImageOnBottom.image.src(), bottomCardData.getSrcAttr());
    }

    @Test
    public void getAltTest() {
        assertEquals(cardImageOnTop.image.alt(), topCardData.getAltAttr());
        assertEquals(cardImageOnBottom.image.alt(), bottomCardData.getAltAttr());
    }

    @Test
    public void isValidationTest() {
        cardImageOnTop.text.is().text(is(topCardData.getText()));
        cardImageOnTop.image.is().src(is(topCardData.getSrcAttr()));
        cardImageOnTop.image.is().alt(is(topCardData.getAltAttr()));
        cardImageOnTop.image.unhighlight();
        cardImageOnTop.image.assertThat().width(is(topCardData.getWidth()));
        cardImageOnTop.image.assertThat().height(is(topCardData.getHeight()));

        cardImageOnBottom.text.is().text(is(bottomCardData.getText()));
        cardImageOnBottom.image.is().src(is(bottomCardData.getSrcAttr()));
        cardImageOnBottom.image.is().alt(is(bottomCardData.getAltAttr()));
        cardImageOnBottom.image.unhighlight();
        cardImageOnBottom.image.assertThat().width(is(bottomCardData.getWidth()));
        cardImageOnBottom.image.assertThat().height(is(bottomCardData.getHeight()));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardImageOnTop.image);
        baseValidation(cardImageOnTop.text);

        baseValidation(cardImageOnBottom.image);
        baseValidation(cardImageOnBottom.text);
    }

    @Test
    public void imageClassTest() {
        cardImageOnTop.image.is().core().hasClass(topCardData.getImageClass());
        cardImageOnTop.image.assertThat().core().hasClass(bottomCardData.getImageClass());

        cardImageOnBottom.image.is().core().hasClass(topCardData.getImageClass());
        cardImageOnBottom.image.assertThat().core().hasClass(bottomCardData.getImageClass());
    }

    @Test
    public void imagePositionTest() {
        assertEquals(cardImageOnTop.childs().get(1).getTagName(), "img");

        WebList children = cardImageOnBottom.childs();
        assertEquals(children.get(children.size()).getTagName(), "img");
    }
}
