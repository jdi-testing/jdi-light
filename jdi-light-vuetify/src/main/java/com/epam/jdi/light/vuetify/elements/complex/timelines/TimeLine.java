package com.epam.jdi.light.vuetify.elements.complex.timelines;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.annotations.JDITimeLine;
import com.epam.jdi.light.vuetify.asserts.timelines.TimeLineAssert;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

/**
 * To see an example of Timeline web element please visit
 * https://vuetifyjs.com/en/components/timelines/
 */
public class TimeLine<T extends ICoreElement, U extends ICoreElement> extends UIListBase<TimeLineAssert> implements ISetup{

    protected String ROOT_LOCATOR = ".v-timeline";
    protected String ITEMS_LOCATOR = ".v-timeline-item";
    protected String BODY_LOCATOR = ".v-timeline-item__body";
    protected String DIVIDER_LOCATOR = ".v-timeline-item__divider";
    protected String OPPOSITE_LOCATOR = ".v-timeline-item__opposite";

    protected String ALIGN_TOP_CLASS = "v-timeline--align-top";
    protected String DENSE_CLASS = "v-timeline--dense";
    protected String REVERSE_CLASS = "v-timeline--reverse";

    protected Class<T> bodyClass;
    protected Class<U> dividerClass;

    @JDIAction("Check if '{name}' is align to top")
    public boolean isAlignTop() {
        return hasClass(ALIGN_TOP_CLASS);
    }

    @JDIAction("Check if '{name}' is dense")
    public boolean isDense() {
        return hasClass(DENSE_CLASS);
    }

    @JDIAction("Check if '{name}' is reverse")
    public boolean isReversed() {
        return hasClass(REVERSE_CLASS);
    }

    @Override
    @JDIAction("Get list from '{name}'")
    public WebList list() {
        return finds(ITEMS_LOCATOR).setName(getName() + " Time line");
    }

    @JDIAction("Get list of items from '{name}'")
    public List<TimeLineItem<T, U>> items() {
        return list().map(this::createItem);
    }

    @JDIAction("Get item by index '{0}' from '{name}'")
    public TimeLineItem<T, U> item(int index) {
        return createItem(list().get(index));
    }

    protected TimeLineItem<T, U> createItem(UIElement root) {
        TimeLineItem<T, U> timeLineItem = new TimeLineItem<>();
        timeLineItem.setCore(TimeLineItem.class, root);
        timeLineItem.bodyClass = bodyClass;
        timeLineItem.dividerClass = dividerClass;
        timeLineItem.BODY_LOCATOR = BODY_LOCATOR;
        timeLineItem.DIVIDER_LOCATOR = DIVIDER_LOCATOR;
        timeLineItem.OPPOSITE_LOCATOR = OPPOSITE_LOCATOR;
        return timeLineItem;
    }

    @Override
    public TimeLineAssert is() {
        return new TimeLineAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDITimeLine.class, TimeLine.class)) {
            JDITimeLine annotation = field.getAnnotation(JDITimeLine.class);
            initializeLocators(annotation);
        }
        setCore(TimeLine.class, $(ROOT_LOCATOR));
        setName(String.format("Time line container %s", field.getName()));
        initializeGenerics(field);
    }

    private void initializeLocators(JDITimeLine annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.items().isEmpty()) {
            ITEMS_LOCATOR = annotation.items();
        }
        if (!annotation.body().isEmpty()) {
            BODY_LOCATOR = annotation.body();
        }
        if (!annotation.divider().isEmpty()) {
            DIVIDER_LOCATOR = annotation.divider();
        }
        if (!annotation.opposite().isEmpty()) {
            OPPOSITE_LOCATOR = annotation.opposite();
        }
    }

    private void initializeGenerics(Field field) {
        Type bodyType = getGenericTypes(field)[0];
        Type dividerType = getGenericTypes(field)[1];
        bodyClass = bodyType.toString().equals("?") ? (Class<T>) UIElement.class : (Class<T>) bodyType;
        dividerClass = dividerType.toString().equals("?") ? (Class<U>) UIElement.class : (Class<U>) dividerType;
    }
}
