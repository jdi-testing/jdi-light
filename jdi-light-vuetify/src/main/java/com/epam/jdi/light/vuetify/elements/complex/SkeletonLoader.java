package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.SkeletonLoaderAssert;
import com.epam.jdi.light.vuetify.interfaces.HasCursor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

/**
 * To see an example of Skeleton Loader web element please visit https://v2.vuetifyjs.com/en/components/skeleton-loaders/
 */

public class SkeletonLoader extends UIBaseElement<SkeletonLoaderAssert> implements HasTheme, HasElevation, HasCursor,
        HasMeasurement, IsTile {
    @Override
    public SkeletonLoaderAssert is() {
        return new SkeletonLoaderAssert().set(this);
    }

    @JDIAction("Get '{name}' avatar")
    public UIElement avatar() {
        return core().find(".v-skeleton-loader__avatar");
    }

    @JDIAction("Get '{name}' text")
    public UIElement text() {
        return core().find(".v-skeleton-loader__text");
    }

    @JDIAction("Get '{name}' heading")
    public UIElement heading() {
        return core().find(".v-skeleton-loader__heading");
    }

    @JDIAction("Get '{name}' button")
    public UIElement button() {
        return core().find(".v-skeleton-loader__button");
    }

    @JDIAction("Get '{name}' image")
    public UIElement image() {
        return core().find(".v-skeleton-loader__image");
    }

    @JDIAction("Get '{name}' article")
    public UIElement article() {
        return core().find(".v-skeleton-loader__article");
    }

    @JDIAction("Get '{name}' paragraph")
    public UIElement paragraph() {
        return core().find(".v-skeleton-loader__paragraph");
    }

    @JDIAction("Get '{name}' actions")
    public UIElement actions() {
        return core().find(".v-skeleton-loader__actions");
    }

    @JDIAction("Get '{name}' divider")
    public UIElement divider() {
        return core().find(".v-skeleton-loader__divider");
    }

    @JDIAction("Get if '{name}' is boilerplate")
    public boolean isBoilerplate() {
        return core().hasClass("v-skeleton-loader--boilerplate");
    }
}
