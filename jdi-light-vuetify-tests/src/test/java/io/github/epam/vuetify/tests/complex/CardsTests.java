package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.cardsPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.CardsPage.customActionsCard;
import static io.github.com.pages.CardsPage.informationCard;
import static io.github.com.pages.CardsPage.loadingCard;
import static io.github.com.pages.CardsPage.mediaTextCard;
import static io.github.com.pages.CardsPage.outlinedCard;
import static io.github.com.pages.CardsPage.revealCard;
import static io.github.com.pages.CardsPage.variousAttributesCards;
import static org.hamcrest.Matchers.containsString;

public class CardsTests extends TestsInit {

    @BeforeClass
    public void before() {
        cardsPage.open();
        waitCondition(() -> cardsPage.isOpened());
        cardsPage.checkOpened();
    }

    @Test(description = "Test checks custom element information card functionality")
    public void informationCardTest() {
        informationCard.show();
        informationCard.is().displayed()
                .and().has().title("be•nev•o•lent");
        informationCard.primaryText().has().text(containsString("a benevolent smile"));
        informationCard.actions().get("Learn More").click();
    }

    @Test(description = "Test checks custom element card reveal functionality")
    public void revealCardTest() {
        revealCard.show();
        revealCard.is().displayed();
        revealCard.content().has().text(containsString("el·ee·mos·y·nar·y"))
                .and().text(containsString("dependent on charity"));
        UIElement learnMore = revealCard.actions().get("Learn More");
        learnMore.is().displayed();
        learnMore.click();
        Card reveal = revealCard.revealCard();
        reveal.is().displayed();
        // issue 4743
        //learnMore.is().notVisible();
        reveal.content().has().text(containsString("late 16th century"));
        UIElement closeBtn = reveal.actions().get("Close");
        closeBtn.click();
        //reveal.is().notVisible();
        learnMore.is().displayed();
    }

    @Test(description = "Test checks custom element media text card functionality")
    public void mediaTextCardTest() {
        mediaTextCard.show();
        mediaTextCard.is().displayed();
        mediaTextCard.image().is().displayed();
        mediaTextCard.has().title("Top 10 Australian beaches")
                .and().subtitle(containsString("Number 10"));
        mediaTextCard.content().has().text(containsString("Whitehaven Beach"));
        mediaTextCard.shareButton().click();
    }

    @Test(description = "Test checks custom element custom actions card functionality")
    public void customActionsCardTest() {
        customActionsCard.show();

        customActionsCard.extendedText.is().hidden();
        customActionsCard.expandButton().click();
        customActionsCard.extendedText.is().displayed()
                .and().text(containsString("I'm a thing."));
        customActionsCard.expandButton().click();
        waitCondition(customActionsCard.extendedText::isHidden);
        customActionsCard.extendedText.is().hidden();
    }

    @Test(description = "Test checks if card is rounded or not : rounded(y/n)")
    public void roundedCardTest() {
        variousAttributesCards.get(3).show();
        variousAttributesCards.get(3).is().rounded()
                .and().has().rounded(3);
        customActionsCard.show();
        customActionsCard.is().notRounded();
    }

    @Test(description = "Test checks if card is outlined or not : outlined(y/n)")
    public void outlinedCardTest() {
        outlinedCard.show();
        outlinedCard.is().outlined();
        mediaTextCard.show();
        mediaTextCard.is().notOutlined();
    }

    @Test(description = "Test checks if card is shaped or not : shaped(y/n)")
    public void shapedCardTest() {
        variousAttributesCards.get(2).show();
        variousAttributesCards.get(2).is().shaped();
        variousAttributesCards.get(3).show();
        variousAttributesCards.get(3).is().notShaped();
    }

    @Test(description = "Test checks if card is tile or not :  tile(y/n)")
    public void tileCardTest() {
        variousAttributesCards.get(1).show();
        variousAttributesCards.get(1).is().tile();
        variousAttributesCards.get(2).show();
        variousAttributesCards.get(2).is().notTile();
    }

    @Test(description = "Test checks if card is disabled or not :  disabled(y/n)")
    public void disabledCardTest() {
        variousAttributesCards.get(4).show();
        variousAttributesCards.get(4).is().disabled();
        variousAttributesCards.get(5).show();
        variousAttributesCards.get(5).is().enabled();
    }

    @Test(description = "Test checks if card is loading or not :  loading(y/n), loader-height(0-n)")
    public void loadingCardTest() {
        loadingCard.show();
        loadingCard.reserveButton().click();
        waitCondition(() -> !loadingCard.isLoading());
        loadingCard.is().loaded();
    }

    @Test(description = "Test checks if card is elevated or not :  elevation(0-n)")
    public void elevationCardTest() {
        variousAttributesCards.get(1).show();
        variousAttributesCards.get(1).is().elevated();
        variousAttributesCards.get(1).has().elevation(5);
        variousAttributesCards.get(2).show();
        variousAttributesCards.get(2).is().notElevated();
    }

    @Test(description = "Test checks if card is link or not : link (y/n)")
    public void linkCardTest() {
        variousAttributesCards.get(5).show();
        variousAttributesCards.get(5).is().link();
        variousAttributesCards.get(4).show();
        variousAttributesCards.get(4).is().notLink();
        variousAttributesCards.get(1).has().maxWidthPx(344);
    }

    @Test(description = "Test checks card's height and width : height/width(0-n)")
    public void measurementsCardTest() {
        variousAttributesCards.get(1).show();
        variousAttributesCards.get(1).has().width(344)
                .and().height(244);
    }

    @Test(description = "Test checks card's color : color(name of material color or css color)")
    public void colorCardTest() {
        variousAttributesCards.get(1).show();
        variousAttributesCards.get(1).has().backgroundColor(WHITE.value())
                .and().color(BLACK_TRANSPARENT_087.value());
    }

    @Test(description = "Test checks card's theme : theme(dark,light)")
    public void themeCardTest() {
        variousAttributesCards.get(1).show();
        variousAttributesCards.get(1).has().lightTheme();
    }

    @Test(description = "Test checks if card is flat or not : flat(y/n)")
    public void flatCardTest() {
        variousAttributesCards.get(5).show();
        variousAttributesCards.get(5).is().flat();
        variousAttributesCards.get(4).show();
        variousAttributesCards.get(4).is().notFlat();
    }

    @Test(description = "Test checks if card is hover or not : hover(y/n)")
    public void hoverCardTest() {
        variousAttributesCards.get(2).show();
        variousAttributesCards.get(2).is().hover();
        variousAttributesCards.get(3).show();
        variousAttributesCards.get(3).is().notHover();
    }

    @Test(description = "Test checks if card is raised or not : raised(y/n)")
    public void raisedCardTest() {
        variousAttributesCards.get(4).show();
        variousAttributesCards.get(4).is().raised();
        variousAttributesCards.get(5).show();
        variousAttributesCards.get(5).is().notRaised();
    }
}
