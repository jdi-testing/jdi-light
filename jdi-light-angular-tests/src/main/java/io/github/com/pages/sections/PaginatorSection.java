package io.github.com.pages.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class PaginatorSection {
    @UI("#paginator-list-length-input")
    public static TextField listLength;

    @UI("#paginator-page-size-options-input")
    public static TextField pageSizeOptions;

    @UI("//paginator-configurable-example/mat-paginator")
    public static Paginator paginator;
}
