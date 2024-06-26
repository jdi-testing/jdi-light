package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.PaginatorAssert;
import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

/**
 * To see an example of Paginator web element please visit <a href="https://material.angular.io/components/paginator/overview">...</a>.
 */

public class Paginator extends UIBaseElement<PaginatorAssert> implements HasColor {
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
    private static final String SELECT_PANEL_LOCATOR = "div.mat-mdc-select-panel";
    private static final String ITEM_PER_PAGE_OPTIONS_LOCATOR = "mat-option";
    private static final String ARIA_EXPANDED_ATTR = "aria-expanded";

    private Pattern rangeLabelPattern = Pattern.compile("^(\\d+)( . (\\d+))? .+ (\\d+)");

    @JDIAction("Set pattern for '{name}' range label")
    public void setRangeLabelPattern(String regex) {
        rangeLabelPattern = Pattern.compile(regex);
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
    public UIElement itemPerPageSelector() {
        return core().find(ITEM_PER_PAGE_SELECTOR_LOCATOR);
    }

    //    @JDIAction("Get item per page selector for '{name}'")
//    public UIElement materiialSelector() {
//        return new Dropdown().setCore(core().find(ITEM_PER_PAGE_SELECTOR_LOCATOR));
//    }
    @JDIAction("Get WebList of items per page options for '{name}'")
    private WebList itemsPerPageOptionsWebList() {
        return new WebList(By.cssSelector(ITEM_PER_PAGE_OPTIONS_LOCATOR));
    }

    @JDIAction("Get options for '{name}'")
    public List<Integer> options() {
        expandItemPerPageOptions();
        final List<Integer> collect = itemsPerPageOptionsWebList().values().stream().map(Integer::parseInt).collect(toList());
        collapseItemPerPageOptions();
        return collect;
    }

    @JDIAction("Expand options for '{name}'")
    private void expandItemPerPageOptions() {
        if (itemPerPageSelector().attr(ARIA_EXPANDED_ATTR).equals("false")) {
            itemPerPageSelector().click();
        }
    }

    @JDIAction("Collapse items per page options for '{name}'")
    private void collapseItemPerPageOptions() {
        if (itemPerPageSelector().attr(ARIA_EXPANDED_ATTR).equals("true")) {
            UIElement uiElement = new UIElement(By.cssSelector(SELECT_PANEL_LOCATOR));
            Point pointOutsidePanel = new Point(uiElement.core().getRect().getWidth() + 2, uiElement.core().getRect().getHeight() + 2);
            uiElement.core().click(pointOutsidePanel.getX(), pointOutsidePanel.getY());
        }
    }

    @JDIAction("Select items per page option '{0}' for '{name}'")
    public void selectItemPerPageOption(int number) {
        expandItemPerPageOptions();
        itemsPerPageOptionsWebList().select(String.valueOf(number));
    }

    @JDIAction("Get selected option for '{name}'")
    public int selected() {
        return parseInt(itemPerPageSelector().getText());
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

    @Override
    @JDIAction("Get '{name}' color")
    public String color() {
        if (core().hasAttribute("color")) {
            return core().attr("color");
        }
        expandItemPerPageOptions();
        final String cssValue = core().find(ITEM_PER_PAGE_FIELD_LOCATOR).find(BOARDER_LOCATOR).getCssValue("border-color");
        collapseItemPerPageOptions();
        return cssValue;
    }

    @JDIAction("Get color for selected value in the list of options for '{name}'")
    public String selectedOptionColor() {
        expandItemPerPageOptions();
        String cssValue = selectedOptionFromItemsPerPageList().find("span").getCssValue("COLOR_ATT");
        collapseItemPerPageOptions();
        return cssValue;
    }

    @JDIAction("Get selected option from items per page list for '{name}'")
    private UIElement selectedOptionFromItemsPerPageList() {
        return itemsPerPageOptionsWebList().stream()
                .filter(el -> el
                        .attr("aria-selected").equals("true"))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("No element with attribute aria-selected = true")
                );
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
    public boolean isPageSizeHidden() {
        return core().find(PAGINATOR_PAGE_SIZE_SECTION_LOCATOR).isHidden();
    }

    /**
     * @return The zero-based page index of the displayed list of items
     */
    @JDIAction("Get '{name}' current page index")
    public int pageIndexCurrent() {
        final int first = parseInt(getMatcherForRange().group(1));
        return (first - 1) / selected();
    }

    @JDIAction("Get '{name}' total number of items that are being paginated")
    public int totalNumberOfPaginatedItems() {
        return parseInt(getMatcherForRange().group(4));
    }

    @JDIAction("Get if '{name}' has first and last page buttons shown")
    public boolean isFirstLastButtonsShown() {
        return lastPageButton().isDisplayed() && firstPageButton().isDisplayed();
    }

    @JDIAction("Parse '{name}' range with pattern '{rangeLabelPattern}'")
    private Matcher getMatcherForRange() {
        Matcher matcher = rangeLabelPattern.matcher(range());
        if (!matcher.matches()) {
            throw new IllegalStateException(String.format("Pattern '%s' has no matches for string '%s'", rangeLabelPattern.pattern(), range()));
        }
        return matcher;
    }
}
