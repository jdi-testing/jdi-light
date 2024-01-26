package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.PaginatorAssert;
import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * To see an example of Paginator web element please visit <a href="https://material.angular.io/components/paginator/overview">...</a>.
 */

public class Paginator extends UIBaseElement<PaginatorAssert> {
    private static final String ITEM_PER_PAGE_LABEL_LOCATOR = ".mat-mdc-paginator-page-size-label";
    private static final String ITEM_PER_PAGE_FIELD_LOCATOR = "mat-form-field";
    private static final String RANGE_LABEL_LOCATOR = ".mat-mdc-paginator-range-label";
    private static final String FIRST_PAGE_BUTTON_LOCATOR = "button.mat-mdc-paginator-navigation-first";
    private static final String LAST_PAGE_BUTTON_LOCATOR = "button.mat-mdc-paginator-navigation-last";
    private static final String PREVIOUS_PAGE_BUTTON_LOCATOR = "button.mat-mdc-paginator-navigation-previous";
    private static final String NEXT_PAGE_BUTTON_LOCATOR = "button.mat-mdc-paginator-navigation-next";
    private static final String BOARDER_LOCATOR = ".mdc-notched-outline__leading";
    private static final String PAGINATOR_PAGE_SIZE_SECTION_LOCATOR = ".mat-mdc-paginator-page-size";
    private static final String ITEM_PER_PAGE_SELECTOR_LOCATOR = "mat-select";
    private final PaginatorSelector itemPerPageSelector;
    private static final Pattern PATTERN = Pattern.compile("^(\\d+)( . (\\d+))? .+ (\\d+)");

    public Paginator() {
        itemPerPageSelector = new PaginatorSelector().setCore(PaginatorSelector.class, core().find(ITEM_PER_PAGE_SELECTOR_LOCATOR));
    }

    @Override
    public PaginatorAssert is() {
        return new PaginatorAssert().set(this);
    }

    @Override
    public PaginatorAssert has() {
        return is();
    }

    @JDIAction("Get label for '{name}'")
    public String itemPerPageLabel() {
        return core().find(ITEM_PER_PAGE_LABEL_LOCATOR).getText();
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Get previous page button for '{name}'")
    public Button previousButton() {
        return new Button().setCore(Button.class, core().find(PREVIOUS_PAGE_BUTTON_LOCATOR));
    }

    @JDIAction("Get next page button for '{name}'")
    public Button nextButton() {
        return new Button().setCore(Button.class, core().find(NEXT_PAGE_BUTTON_LOCATOR));
    }

    @JDIAction("Get first page button for '{name}'")
    public Button firstPageButton() {
        return new Button().setCore(Button.class, core().find(FIRST_PAGE_BUTTON_LOCATOR));
    }

    @JDIAction("Get last page button for '{name}'")
    public Button lastPageButton() {
        return new Button().setCore(Button.class, core().find(LAST_PAGE_BUTTON_LOCATOR));
    }

    @JDIAction("Get item per page selector for '{name}'")
    public PaginatorSelector itemPerPageSelector() {
        return itemPerPageSelector;
    }

    @JDIAction("Get options for '{name}'")
    public List<Integer> options() {
        return itemPerPageSelector.values().stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    @JDIAction("Select option for '{name}'")
    public void select(int number) {
        itemPerPageSelector.select(String.valueOf(number));
    }

    @JDIAction("Get selected option for '{name}'")
    public int selected() {
        return Integer.parseInt(itemPerPageSelector.value());
    }

    @JDIAction("Get range for '{name}'")
    public String range() {
        return core().find(RANGE_LABEL_LOCATOR).getText();
    }

    @JDIAction("Click previous for '{name}'")
    public void previousPage() {
        previousButton().click();
    }

    @JDIAction("Click next for '{name}'")
    public void nextPage() {
        nextButton().click();
    }

    @JDIAction("Get COLOR theme for '{name}'")
    public AngularColors color() {
        final AngularColors color = AngularColors.fromName(core().attr("color"));
        return color.equals(AngularColors.UNDEFINED) ? AngularColors.PRIMARY : color;
    }

    @JDIAction("Get COLOR of selector`s boarder for '{name}'")
    public String colorOfBoarder() {
        itemPerPageSelector.expand();
        final String cssValue = core().find(ITEM_PER_PAGE_FIELD_LOCATOR).find(BOARDER_LOCATOR).getCssValue("border-color");
        itemPerPageSelector.collapse();
        return cssValue;
    }

    @JDIAction("Get COLOR for selected value in the list of options for '{name}'")
    public String colorInList() {
        itemPerPageSelector.expand();
        String cssValue = itemPerPageSelector.selectedElement().getCssValue("color");
        itemPerPageSelector.collapse();
        return cssValue;
    }

    @JDIAction("Get '{name}' firstPageLabel")
    public String lastPageLabel() {
        return core().attr("lastPageLabel");
    }

    @JDIAction("Get '{name}' firstPageLabel")
    public String firstPageLabel() {
        return core().attr("firstPageLabel");
    }

    @JDIAction("Get if '{name}' page size selector is hidden")
    public boolean hidePageSize() {
        return core().find(PAGINATOR_PAGE_SIZE_SECTION_LOCATOR).isHidden();
    }

    @JDIAction("Get '{name}' page index")
    public int pageIndex() {
        final int first = Integer.parseInt(getMatcherForRange().group(1));
        return first != 0 ? (first - 1) / selected() : 0;
    }

    @JDIAction("Get '{name}' page index")
    public int length() {
        return Integer.parseInt(getMatcherForRange().group(4));
    }

    @JDIAction("Parse '{name}' range with pattern {PATTERN}")
    private Matcher getMatcherForRange() {
        Matcher matcher = PATTERN.matcher(range());
        if (!matcher.matches()) {
            throw new IllegalStateException(
                    String.format("Pattern '%s' has no matches for string '%s'", PATTERN.pattern(), range()));
        }
        return matcher;
    }

    @JDIAction("Get if '{name}' has first and last page buttons shown")
    public boolean showFirstLastButtons() {
        return lastPageButton().isDisplayed() && firstPageButton().isDisplayed();
    }
}
