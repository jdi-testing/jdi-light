package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.cardsPage;
import static io.github.com.pages.CardsPage.customActionsCard;
import static io.github.com.pages.CardsPage.informationCard;
import static io.github.com.pages.CardsPage.loadingCard;
import static io.github.com.pages.CardsPage.mediaTextCard;
import static io.github.com.pages.CardsPage.outlinedCard;
import static io.github.com.pages.CardsPage.revealCard;
import static io.github.com.pages.CardsPage.revealedCard;
import static org.hamcrest.Matchers.containsString;

public class CardsTests extends TestsInit {
    @BeforeClass
    public void before() {
        cardsPage.open();
        cardsPage.checkOpened();
    }

    @Test
    public void informationCardTest() {
        informationCard.is().displayed();
        informationCard.has().title("be•nev•o•lent");
        informationCard.primaryText().has().text(containsString("a benevolent smile"));
        informationCard.button().click();
    }

    @Test
    public void outlinedCardTest() {
        outlinedCard.is().displayed();
        outlinedCard.has().title("Headline 5");
        outlinedCard.has().subtitle(containsString("divisely hello coldly"));
        outlinedCard.overlineText().has().text("OVERLINE");
        outlinedCard.avatar().has().css("width", "80px");
        outlinedCard.button().click();
    }

    @Test
    public void mediaTextCardTest() {
        mediaTextCard.is().displayed();
        mediaTextCard.image().has().css("background-size", "cover");
        mediaTextCard.has().title("Top 10 Australian beaches");
        mediaTextCard.has().subtitle(containsString("Number 10"));
        mediaTextCard.content().has().text(containsString("Whitehaven Beach"));
        mediaTextCard.shareButton().click();
        mediaTextCard.exploreButton().click();
    }

    @Test
    public void loadingCardTest() {
        loadingCard.is().displayed();
        loadingCard.has().title("Cafe Badilico");
        loadingCard.has().subtitle(containsString("Italian, Cafe"));
        loadingCard.content().has().text(containsString("Small plates, salads & sandwiches"));

        loadingCard.secondTitle().has().text("Tonight's availability");
        loadingCard.chipsList().stream()
                .map(UIElement::is)
                .peek(UIAssert::displayed)
                .map(UIAssert::element)
                .forEach(UIElement::click);

        loadingCard.progressBar().isHidden();
        loadingCard.reserveButton().click();
        Timer.waitCondition(loadingCard.progressBar()::isDisplayed);
        loadingCard.progressBar().is().displayed();
        Timer.waitCondition(loadingCard.progressBar()::isHidden);
        loadingCard.progressBar().is().hidden();
    }

    @Test
    public void revealCardTest() {
        revealCard.is().displayed();
        revealCard.has().title("el·ee·mos·y·nar·y");

        revealedCard.is().hidden();
        revealCard.button().click();
        revealedCard.is().displayed();

        revealedCard.content().has().text(containsString("Origin"));
        revealedCard.content().has().text(containsString("from medieval Latin eleemosynarius"));

        revealedCard.actions().find("button").click();
        revealedCard.is().hidden();
    }

    @Test
    public void customActionsCardTest() {
        customActionsCard.is().displayed();
        customActionsCard.has().title(containsString("Top western road trips"));
        customActionsCard.has().subtitle(containsString("1,000 miles of wonder"));
        customActionsCard.image().is().displayed();
        customActionsCard.exploreButton().click();

        customActionsCard.dropdownText().is().hidden();
        customActionsCard.expandButton().click();
        customActionsCard.dropdownText().is().displayed();
        customActionsCard.dropdownText().has().text(containsString("I'm a thing."));
        customActionsCard.expandButton().click();
        customActionsCard.dropdownText().is().hidden();
    }

}
