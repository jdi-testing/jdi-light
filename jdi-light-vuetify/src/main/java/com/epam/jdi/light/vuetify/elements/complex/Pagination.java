package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIPagination;
import com.epam.jdi.light.vuetify.asserts.PaginationAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Pagination web element please visit
 * https://v2.vuetifyjs.com/en/components/paginations/
 */
public class Pagination extends UIListBase<PaginationAssert> implements ISetup, HasTheme {

    protected static final String CORE_CLASS_DISABLED = "v-pagination--disabled";
    protected static final String ITEM_CLASS_SELECTED = "v-pagination__item--active";
    private static final String CIRCLE_CLASS = "v-pagination--circle";

    private String rootLocator = ".v-pagination";
    private String itemsLocator = ".v-pagination__item";
    private String rightNavigationLocator = ".v-pagination__navigation[2]";
    private String leftNavigationLocator = ".v-pagination__navigation[1]";

    @Override
    @JDIAction("Get '{name}' list of all buttons ")
    public WebList list() {
        return core().finds(itemsLocator).setName(getName() + " pagination");
    }

    @JDIAction("Get '{name}' left navigation button")
    public VuetifyButton leftNavigation() {
        return new VuetifyButton(core().find(leftNavigationLocator));
    }

    @JDIAction("Get '{name}' right navigation button")
    public VuetifyButton rightNavigation() {
        return new VuetifyButton(core().find(rightNavigationLocator));
    }

    @JDIAction("Get '{name}' next icon")
    public UIElement nextIcon() {
        return rightNavigation().find("i");
    }

    @JDIAction("Get '{name}' previous icon")
    public UIElement previousIcon() {
        return leftNavigation().find("i");
    }

    @JDIAction("Get '{name}' more button")
    public UIElement moreButton() {
        return core().find(".v-pagination__more");
    }

    @JDIAction("Get '{name}' active button")
    public VuetifyButton activeButton() {
        return new VuetifyButton(core().find("." + ITEM_CLASS_SELECTED));
    }

    @JDIAction("Get '{name}' total visible")
    public Integer totalVisible() {
        return list().size();
    }

    @Override
    @JDIAction("Get '{name}' selected button text")
    public String selected() {
        return list().stream()
                     .filter(button -> button.hasClass(ITEM_CLASS_SELECTED))
                     .findFirst()
                     .map(UIElement::getText)
                     .orElse(null);
    }

    @Override
    @JDIAction("Get if button from '{name}' by name '{0}' is selected")
    public boolean selected(String option) {
        return list().get(option).hasClass(ITEM_CLASS_SELECTED);
    }

    @Override
    @JDIAction("Get if button from '{name}' by index '{0}' is selected")
    public boolean selected(int index) {
        return list().get(index).hasClass(ITEM_CLASS_SELECTED);
    }

    @JDIAction("Get if button from '{name}' by name '{0}' is selected")
    public PaginationPage selectedPage() {
        return new PaginationPage().setCore(PaginationPage.class, list().stream()
                .filter(button -> button.hasClass(ITEM_CLASS_SELECTED))
                .findFirst().get());
    }

    @JDIAction("Get Page '{name}' by name '{0}'")
    public PaginationPage page(String option) {
        return new PaginationPage().setCore(PaginationPage.class, list().get(option));
    }

    @JDIAction("Get Page '{name}' by index '{0}'")
    public PaginationPage page(int index) {
        return new PaginationPage().setCore(PaginationPage.class, list().get(index));
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(CORE_CLASS_DISABLED);
    }

    @JDIAction("Get if '{name}' is at start")
    public boolean isStart() {
        return leftNavigation().isDisabled();
    }

    @JDIAction("Get if pagination '{name}' is at end")
    public boolean isEnd() {
        return rightNavigation().isDisabled();
    }

    @Override
    public PaginationAssert is() {
        return new PaginationAssert().set(this);
    }

    @JDIAction("Get if '{name}' has next page")
    public boolean hasNext() {
        return !isEnd();
    }

    @JDIAction("Get if '{name}' has previous page")
    public boolean hasPrevious() {
        return !isStart();
    }

    @JDIAction("Go to next page through next button in '{name}'")
    public void next() {
        rightNavigation().click();
    }

    @JDIAction("Go to previous page through previous button in '{name}'")
    public void back() {
        leftNavigation().click();
    }

    @JDIAction("Get if '{name}' is circle")
    public boolean isCircle() {
        return core().hasClass(CIRCLE_CLASS);
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIPagination.class, Pagination.class)) {
            JDIPagination annotation = field.getAnnotation(JDIPagination.class);
            setup(annotation.root(), annotation.items(), annotation.left(), annotation.right());
        }
        this.setName(String.format("Pagination %s", field.getName()));
    }

    public Pagination setup(String root, String items, String left, String right) {
        if (!root.isEmpty()) {
            rootLocator = root;
        }
        if (!items.isEmpty()) {
            itemsLocator = items;
        }
        if (!left.isEmpty()) {
            leftNavigationLocator = left;
        }
        if (!right.isEmpty()) {
            rightNavigationLocator = right;
        }

        this.setCore(Pagination.class, $(rootLocator));
        return this;
    }
}
