package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.Card;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardPage extends NewAngularPage {
    @UI("#simple-card")
    public static Card simpleCard;

    @UI("#example-card")
    public static Card card;

    @UI("#card-with-footer")
    public static Card cardWithFooter;

    @UI("#card-with-alignment-align-start")
    public static Card cardAlignStartActions;

    @UI("#card-with-alignment-align-end")
    public static Card cardAlignEndActions;

    @UI("#card-with-media-size-sm-image")
    public static Card cardWithSmallImage;

    @UI("#card-with-media-size-md-image")
    public static Card cardWithMediumImage;

    @UI("#card-with-media-size-lg-image")
    public static Card cardWithLargeImage;

    @UI("#card-with-media-size-xl-image")
    public static Card cardWithExtraLargeImage;
}
