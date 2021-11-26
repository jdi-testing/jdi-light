package com.epam.jdi.light.vuetify.elements.complex.timelines;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.timelines.TimeLineItemAssert;

import static com.epam.jdi.light.common.UIUtils.initT;

public class TimeLineItem<T extends ICoreElement, U extends ICoreElement> extends UIBaseElement<TimeLineItemAssert> {

    protected static final String SMALL_CLASS = "v-timeline-item__dot--small";
    protected static final String LARGE_CLASS = "v-timeline-item__dot--large";

    protected String bodyLocator;
    protected String dividerLocator;
    private String oppositeLocator;
    protected String dotLocator = ".v-timeline-item__dot";
    protected String innerDotLocator = ".v-timeline-item__inner-dot";

    protected Class<T> bodyClass;
    protected Class<U> dividerClass;

    TimeLineItem() {}

    public T body() {
        return initT(find(bodyLocator), this, bodyClass);
    }

    public U divider() {
        return initT(find(dividerLocator), this, dividerClass);
    }

    public UIElement opposite() {
        return find(oppositeLocator);
    }

    public boolean isSmall() {
        return find(dotLocator).hasClass(SMALL_CLASS);
    }

    public boolean isLarge() {
        return find(dotLocator).hasClass(LARGE_CLASS);
    }

    public String dotColor() {
        return find(innerDotLocator).css("background-color");
    }

    @Override
    public TimeLineItemAssert is() {
        return new TimeLineItemAssert().set(this);
    }

    public void setOppositeLocator(String oppositeLocator) {
        this.oppositeLocator = oppositeLocator;
    }
}
