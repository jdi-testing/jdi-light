package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.*;
import com.epam.jdi.light.ui.bootstrap.elements.complex.*;
import com.epam.jdi.light.ui.bootstrap.elements.complex.navs.*;
import com.epam.jdi.light.ui.bootstrap.elements.composite.DropdownMenu;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.*;
import io.github.com.RangeControl;
import io.github.com.sections.*;
import io.github.com.sections.buttongroup.*;
import io.github.com.sections.card.*;
import io.github.com.sections.dropdown.DropdownForm;
import io.github.com.sections.dropdown.DropdownMenuContent;
import io.github.com.sections.form.*;
import io.github.com.sections.inputgroup.*;
import io.github.com.sections.listgroup.*;
import io.github.com.sections.modal.*;
import io.github.com.sections.modal.gridmodal.GridModalSection;
import io.github.com.sections.navbar.*;
import io.github.com.sections.pagination.*;
import io.github.com.sections.progress.ProgressSection;
import io.github.com.sections.spinner.GrowingSpinnersSection;
import io.github.com.sections.spinner.SpinnerAlignmentSection;
import io.github.com.sections.spinner.SpinnerSizeSection;
import io.github.com.sections.toast.Toast;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static UIElement inputGroupWrap;
    public static UIElement inputGroupNowrap;
    public static Button redButton;
    public static Button doubleButton;
    public static Button disabledButton;

    @UI("[type=button][value='+']") public static Button increaseProgress;
    @UI("[type=button][value='-']") public static Button decreaseProgress;
    @UI("[type=button][value='reset']") public static Button resetProgress;
    public static Progress progressbar;
    public static Progress multiProgressbar;
    public static Breadcrumb breadcrumb;
    public static Switch switcher;
    public static Switch disabledSwitcher;
    public static Button buttonWithTooltip;
    public static Button simpleToastButton;

    @UI("#jumbotron-fluid")
    public static Jumbotron jumbotronFluid;
    @UI("#jumbotron")
    public static Jumbotron jumbotron;
    @UI("#simpleDropdown")
    public static DropdownMenu simpleDropdown;
    @UI("#linkDropdown")
    public static DropdownMenu linkDropdown;
    @UI("#primaryDropdown")
    public static DropdownMenu primaryDropdown;
    @UI("#successDropdown")
    public static DropdownMenu successDropdown;
    @UI("#infoDropdown")
    public static DropdownMenu infoDropdown;
    @UI("#splitDropdown")
    public static DropdownMenu splitDropdown;
    @UI("#largeDropdown")
    public static DropdownMenu largeDropdown;
    @UI("#largeSplitDropdown")
    public static DropdownMenu largeSplitDropdown;
    @UI("#smallDropdown")
    public static DropdownMenu smallDropdown;
    @UI("#smallSplitDropdown")
    public static DropdownMenu smallSplitDropdown;
    @UI("#dropUpDropdown")
    public static DropdownMenu dropUpDropdown;
    @UI("#dropUpSplitDropdown")
    public static DropdownMenu dropUpSplitDropdown;
    @UI("#dropRightDropdown")
    public static DropdownMenu dropRightDropdown;
    @UI("#dropRightSplitDropdown")
    public static DropdownMenu dropRightSplitDropdown;
    @UI("#dropLeftDropdown")
    public static DropdownMenu dropLeftDropdown;
    @UI("#dropLeftSplitDropdown")
    public static DropdownMenu dropLeftSplitDropdown;
    @UI("#rightAllignedDropdown")
    public static DropdownMenu rightAllignedDropdown;
    @UI("#leftAllignedDropdown")
    public static DropdownMenu leftAllignedDropdown;
    @UI("#dropdown-menu-items")
    public static DropdownMenu dropdownMenuItems;
    @UI("#dropdown-menu-text-item")
    public static DropdownMenu dropdownMenuTextItem;
    @UI("#dropdown-menu-items-active")
    public static DropdownMenu dropdownMenuItemsActive;
    @UI("#dropdown-menu-disabled-item")
    public static DropdownMenu dropdownMenuDisabledItem;
    @UI("#dropdown-content-header")
    public static DropdownMenuContent dropdownMenuContentHeader;
    @UI("#dropdown-content-divider")
    public static DropdownMenuContent dropdownMenuContentDivider;
    @UI("#dropdown-content-text")
    public static DropdownMenuContent dropdownMenuContentText;
    public static DropdownMenu offsetDropdown;
    public static DropdownMenu referenceDropdown;
    public static DropdownForm dropdownForm;
    public static Alert simpleAlert;
    public static DismissAlert dismissibleAlert;
    @UI("#badge-secondary")
    public static Text badgeSecondary;
    @UI("#badge-success")
    public static Link badgeSuccess;
    @UI("#btn-primary")
    public static ButtonWithBadge buttonWithBadge;

    @UI("//h4[.='Navbar - Containers']/../..")
    public static NavbarContainer navbarContainers;
    @UI("//h4[.='Navbar - Nav']/../..")
    public static NavbarNav navbarNav;

    public static Button startButton;
    public static Spinner spinnerLoading;
    public static Loading spinnerRotate;

    @UI("#forms-readonly-input")
    public static TextField readonlyInput;
    @UI("#readonlyPlainText1")
    public static ReadonlyPlainText readonlyPlainText1;
    @UI("#readonlyPlainText2")
    public static ReadonlyPlainText readonlyPlainText2;
    @UI("#forms-select-menu-large")
    public static SelectMenu formsSelectMenuLarge;
    @UI("#forms-select-menu")
    public static SelectMenu formsSelectMenu;
    @UI("#forms-select-menu-small")
    public static SelectMenu formsSelectMenuSmall;
    @UI("#forms-select-menu-multiple")
    public static SelectMenu formsSelectMenuMultiple;
    @UI("#forms-select-menu-size")
    public static SelectMenu formsSelectMenuSize;
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
    //region COLLAPSE
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

    //region Cards
    @UI("#card-body")
    public static CardBody cardBody;
    @UI(".card-columns")
    public static CardColumnsSection cardColumnsSection;
    @UI(".card-deck:nth-of-type(1)")
    public static CardDeckSection cardDeckSectionWithoutFooter;
    @UI(".card-deck:nth-of-type(2)")
    public static CardDeckSection cardDeckSectionWithFooter;
    @UI("#card-example")
    public static CardExample cardExample;
    @UI(".card-group:nth-of-type(1)")
    public static CardGroupSection cardGroupSectionWithoutFooter;
    @UI(".card-group:nth-of-type(2)")
    public static CardGroupSection cardGroupSectionWithFooter;
    @UI("#card-horizontal")
    public static CardHorizontal cardHorizontal;
    @UI("#card-image")
    public static CardImage cardImage;
    @UI("#card-image-caps-1")
    public static CardImageCaps cardImageOnTop;
    @UI("#card-image-caps-2")
    public static CardImageCaps cardImageOnBottom;
    @UI("#card-image-overlay")
    public static CardImageOverlays cardImageOverlays;
    @UI("#card-kitchen-sink")
    public static CardKitchenSink cardKitchenSink;
    @UI("#card-list-groups")
    public static CardListGroups cardListGroups;
    @UI("#card-mixins-utilities")
    public static CardMixinsUtilities cardMixinsUtilities;
    @UI("#card-navigation")
    public static CardNavigation cardNavigation;
    @UI("#card-bright-blue")
    public static CardStyled cardBrightBlue;
    @UI("#card-grey")
    public static CardStyled cardGrey;
    @UI("#card-green")
    public static CardStyled cardGreen;
    @UI("#card-red")
    public static CardStyled cardRed;
    @UI("#card-yellow")
    public static CardStyled cardYellow;
    @UI("#card-blue")
    public static CardStyled cardBlue;
    @UI("#card-light")
    public static CardStyled cardLight;
    @UI("#card-dark")
    public static CardStyled cardDark;
    @UI("#card-border-primary")
    public static CardStyled cardStyledPrimary;
    @UI("#card-border-secondary")
    public static CardStyled cardStyledSecondary;
    @UI("#card-border-success")
    public static CardStyled cardStyledSuccess;
    @UI("#card-border-danger")
    public static CardStyled cardStyledDanger;
    @UI("#card-border-warning")
    public static CardStyled cardStyledWarning;
    @UI("#card-border-info")
    public static CardStyled cardStyledInfo;
    @UI("#card-border-light")
    public static CardStyled cardStyledLight;
    @UI("#card-border-dark")
    public static CardStyled cardStyledDark;
    @UI("#card-text-left")
    public static CardTextAlignment cardLeftTextAlignment;
    @UI("#card-text-center")
    public static CardTextAlignment cardCenterTextAlignment;
    @UI("#card-text-right")
    public static CardTextAlignment cardRightTextAlignment;
    @UI(".w-75")
    public static CardUtilities cardWidth75;
    @UI(".w-50")
    public static CardUtilities cardWidth50;
    @UI("#card-custom-css-1")
    public static CardWithCustomCss cardWithCustomCss13Rem;
    @UI("#card-custom-css-2")
    public static CardWithCustomCss cardWithCustomCss9Rem;
    @UI("#card-with-grid-markup")
    public static CardWithGridMarkup cardWithGridMarkup;
    @UI("#card-with-header")
    public static CardWithHeaderAndFooter cardWithHeader;
    @UI("#card-with-header-and-footer-quote")
    public static CardWithHeaderAndFooter cardWithHeaderAndFooterQuote;
    @UI("#card-with-header-and-footer")
    public static CardWithHeaderAndFooter cardWithHeaderAndFooter;
    @UI("#card-subtitle-link")
    public static CardWithSubtitlesAndLinks cardWithSubtitlesAndLinks;
    //endregion

    @UI("#button-with-dropdown")
    public static InputGroupButtonWithDropdown inputGroupButtonWithDropdown;
    @UI("#segmented-button")
    public static SegmentedButton segmentedButton;
    @UI("#buttonToolbar1")
    public static ButtonGroupToolbar buttonGroupToolbar;
    @UI("#buttonToolbar2")
    public static ButtonGroupToolbar buttonGroupToolbarWithInputField;
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
    public static ButtonGroupBasic buttonGroupBasic;
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
    @UI("#customCheck1-div")
    public static Checkbox customCheckbox;
    @UI("#multiple-inputs")
    public static MultipleInputs multipleInputs;
    @UI("#growing-spinners")
    public static GrowingSpinnersSection growingSpinners;
    @UI("#spinner-size")
    public static SpinnerSizeSection spinnerSize;
    @UI("body")
    public static CheckboxesAndRadiosWithoutLabels checkboxesAndRadiosWithoutLabels;
    @UI("#modalMdo")
    public static Button modalMdoButton;
    @UI("#modalFat")
    public static Button modalFatButton;
    @UI("#modalGetbootstrap")
    public static Button modalGetbootstrapButton;
    @UI("#modalVaryingContentWindow")
    public static ModalVaryingContent modalVaryingContentWindow;
    @UI("#modal-youtube button.btn-primary")
    public static Button modalEmbeddedVideoButton;
    @UI("#youTubeModalLabel")
    public static EmbeddedVideoModal embeddedVideoModal;
    @UI("//h4[.='Navbar - Text']/../..")
    public static NavbarText navbarText;
    @UI("//h4[.='Modal - Tooltips and popovers']/../..")
    public static ModalTooltipsAndPopovers modalTooltipsAndPopovers;

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
    public static SpinnerAlignmentSection spinnerAlignment;
    @UI("body")
    public static CheckboxAndRadioButtonCustomDisabled checkboxAndRadioButtonCustomDisabled;
    @UI("body")
    public static RadioButtonsCustomInline radioButtonsCustomInline;
    @UI("#translucentToastButton")
    public static Button translucentToastButton;
    @UI("#translucentToast")
    public static Toast translucentToast;
    @UI("#custom-radio-con")
    public static RadioButtonsCustom radioButtonCustom;

    //region Navbars
    @UI("#navbar-external-content")
    public static NavbarExternalContent navbarExternalContent;
    @UI("#navbar-supported-content")
    public static NavbarSupportedContent navbarSupportedContent;
    @UI("#navbar-base-for-brand")
    public static NavbarSection navbarSection;
    @UI("#navbar-sticky-top")
    public static NavbarPlacement navbarPlacementStickyTop;
    //endregion

    //region Ranges
    @UI("#formControlRange")
    public static RangeInput rangeInput;
    public static Range defaultRange;
    public static Range minMaxRange;
    public static Range fractionalRange;
    public static Range disabledRange;
    @UI("#default-range")
    public static RangeControl rangeControl;
    //endregion

    //region Modals
    @UI("#grid-modal-base")
    public static GridModalSection gridModalSection;
    //@UI("#modal-scroll-long")
    public static SectionModalLongScrolling sectionModalLongScrolling;
    @UI("#modal-live-demo .bd-example .btn")
    public static Button modalLiveDemoLaunchButton;
    @UI("#exampleModalLive")
    public static ModalLiveDemo modalLiveDemo;
    @UI("#modal-vertically-centered")
    public static ModalVerticallyCentered modalVerticallyCentered;
    @UI("#modal-optional-sizes")
    public static ModalOptionalSizes modalOptionalSizes;
    //endregion

    @UI("#form-controls-file-input")
    public static InputFileSection inputFileSection;
    @UI("#file-input .custom-file")
    public static InputGroupCustomFileInput inputGroupCustomFileInput;
    @UI(".input-group#upload-file")
    public static InputGroupCustomUploadFile inputGroupCustomUploadFile;
}
