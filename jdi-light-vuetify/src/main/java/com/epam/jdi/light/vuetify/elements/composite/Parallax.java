package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.asserts.ParallaxAssert;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

/**
 * Parallax is basically a container with a background image that scrolls slower than browser window.
 * Since Parallax might contain any elements, as a page section would,
 * you can describe specific parallaxes with content by extending the class.
 *
 * To see an example of Parallax web element please visit https://vuetifyjs.com/en/components/parallax
 */

public class Parallax extends UIBaseElement<ParallaxAssert> {

    protected String parallaxContent = "v-parallax__content";

    // For parallax, Vuetify uses HTML image instead of Vuetify image
    @UI(".v-parallax__image-container > img")
    protected com.epam.jdi.light.vuetify.elements.common.Image parallaxImage;

    @JDIAction("Get '{name}' parallax container height")
    public int heightPx() {
        String rootElementStyle = core().getAttribute("style");
        return Integer.parseInt(extractStyleAttributeValue(rootElementStyle, "height")
                .replace("px", ""));
    }

    @JDIAction("Check if '{name}' content section has elements within it")
    public boolean hasContent() {
        UIElement content = core().find(By.className(parallaxContent));
        return content.finds(By.cssSelector("*")).size() > 0;
    }

    /**
     * Method to get parallax Image
     *
     * @return com.epam.jdi.light.ui.html.elements.common.Image as some of the vuelify Image methods are not working
     * for parallax Image, while html Image methods are working fine
     */
    @JDIAction("Get '{name}' parallax image")
    public com.epam.jdi.light.ui.html.elements.common.Image image() {
        return parallaxImage.getJDIImage();
    }

    private String extractStyleAttributeValue(String styleAttributeValues, String valueName) {
        Pattern valuePattern = Pattern.compile(format("%s: (.*?);", valueName));
        Matcher matcher = valuePattern.matcher(styleAttributeValues);
        if (matcher.find()) {
            return matcher.group(1);
        } else { return ""; }
    }

    @Override
    public ParallaxAssert is() { return new ParallaxAssert().set(this); }
}
