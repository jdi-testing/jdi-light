package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ParallaxAssert;
import com.epam.jdi.light.vuetify.interfaces.HasImage;
import com.epam.jdi.light.vuetify.interfaces.IsContainer;
import org.openqa.selenium.By;
import com.epam.jdi.light.vuetify.elements.common.Image;

/**
 * Parallax is basically a container with a background image that scrolls slower than browser window.
 * Since Parallax might contain any elements, as a page section would,
 * you can describe specific parallaxes with content by extending the class.
 *
 * To see an example of Parallax web element please visit https://vuetifyjs.com/en/components/parallax
 */

public class Parallax extends UIBaseElement<ParallaxAssert> implements IsContainer, HasImage {

    protected String parallaxContent = "v-parallax__content";

    @JDIAction("Get '{name}' parallax container height")
    public int height() {
        String heightValue = core().getAttribute("style").replaceFirst(".*height: (\\d+)px;.*", "$1");
        return Integer.parseInt(heightValue);
    }

    @Override
    @JDIAction("Get '{name}' content")
    public UIElement content() {
        return core().find(By.className(parallaxContent));
    }

    @JDIAction("Get if '{name}' content section has elements within it")
    public boolean hasContent() {
        return content().children().size() > 0;
    }

    /**
     * Method to get parallax Image
     *
     * @return com.epam.jdi.light.ui.html.elements.common.Image as some of the vuelify Image methods are not working
     * for parallax Image, while html Image methods are working fine
     */
    @JDIAction("Get '{name}' parallax image")
    public Image image() {
        return new Image().setCore(Image.class, core());
    }

    @Override
    public ParallaxAssert is() { return new ParallaxAssert().set(this); }
}
