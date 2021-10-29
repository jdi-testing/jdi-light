package com.epam.jdi.light.vuetify.elements.complex.timelines;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.timelines.TimeLineItemAssert;

import static com.epam.jdi.light.common.UIUtils.initT;

public class TimeLineItem<T extends ICoreElement, U extends ICoreElement> extends UIBaseElement<TimeLineItemAssert> {

    protected String BODY_LOCATOR;
    protected String DIVIDER_LOCATOR;
    protected String OPPOSITE_LOCATOR;
    protected String DOT_LOCATOR = ".v-timeline-item__dot";
    protected String INNER_DOT_LOCATOR = ".v-timeline-item__inner-dot";

    protected String SMALL_CLASS = "v-timeline-item__dot--small";
    protected String LARGE_CLASS = "v-timeline-item__dot--large";

    protected Class<T> bodyClass;
    protected Class<U> dividerClass;

    TimeLineItem() {}

    public T body() {
        return initT(find(BODY_LOCATOR), this, bodyClass);
    }

    public U divider() {
        return initT(find(DIVIDER_LOCATOR), this, dividerClass);
    }

    public UIElement opposite() {
        return find(OPPOSITE_LOCATOR);
    }

    public boolean isSmall() {
        return find(DOT_LOCATOR).hasClass(SMALL_CLASS);
    }

    public boolean isLarge() {
        return find(DOT_LOCATOR).hasClass(LARGE_CLASS);
    }

    public String dotColor() {
        return find(INNER_DOT_LOCATOR).css("background-color");
    }

    @Override
    public TimeLineItemAssert is() {
        return new TimeLineItemAssert().set(this);
    }
}
