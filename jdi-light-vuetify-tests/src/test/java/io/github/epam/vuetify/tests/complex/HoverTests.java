package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.cards.MusicHoverCard;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.hoverPage;
import static io.github.com.pages.HoverPage.closeDelayHover;
import static io.github.com.pages.HoverPage.cookingHoverCard;
import static io.github.com.pages.HoverPage.disabledHover;
import static io.github.com.pages.HoverPage.musicHoverCards;
import static io.github.com.pages.HoverPage.openDelayHover;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class HoverTests extends TestsInit {

    private static final List<String> SUBHEADINGS = Arrays.asList("New Releases", "Rock", "Mellow Moods");
    private static final String COOKING_CARD_PRICE = "$14.99";
    private static final String COOKING_CARD_HEADER_TEXT = "cooking utensils";

    @BeforeClass
    public void before() {
        hoverPage.open();
        waitCondition(() -> hoverPage.isOpened());
        hoverPage.checkOpened();
    }

    @Test(description = "Assert that hover effect is disabled and absent even if card is being hovered")
    public void hoverEffectIsAbsentTest() {
        disabledHover.show();
        disabledHover.assertThat().attr("class", not(containsString("on-hover")));
    }

    @Test(description = "Assert that hover effect is enabled and present only when card is being hovered")
    public void hoverEffectIsPresentTest() {
        Stream.of(openDelayHover, closeDelayHover).forEach(item -> {
            item.has().cssClass("elevation-2");
            item.show();
            item.has().cssClass("elevation-16");
            item.has().cssClass("on-hover");
            item.suppress();
            item.has().cssClass("elevation-2");
        });

        musicHoverCards.forEach(item -> {
            item.has().cssClass("elevation-2");
            item.getHover().show();
            item.has().cssClass("elevation-12");
            item.has().cssClass("on-hover");
            item.getHover().suppress();
            item.has().cssClass("elevation-2");
        });
    }

    @Test(description = "Assert that Music Card list player buttons appear only when card is being hovered")
    public void musicCardListPlayerButtonsAppearWhenHoveredTest() {
        musicHoverCards.forEach(card -> {
            card.getPlayerButtons().stream()
                    .map(Button::has)
                    .forEach(textAssert -> textAssert.cssClasses(Matchers.hasItem(not("show-btns"))));

            card.getHover().show();
            card.getPlayerButtons().stream()
                    .map(Button::has)
                    .forEach(textAssert -> textAssert.cssClass("show-btns"));

            card.getPlayerButtons().forEach(button -> button.core().isClickable());
            card.getPlayerButtons().forEach(HasClick::click);

            card.getHover().suppress();
            card.getPlayerButtons().stream()
                    .map(Button::has)
                    .forEach(textAssert -> textAssert.cssClasses(Matchers.hasItem(not("show-btns"))));
        });
    }

    @Test(description = "Assert that Music Card list has proper texts")
    public void musicCardListTextsTest() {
        SUBHEADINGS.forEach(subheading -> jdiAssert(musicHoverCards.stream()
                        .map(MusicHoverCard::getSubheading)
                        .map(IsText::getText)
                        .collect(Collectors.toList()), Matchers.hasItem(subheading)));
    }

    @Test(description = "Assert that Cooking Card price text appears only when card is being hovered")
    public void cookingCardPriceTextAppearsWhenHoveredTest() {
        cookingHoverCard.getPriceHover().is().notVisible();
        cookingHoverCard.getPriceHover().show();
        cookingHoverCard.getPriceHover().has().text(containsString(COOKING_CARD_PRICE));
        cookingHoverCard.getPriceHover().suppress();
        cookingHoverCard.getPriceHover().is().notVisible();
    }

    @Test(description = "Assert that Cooking Card header contains proper text")
    public void cookingCardHeaderTextTest() {
        cookingHoverCard.getCookingHeader().has().text(containsString(COOKING_CARD_HEADER_TEXT));
    }

    @Test(description = "Assert that Cooking Card button is clickable, and price text appears when clicking")
    public void cookingCardCardButtonTest() {
        cookingHoverCard.getCartButton().core().isClickable();
        cookingHoverCard.getCartButton().click();
        cookingHoverCard.getPriceHover().has().text(containsString(COOKING_CARD_PRICE));
        cookingHoverCard.getPriceHover().suppress();
    }
}
