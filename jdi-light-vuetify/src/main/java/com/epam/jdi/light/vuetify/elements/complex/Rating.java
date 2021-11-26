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

    protected static final int DEFAULT_SIZE = 24;

    protected String rootLocator = ".v-rating";
    protected String emptyIconLocator = "";
    protected String fullIconLocator = "";
    protected String halfIconLocator = "";
    protected String colorLocator = "";
    protected String backgroundColorLocator = "";
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

    @JDIAction("Get {name} rating")
    public Double getValue() {

        if (!halfIconLocator.isEmpty()) {
            UIElement distinctiveElement = distinctiveElement(halfIconLocator);
            if (distinctiveElement != null) {
                return rating(distinctiveElement) + 0.5;
            }
        }
        if (!Objects.equals(fullIconLocator, emptyIconLocator)) {
            UIElement distinctiveElement = distinctiveElement(emptyIconLocator);
            if (distinctiveElement != null) {
                return rating(distinctiveElement);
            }
            if (fullIconLocator != null && !fullIconLocator.isEmpty() && distinctiveElement(fullIconLocator) != null) {
                return (double) length();
            }
        }
        if (!Objects.equals(backgroundColorLocator, colorLocator)) {
            UIElement distinctiveElement = distinctiveElement(backgroundColorLocator);
            if (distinctiveElement != null) {
                return rating(distinctiveElement);
            }
        }
        if (!backgroundDarkenLocator.isEmpty()) {
            UIElement distinctiveElement = distinctiveElement(backgroundDarkenLocator);
            if (distinctiveElement != null) {
                return rating(distinctiveElement);
            }
        }

        return (double) length();
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
            initializeLocators(annotation);
        }
        this.setCore(Breadcrumbs.class, $(rootLocator));
        this.setName(String.format("Rating container %s", field.getName()));
    }

    private void initializeLocators(JDIRating annotation) {
        if (!annotation.root().isEmpty()) {
            rootLocator = annotation.root();
        }
        if (!annotation.emptyIcon().isEmpty()) {
            emptyIconLocator = annotation.emptyIcon();
        }
        if (!annotation.fullIcon().isEmpty()) {
            fullIconLocator = annotation.fullIcon();
        }
        if (!annotation.halfIcon().isEmpty()) {
            halfIconLocator = annotation.halfIcon();
        }
        if (!annotation.backgroundColor().isEmpty()) {
            backgroundColorLocator = annotation.backgroundColor();
        }
        if (!annotation.color().isEmpty()) {
            colorLocator = annotation.color();
        }
        if (!annotation.backgroundDarken().isEmpty()) {
            backgroundDarkenLocator = annotation.backgroundDarken();
        }
    }

    @Override
    public RatingAssert is() {
        return new RatingAssert().set(this);
    }
}
