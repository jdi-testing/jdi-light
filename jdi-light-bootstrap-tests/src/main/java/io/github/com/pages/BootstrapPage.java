package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Alert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;

import io.github.com.sections.*;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static UIElement inputGroupWrap,inputGroupNowrap;
    public static Button redButton, doubleButton, disabledButton;
    @UI("#simple-alert") public static Alert simpleAlert;
    @UI("#dismissible-alert") public static Alert dismissibleAlert;
    @UI("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @UI("#jumbotron") public static Jumbotron jumbotron;
    //endregion

    //region Complex Elements
    @UI("#carousel-example-slides-only") public static Carousel carouselWithSlidesOnly;
    @UI("#carousel-example-controls") public static Carousel carouselWithControls;
    @UI("#carousel-example-indicators") public static Carousel carouselWithIndicators;
    @UI("#carousel-example-captions") public static Carousel carouselWithCaptions;
    @UI("#carousel-example-fade") public static Carousel carouselWithFadeTransition;
    @UI("#carousel-example-interval") public static Carousel carouselWithCustomInterval;
    // COLLAPSE
    @JDropdown(expand = "#bs-collapse-link",
            value = "#bs-collapse-one",
            list = "#bs-collapse-one-body")
    public static Collapse collapseLink;
    @JDropdown(expand = "#bs-collapse-btn",
            value = "#bs-collapse-one",
            list = "#bs-collapse-one-body")
    public static Collapse collapseDataTarget;
    @JDropdown(expand = "#bs-multi-toggle-one",
            value = "#bs-multi-one",
            list = "#bs-multi-one-body")
    public static Collapse collapseToggleOne;
    @JDropdown(expand = "#bs-multi-toggle-two",
            value = "#bs-multi-two",
            list = "#bs-multi-two-body")
    public static Collapse collapseToggleTwo;
    @JDropdown(expand = "#bs-multi-toggle-both",
            value = "#bs-multi-one",
            list = "#bs-multi-one-body")
    public static Collapse collapseToggleBoth;
    @JDropdown(expand = "#bs-group-toggle-one",
            value = "#bs-group-one",
            list = "#bs-group-one-body")
    public static Collapse collapseGroupOne;
    @JDropdown(expand = "#bs-group-toggle-two",
            value = "#bs-group-two",
            list = "#bs-group-two-body")
    public static Collapse collapseGroupTwo;
    @JDropdown(expand = "#bs-group-toggle-three",
            value = "#bs-group-three",
            list = "#bs-group-three-body")
    public static Collapse collapseGroupThree;
    //endregion

    //region Composite Elements
    @UI("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    @UI("#input-group-checkbox") public static InputGroupInputWithCheckBox inputGroupCheckBox;
    @UI("#input-group-radio") public static InputGroupInputWithRadio inputGroupRadio;
    @UI("#card-example") public static CardExample cardExample;
    @UI("#button-with-dropdown") public static ButtonWithDropdown buttonWithDropdown;
    @UI("#segmented-button") public static SegmentedButton segmentedButton;
    //endregion
}