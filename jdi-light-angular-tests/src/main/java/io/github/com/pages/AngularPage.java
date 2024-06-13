package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import io.github.com.pages.sections.ListSection;
import io.github.com.pages.sections.SnackbarSection;
import io.github.com.pages.sections.TabGroupSection;
import io.github.com.pages.sections.TableSection;

public class AngularPage extends WebPage {

    @UI("#basic_icon")
    public static Icon basicIcon;
    @UI("#svg_icon")
    public static Icon svgIcon;
    @UI("#bottom-sheet")
    public static BottomSheet bottomSheet;
    public static Dialog dialog;
    public static ListSection listSection;
    public static SnackbarSection snackbarSection;
    public static TabGroupSection tabsSection;
    public static TableSection tableSection;
}
