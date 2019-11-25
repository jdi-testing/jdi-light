package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.CardAssert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * To see an example of Card Image Caps in bootstrap please visit https://getbootstrap.com/docs/4.3/components/card/#images
 */

public class CardImageCaps extends Card {
    @UI(".card-img-top")
    public Image image;
    @UI(".card-body")
    public Text text;

    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
