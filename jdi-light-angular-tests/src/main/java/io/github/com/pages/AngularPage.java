package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import io.github.com.pages.sections.*;

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
    public static SelectSection selectSection;
    public static ListSection listSection;
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
    public static DividerSection dividerSection;
}
