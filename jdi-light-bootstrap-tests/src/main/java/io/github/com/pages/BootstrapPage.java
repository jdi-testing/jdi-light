package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.*;
import com.epam.jdi.light.ui.bootstrap.elements.common.Alert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Badge;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;

import io.github.com.sections.*;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static UIElement inputGroupWrap,inputGroupNowrap;
    public static Button redButton, doubleButton, disabledButton;

    @UI("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @UI("#jumbotron") public static Jumbotron jumbotron;
    @UI("#breadcrumb") public static Breadcrumb breadcrumb;
    @UI("#simple-alert") public static Alert simpleAlert;
    @UI("#dismissible-alert") public static Alert dismissibleAlert;
    @UI("#badge-secondary") public static Badge badgeSecondary;
    @UI("#btn-primary") public static Button buttonPrimary;
    @UI("#badge-success") public static Link badgeSuccess;
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
    @UI("#input-group-checkbox") public static InputGroupInputWithCheckBox inputGroupCheckBox;
    @UI("#input-group-radio") public static InputGroupInputWithRadio inputGroupRadio;
    @UI("#input-group-basic-example1") public static InputGroupInputWithText inputGroupBasicExample1;
    @UI("#input-group-basic-example2") public static InputGroupInputWithText inputGroupBasicExample2;
    @UI("#input-group-basic-example3") public static InputGroupInputWithLabelAndText inputGroupBasicExample3;
    @UI("#input-group-basic-example4") public static InputGroupInputWithTwoText inputGroupBasicExample4;
    @UI("#input-group-basic-example5") public static InputGroupTextareaWithText inputGroupBasicExample5;
    @UI("#input-group-default") public static InputGroupSizing inputGroupDefaultSizing;
    @UI("#input-group-small") public static InputGroupSizing inputGroupSmallSizing;
    @UI("#input-group-large") public static InputGroupSizing inputGroupLargeSizing;
    @UI("#card-example") public static CardExample cardExample;
    @UI("#card-body") public static CardBody cardBody;
    @UI("#button-with-dropdown") public static ButtonWithDropdown buttonWithDropdown;
    @UI("#segmented-button") public static SegmentedButton segmentedButton;
    @UI("#card-subtitle-link") public static CardWithSubtitlesAndLinks cardWithSubtitlesAndLinks;
    @UI("#card-custom-css-1") public static CardWithCustomCss13Rem cardWithCustomCss13Rem;
    @UI("#card-custom-css-2") public static CardWithCustomCss9Rem cardWithCustomCss9Rem;
    @UI("#custom-select-01") public static CustomSelect customSelect;
    @UI("#custom-select-button-01") public static CustomSelectWithButton customSelectWithButton;
    @UI("#media-object-sample") public static MediaObjectSample mediaObjectSample;
    @UI("#media-object-nesting") public static MediaObjectNesting mediaObjectNesting;
    @UI("#media-object-list") public static JList<MediaObjectSample> mediaObjectList;
    @UI("#basic-example") public static ButtonGroupBasicExample buttonGroupBasicExample;
    @UI("#vertical-variation") public static  ButtonGroupVerticalVariation buttonGroupVerticalVariation;
    @UI("#button-group-nesting") public static ButtonGroupNesting buttonGroupNesting;
    @UI("#btn-lg-group") public static ButtonGroupSizing largeBtnGroup;
    @UI("#btn-md-group") public static ButtonGroupSizing defaultBtnGroup;
    @UI("#btn-sm-group") public static ButtonGroupSizing smallBtnGroup;
    @UI("#card-text-left") public static CardTextAlignment cardLeftTextAlignment;
    @UI("#card-text-center") public static CardTextAlignment cardCenterTextAlignment;
    @UI("#card-text-right") public static CardTextAlignment cardRightTextAlignment;
    @UI("#card-navigation") public static CardNavigation cardNavigation;
    //endregion
}
