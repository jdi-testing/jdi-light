package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import io.github.com.custom.cards.CustomActionsCard;
import io.github.com.custom.cards.InformationCard;
import io.github.com.custom.cards.LoadingCard;
import io.github.com.custom.cards.MediaTextCard;
import io.github.com.custom.cards.OutlinedCard;

import java.util.List;

public class CardsPage extends VuetifyPage {

    @UI("//div[@class='container' and .//h2[contains(text(), 'Information Cards')]]/div")
    public static InformationCard informationCard;

    @UI("//div[@class='container' and .//h2[contains(text(), 'Outlined Card')]]/div")
    public static OutlinedCard outlinedCard;

    @UI("//div[@class='container' and .//h2[contains(text(), 'Media with text')]]/div")
    public static MediaTextCard mediaTextCard;

    @WaitAfterAction(1)
    @UI("//div[@class='container' and .//h2[contains(text(), 'Loading')]]/div")
    public static LoadingCard loadingCard;

    @WaitAfterAction(1)
    @UI("//div[@class='container' and .//h2[contains(text(), 'Card Reveal')]]/div")
    public static InformationCard revealCard;

    @UI("//div[@class='container' and .//h2[contains(text(), 'Custom Actions')]]/div")
    public static CustomActionsCard customActionsCard;

    @UI("//*[contains(text(), 'Various Attributes Card')]/following-sibling::div//*[contains(@class, 'v-card') and contains(@class, 'v-sheet')]")
    public static List<Card> variousAttributesCards;
}
