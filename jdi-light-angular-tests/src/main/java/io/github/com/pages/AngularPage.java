package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import io.github.com.pages.sections.CardSection;
import io.github.com.pages.sections.ChipsSection;
import io.github.com.pages.sections.DatepickerSection;
import io.github.com.pages.sections.ExpansionPanelSection;
import io.github.com.pages.sections.FormFieldsSection;
import io.github.com.pages.sections.GridListSection;
import io.github.com.pages.sections.InputSection;
import io.github.com.pages.sections.ListSection;
import io.github.com.pages.sections.MenuSection;
import io.github.com.pages.sections.PaginatorSection;
import io.github.com.pages.sections.SelectSection;
import io.github.com.pages.sections.SideNavSection;
import io.github.com.pages.sections.SlideToggleSection;
import io.github.com.pages.sections.SliderSection;
import io.github.com.pages.sections.SnackbarSection;
import io.github.com.pages.sections.SortingOverviewSection;
import io.github.com.pages.sections.TabGroupSection;
import io.github.com.pages.sections.TableSection;
import io.github.com.pages.sections.ToolbarSection;
import io.github.com.pages.sections.TooltipSection;

public class AngularPage extends WebPage {

    @UI("#basic_icon")
    public static Icon basicIcon;
    @UI("#svg_icon")
    public static Icon svgIcon;
    @UI("#bottom-sheet")
    public static BottomSheet bottomSheet;
    public static Dialog dialog;
    public static ToolbarSection toolbarSection;
    public static SlideToggleSection slideToggleSection;
    public static InputSection inputSection;
    public static ListSection listSection;
    public static GridListSection gridListSection;
    public static SnackbarSection snackbarSection;
    public static MenuSection menuSection;
    public static PaginatorSection paginatorSection;
    public static TabGroupSection tabsSection;
    public static SliderSection sliderSection;
    public static CardSection cardSection;
    public static TooltipSection tooltipSection;
    public static DatepickerSection datepickerSection;
    public static FormFieldsSection formFieldsSection;
    public static SideNavSection sidenavSection;
    public static ExpansionPanelSection expansionPanelSection;
    public static SortingOverviewSection sortingOverviewSection;
    public static ChipsSection chipsSection;
    public static TableSection tableSection;
}
