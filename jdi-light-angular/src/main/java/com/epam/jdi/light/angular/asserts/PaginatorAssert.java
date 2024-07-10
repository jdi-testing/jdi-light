package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaginatorAssert extends UIAssert<PaginatorAssert, Paginator> implements ColorAssert<PaginatorAssert, Paginator> {
    @JDIAction(value = "Assert that '{name}' has '{0}' label", isAssert = true)
    public PaginatorAssert pageSizeLabel(final String label) {
        jdiAssert(element().itemPerPageLabel(), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' matches '{0}' label regEx", isAssert = true)
    public PaginatorAssert pageSizeLabelMatches(final String regex) {
        jdiAssert(element().itemPerPageLabel(), Matchers.matchesPattern(regex));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public PaginatorAssert itemsPerPageSelected(final int number) {
        jdiAssert(element().selected(), Matchers.is(number));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' options for '{name}'", isAssert = true)
    public PaginatorAssert itemsPerPageList(final List<String> options) {
        element().itemPerPageSelect.expand();
        jdiAssert(element().itemPerPageSelect.list().values(), Matchers.equalTo(options));
        return this;

    }

    @JDIAction(value = "Assert that range is '{0}' for '{name}'", isAssert = true)
    public PaginatorAssert rangeLabel(final String label) {
        jdiAssert(element().range(), Matchers.equalTo(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name} has firstPageLabel='{0}'", isAssert = true)
    public PaginatorAssert firstPageLabel(final String label) {
        jdiAssert(element().firstPageLabel(), Matchers.equalTo(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name} has lastPageLabel='{0}'", isAssert = true)
    public PaginatorAssert lastPageLabel(final String label) {
        jdiAssert(element().lastPageLabel(), Matchers.equalTo(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has hidden page size", isAssert = true)
    public PaginatorAssert hiddenPageSize(boolean value) {
        jdiAssert(element().isPageSizeHidden(), Matchers.is(value),
                value ? "page size should be hidden" : "page size should be visible");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has shown first and last page buttons", isAssert = true)
    public PaginatorAssert firstLastButtonsShown(boolean value) {
        jdiAssert(element().isFirstLastButtonsShown(), Matchers.is(value),
                value ? "first and last buttons should be SHOWN" : "first and last buttons should be DISPLAYED"
        );
        return this;
    }

    /**
     * @param pageIndex starts from 0
     */
    @JDIAction(value = "Assert that '{name}' has current page index of {0}", isAssert = true)
    public PaginatorAssert pageIndexCurrent(int pageIndex) {
        jdiAssert(element().pageIndexCurrent(), Matchers.equalTo(pageIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} total number of items that are being paginated", isAssert = true)
    public PaginatorAssert totalNumberOfPaginatedItems(int length) {
        jdiAssert(element().totalNumberOfPaginatedItems(), Matchers.equalTo(length));
        return this;
    }

    @JDIAction(value = "Assert that previous button enabled for '{name}'", isAssert = true)
    public PaginatorAssert previousPageButtonEnabled() {
        jdiAssert(element().previousButton().isEnabled(), Matchers.is(true),
                "previous button should be ENABLED");
        return this;
    }

    @JDIAction(value = "Assert that previous button disabled for '{name}'", isAssert = true)
    public PaginatorAssert previousPageButtonDisabled() {
        jdiAssert(element().previousButton().isDisabled(), Matchers.is(true),
                "previous button should be DISABLED");
        return this;
    }

    @JDIAction(value = "Assert that next button enabled for '{name}'", isAssert = true)
    public PaginatorAssert nextPageButtonEnabled() {
        jdiAssert(element().nextButton().isEnabled(), Matchers.is(true),
                "next button should be ENABLED");
        return this;
    }

    @JDIAction(value = "Assert that next button disabled for '{name}'", isAssert = true)
    public PaginatorAssert nextPageButtonDisabled() {
        jdiAssert(element().nextButton().isDisabled(), Matchers.is(true),
                "previous button should be DISABLED");
        return this;
    }

    @JDIAction(value = "Assert that item per page selector is disabled for '{name}'", isAssert = true)
    public PaginatorAssert itemPerPageSelectorDisabled() {
        jdiAssert(element().itemPerPageSelect.attr("aria-disabled"), Matchers.equalTo("true"),
                "item per page selector should be DISABLED");
        return this;
    }

    @JDIAction(value = "Assert that first page button displayed={0} for '{name}'", isAssert = true)
    public PaginatorAssert firstPageButtonDisplayed(boolean value) {
        jdiAssert(element().firstPageButton().isDisplayed(), Matchers.is(value),
                value ? "fist page button should be DISPLAYED" : "first page button should be HIDDEN");
        return this;
    }

    @JDIAction(value = "Assert that last page button displayed={0} for '{name}'", isAssert = true)
    public PaginatorAssert lastPageButtonDisplayed(boolean value) {
        jdiAssert(element().lastPageButton().isDisplayed(), Matchers.is(value),
                value ? "last page button should be DISPLAYED" : "last page button should be HIDDEN");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public PaginatorAssert color(AngularColors expectedColor) {
        jdiAssert(element().color(), Matchers.equalTo(expectedColor.getType()));
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public PaginatorAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.equalTo(expectedColor));
        return this;
    }
}

