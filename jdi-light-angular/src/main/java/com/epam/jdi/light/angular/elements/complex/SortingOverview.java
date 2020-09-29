package com.epam.jdi.light.angular.elements.complex;


import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.angular.asserts.SortingOverviewAssert;
import com.epam.jdi.light.elements.complex.WebList;

/**
 * To see an example of Sorting Overview web element please visit https://material.angular.io/components/sort/overview.
 */
public class SortingOverview extends UIBaseElement<SortingOverviewAssert> {

    @JDIAction("Get table headers")
    public WebList getTableHeaders() {
        return this.finds(".mat-sort-header");
    }

    @JDIAction("Get header with text '{text}'")
    public void clickButtonByText(String text) {
        getTableHeaders().get(text).click();
    }

    @JDIAction("Is header clicked")
    public boolean headerButtonIsClicked() {
        return this.find(".mat-sort-header-arrow").isDisplayed();
    }


    @Override
    public SortingOverviewAssert is() {
        return new SortingOverviewAssert().set(this);
    }

}
