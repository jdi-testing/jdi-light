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

    @UI(".//h2[contains(text(), 'Information Cards')]/following::div[contains(@class, 'v-card')]")
    public static InformationCard informationCard;

    @UI(".//h2[contains(text(), 'Outlined Card')]/following::div[contains(@class, 'v-card')]")
    public static OutlinedCard outlinedCard;

    @UI(".//h2[contains(text(), 'Media with text')]/following::div[contains(@class, 'v-card')]")
    public static MediaTextCard mediaTextCard;

    @WaitAfterAction(1)
    @UI(".//h2[contains(text(), 'Loading')]/following::div[contains(@class, 'v-card')]")
    public static LoadingCard loadingCard;

    @WaitAfterAction(1)
    @UI(".//h2[contains(text(), 'Card Reveal')]/following::div[contains(@class, 'v-card')]")
    public static Card revealCard;

    @UI(".//h2[contains(text(), 'Custom Actions')]/following::div[contains(@class, 'v-card')]")
    public static CustomActionsCard customActionsCard;

    @UI(".//h2[contains(text(), 'Various Attributes Card')]/following::div[contains(@class, 'v-sheet')]")
    public static List<Card> variousAttributesCards;
}
