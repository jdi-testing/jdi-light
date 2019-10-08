package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.*;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ButtonWithSpinner;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Popover;
import io.github.com.sections.*;
import io.github.com.sections.card.CardWithGridMarkup;
import io.github.com.sections.card.CardWithHeaderAndFooter;
import io.github.com.sections.spinner.GrowingSpinners;
import io.github.com.sections.spinner.SpinnerSize;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static UIElement inputGroupWrap,inputGroupNowrap;
    public static Button redButton, doubleButton, disabledButton;

    @UI("//input[contains(@class, 'progress-change plus')]")  public static Button plus;
    @UI("//input[contains(@class, 'progress-change minus')]") public static Button minus;
    @UI("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @UI("#jumbotron") public static Jumbotron jumbotron;
    @UI("#breadcrumb") public static Breadcrumb breadcrumb;
    @UI("#simple-alert") public static Alert simpleAlert;
    @UI("#dismissible-alert") public static Alert dismissibleAlert;
    @UI("#badge-secondary") public static Badge badgeSecondary;
    @UI("#btn-primary") public static Button buttonPrimary;
    @UI("#badge-success") public static Link badgeSuccess;
    @UI("#spinner-text-primary") public static ColorSpinner spinnerWithTextPrimary;
    @UI("#spinner-text-secondary") public static ColorSpinner spinnerWithTextSecondary;
    @UI("#spinner-text-success") public static ColorSpinner spinnerWithTextSuccess;
    @UI("#spinner-text-danger") public static ColorSpinner spinnerWithTextDanger;
    @UI("#spinner-text-warning") public static ColorSpinner spinnerWithTextWarning;
    @UI("#spinner-text-info") public static ColorSpinner spinnerWithTextInfo;
    @UI("#spinner-text-light") public static ColorSpinner spinnerWithTextLight;
    @UI("#spinner-text-dark") public static ColorSpinner spinnerWithTextDark;
    @UI("#tooltipOnTop") public static Tooltip tooltipOnTopButton;
    @UI("#tooltipOnBottom") public static Tooltip tooltipOnBottomButton;
    @UI("#tooltipOnLeft") public static Tooltip tooltipOnLeftButton;
    @UI("#tooltipOnRight") public static Tooltip tooltipOnRightButton;
    @UI("#tooltipWithHTML") public static Tooltip tooltipWithHTML;
    @UI("#wrapperForDisabledButton") public static Tooltip wrapperForDisabledButton;
    @UI("#tooltipOnDisabledButton") public static Tooltip tooltipOnDisabledButton;
    @UI("#progress-bar-base-width-0") public static Progress progressBaseProgress0;
    @UI("#progress-bar-base-width-0 .progress-bar") public static Progress progressBaseWidth0;
    @UI("#progress-bar-base-width-25 .progress-bar") public static Progress progressBaseWidth25;
    @UI("#progress-bar-base-width-50 .progress-bar") public static Progress progressBaseWidth50;
    @UI("#progress-bar-base-width-75 .progress-bar") public static Progress progressBaseWidth75;
    @UI("#progress-bar-base-width-100 .progress-bar") public static Progress progressBaseWidth100;
    @UI("#progress-animated") public static Progress progressAnimated;
    @UI("#progress-with-labels") public static Progress progressWithLabels;
    @UI("#progress-backgrounds-green") public static Progress progressBackgroundGreen;
    @UI("#progress-backgrounds-blue") public static Progress progressBackgroundBlue;
    @UI("#progress-backgrounds-yellow") public static Progress progressBackgroundYellow;
    @UI("#progress-backgrounds-red") public static Progress progressBackgroundRed;
    @UI("#button-show-spinner-border") public static Button buttonSpinnerBorder;
    @UI("#spinner-border") public static Spinner spinnerBorder;
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
    @UI("#card-image") public static CardImage cardImage;
    @UI("#card-body") public static CardBody cardBody;
    @UI("#card-with-header") public static CardWithHeaderAndFooter cardWithHeader;
    @UI("#card-with-header-and-footer-quote") public static CardWithHeaderAndFooter cardWithHeaderAndFooterQuote;
    @UI("#card-with-header-and-footer") public static CardWithHeaderAndFooter cardWithHeaderAndFooter;
    @UI("#card-with-grid-markup") public static CardWithGridMarkup cardWithGridMarkup;
    @UI("#card-bright-blue") public static CardWithHeaderAndFooter cardBrightBlue;
    @UI("#card-grey") public static CardWithHeaderAndFooter cardGrey;
    @UI("#card-green") public static CardWithHeaderAndFooter cardGreen;
    @UI("#card-red") public static CardWithHeaderAndFooter cardRed;
    @UI("#card-yellow") public static CardWithHeaderAndFooter cardYellow;
    @UI("#card-blue") public static CardWithHeaderAndFooter cardBlue;
    @UI("#card-light") public static CardWithHeaderAndFooter cardLight;
    @UI("#card-dark") public static CardWithHeaderAndFooter cardDark;
    @UI("#card-border-primary") public static CardBorder cardBorderPrimary;
    @UI("#card-border-secondary") public static CardBorder cardBorderSecondary;
    @UI("#card-border-success") public static CardBorder cardBorderSuccess;
    @UI("#card-border-danger") public static CardBorder cardBorderDanger;
    @UI("#card-border-warning") public static CardBorder cardBorderWarning;
    @UI("#card-border-info") public static CardBorder cardBorderInfo;
    @UI("#card-border-light") public static CardBorder cardBorderLight;
    @UI("#card-border-dark") public static CardBorder cardBorderDark;
    @UI("#button-with-dropdown") public static ButtonWithDropdown buttonWithDropdown;
    @UI("#segmented-button") public static SegmentedButton segmentedButton;
    @UI("#buttonToolbar1") public static ButtonToolbar buttonToolbar;
    @UI("#buttonToolbar2") public static ButtonToolbar buttonToolbarWithInputField;
    @UI("#card-subtitle-link") public static CardWithSubtitlesAndLinks cardWithSubtitlesAndLinks;
    @UI("#card-custom-css-1") public static CardWithCustomCss13Rem cardWithCustomCss13Rem;
    @UI("#card-custom-css-2") public static CardWithCustomCss9Rem cardWithCustomCss9Rem;
    @UI("#card-mixins-utilities") public static CardMixinsUtilities cardMixinsUtilities;
    @UI("#card-horizontal") public static CardHorizontal cardHorizontal;
    @UI("#custom-select-01") public static CustomSelect customSelect;
    @UI("#custom-select-button-01") public static CustomSelectWithButton customSelectWithButton;
    @UI("#media-object-sample") public static MediaObjectSample mediaObjectSample;
    @UI("#media-object-nesting") public static MediaObjectNesting mediaObjectNesting;
    @UI("#media-object-list") public static JList<MediaObjectSample> mediaObjectList;
    @UI("#multiple-addons-1")  public static InputGroupMultipleAddonsUpper multipleAddonUpper;
    @UI("#multiple-addons-2")  public static InputGroupMultipleAddonsLower multipleAddonLower;
    @UI("#basic-example") public static ButtonGroupBasicExample buttonGroupBasicExample;
    @UI("#vertical-variation") public static  ButtonGroupVerticalVariation buttonGroupVerticalVariation;
    @UI("#button-group-nesting") public static ButtonGroupNesting buttonGroupNesting;
    @UI("#btn-lg-group") public static ButtonGroupSizing largeBtnGroup;
    @UI("#btn-md-group") public static ButtonGroupSizing defaultBtnGroup;
    @UI("#btn-sm-group") public static ButtonGroupSizing smallBtnGroup;
    @UI("#card-text-left") public static CardTextAlignment cardLeftTextAlignment;
    @UI("#card-text-center") public static CardTextAlignment cardCenterTextAlignment;
    @UI("#card-text-right") public static CardTextAlignment cardRightTextAlignment;
    @UI("#list-group-basic-example") public static ListGroupBasicExample listGroupBasicExample;
    @UI("#list-group-active-items") public static ListGroupActiveItems listGroupActiveItems;
    @UI("#disabled-items") public static ListGroupDisabledItems listGroupDisabledItems;
    @UI("#list-group-links") public static ListGroupLinks listGroupLinks;
    @UI("#list-group-buttons") public static ListGroupButtons listGroupButtons;
    @UI("#list-group-flush") public static ListGroupFlush listGroupFlush;
    @UI("#list-group-horizontal") public static ListGroupHorizontal listGroupHorizontal;
    @UI("#list-group-with-badges") public static ListGroupWithBadges listGroupWithBadges;
    @UI("#list-group-custom-content") public static ListGroupCustomContent listGroupCustomContent;
    @UI("#radio-buttons") public static RadioButtonGroup radioButtonGroup;
    @UI(".card-group:nth-of-type(1)") public static CardGroup cardGroupWithoutFooter;
    @UI(".card-group:nth-of-type(2)") public static CardGroup cardGroupWithFooter;
    @UI("#card-list-groups") public static CardListGroups cardListGroups;
    @UI("#pagination-overview") public static PaginationOverview paginationOverview;
    @UI("#pagination-icons") public static PaginationIcons paginationIcons;
    @UI("#pagination-states") public static PaginationStates paginationStates;
    @UI("#pagination-big") public static PaginationSizeBig paginationSizeBig;
    @UI("#pagination-small") public static PaginationSizeSmall paginationSizeSmall;
    @UI("#pagination-center") public static PaginationAlignCenter paginationAlignCenter;
    @UI("#pagination-end") public static PaginationAlignEnd paginationAlignEnd;
    @UI("#nav-base-li") public static NavsBaseLi navsBaseLi;
    @UI("#nav-base-a") public static NavsBaseA navsBaseA;
    @UI("#nav-center") public static NavsAlignmentCenter navsAlignmentCenter;
    @UI("#nav-end") public static NavsAlignmentEnd navsAlignmentEnd;
    @UI("#nav-vert-li") public static NavsVerticalLi navsVerticalLi;
    @UI("#nav-vert-a") public static NavsVerticalA navsVerticalA;
    @UI("#nav-tabs") public static NavsTabs navsTabs;
    @UI("#nav-pills") public static NavsPills navsPills;
    @UI("#nav-justify") public static NavsJustify navsJustify;
    @UI("#nav-with-dropdown") public static NavsTabsWithDropdown navsTabsWithDropdown;
    @UI("#nav-pills-drop") public static NavsPillsWithDropdown navsPillsWithDropdown;
    @UI(".card-columns") public static CardColumns cardColumns;
    @UI("#list-example>a") public static ListGroup listGroupForScrollspy;
    @UI("#list-example~div") public static ScrollspyWithListGroup scrollspyWithListGroup;
    @UI("#navbar-example3") public static NestedNav nestedNav;
    @UI("#navbar-example3~div") public static ScrollspyWithNestedNav scrollspyWithNestedNav;
    @UI("body") public static Popover popover;
    @UI("body") public static CheckboxesDefaultInline checkboxesDefaultInline;
    @UI("body") public static RadioButtonsDefaultInline radioButtonsDefaultInline;
    @UI("body") public static CheckboxesDefault checkboxesDefault;
    @UI("body") public static CheckboxesCustom checkboxesCustom;
    @UI(".card-deck:nth-of-type(1)") public static CardDeck cardDeckWithoutFooter;
    @UI(".card-deck:nth-of-type(2)") public static CardDeck cardDeckWithFooter;
    @UI("#multiple-inputs") public static MultipleInputs multipleInputs;
    @UI("#growing-spinners") public static GrowingSpinners growingSpinners;
    @UI("#spinner-size") public static SpinnerSize spinnerSize;
    @UI("#button-with-spinner-and-text") public static ButtonWithSpinner buttonWithSpinnerAndText;
    @UI("#button-with-spinner") public static ButtonWithSpinner buttonWithSpinner;
    @UI("#button-with-growing-spinner-and-text") public static ButtonWithSpinner buttonWithGrowingSpinnerAndText;
    @UI("#button-with-growing-spinner") public static ButtonWithSpinner buttonWithGrowingSpinner;
    //Toasts
    @UI("#toastRightTop") public static Toast toastWithTopAlign;
    @UI("#linkToastRightTop") public static Button toastWithTopAlignButton;
    @UI("#simpleToast") public static Toast simpleToast;
    @UI("#linkSimpleToastExample") public static Button simpleToastButton;
    @UI("#multipleToast") public static Button stackOfToastsButton;
    @UI("#firstMultipleToast") public static Toast firstStackToast;
    @UI("#secondMultipleToast") public static Toast secondStackToast;
    @UI("#linkStackAlign") public static Button stackOfToastsWithTopAlignButton;
    @UI("#firstStackToast") public static Toast firstTopAlignStackToast;
    @UI("#secondStackToast") public static Toast secondTopAlignStackToast;
    @UI("#linkToastCenterTop") public static Toast toastWithCenterAlignButton;
    @UI("#toastCenterTop") public static Toast toastWithCenterAlign;
    @UI("#custom-radio-con") public static RadioButtonsCustom radioButtonCustom;
    //endregion
}
