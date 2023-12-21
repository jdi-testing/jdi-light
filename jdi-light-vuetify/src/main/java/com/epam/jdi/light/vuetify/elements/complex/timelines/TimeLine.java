package com.epam.jdi.light.vuetify.elements.complex.timelines;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.annotations.JDITimeLine;
import com.epam.jdi.light.vuetify.asserts.timelines.TimeLineAssert;
import com.epam.jdi.light.vuetify.interfaces.IsDense;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.jdiai.tools.ReflectionUtils.getGenericTypes;

/**
 * To see an example of Timeline web element please visit
 * https://vuetifyjs.com/en/components/timelines/
 */
public class TimeLine<T extends ICoreElement, U extends ICoreElement> extends UIListBase<TimeLineAssert> implements ISetup, IsDense {

    private static final String ALIGN_TOP_CLASS = "v-timeline--align-top";
    private static final String REVERSE_CLASS = "v-timeline--reverse";

    private String rootLocator = ".v-timeline";
    private String itemsLocator = ".v-timeline-item";
    private String bodyLocator = ".v-timeline-item__body";
    private String dividerLocator = ".v-timeline-item__divider";
    private String oppositeLocator = ".v-timeline-item__opposite";

    private Class<T> bodyClass;
    private Class<U> dividerClass;

    @JDIAction("Get if '{name}' is align to top")
    public boolean isAlignTop() {
        return core().hasClass(ALIGN_TOP_CLASS);
    }

    @JDIAction("Get if '{name}' is reverse")
    public boolean isReversed() {
        return core().hasClass(REVERSE_CLASS);
    }

    @Override
    @JDIAction("Get list from '{name}'")
    public WebList list() {
        return core().finds(itemsLocator).setName(getName() + " Time line");
    }

    @JDIAction("Get list of items from '{name}'")
    public List<TimeLineItem<T, U>> items() {
        return list().map(elem -> createItem(elem, bodyClass, dividerClass));
    }

    @JDIAction("Get item by index '{0}' from '{name}'")
    public TimeLineItem<T, U> item(int index) {
        return createItem(list().get(index), bodyClass, dividerClass);
    }

    @JDIAction("Get default item by index '{0}' from '{name}'")
    public TimeLineItem<UIElement, UIElement> defaultItem(int index) {
        return createItem(list().get(index), UIElement.class, UIElement.class);
    }

    protected <C extends ICoreElement, D extends ICoreElement> TimeLineItem<C, D> createItem(UIElement root, Class<C> body, Class<D> divider) {
        TimeLineItem<C, D> timeLineItem = new TimeLineItem<>();
        timeLineItem.setCore(TimeLineItem.class, root);
        timeLineItem.setBodyClass(body);
        timeLineItem.setDividerClass(divider);
        timeLineItem.setBodyLocator(bodyLocator);
        timeLineItem.setDividerLocator(dividerLocator);
        timeLineItem.setOppositeLocator(oppositeLocator);
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
        setCore(TimeLine.class, $(rootLocator));
        setName(String.format("Time line %s", field.getName()));
        initializeGenerics(field);
    }

    private void initializeLocators(JDITimeLine annotation) {
        if (!annotation.root().isEmpty()) {
            rootLocator = annotation.root();
        }
        if (!annotation.items().isEmpty()) {
            itemsLocator = annotation.items();
        }
        if (!annotation.body().isEmpty()) {
            bodyLocator = annotation.body();
        }
        if (!annotation.divider().isEmpty()) {
            dividerLocator = annotation.divider();
        }
        if (!annotation.opposite().isEmpty()) {
            oppositeLocator = annotation.opposite();
        }
    }

    private void initializeGenerics(Field field) {
        Type bodyType = getGenericTypes(field)[0];
        Type dividerType = getGenericTypes(field)[1];
        bodyClass = (Class<T>) (bodyType.toString().equals("?") ? UIElement.class : bodyType);
        dividerClass = (Class<U>) (dividerType.toString().equals("?") ? UIElement.class : dividerType);
    }
}
