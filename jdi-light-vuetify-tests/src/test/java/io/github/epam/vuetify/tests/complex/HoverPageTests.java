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
import static io.github.com.StaticSite.hoverPage;
import static io.github.com.pages.HoverPage.cartButton;
import static io.github.com.pages.HoverPage.closeDelayHover;
import static io.github.com.pages.HoverPage.cookingHeader;
import static io.github.com.pages.HoverPage.disabledHover;
import static io.github.com.pages.HoverPage.musicHoverCards;
import static io.github.com.pages.HoverPage.openDelayHover;
import static io.github.com.pages.HoverPage.priceHover;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class HoverPageTests extends TestsInit {
    @BeforeClass
    public void before() {
        hoverPage.open();
        hoverPage.checkOpened();
    }

    @Test
    public void hoverEffectsTest() {
        disabledHover.show();
        disabledHover.suppress();

        Stream.of(openDelayHover, closeDelayHover).forEach(hover -> {
            hover.has().cssClass("elevation-2");
            hover.show();
            hover.has().cssClass("elevation-16");
            hover.has().cssClass("on-hover");
            hover.suppress();
            hover.has().cssClass("elevation-2");
        });
    }

    @Test
    public void musicCardListTest() {
        final List<String> subheadings = Arrays.asList("New Releases", "Rock", "Mellow Moods");
        subheadings.forEach(subheading -> jdiAssert(
                    musicHoverCards.stream()
                            .map(MusicHoverCard::getSubheading).map(IsText::getText).collect(Collectors.toList()),
                    Matchers.hasItem(subheading)
            )
        );

        musicHoverCards.forEach(card -> {
            card.getPlayerButtons().stream().map(Button::has).forEach(textAssert -> textAssert
                    .cssClasses(Matchers.hasItem(not("show-btns"))));

            card.getHover().show();
            card.getPlayerButtons().stream().map(Button::has).forEach(textAssert -> textAssert.cssClass("show-btns"));
            card.getPlayerButtons().forEach(HasClick::click);

            card.getHover().suppress();
            card.getPlayerButtons().stream().map(Button::has).forEach(textAssert -> textAssert
                    .cssClasses(Matchers.hasItem(not("show-btns"))));
        });
    }

    @Test
    public void cookingCardTest() {
        cookingHeader.has().text(containsString("cooking utensils"));
        cartButton.click();

        priceHover.show();
        priceHover.has().text(containsString("$14.99"));
        priceHover.suppress();
    }
}
