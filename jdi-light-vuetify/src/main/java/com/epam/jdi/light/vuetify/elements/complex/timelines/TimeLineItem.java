package com.epam.jdi.light.vuetify.elements.complex.timelines;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.timelines.TimeLineItemAssert;
import com.epam.jdi.light.vuetify.elements.complex.Text;

import static com.epam.jdi.light.common.UIUtils.initT;

public class TimeLineItem<T extends ICoreElement, U extends ICoreElement> extends UIBaseElement<TimeLineItemAssert> {

    private static final String SMALL_CLASS = "v-timeline-item__dot--small";
    private static final String LARGE_CLASS = "v-timeline-item__dot--large";

    private String bodyLocator;
    private String dividerLocator;
    private String oppositeLocator;
    private String dotLocator = ".v-timeline-item__dot";
    private String innerDotLocator = ".v-timeline-item__inner-dot";

    private Class<T> bodyClass;
    private Class<U> dividerClass;

    TimeLineItem() { }

    public T body() {
        return initT(find(bodyLocator), this, bodyClass);
    }

    public U divider() {
        return initT(find(dividerLocator), this, dividerClass);
    }

    public Text opposite() { return new Text().setCore(Text.class, core().find(oppositeLocator)); }

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

    public void setBodyLocator(String bodyLocator) {
        this.bodyLocator = bodyLocator;
    }

    public void setDividerLocator(String dividerLocator) {
        this.dividerLocator = dividerLocator;
    }

    public void setDotLocator(String dotLocator) {
        this.dotLocator = dotLocator;
    }

    public void setInnerDotLocator(String innerDotLocator) {
        this.innerDotLocator = innerDotLocator;
    }

    public void setBodyClass(Class<T> bodyClass) {
        this.bodyClass = bodyClass;
    }

    public void setDividerClass(Class<U> dividerClass) {
        this.dividerClass = dividerClass;
    }
}
