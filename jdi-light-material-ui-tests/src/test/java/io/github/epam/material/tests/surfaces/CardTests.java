package io.github.epam.material.tests.surfaces;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.pages.surfaces.CardPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.cardPage;
import static io.github.com.pages.surfaces.CardPage.complexCard;
import static io.github.com.pages.surfaces.CardPage.outlinedCard;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

/**
 * To see an example of Card web element please visit
 * https://material-ui.com/ru/components/cards/
 */

public class CardTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        cardPage.open();
        cardPage.isOpened();
    }

    @Test
    public void outlinedCardTestContent() {
        outlinedCard.getContent().is().text(containsString("Word of the Day"));
        outlinedCard.getContent().is().text(containsString("be•nev•o•lent"));
        outlinedCard.has().classValue(containsString("MuiPaper-outlined"));
    }

    @Test
    public void outlinedCardButtonsTest() {
        outlinedCard.is().assertNumberOfButtonsOnCard(1);
        UIElement test = outlinedCard.getActionButtonByNumber(1);
        test.is().text("LEARN MORE");
    }

    @Test
    public void complexCardHeaderTest() {
        complexCard.getHeader().is().displayed();
        complexCard.getHeaderTitle().is().text("Shrimp and Chorizo Paella");
        complexCard.getHeaderSubheader().is().text("September 14, 2016");
        complexCard.getHeaderAvatar().is().displayed();
        complexCard.getHeaderAction().is().displayed();
        complexCard.getHeaderActionButtons().get(1).click();
    }

    @Test
    public void complexCardMediaTest() {
        complexCard.getContent().is().displayed();
        CardPage.complexCardImage()
                .has()
                .attr("title", "Paella dish")
                .css("background-image", containsStringIgnoringCase("/paella.jpg"));
    }

    @Test
    public void complexCardButtonsTest() {
        complexCard.is().assertNumberOfButtonsOnCard(3);
        UIElement heartButton = complexCard.getActionButtonByNumber(1);
        heartButton.click();
        //heartButton.has().classValue(containsString("jss"));
        /*new Timer(1000L)
                .wait(() -> heartButton.has().classValue(containsString("jss")));*/
    }

    @Test
    public void comlexCardContentTest() {
        String expectedText = "This impressive paella is a perfect party dish and a fun meal to cook " +
                "together with your guests. Add 1 cup of frozen peas along with the mussels, if you like.";
        complexCard.getContent().is().text(containsString(expectedText));

    }


    /*@Test
    public void complexCardTest() {
        String expectedText = "This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like.";
        pTagTexts.get(3).has().text(Matchers.is(expectedText));
        complexCardImage.is().displayed();

        complexCardHeartIconButton.click();
        new Timer(1000L)
                .wait(() -> complexCardHeartIcon.has().classValue(Matchers.containsString("jss")));

        complexCardHeartIconButton.click();
        new Timer(1000L)
                .wait(() -> complexCardHeartIcon.has().classValue(Matchers.not("jss")));

        complexCardSliderDownButton.click();
        complexCardHiddenTextArea.is().displayed();
        complexCardHiddenText.get(1).has().text(Matchers.containsString("Method:"));
    }*/
}
