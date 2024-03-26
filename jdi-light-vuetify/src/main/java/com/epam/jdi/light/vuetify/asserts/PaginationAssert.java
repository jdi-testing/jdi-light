package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;

import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaginationAssert extends UISelectAssert<PaginationAssert, Pagination>
    implements ThemeAssert<PaginationAssert, Pagination> {

    @JDIAction(value = "Assert that '{name}' at the start", isAssert = true)
    public PaginationAssert atStart() {
        jdiAssert(element().isStart(), Matchers.is(true), "Pagination is not at start");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' at the end", isAssert = true)
    public PaginationAssert atEnd() {
        jdiAssert(element().isEnd(), Matchers.is(true), "Pagination is not at end");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is circle", isAssert = true)
    public PaginationAssert circle() {
        jdiAssert(element().isCircle(), Matchers.is(true), "Pagination is not circle");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not circle", isAssert = true)
    public PaginationAssert notCircle() {
        jdiAssert(element().isCircle(), Matchers.is(false), "Pagination is circle");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' aria-label has value '{0}'", isAssert = true)
    public PaginationAssert currentPageAriaLabel(String lbl) {
        jdiAssert(element().activeButton().ariaLabel(),
                Matchers.containsString(lbl));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' previous-aria-label has value '{0}'", isAssert = true)
    public PaginationAssert previousAriaLabel(String lbl) {
        jdiAssert(element().leftNavigation().ariaLabel(),
                Matchers.containsString(lbl));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' next-aria-label has value '{0}'", isAssert = true)
    public PaginationAssert nextAriaLabel(String lbl) {
        jdiAssert(element().rightNavigation().ariaLabel(),
                Matchers.containsString(lbl));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' next icon has value '{0}'", isAssert = true)
    public PaginationAssert nextIcon(String icon) {
        jdiAssert(element().nextIcon().hasClass(icon),
                Matchers.is(true), "Paginator next icon is not " + icon);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' next icon has value '{0}'", isAssert = true)
    public PaginationAssert previousIcon(String icon) {
        jdiAssert(element().previousIcon().hasClass(icon),
                Matchers.is(true), "Paginator previous icon is not " + icon);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' total visible has value '{0}'", isAssert = true)
    public PaginationAssert totalVisible(Integer totalVisible) {
        jdiAssert(element().totalVisible(), Matchers.is(totalVisible));
        return this;
    }
}
