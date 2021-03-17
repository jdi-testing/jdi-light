package com.epam.jdi.light.material.elements.surfaces;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.annotations.JDICard;
import com.epam.jdi.light.material.asserts.surfaces.CardAssert;

import java.lang.reflect.Field;

public class Card extends UIBaseElement<CardAssert> implements ISetup {

    private String cardHeaders;
    private String cardBackground;
    private String cardButtons;
    private String cardContent;

    @JDIAction("Get the card background headers")
    public WebList getCardButtons() {
        return this.finds(cardButtons);
    }

    @JDIAction("Get the card background headers")
    public WebList getCardHeaders() {
        return this.finds(cardHeaders);
    }

    @JDIAction("Is card background clickable")
    public boolean isBackgroundClickable() {
        return this.find(cardBackground).isClickable();
    }

    @JDIAction("Get the card content")
    public WebList getInnerCardContent() {
        return this.find(cardContent).children();
    }

    @JDIAction("Is background image displayed")
    public boolean isBackgroundImageDisplayed() {
        return this.find(cardBackground).isDisplayed();
    }

    @JDIAction("Click on background")
    public void clickOnBackground() {
        this.find(cardBackground).click();
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDICard.class, Card.class))
            return;
        JDICard j = field.getAnnotation(JDICard.class);

        cardHeaders = j.cardHeaders();
        cardBackground = j.cardBackground();
        cardButtons = j.cardButtons();
        cardContent = j.cardContent();
    }
}
