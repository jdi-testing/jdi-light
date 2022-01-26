package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.asserts.RatingAssert;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Rating web element please visit https://vuetifyjs.com/en/components/ratings
 */
public class Rating extends UIBaseElement<RatingAssert> implements ISetup, IBaseElement {

    private static final int DEFAULT_SIZE = 24;

    private String rootLocator = ".v-rating";
    private String emptyIconLocator = "";
    private String fullIconLocator = "";
    private String halfIconLocator = "";
    private String colorLocator = "";
    private String backgroundColorLocator = "";
    private String backgroundDarkenLocator = "";

    @JDIAction("Get {name} rating buttons")
    public WebList getRatingButtons() {
        return core().finds("button");
    }

    @JDIAction("Get {name} count rating buttons")
    public int length() {
        return getRatingButtons().size();
    }

    @JDIAction("Get {name} size rating buttons")
    public int size() {
        if (!getRatingButtons().get(1).getAttribute("style").isEmpty()) {
            return Integer.parseInt(getRatingButtons().get(1).getAttribute("style").replaceAll("^\\D*?(\\d+).*$", "$1"));
        } else {
            return DEFAULT_SIZE;
        }
    }

    @JDIAction("Get {name} color")
    public String color() {
        return Arrays.stream(getRatingButtons().get(1).getAttribute("class").split(" "))
                .filter(word -> word.contains("--text"))
                .findFirst()
                .orElse("");
    }

    @JDIAction("Get {name} button index {0} color")
    public String color(int index) {
        return Arrays.stream(getRatingButtons().get(index).getAttribute("class").split(" "))
                .filter(word -> word.contains("--text"))
                .findFirst()
                .orElse("");
    }

    protected Rectangle getRect() {
        return getRatingButtons().get(1).getRect();
    }

    @JDIAction("Set {name} rating to {0}")
    public void hoverSetValue(double rating) {
        if (rating % 1 == 0) {
            getRatingButtons().get((int) rating).hover();
            new Actions(core().driver()).moveByOffset(1, 0).build().perform();
        } else {
            getRatingButtons().get((int) rating + 1).hover();
        }
    }

    protected Double rating(UIElement element) {
        return Double.parseDouble(element.getAttribute("aria-label").replaceAll("^\\D*?(\\d+).*$", "$1")) - 1;
    }

    protected UIElement distinctiveElement(String locator) {
        return getRatingButtons().stream().filter(button -> button.hasClass(locator)).findFirst().orElse(null);
    }

    protected boolean hasHalfIconItem() {
        return !halfIconLocator.isEmpty() && distinctiveElement(halfIconLocator) != null;
    }

    protected boolean fullAndEmptyIconLocatorsAreDifferent() {
        return !Objects.equals(fullIconLocator, emptyIconLocator);
    }

    protected boolean backgroundColorAndColorLocatorsAreDifferent() {
        return !Objects.equals(backgroundColorLocator, colorLocator);
    }

    protected boolean hasEmptyIconItem() {
        return distinctiveElement(emptyIconLocator) != null;
    }

    protected boolean hasFullIconItem() {
        return fullIconLocator != null && !fullIconLocator.isEmpty() && distinctiveElement(fullIconLocator) != null;
    }

    protected boolean hasBackgroundColorItem() {
        return distinctiveElement(backgroundColorLocator) != null;
    }

    protected boolean hasBackgroundDarkenItem() {
        return !backgroundDarkenLocator.isEmpty() && distinctiveElement(backgroundDarkenLocator) != null;
    }

    @JDIAction("Get {name} rating")
    public Double getValue() {
        double value = length();

        if (hasHalfIconItem()) {
            UIElement halfIconElement = distinctiveElement(halfIconLocator);
            value = rating(halfIconElement) + 0.5;

        } else if (fullAndEmptyIconLocatorsAreDifferent()) {
            value = hasEmptyIconItem() ? rating(distinctiveElement(emptyIconLocator)) :
                    hasFullIconItem() ? length() : value;

        } else if (backgroundColorAndColorLocatorsAreDifferent() && hasBackgroundColorItem()) {
            UIElement backgroundColorItem = distinctiveElement(backgroundColorLocator);
            value = rating(backgroundColorItem);

        } else if (hasBackgroundDarkenItem()) {
            UIElement backgroundDarkenItem = distinctiveElement(backgroundDarkenLocator);
            value = rating(backgroundDarkenItem);
        }
        return value;
    }

    @JDIAction("Set {name} rating to {0}")
    public void setValue(double rating) {
        if (rating % 1 == 0) {
            getRatingButtons().get((int) rating).click(getRect().getWidth() / 2 + 1, getRect().getWidth() / 2);
        } else {
            getRatingButtons().get((int) rating + 1).click(getRect().getWidth() / 2 - 1, getRect().getWidth() / 2);
        }
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIRating.class, Rating.class)) {
            JDIRating annotation = field.getAnnotation(JDIRating.class);
            setup(annotation.root(), annotation.emptyIcon(), annotation.fullIcon(), annotation.halfIcon(),
                    annotation.backgroundColor(), annotation.color(), annotation.backgroundDarken());
        }
        this.setName(String.format("Rating container %s", field.getName()));
    }

    public Rating setup(String root, String emptyIcon, String fullIcon, String halfIcon,
                        String backgroundColor, String color, String backgroundDarken) {
        if (!root.isEmpty()) {
            rootLocator = root;
        }
        if (!emptyIcon.isEmpty()) {
            emptyIconLocator = emptyIcon;
        }
        if (!fullIcon.isEmpty()) {
            fullIconLocator = fullIcon;
        }
        if (!halfIcon.isEmpty()) {
            halfIconLocator = halfIcon;
        }
        if (!backgroundColor.isEmpty()) {
            backgroundColorLocator = backgroundColor;
        }
        if (!color.isEmpty()) {
            colorLocator = color;
        }
        if (!backgroundDarken.isEmpty()) {
            backgroundDarkenLocator = backgroundDarken;
        }
        this.setCore(Rating.class, $(rootLocator));
        return this;
    }

    @Override
    public RatingAssert is() {
        return new RatingAssert().set(this);
    }
}
