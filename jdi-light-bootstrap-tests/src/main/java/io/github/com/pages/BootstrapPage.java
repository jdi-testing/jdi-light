package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.*;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import com.epam.jdi.light.ui.bootstrap.elements.complex.DropdownMenu;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.github.com.RangeControl;
import io.github.com.custom.ButtonWithTooltip;
import io.github.com.custom.FullName;
import io.github.com.entities.SlideInfo;
import io.github.com.sections.DismissAlert;
import io.github.com.sections.Slide;

public class BootstrapPage extends WebPage {
    public static UIElement inputGroupWrap, inputGroupNowrap;
    public static Badge badge;
    public static Button redButton, doubleButton, disabledButton, increaseProgress,
        decreaseProgress, resetProgress;
    public static Progress progressbar, multiProgressbar;
    public static Breadcrumb breadcrumb;
    public static Checkbox acceptCheckbox;
    @UI(".checkbox-input") public static Checklist checkNumbers;
    public static RadioButtons airClassOptions;
    public static Switch switcher, disabledSwitcher;
    public static ButtonWithTooltip buttonWithTooltip;
    public static Button simpleToastButton;
    public static Button expandLink;
    public static Text hiddenText;
    public static FullName multipleInputs;
    public static DropdownMenu dropdownMenu;
    public static DropdownMenu dropdownMenuSplit;

    //region Alerts
    public static Alert simpleAlert;
    public static DismissAlert dismissibleAlert;
    //endregion

    //region Ranges
    public static Range defaultRange;
    public static Range minMaxRange;
    public static Range fractionalRange;
    public static Range disabledRange;
    @UI("#default-range")
    public static RangeControl rangeControl;
    //endregion

    public static Button startButton;
    public static Spinner spinnerLoading;
    public static Loading spinnerRotate;

    public static Carousel<Slide, SlideInfo> carousel;
    @UI("#list-example>a") public static WebList scrollSpy;

}
