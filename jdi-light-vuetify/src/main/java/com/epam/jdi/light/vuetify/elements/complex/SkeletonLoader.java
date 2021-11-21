package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of Skeleton Loader web element please visit https://vuetifyjs.com/en/components/skeleton-loaders/
 */

public class SkeletonLoader extends UIBaseElement<UIAssert<?,?>> {

    @JDIAction("Get '{name}' avatar boilerplate")
    public UIElement avatarBoilerplate() {
        return core().find(".v-skeleton-loader__avatar");
    }

    @JDIAction("Get '{name}' text boilerplate")
    public UIElement textBoilerplate() {
        return core().find(".v-skeleton-loader__text");
    }

    @JDIAction("Get '{name}' heading boilerplate")
    public UIElement headingBoilerplate() {
        return core().find(".v-skeleton-loader__heading");
    }

    @JDIAction("Get '{name}' button boilerplate")
    public UIElement buttonBoilerplate() {
        return core().find(".v-skeleton-loader__button");
    }

    @JDIAction("Get '{name}' image boilerplate")
    public UIElement imageBoilerplate() {
        return core().find(".v-skeleton-loader__image");
    }

    @JDIAction("Get '{name}' article boilerplate")
    public UIElement articleBoilerplate() {
        return core().find(".v-skeleton-loader__article");
    }

    @JDIAction("Get '{name}' paragraph boilerplate")
    public UIElement paragraphBoilerplate() {
        return core().find(".v-skeleton-loader__paragraph");
    }

    @JDIAction("Get '{name}' actions boilerplate")
    public UIElement actionsBoilerplate() {
        return core().find(".v-skeleton-loader__actions");
    }

    @JDIAction("Get '{name}' divider boilerplate")
    public UIElement dividerBoilerplate() {
        return core().find(".v-skeleton-loader__divider");
    }
}
