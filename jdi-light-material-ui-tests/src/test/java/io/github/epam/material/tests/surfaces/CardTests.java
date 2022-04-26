package io.github.epam.material.tests.surfaces;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.cardPage;
import static io.github.com.pages.surfaces.CardPage.complexCard;
import static io.github.com.pages.surfaces.CardPage.complexCardDropdownText;
import static io.github.com.pages.surfaces.CardPage.complexCardImage;
import static io.github.com.pages.surfaces.CardPage.outlinedCard;
import static io.github.com.pages.surfaces.CardPage.simpleCard;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Card web element please visit
 * https://material-ui.com/ru/components/cards/
 */

public class CardTests extends TestsInit {

    private static final Timer TIMER = new Timer(16000L);

    @BeforeMethod
    public void beforeTest() {
        cardPage.open();
        cardPage.isOpened();
    }

    @Test
    public void simpleCardTest() {
        simpleCard.is().displayed();
        simpleCard.has().title("be•nev•o•lent");
        simpleCard.primaryText().has().text(containsString("a benevolent smile"));
        simpleCard.learnMoreButton().click();
    }

    @Test
    public void outlinedCardTest() {
        outlinedCard.is().displayed();
        outlinedCard.has().title("be•nev•o•lent");
        outlinedCard.has().classValue(containsString("MuiPaper-outlined"));
        outlinedCard.learnMoreButton().has().text("LEARN MORE");
    }

    @Test
    public void complexCardTest() {
        complexCard.has().title(containsString("Shrimp and Chorizo Paella"));
        complexCard.has().subtitle(containsString("September 14, 2016"));

        complexCardImage.is().displayed();
        complexCardImage
                .has()
                .css("background-image", "url(\"https://mui.com/static/images/cards/paella.jpg\")");
        complexCard.textUnderImage().has().text(containsString("paella is a perfect party dish"));

        complexCard.addToFavoritesButton().click();
        complexCard.addToFavoritesSvgIcon().has().css("color", Colors.RED_500.rgba());

        complexCardDropdownText.is().hidden();
        complexCard.expandButton().click();
        complexCardDropdownText.is().displayed();
        complexCardDropdownText.has().text(containsString("Heat 1/2 cup of the broth in a pot"));
        complexCard.expandButton().click();
        TIMER.wait(() -> complexCardDropdownText.is().hidden());
    }
}
