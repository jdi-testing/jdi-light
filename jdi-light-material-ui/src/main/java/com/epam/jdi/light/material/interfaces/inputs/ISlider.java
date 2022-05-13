package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import org.apache.commons.lang3.RegExUtils;
import org.openqa.selenium.By;

import java.util.Locale;

public interface ISlider extends CanBeDisabled {
    enum Orientation {
        VERTICAL, HORIZONTAL
    }

    enum Type {
        DISCRETE, CONTINUOUS
    }

    @JDIAction(value = "Get {name}'s slider label")
    default UIElement sliderLabel() {
        return find(".MuiSlider-valueLabel");
    }

    @JDIAction(value = "Get {name}'s slider")
    default UIElement slider() {
        return find("[role=slider]");
    }

    @JDIAction(value = "Get {name}'s track")
    default UIElement track() {
        return core().find(By.cssSelector(".MuiSlider-track"));
    }

    @JDIAction(value = "Get {name}'s thumb")
    default UIElement thumb(int index) {
        return core().finds(".MuiSlider-thumb").get(index);
    }

    @JDIAction(value = "Get {name}'s value")
    default String value(int index) {
        return thumb(index).attr("aria-valuenow");
    }

    @JDIAction(value = "Get {name}'s minimum value")
    default String min(int index) {
        return thumb(index).attr("aria-valuemin");
    }

    @JDIAction(value = "Get {name}'s maximum value")
    default String max(int index) {
        return thumb(index).attr("aria-valuemax");
    }
    @JDIAction(value = "Set value '{0}' for '{name}'")
    default void setValue(int index, String value) {
        if (this.isDisabled()) {
            return;
        }
        double minVal = Double.parseDouble(min(index));
        double maxVal = Double.parseDouble(max(index));
        double percentsInUnit = 100d / (maxVal - minVal);
        double newStyleValue = (Double.parseDouble(value) - minVal) * percentsInUnit;

        String thumbStyle = thumb(index).getAttribute("style");
        String newThumbStyle = RegExUtils.replacePattern(thumbStyle, "([\\d.]+)",
                String.valueOf(newStyleValue));

        thumb(index).setAttribute("aria-valuenow", value);
        thumb(index).setAttribute("style", newThumbStyle);
        core().findFirst("input").setAttribute("value", value);
        thumb(index).click();
    }

    @JDIAction(value = "Get '{name}' orientation")
    default Orientation orientation() {
        return Orientation.valueOf(thumb(1).attr("aria-orientation").toUpperCase(Locale.ROOT));
    }

    @JDIAction(value = "Check that {name} is discrete")
    default Type type() {
        return finds(".MuiSlider-mark").isNotEmpty() ? Type.DISCRETE : Type.CONTINUOUS;
    }


    @JDIAction(value = "drag and drop {name}'s thumb")
    default void dragAndDropThumbTo(int index, String value) {
        Orientation orientation = orientation();
        double minValue = Double.parseDouble(min(index));
        double maxValue = Double.parseDouble(max(index));
        double coreSize, trackSize;

        if(orientation.equals(Orientation.HORIZONTAL)) {
            coreSize = core().getSize().getWidth();
            trackSize = track().getSize().getWidth();
        } else {
            coreSize = core().getSize().getHeight();
            trackSize = track().getSize().getHeight();
        }

        double pixelsInUnit = coreSize / (maxValue - minValue);
        double offset = (Double.parseDouble(value) - minValue) * pixelsInUnit - trackSize;

        if (orientation.equals(Orientation.HORIZONTAL)) {
            thumb(index).dragAndDropTo((int) Math.round(offset), 0);
        } else {
            thumb(index).dragAndDropTo(0, -(int) Math.round(offset));
        }
    }
}
