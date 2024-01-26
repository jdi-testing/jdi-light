package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.StringUtils.format;

public class PaginatorAssert extends UIAssert<PaginatorAssert, Paginator> {
    @JDIAction(value = "Assert that '{name}' has '{0}' label", isAssert = true)
    public PaginatorAssert itemPerPageLabel(String label) {
        jdiAssert(element().itemPerPageLabel(), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public PaginatorAssert itemsPerPageSelected(final int number) {
        jdiAssert(element().selected(), Matchers.is(number));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' options for '{name}'", isAssert = true)
    public PaginatorAssert itemsPerPageList(final List<Integer> options) {
        jdiAssert(element().options(), Matchers.is(options));
        return this;

    }

    @JDIAction(value = "Assert that range is '{0}' for '{name}'", isAssert = true)
    public PaginatorAssert rangeLabel(String label) {
        String expected = format(label);
        jdiAssert(element().range(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' color theme", isAssert = true)
    public PaginatorAssert color(AngularColors value) {
        jdiAssert(element().color(), Matchers.equalTo(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' color of the boarder", isAssert = true)
    public PaginatorAssert colorOfBoarder(AngularColors value) {
        AngularColors actualColor = AngularColors.fromColor(element().colorOfBoarder());
        jdiAssert(actualColor, Matchers.equalTo(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' color of the selected option", isAssert = true)
    public PaginatorAssert colorOfSelectedOption(AngularColors value) {
        AngularColors actualColorInList = AngularColors.fromColor(element().colorInList());
        jdiAssert(actualColorInList, Matchers.equalTo(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name} has firstPageLabel='{0}'", isAssert = true)
    public PaginatorAssert firstPageLabel(String label) {
        jdiAssert(element().firstPageLabel(), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name} has lastPageLabel='{0}'", isAssert = true)
    public PaginatorAssert lastPageLabel(String label) {
        jdiAssert(element().lastPageLabel(), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has hidden page size", isAssert = true)
    public PaginatorAssert hiddenPageSize(final boolean value) {
        jdiAssert(element().hidePageSize(), Matchers.is(value),
                value ? "page size should be hidden" : "page size should be visible");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has shown first and last page buttons", isAssert = true)
    public PaginatorAssert showFirstLastButtons(boolean value) {
        jdiAssert(element().showFirstLastButtons(), Matchers.is(value),
                value ? "first and last buttons should be shown" : "first and last buttons should be hidden"
        );
        return this;
    }

    /**
     * @param pageIndex starts from 0
     */
    @JDIAction(value = "Assert that '{name}' has page index of {0}", isAssert = true)
    public PaginatorAssert pageIndex(int pageIndex) {
        jdiAssert(element().pageIndex(), Matchers.is(pageIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has page index of {0}", isAssert = true)
    public PaginatorAssert length(int length) {
        jdiAssert(element().length(), Matchers.is(length));
        return this;
    }
}

