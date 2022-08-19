package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.jdiai.tools.Timer;

import java.util.List;

/**
 * To see an example of Chip web element please visit https://vuetifyjs.com/en/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, HasIcon, HasLabel {

    private static final String TEXT1 = ".v-chip__content";
    private static final String TEXT2 = "//span[@class='v-chip__content']/text()";
    private static final String ALL_TEXTS_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/*[text()]";
    private static final String BOLD_TEXT_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/strong";
    private static final String REGULAR_TEXT_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/span";
    private static final String CLOSE_BUTTON = "button.v-chip__close";
    private static final String FILTER = ".v-chip__filter";
    private static final String IMAGE = ".v-image__image";

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @JDIAction("Get {name}'s text")
    public String getText() {
        if (!find(TEXT1).getText().isEmpty()) {
            return find(TEXT1).getText();
        } else {
            return find(TEXT2).getText();
        }
    }

    @JDIAction("Get bold text from {name}'s composite label")
    public String getBoldTextFromCompositeLabel() {
        return find(BOLD_TEXT_FROM_COMPOSITE_LABEL).getText();
    }

    @JDIAction("Get bold text from {name}'s composite label")
    public String getRegularTextFromCompositeLabel() {
        return find(REGULAR_TEXT_FROM_COMPOSITE_LABEL).getText();
    }

    @JDIAction("Get all the text from {name}'s composite label")
    public String getFullTextFromCompositeLabel() {
        StringBuilder result = new StringBuilder();
        List<UIElement> labelParts = finds(ALL_TEXTS_FROM_COMPOSITE_LABEL);
        for (int i = 1; i <= labelParts.size(); i++) {
            result.append(labelParts.get(i).getText());
            result.append(" ");
        }
        return result.toString().trim();
    }

    @JDIAction("Close '{name}'")
    public void close() {
        find(CLOSE_BUTTON).click();
    }

    @JDIAction("Check that '{name}' is draggable")
    public boolean isDraggable() {
        return hasClass("v-chip--draggable");
    }

    @JDIAction("Check that '{name}' is active")
    public boolean isActive() {
        return hasClass("v-chip--active");
    }

    @JDIAction("Check if '{name}' filter icon is displayed")
    public boolean isFilterIconDisplayed() {
        return find(FILTER).isDisplayed();
    }

    // "label" refers to specific element border radius settings
    @JDIAction("Check if '{name}' is marked as label chip")
    public boolean isLabel() {
        return hasClass("v-chip--label");
    }

    @JDIAction("Check that '{name}' has an image")
    public boolean hasImage() {
        return new Timer(base().getTimeout() * 1000L)
            .wait(() -> this.find(IMAGE).isExist());
    }

    @JDIAction("Get {name}'s height")
    public String height() {
        return css("height");
    }

    @JDIAction("Get {name}'s font size")
    public String fontSize() {
        return css("font-size");
    }

    @JDIAction("Get {name}'s font color")
    public String fontColor() {
        return css("color");
    }

    @JDIAction("Get {name}'s background color")
    public String backgroundColor() {
        return css("background-color");
    }

    @JDIAction("Get {name}'s borderColor")
    public String borderColor() {
        return css("border-color");
    }

    @JDIAction("Get {name}'s color name")
    public String colorName() {
        String className = attr("class");
        if (className.contains("v-chip--no-color")) {
            return "Default";
        } else {
            return className.split("v-size")[1].split(" ")[1];
        }
    }

    @JDIAction("Check if {name} has a visible border")
    public boolean hasVisibleBorder() {
        return !css("border-color").equals(css("background-color"))
            && !css("border-color").contains("transparent");
    }

    @Override
    public void click() {
        core().click(1, getSize().getHeight() / 2); //click left center in order to miss a closing button if it is on a chip
    }

    @JDIAction("Check if {name} is removable")
    public boolean isRemovable() {
        return hasClass("v-chip--removable");
    }
}
