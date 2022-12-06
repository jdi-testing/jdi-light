package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaginationAssert extends UISelectAssert<PaginationAssert, Pagination>
    implements ThemeAssert<PaginationAssert, Pagination> {
    private static final String DEFAULT_CURRENT_PAGE_ARIA_LABEL = "Current Page";
    private static final String DEFAULT_PREVIOUS_ARIA_LABEL = "Previous page";
    private static final String DEFAULT_NEXT_ARIA_LABEL = "Next page";
    private static final String DEFAULT_PAGE_ARIA_LABEL = "Goto Page";
    private static final String ITEM_CLASS_SELECTED = "v-pagination__item--active";

    @JDIAction("Assert that '{name}' at the start")
    public PaginationAssert started() {
        jdiAssert(element().isStart() ? "start" : "end", Matchers.is("start"));
        return this;
    }

    @JDIAction("Assert that '{name}' at the end")
    public PaginationAssert ended() {
        jdiAssert(element().isStart() ? "start" : "end", Matchers.is("end"));
        return this;
    }

    @JDIAction("Assert that '{name}' is circle")
    public PaginationAssert circle() {
        jdiAssert(element().isCircle() ? "circle" : "not circle", Matchers.is("circle"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not circle")
    public PaginationAssert notCircle() {
        jdiAssert(element().isCircle() ? "circle" : "not circle", Matchers.is("not circle"));
        return this;
    }

//    @JDIAction("Assert that theme of '{name}' is light")
//    public PaginationAssert lightTheme() {
//        jdiAssert(element().isLightTheme(), Matchers.is(true));
//        return this;
//    }
//
//    @JDIAction("Assert that theme of '{name}' is dark")
//    public PaginationAssert darkTheme() {
//        jdiAssert(element().isDarkTheme(), Matchers.is(true));
//        return this;
//    }

    @JDIAction("Assert that '{name}' aria-label has value '{0}'")
    public PaginationAssert currentPageAriaLabel() {
        jdiAssert(element().activeButton().ariaLabel(),
                Matchers.containsString(DEFAULT_CURRENT_PAGE_ARIA_LABEL));
        return this;
    }

    @JDIAction("Assert that '{name}' previous-aria-label has value '{0}'")
    public PaginationAssert previousAriaLabel() {
        jdiAssert(element().leftNavigation().ariaLabel(),
                Matchers.containsString(DEFAULT_PREVIOUS_ARIA_LABEL));
        return this;
    }

    @JDIAction("Assert that '{name}' next-aria-label has value '{0}'")
    public PaginationAssert nextAriaLabel() {
        jdiAssert(element().rightNavigation().ariaLabel(),
                Matchers.containsString(DEFAULT_NEXT_ARIA_LABEL));
        return this;
    }

    @JDIAction("Assert that '{name}' next icon has value '{0}'")
    public PaginationAssert nextIcon(String icon) {
        jdiAssert(element().nextIcon().hasClass(icon),
                Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' next icon has value '{0}'")
    public PaginationAssert previousIcon(String icon) {
        jdiAssert(element().previousIcon().hasClass(icon),
                Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' page-aria-label has value '{0}'")
    public PaginationAssert pageAriaLabel() {
        element().list().foreach(button -> {
            if (!button.hasClass(ITEM_CLASS_SELECTED)) {
                jdiAssert(button.getAttribute("aria-label"),
                        Matchers.containsString(DEFAULT_PAGE_ARIA_LABEL));
            }
        });

        return this;
    }
    @JDIAction("Assert that '{name}' total visible has value '{0}'")
    public PaginationAssert totalVisible(Integer totalVisible) {
        jdiAssert(element().totalVisible(), Matchers.is(totalVisible));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public PaginationAssert color(String color, Boolean isMaterialColor) {
        if (isMaterialColor) {
            jdiAssert(element().activeButton().hasClass(color), Matchers.is(true));
        } else {
            jdiAssert(element().activeButton().has().borderColor(color), Matchers.is(color));
            jdiAssert(element().activeButton().has().backgroundColor(color), Matchers.is(color));
        }
        return this;
    }
}
