package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.asserts.RatingAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Rating web element please visit https://vuetifyjs.com/en/components/ratings
 */
public class Rating extends UIBaseElement<RatingAssert> implements ISetup, IBaseElement, IsReadOnly, HasColor, IsDense,
        HasTheme {
    private String rootLocator = ".v-rating";
    private String fullIconLocator = ".mdi-star";
    private String halfIconLocator = ".mdi-star-half-full";

    @JDIAction("Get '{name}' count buttons")
    public int length() {
        return getRatingButtons().size();
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getRatingButtons() {
        return core().finds("button");
    }

    @Override
    @JDIAction("Get '{name}' color")
    public String color() {
        return getRatingButtons().get(1).css("color");
    }

    @JDIAction("Get '{name}' button index '{0}' color")
    public String color(int index) {
        return getRatingButtons().get(index).css("color");
    }

    @JDIAction("Set '{name}' rating to '{0}'")
    public void hoverSetValue(double rating) {
        if (rating % 1 == 0) {
            getRatingButtons().get((int) rating).hover();
            new Actions(core().driver()).moveByOffset(1, 0).build().perform();
        } else {
            getRatingButtons().get((int) rating + 1).hover();
            new Actions(core().driver()).moveByOffset(-1, 0).build().perform();
        }
    }

    @JDIAction("Get '{name}' rating")
    public Double getValue() {
        double value = core().finds(fullIconLocator).size();
        if (core().finds(halfIconLocator).isNotEmpty()) {
            value += 0.5;
        }
        return value;
    }

    @JDIAction("Set '{name}' rating to '{0}'")
    public void setValue(double rating) {
        if (rating % 1 == 0) {
            getRatingButtons().get((int) rating).click(getRect().getWidth() / 2 + 1, getRect().getWidth() / 2);
        } else {
            getRatingButtons().get((int) rating + 1).click(getRect().getWidth() / 2 - 1, getRect().getWidth() / 2);
        }
    }

    @JDIAction("Get '{name}' theme")
    public String theme() {
        return getRatingButtons().get(1).classLike("theme--");
    }

    @JDIAction("Get '{name}' size")
    public int size() {
        return Integer.parseInt(getRatingButtons().get(1).css("font-size").replace("px", ""));
    }

    protected Rectangle getRect() {
        return getRatingButtons().get(1).getRect();
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIRating.class, Rating.class)) {
            JDIRating annotation = field.getAnnotation(JDIRating.class);
            setup(annotation.root(), annotation.fullIcon(), annotation.halfIcon());
        }
        this.setName(String.format("Rating container %s", field.getName()));
    }

    public Rating setup(String root, String fullIcon, String halfIcon) {
        if (!root.isEmpty()) {
            rootLocator = root;
        }
        if (!fullIcon.isEmpty()) {
            fullIconLocator = fullIcon;
        }
        if (!halfIcon.isEmpty()) {
            halfIconLocator = halfIcon;
        }
        this.setCore(Rating.class, $(rootLocator));
        return this;
    }

    @Override
    public RatingAssert is() {
        return new RatingAssert().set(this);
    }
}
