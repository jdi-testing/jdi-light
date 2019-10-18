package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Alert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Badge;
import com.epam.jdi.light.ui.bootstrap.elements.common.Breadcrumb;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.ColorSpinner;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.MultipleInputs;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.common.Tooltip;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ButtonWithSpinner;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Navbar;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Popover;
import io.github.com.sections.ButtonAddons;
import io.github.com.sections.ButtonGroupBasicExample;
import io.github.com.sections.ButtonGroupNesting;
import io.github.com.sections.ButtonGroupSizing;
import io.github.com.sections.ButtonGroupVerticalVariation;
import io.github.com.sections.ButtonToolbar;
import io.github.com.sections.ButtonWithDropdown;
import io.github.com.sections.CardBody;
import io.github.com.sections.CardBorder;
import io.github.com.sections.CardColumns;
import io.github.com.sections.CardDeck;
import io.github.com.sections.CardExample;
import io.github.com.sections.CardGroup;
import io.github.com.sections.CardHorizontal;
import io.github.com.sections.CardImage;
import io.github.com.sections.CardKitchenSink;
import com.epam.jdi.light.ui.bootstrap.elements.complex.CardImageCaps;
import io.github.com.sections.CardListGroups;
import io.github.com.sections.CardMixinsUtilities;
import io.github.com.sections.CardNavigation;
import io.github.com.sections.CardTextAlignment;
import io.github.com.sections.CardWithCustomCss13Rem;
import io.github.com.sections.CardWithCustomCss9Rem;
import io.github.com.sections.CardWithSubtitlesAndLinks;
import io.github.com.sections.CheckboxAndRadioButtonCustomDisabled;
import io.github.com.sections.CheckboxesAndRadiosWithoutLabels;
import io.github.com.sections.CheckboxesCustom;
import io.github.com.sections.CheckboxesDefault;
import io.github.com.sections.CheckboxesDefaultInline;
import io.github.com.sections.CustomSelect;
import io.github.com.sections.CustomSelectWithButton;
import io.github.com.sections.FormBrowserDefaults;
import io.github.com.sections.FormCustomStyles;
import io.github.com.sections.FormDisabled;
import io.github.com.sections.FormHelpText;
import io.github.com.sections.FormHorizontal;
import io.github.com.sections.FormOverview;
import io.github.com.sections.FormServerSide;
import io.github.com.sections.FormTooltip;
import io.github.com.sections.FormsSizing;
import io.github.com.sections.InputGroupInputWithCheckBox;
import io.github.com.sections.InputGroupInputWithLabelAndText;
import io.github.com.sections.InputGroupInputWithRadio;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.InputGroupInputWithTwoText;
import io.github.com.sections.InputGroupMultipleAddonsLower;
import io.github.com.sections.InputGroupMultipleAddonsUpper;
import io.github.com.sections.InputGroupSizing;
import io.github.com.sections.InputGroupTextareaWithText;
import io.github.com.sections.Jumbotron;
import io.github.com.sections.ListGroupActiveItems;
import io.github.com.sections.ListGroupBasicExample;
import io.github.com.sections.ListGroupButtons;
import io.github.com.sections.ListGroupCustomContent;
import io.github.com.sections.ListGroupDisabledItems;
import io.github.com.sections.ListGroupFlush;
import io.github.com.sections.ListGroupHorizontal;
import io.github.com.sections.ListGroupLinks;
import io.github.com.sections.ListGroupWithBadges;
import io.github.com.sections.MediaObjectNesting;
import io.github.com.sections.MediaObjectSample;
import io.github.com.sections.NavbarExternalContent;
import io.github.com.sections.NavbarWithDropdown;
import io.github.com.sections.NavsAlignmentCenter;
import io.github.com.sections.NavsAlignmentEnd;
import io.github.com.sections.NavsBaseA;
import io.github.com.sections.NavsBaseLi;
import io.github.com.sections.NavsJustify;
import io.github.com.sections.NavsPills;
import io.github.com.sections.NavsPillsWithDropdown;
import io.github.com.sections.NavsTabs;
import io.github.com.sections.NavsTabsWithDropdown;
import io.github.com.sections.NavsVerticalA;
import io.github.com.sections.NavsVerticalLi;
import io.github.com.sections.NestedNav;
import io.github.com.sections.PaginationAlignCenter;
import io.github.com.sections.PaginationAlignEnd;
import io.github.com.sections.PaginationIcons;
import io.github.com.sections.PaginationOverview;
import io.github.com.sections.PaginationSizeBig;
import io.github.com.sections.PaginationSizeSmall;
import io.github.com.sections.PaginationStates;
import io.github.com.sections.ProgressMultipleBars;
import io.github.com.sections.ProgressSection;
import io.github.com.sections.RadioButtonGroup;
import io.github.com.sections.RadioButtonsCustom;
import io.github.com.sections.RadioButtonsCustomInline;
import io.github.com.sections.RadioButtonsDefaultInline;
import io.github.com.sections.ScrollSpyNav;
import io.github.com.sections.SegmentedButton;
import io.github.com.sections.Switches;
import io.github.com.sections.Toast;
import io.github.com.sections.card.CardImageOverlays;
import io.github.com.sections.card.CardUtilities;
import io.github.com.sections.card.CardWithGridMarkup;
import io.github.com.sections.card.CardWithHeaderAndFooter;
import io.github.com.sections.modal.ModalVerticallyCentered;
import io.github.com.sections.form.ReadonlyPlainText;
import io.github.com.sections.modal.ModalVaryingContent;
import io.github.com.sections.modal.SectionModalLongScrolling;
import io.github.com.sections.modal.gridmodal.GridModalSection;
import io.github.com.sections.navbar.NavbarColorScheme;
import io.github.com.sections.navbar.NavbarForm;
import io.github.com.sections.navbar.NavbarSupportedContent;
import io.github.com.sections.navbar.NavbarText;
import io.github.com.sections.navbar.NavbarWithInputGroupForm;
import io.github.com.sections.spinner.GrowingSpinners;
import io.github.com.sections.spinner.SpinnerAlignment;
import io.github.com.sections.spinner.SpinnerSize;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static UIElement inputGroupWrap;
    public static UIElement inputGroupNowrap;
    public static Button redButton;
    public static Button doubleButton;
    public static Button disabledButton;

    @UI("//input[contains(@class, 'progress-change plus')]")
    public static Button plus;
    @UI("//input[contains(@class, 'progress-change minus')]")
    public static Button minus;
    @UI("#jumbotron-fluid")
    public static Jumbotron jumbotronFluid;
    @UI("#jumbotron")
    public static Jumbotron jumbotron;
    @UI("#breadcrumb")
    public static Breadcrumb breadcrumb;
    @UI("#simple-alert")
    public static Alert simpleAlert;
    @UI("#dismissible-alert")
    public static Alert dismissibleAlert;
    @UI("#badge-secondary")
    public static Badge badgeSecondary;
    @UI("#btn-primary")
    public static Button buttonPrimary;
    @UI("#badge-success")
    public static Link badgeSuccess;
    @UI("#spinner-text-primary")
    public static ColorSpinner spinnerWithTextPrimary;
    @UI("#spinner-text-secondary")
    public static ColorSpinner spinnerWithTextSecondary;
    @UI("#spinner-text-success")
    public static ColorSpinner spinnerWithTextSuccess;
    @UI("#spinner-text-danger")
    public static ColorSpinner spinnerWithTextDanger;
    @UI("#spinner-text-warning")
    public static ColorSpinner spinnerWithTextWarning;
    @UI("#spinner-text-info")
    public static ColorSpinner spinnerWithTextInfo;
    @UI("#spinner-text-light")
    public static ColorSpinner spinnerWithTextLight;
    @UI("#spinner-text-dark")
    public static ColorSpinner spinnerWithTextDark;
    @UI("#tooltipOnTop")
    public static Tooltip tooltipOnTopButton;
    @UI("#tooltipOnBottom")
    public static Tooltip tooltipOnBottomButton;
    @UI("#tooltipOnLeft")
    public static Tooltip tooltipOnLeftButton;
    @UI("#tooltipOnRight")
    public static Tooltip tooltipOnRightButton;
    @UI("#tooltipWithHTML")
    public static Tooltip tooltipWithHTML;
    @UI("#wrapperForDisabledButton")
    public static Tooltip wrapperForDisabledButton;
    @UI("#tooltipOnDisabledButton")
    public static Tooltip tooltipOnDisabledButton;
    @UI("#progress-bar-base-width-0")
    public static Progress progressBaseProgress0;
    @UI("#progress-bar-base-width-0 .progress-bar")
    public static Progress progressBaseWidth0;
    @UI("#progress-bar-base-width-25 .progress-bar")
    public static Progress progressBaseWidth25;
    @UI("#progress-bar-base-width-50 .progress-bar")
    public static Progress progressBaseWidth50;
    @UI("#progress-bar-base-width-75 .progress-bar")
    public static Progress progressBaseWidth75;
    @UI("#progress-bar-base-width-100 .progress-bar")
    public static Progress progressBaseWidth100;
    @UI("#progress-animated")
    public static Progress progressAnimated;
    @UI("#progress-with-labels")
    public static Progress progressWithLabels;
    @UI("#progress-backgrounds-green")
    public static Progress progressBackgroundGreen;
    @UI("#progress-backgrounds-blue")
    public static Progress progressBackgroundBlue;
    @UI("#progress-backgrounds-yellow")
    public static Progress progressBackgroundYellow;
    @UI("#progress-backgrounds-red")
    public static Progress progressBackgroundRed;
    @UI("#navbar-containers-centred")
    public static Navbar navbarCentredContainer;
    @UI("#navbar-containers-expanded")
    public static Navbar navbarExpandedContainer;
    @UI("#button-show-spinner-border")
    public static Button buttonSpinnerBorder;
    @UI("#spinner-border")
    public static Spinner spinnerBorder;
    @UI("#forms-readonly-input")
    public static TextField readonlyInput;
    @UI("#readonlyPlainText1")
    public static ReadonlyPlainText readonlyPlainText1;
    @UI("#readonlyPlainText2")
    public static ReadonlyPlainText readonlyPlainText2;
    //endregion

    //region Complex Elements
    @UI("#carousel-example-slides-only")
    public static Carousel carouselWithSlidesOnly;
    @UI("#carousel-example-controls")
    public static Carousel carouselWithControls;
    @UI("#carousel-example-indicators")
    public static Carousel carouselWithIndicators;
    @UI("#carousel-example-captions")
    public static Carousel carouselWithCaptions;
    @UI("#carousel-example-fade")
    public static Carousel carouselWithFadeTransition;
    @UI("#carousel-example-interval")
    public static Carousel carouselWithCustomInterval;
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
    @UI("#input-group-checkbox")
    public static InputGroupInputWithCheckBox inputGroupCheckBox;
    @UI("#input-group-radio")
    public static InputGroupInputWithRadio inputGroupRadio;
    @UI("#input-group-basic-example1")
    public static InputGroupInputWithText inputGroupBasicExample1;
    @UI("#input-group-basic-example2")
    public static InputGroupInputWithText inputGroupBasicExample2;
    @UI("#input-group-basic-example3")
    public static InputGroupInputWithLabelAndText inputGroupBasicExample3;
    @UI("#input-group-basic-example4")
    public static InputGroupInputWithTwoText inputGroupBasicExample4;
    @UI("#input-group-basic-example5")
    public static InputGroupTextareaWithText inputGroupBasicExample5;
    @UI("#input-group-default")
    public static InputGroupSizing inputGroupDefaultSizing;
    @UI("#input-group-small")
    public static InputGroupSizing inputGroupSmallSizing;
    @UI("#input-group-large")
    public static InputGroupSizing inputGroupLargeSizing;
    // Button addons
    @UI("#input-group-button-addon1")
    public static ButtonAddons inputGroupButtonAddons1;
    @UI("#input-group-button-addon2")
    public static ButtonAddons inputGroupButtonAddons2;
    @UI("#input-group-button-addon3")
    public static ButtonAddons inputGroupButtonAddons3;
    @UI("#input-group-button-addon4")
    public static ButtonAddons inputGroupButtonAddons4;
    @UI("#card-example")
    public static CardExample cardExample;
    @UI("#card-image")
    public static CardImage cardImage;
    @UI("#card-image-overlay")
    public static CardImageOverlays cardImageOverlays;
    @UI("#card-image-caps-1")
    public static CardImageCaps cardImageOnTop;
    @UI("#card-image-caps-2")
    public static CardImageCaps cardImageOnBottom;
    @UI("#card-body")
    public static CardBody cardBody;
    @UI("#card-with-header")
    public static CardWithHeaderAndFooter cardWithHeader;
    @UI("#card-with-header-and-footer-quote")
    public static CardWithHeaderAndFooter cardWithHeaderAndFooterQuote;
    @UI("#card-with-header-and-footer")
    public static CardWithHeaderAndFooter cardWithHeaderAndFooter;
    @UI("#card-with-grid-markup")
    public static CardWithGridMarkup cardWithGridMarkup;
    @UI("#card-bright-blue")
    public static CardWithHeaderAndFooter cardBrightBlue;
    @UI("#card-grey")
    public static CardWithHeaderAndFooter cardGrey;
    @UI("#card-green")
    public static CardWithHeaderAndFooter cardGreen;
    @UI("#card-red")
    public static CardWithHeaderAndFooter cardRed;
    @UI("#card-yellow")
    public static CardWithHeaderAndFooter cardYellow;
    @UI("#card-blue")
    public static CardWithHeaderAndFooter cardBlue;
    @UI("#card-light")
    public static CardWithHeaderAndFooter cardLight;
    @UI("#card-dark")
    public static CardWithHeaderAndFooter cardDark;
    @UI("#card-border-primary")
    public static CardBorder cardBorderPrimary;
    @UI("#card-border-secondary")
    public static CardBorder cardBorderSecondary;
    @UI("#card-border-success")
    public static CardBorder cardBorderSuccess;
    @UI("#card-border-danger")
    public static CardBorder cardBorderDanger;
    @UI("#card-border-warning")
    public static CardBorder cardBorderWarning;
    @UI("#card-border-info")
    public static CardBorder cardBorderInfo;
    @UI("#card-border-light")
    public static CardBorder cardBorderLight;
    @UI("#card-border-dark")
    public static CardBorder cardBorderDark;
    @UI("#button-with-dropdown")
    public static ButtonWithDropdown buttonWithDropdown;
    @UI("#segmented-button")
    public static SegmentedButton segmentedButton;
    @UI("#buttonToolbar1")
    public static ButtonToolbar buttonToolbar;
    @UI("#buttonToolbar2")
    public static ButtonToolbar buttonToolbarWithInputField;
    @UI("#card-subtitle-link")
    public static CardWithSubtitlesAndLinks cardWithSubtitlesAndLinks;
    @UI("#card-custom-css-1")
    public static CardWithCustomCss13Rem cardWithCustomCss13Rem;
    @UI("#card-custom-css-2")
    public static CardWithCustomCss9Rem cardWithCustomCss9Rem;
    @UI("#card-mixins-utilities")
    public static CardMixinsUtilities cardMixinsUtilities;
    @UI("#card-horizontal")
    public static CardHorizontal cardHorizontal;
    @UI("#custom-select-01")
    public static CustomSelect customSelect;
    @UI("#custom-select-button-01")
    public static CustomSelectWithButton customSelectWithButton;
    @UI("#media-object-sample")
    public static MediaObjectSample mediaObjectSample;
    @UI("#media-object-nesting")
    public static MediaObjectNesting mediaObjectNesting;
    @UI("#media-object-list")
    public static JList<MediaObjectSample> mediaObjectList;
    @UI("#multiple-addons-1")
    public static InputGroupMultipleAddonsUpper multipleAddonUpper;
    @UI("#multiple-addons-2")
    public static InputGroupMultipleAddonsLower multipleAddonLower;
    @UI("#basic-example")
    public static ButtonGroupBasicExample buttonGroupBasicExample;
    @UI("#vertical-variation")
    public static ButtonGroupVerticalVariation buttonGroupVerticalVariation;
    @UI("#button-group-nesting")
    public static ButtonGroupNesting buttonGroupNesting;
    @UI("#btn-lg-group")
    public static ButtonGroupSizing largeBtnGroup;
    @UI("#btn-md-group")
    public static ButtonGroupSizing defaultBtnGroup;
    @UI("#btn-sm-group")
    public static ButtonGroupSizing smallBtnGroup;
    @UI("#card-text-left")
    public static CardTextAlignment cardLeftTextAlignment;
    @UI("#card-text-center")
    public static CardTextAlignment cardCenterTextAlignment;
    @UI("#card-text-right")
    public static CardTextAlignment cardRightTextAlignment;
    @UI("#list-group-basic-example")
    public static ListGroupBasicExample listGroupBasicExample;
    @UI("#list-group-active-items")
    public static ListGroupActiveItems listGroupActiveItems;
    @UI("#disabled-items")
    public static ListGroupDisabledItems listGroupDisabledItems;
    @UI("#list-group-links")
    public static ListGroupLinks listGroupLinks;
    @UI("#list-group-buttons")
    public static ListGroupButtons listGroupButtons;
    @UI("#list-group-flush")
    public static ListGroupFlush listGroupFlush;
    @UI("#list-group-horizontal")
    public static ListGroupHorizontal listGroupHorizontal;
    @UI("#list-group-with-badges")
    public static ListGroupWithBadges listGroupWithBadges;
    @UI("#list-group-custom-content")
    public static ListGroupCustomContent listGroupCustomContent;
    @UI("#radio-buttons")
    public static RadioButtonGroup radioButtonGroup;
    @UI(".card-group:nth-of-type(1)")
    public static CardGroup cardGroupWithoutFooter;
    @UI(".card-group:nth-of-type(2)")
    public static CardGroup cardGroupWithFooter;
    @UI("#card-list-groups")
    public static CardListGroups cardListGroups;
    @UI("#pagination-overview")
    public static PaginationOverview paginationOverview;
    @UI("#pagination-icons")
    public static PaginationIcons paginationIcons;
    @UI("#pagination-states")
    public static PaginationStates paginationStates;
    @UI("#pagination-big")
    public static PaginationSizeBig paginationSizeBig;
    @UI("#pagination-small")
    public static PaginationSizeSmall paginationSizeSmall;
    @UI("#pagination-center")
    public static PaginationAlignCenter paginationAlignCenter;
    @UI("#pagination-end")
    public static PaginationAlignEnd paginationAlignEnd;
    @UI("#nav-base-li")
    public static NavsBaseLi navsBaseLi;
    @UI("#nav-base-a")
    public static NavsBaseA navsBaseA;
    @UI("#nav-center")
    public static NavsAlignmentCenter navsAlignmentCenter;
    @UI("#nav-end")
    public static NavsAlignmentEnd navsAlignmentEnd;
    @UI("#nav-vert-li")
    public static NavsVerticalLi navsVerticalLi;
    @UI("#nav-vert-a")
    public static NavsVerticalA navsVerticalA;
    @UI("#nav-tabs")
    public static NavsTabs navsTabs;
    @UI("#nav-pills")
    public static NavsPills navsPills;
    @UI("#nav-justify")
    public static NavsJustify navsJustify;
    @UI("#nav-with-dropdown")
    public static NavsTabsWithDropdown navsTabsWithDropdown;
    @UI("#nav-pills-drop")
    public static NavsPillsWithDropdown navsPillsWithDropdown;
    @UI("#navbar-dark-colorscheme")
    public static NavbarColorScheme navbarDarkColorScheme;
    @UI("#navbar-blue-colorscheme")
    public static NavbarColorScheme navbarBlueColorScheme;
    @UI("#navbar-light-colorscheme")
    public static NavbarColorScheme navbarLightColorScheme;
    @UI("#progress-multiple-bars")
    public static ProgressMultipleBars progressMultipleBars;
    @UI(".card-columns")
    public static CardColumns cardColumns;
    @UI("#list-example>a")
    public static ListGroup listGroupForScrollSpy;
    @UI("#list-example~div")
    public static ScrollSpyNav scrollSpyWithListGroup;
    @UI("#navbar-example3")
    public static NestedNav nestedNav;
    @UI("#navbar-example3~div")
    public static ScrollSpyNav scrollSpyWithNestedNav;
    @UI("#navbar-example2")
    public static NavbarWithDropdown navbarWithDropdown;
    @UI("#navbar-example2~div")
    public static ScrollSpyNav scrollSpyInNavbar;
    @UI("body")
    public static Popover popover;
    @UI("body")
    public static CheckboxesDefaultInline checkboxesDefaultInline;
    @UI("body")
    public static RadioButtonsDefaultInline radioButtonsDefaultInline;
    @UI("body")
    public static CheckboxesDefault checkboxesDefault;
    @UI("body")
    public static CheckboxesCustom checkboxesCustom;
    @UI(".card-deck:nth-of-type(1)")
    public static CardDeck cardDeckWithoutFooter;
    @UI(".card-deck:nth-of-type(2)")
    public static CardDeck cardDeckWithFooter;
    @UI("#multiple-inputs")
    public static MultipleInputs multipleInputs;
    @UI("#growing-spinners")
    public static GrowingSpinners growingSpinners;
    @UI("#spinner-size")
    public static SpinnerSize spinnerSize;
    @UI("body")
    public static CheckboxesAndRadiosWithoutLabels checkboxesAndRadiosWithoutLabels;
    @UI("#validation-submit-form")
    public static FormCustomStyles formCustomStyles;
    @UI("#form-browser-defaults")
    public static FormBrowserDefaults formBrowserDefaults;
    @UI("#form-server-side")
    public static FormServerSide formServerSide;
    @UI("#form-tooltip")
    public static FormTooltip formTooltip;
    @UI("#modalMdo")
    public static Button modalMdoButton;
    @UI("#modalFat")
    public static Button modalFatButton;
    @UI("#modalGetbootstrap")
    public static Button modalGetbootstrapButton;
    @UI("#modalVaryingContentWindow")
    public static ModalVaryingContent modalVaryingContentWindow;
    @UI("#card-kitchen-sink")
    public static CardKitchenSink cardKitchenSink;
    @UI("#card-navigation")
    public static CardNavigation cardNavigation;
    @UI(".w-75")
    public static CardUtilities cardWidth75;
    @UI(".w-50")
    public static CardUtilities cardWidth50;
    @UI("#forms-overview")
    public static FormOverview formOverview;
    @UI("#form-horizontal")
    public static FormHorizontal formHorizontal;


    @UI("//h4[.='Navbar - Text']/../..")
    public static NavbarText navbarText;

    @UI("#striped-base .progress")
    public static JList<ProgressSection> progressSections;
    @UI("#progress-height .progress")
    public static JList<ProgressSection> progressHeightSections;

    @UI("#button-with-spinner-and-text")
    public static ButtonWithSpinner buttonWithSpinnerAndText;
    @UI("#button-with-spinner")
    public static ButtonWithSpinner buttonWithSpinner;
    @UI("#button-with-growing-spinner-and-text")
    public static ButtonWithSpinner buttonWithGrowingSpinnerAndText;
    @UI("#button-with-growing-spinner")
    public static ButtonWithSpinner buttonWithGrowingSpinner;
    @UI("#navbar-form-1")
    public static NavbarForm navbarForm;
    @UI("#navbar-form-2")
    public static NavbarForm navbarFormWithText;
    @UI("#navbar-form-3")
    public static NavbarWithInputGroupForm navbarFormWithInputGroup;
    //Toasts

    @UI("#toastRightTop")
    public static Toast toastWithTopAlign;
    @UI("#linkToastRightTop")
    public static Button toastWithTopAlignButton;
    @UI("#simpleToast")
    public static Toast simpleToast;
    @UI("#linkSimpleToastExample")
    public static Button simpleToastButton;
    @UI("#multipleToast")
    public static Button stackOfToastsButton;
    @UI("#firstMultipleToast")
    public static Toast firstStackToast;
    @UI("#secondMultipleToast")
    public static Toast secondStackToast;
    @UI("#linkStackAlign")
    public static Button stackOfToastsWithTopAlignButton;
    @UI("#firstStackToast")
    public static Toast firstTopAlignStackToast;
    @UI("#secondStackToast")
    public static Toast secondTopAlignStackToast;
    @UI("#linkToastCenterTop")
    public static Button toastWithCenterAlignButton;
    @UI("#toastCenterTop")
    public static Toast toastWithCenterAlign;
    @UI("#spinner-alignment")
    public static SpinnerAlignment spinnerAlignment;
    @UI("body")
    public static CheckboxAndRadioButtonCustomDisabled checkboxAndRadioButtonCustomDisabled;
    @UI("body")
    public static Switches switches;
    @UI("body")
    public static RadioButtonsCustomInline radioButtonsCustomInline;
    @UI("#translucentToastButton")
    public static Button translucentToastButton;
    @UI("#translucentToast")
    public static Toast translucentToast;
    @UI("#custom-radio-con")
    public static RadioButtonsCustom radioButtonCustom;
    @UI("#forms-sizing")
    public static FormsSizing formsSizing;
    @UI("#form-help-text")
    public static FormHelpText formHelpText;
    @UI("#form-disabled")
    public static FormDisabled formDisabled;

    //Navbars
    @UI("#navbar-nav-with-disabled")
    public static Navbar navbarNavWithDisabled;
    @UI("#navbar-nav-with-dropdown")
    public static Navbar navbarNavWithDropdown;
    @UI("#navbar-external-content")
    public static NavbarExternalContent navbarExternalContent;
    @UI("#navbar-supported-content")
    public static NavbarSupportedContent navbarSupportedContent;

    @UI("#modal-vertically-centered")
    public static ModalVerticallyCentered modalVerticallyCentered;
    //endregion

    @UI("#grid-modal-base")
    public static GridModalSection gridModalSection;
    //region Modals
    @UI("#modal-scroll-long")
    public static SectionModalLongScrolling sectionModalLongScrolling;
    //endregion
}
