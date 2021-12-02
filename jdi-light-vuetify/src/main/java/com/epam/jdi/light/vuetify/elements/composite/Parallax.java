package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ParallaxAssert;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class Parallax extends UIBaseElement<ParallaxAssert> {

    protected String parallaxImage = "v-parallax__image-container > img";
    protected String parallaxContent = "v-parallax__content";

    @JDIAction("Get {name} parallax container height")
    public String height() {
        String rootElementStyle = core().getAttribute("style");
        return extractStyleAttributeValue(rootElementStyle, "height");
    }

    @JDIAction("Check if {name} content section has elements within it")
    public boolean hasContent() {
        UIElement content = core().find(By.className(parallaxContent));
        return content.finds(By.cssSelector("*")).size() > 0;
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
