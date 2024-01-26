package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class PaginatorPage extends NewAngularPage {
    @UI("#paginator-list-length-input")
    public static Input listLengthInput;
    @UI("#paginator-page-size-input")
    public static Input pageSizeInput;
    @UI("#paginator-page-size-options-input")
    public static Input pageSizeOptionsInput;

    @UI("//paginator-configurable-example//div[contains(text(),'List length:')]")
    public static Text listLength;
    @UI("//paginator-configurable-example//div[contains(text(),'Page size:')]")
    public static Text pageSize;
    @UI("//paginator-configurable-example//div[contains(text(),'Page index:')]")
    public static Text pageIndex;

    @UI(".mat-mdc-tooltip")
    public static Tooltip tooltip;

    @UI("//paginator-configurable-example//mat-paginator")
    public static Paginator paginatorConfigurable;

    @UI("//mat-paginator[contains(@id, 'paginator-show-first-last-buttons')]")
    public static Paginator paginatorFirstLastButtons;
    @UI("#paginator-color-themepalette-primary")
    public static Paginator paginatorColorPrimary;
    @UI("#paginator-color-themepalette-accent")
    public static Paginator paginatorColorAccent;
    @UI("#paginator-color-themepalette-warn")
    public static Paginator paginatorColorWarn;
    @UI("#paginator-disabled-option")
    public static Paginator paginatorDisabledOption;
    @UI("#paginator-hide-page-size-option")
    public static Paginator paginatorHideSizeOption;
}
