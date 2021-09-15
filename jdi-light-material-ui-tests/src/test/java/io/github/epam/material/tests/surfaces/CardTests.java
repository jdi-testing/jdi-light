package io.github.epam.material.tests.surfaces;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.pages.surfaces.CardPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.cardPage;
import static io.github.com.pages.surfaces.CardPage.complexCard;
import static io.github.com.pages.surfaces.CardPage.complexCardCollapsibleContent;
import static io.github.com.pages.surfaces.CardPage.complexCardHeartButtonIcon;
import static io.github.com.pages.surfaces.CardPage.outlinedCard;
import static io.github.com.pages.surfaces.CardPage.simpleCard;
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
    public void simpleCardTestContent() {
        simpleCard.getContent().is().text(containsString("Word of the Day"));
        simpleCard.getContent().is().text(containsString("be•nev•o•lent"));
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
        outlinedCard.getActionButtonByNumber(1).is().text("LEARN MORE");
    }

    @Test
    public void complexCardHeaderTest() {
        complexCard.getHeader().is().displayed();
        complexCard.is().assertCardTitleText("Shrimp and Chorizo Paella");
        complexCard.is().assertCardSubheaderText("September 14, 2016");
        complexCard.getHeaderAvatar().is().displayed();
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
    public void complexCardHeartButtonTest() {
        complexCard.is().assertNumberOfButtonsOnCard(3);
        UIElement heartButtonIcon = complexCardHeartButtonIcon();
        heartButtonIcon.click();
        heartButtonIcon.has().classValue(containsString("jss"));
    }

    @Test
    public void complexCardCollapseTest() {
        final String collapsibleContentText = "Heat 1/2 cup of the broth in a pot until simmering," +
                " add saffron and set aside for 10 minutes.";
        complexCardCollapsibleContent().is().hidden();
        complexCard.is().assertNumberOfButtonsOnCard(3);
        UIElement collapseButton = complexCard.getActionButtonByNumber(3);
        collapseButton.click();
        collapseButton.has().classValue(containsString("jss"));
        complexCardCollapsibleContent().is().displayed();
        complexCardCollapsibleContent().has().text(containsString(collapsibleContentText));
        collapseButton.click();
        complexCardCollapsibleContent().is().hidden();
    }

    @Test
    public void comlexCardContentTest() {
        String expectedText = "This impressive paella is a perfect party dish and a fun meal to cook " +
                "together with your guests. Add 1 cup of frozen peas along with the mussels, if you like.";
        complexCard.getContent().is().text(containsString(expectedText));
    }
}
