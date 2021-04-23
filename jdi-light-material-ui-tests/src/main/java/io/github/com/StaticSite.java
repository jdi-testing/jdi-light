package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.DataClass;
import io.github.com.pages.displaydata.*;
import io.github.com.pages.feedback.*;
import io.github.com.pages.inputs.*;
import io.github.com.pages.layout.BoxFrame;
import io.github.com.pages.inputs.ButtonGroupFrame;
import io.github.com.pages.inputs.CheckboxPage;
import io.github.com.pages.inputs.EnhancedTransferListFrame;
import io.github.com.pages.inputs.FabFrame;
import io.github.com.pages.inputs.GroupCheckBoxFrame;
import io.github.com.pages.inputs.RadioButtonFrame;
import io.github.com.pages.inputs.SelectFrame;
import io.github.com.pages.inputs.SimpleTransferListFrame;
import io.github.com.pages.inputs.SliderFrame;
import io.github.com.pages.inputs.SplitButtonGroupFrame;
import io.github.com.pages.inputs.SwitchPage;
import io.github.com.pages.inputs.TextFieldFrame;
import io.github.com.pages.layout.ContainerFrame;
import io.github.com.pages.layout.GridFrame;
import io.github.com.pages.layout.HiddenFrame;
import io.github.com.pages.navigation.*;
import io.github.com.pages.surfaces.AccordionPage;
import io.github.com.pages.surfaces.AppBarFrame;
import io.github.com.pages.surfaces.CardPage;
import io.github.com.pages.surfaces.PaperPage;
import io.github.com.pages.utils.*;

@JSite("https://jdi-testing.github.io/jdi-light/material/")
public class StaticSite {

    // inputs
    // switch
    public static SwitchPage switchPage;

    //date and time pickers
    @Url("date_picker")
    public static DateTimePickersPage dateTimePickersPage;

    //simple transfer list
    @Frame("storybook-preview-iframe")
    public static SimpleTransferListFrame simpleTransferListFrame;

    @Url("/material-ui-inputs-transfer-list--simple-transfer-list-view")
    public static WebPage inputSimpleTransferListPage;

    //enhanced transfer list
    @Frame("storybook-preview-iframe")
    public static EnhancedTransferListFrame enhancedTransferListFrame;

    @Url("/material-ui-inputs-transfer-list--enhanced-transfer-list-view")
    public static WebPage inputEnhancedTransferListPage;


    public static ButtonPage buttonPage;

    // radio
    @Frame("storybook-preview-iframe")
    public static RadioButtonFrame radioButtonFrame;

    @Url("/material-ui-inputs-radio--default")
    public static WebPage radioDefaultPage;

    // floating action button
    @Frame("storybook-preview-iframe")
    public static FabFrame fabFrame;

    @Url("/material-ui-inputs-floating-action-button--default")
    public static WebPage inputFabDefaultPage;

    @Url("/material-ui-inputs-floating-action-button--disabled")
    public static WebPage inputFabDisabledPage;

    // text field
    @Frame("storybook-preview-iframe")
    public static TextFieldFrame textFieldFrame;

    @Url("/textarea_autosize")
    public static TextAreaAutoSizePage textAreaAutoSizePage;

    @Url("/material-ui-inputs-text-field--standard")
    public static WebPage inputTextFieldStandardPage;

    @Url("/material-ui-inputs-text-field--field-with-default")
    public static WebPage inputTextFieldFilledWithDefaultPage;

    @Url("/material-ui-inputs-text-field--filled")
    public static WebPage inputTextFieldFilledPage;

    @Url("/material-ui-inputs-text-field--disabled")
    public static WebPage inputTextFieldDisabledPage;

    @Url("/material-ui-inputs-text-field--time")
    public static WebPage inputTextFieldTimePage;

    //checkbox
    @Url("/checkboxes")
    public static CheckboxPage checkboxPage;

    // button group
    @Frame("storybook-preview-iframe")
    public static ButtonGroupFrame buttonGroupFrame;

    @Frame("storybook-preview-iframe")
    public static SplitButtonGroupFrame splitButtonGroupFrame;

    @Url("/material-ui-inputs-button-group--default")
    public static WebPage inputButtonGroupDefaultPage;

    @Url("/material-ui-inputs-button-group--disabled")
    public static WebPage inputButtonGroupDisabledPage;

    @Url("/material-ui-inputs-button-group--split-button")
    public static WebPage inputButtonGroupSplitPage;

    @Frame("storybook-preview-iframe")
    public static SelectFrame selectFrame;

    @Url("/material-ui-inputs-select--disabled-select-view")
    public static WebPage inputSelectDisabledPage;

    @Url("/material-ui-inputs-select--multiple-select-view")
    public static WebPage inputSelectMultiplePage;

    @Url("/material-ui-inputs-select--simple-select-view")
    public static WebPage inputSelectSimplePage;

    //slider
    @Frame("storybook-preview-iframe")
    public static SliderFrame sliderFrame;

    @Url("/material-ui-inputs-sliders--default-and-disabled-sliders")
    public static WebPage inputSliderDefaultAnfDisabledPage;

    @Url("/material-ui-inputs-sliders--range-slider")
    public static WebPage inputSliderRangePage;

    @Url("/material-ui-inputs-sliders--vertical-slider")
    public static WebPage inputSliderVerticalPage;

    // surfaces
    // accordion
    @Frame("storybook-preview-iframe")
    public static AccordionPage accordionPage;

    @Url("/material-ui-surfaces-app-bar--simple-app-bar")
    public static WebPage appBarPage;

    @Frame("storybook-preview-iframe")
    public static AppBarFrame appBarFrame;

    // paper
    public static PaperPage paperPage;

    @Url("/material-ui-surfaces-app-bar--simple-app-bar")
    public static WebPage surfaceSimpleAppBarPage;

    @Url("/card_surface")
    public static CardPage surfaceCardPage;

    // data display
    // divider
    @Frame("storybook-preview-iframe")
    public static InsetDividerFrame insetDividerFrame;

    @Url("/material-ui-data-display-dividers--inset-dividers-view")
    public static WebPage dataDisplayInsetDividerPage;

    @Frame("storybook-preview-iframe")
    public static VerticalDividerFrame verticalDividerFrame;

    @Url("/material-ui-data-display-dividers--vertical-dividers-view")
    public static WebPage dataDisplayVerticalDividerPage;

    // feedback
    // dialog
    public static DialogPage dialogPage;

    @Frame("storybook-preview-iframe")
    public static AvatarFrame dataDisplayAvatarFrame;

    @Url("/material-ui-data-display-avatar--no-image")
    public static WebPage dataDisplayNoImageAvatarPage;

    @Url("/material-ui-data-display-avatar--circle")
    public static WebPage dataDisplayCircleAvatarPage;

    @Url("/material-ui-data-display-avatar--square")
    public static WebPage dataDisplaySquareAvatarPage;

    @Url("/material-ui-data-display-avatar--rounded")
    public static WebPage dataDisplayRoundedAvatarPage;

    @Url("/material-ui-data-display-avatar--fallback-alt")
    public static WebPage dataDisplayFallbackAltAvatarPage;

    @Url("/material-ui-data-display-avatar--letter")
    public static WebPage dataDisplayLetterAvatarPage;

    @Url("/material-ui-data-display-avatar--icon")
    public static WebPage dataDisplayIconAvatarPage;

    public static GroupCheckBoxFrame groupCheckBoxFrame;

    @Url("/material-ui-inputs-checkbox--group")
    public static WebPage groupCheckBoxPage;

    // Display data
    //icons
    @Url("/icons")
    public static IconsPage iconsPage;

    // material icon
    @Frame("storybook-preview-iframe")
    public static MaterialIconFrame materialIconFrame;

    @Url("/material-ui-data-display-material-icons--default")
    public static WebPage displayDataDefaultMaterialIconPage;

    @Url("/material-ui-data-display-material-icons--secondary")
    public static WebPage displayDataLargeMaterialIconPage;

    @Frame("storybook-preview-iframe")
    public static ModalFrame modalFrame;

    @Url("/material-ui-utils-modal--transitions-modal")
    public static WebPage transitionsModalPage;

    @Url("/material-ui-utils-modal--server-modal")
    public static WebPage serverSideModalPage;

    // typography
    @Frame("storybook-preview-iframe")
    public static TypographyFrame typographyFrame;
    // utils
    // popper
    @Frame("storybook-preview-iframe")
    public static PopperFrame popperFrame;

    @Url("/material-ui-utils-popper--simple")
    public static WebPage utilsSimplePopperPage;

    @Url("/material-ui-utils-popper--transitions")
    public static WebPage utilsTransitionsPopperPage;

    @Url("/material-ui-utils-popper--positioned")
    public static WebPage utilsPositionedPoppersPage;


    @Url("/material-ui-data-display-typography--typography-view")
    public static WebPage dataDisplayTypographyPage;

    // badge
    @Frame("storybook-preview-iframe")
    public static BadgePage badgeFrame;

    // tooltip
    @Frame("storybook-preview-iframe")
    public static TooltipFrame tooltipFrame;

    @Url("/material-ui-data-display-tooltip--default")
    public static WebPage displayDataTooltipDefaultPage;

    @Url("/material-ui-data-display-tooltip--interactive")
    public static WebPage displayDataTooltipInteractivePage;

    // table
    @Frame("storybook-preview-iframe")
    public static TableFrame tableFrame;

    @Url("/material-ui-data-display-table--simple")
    public static WebPage displayDataSimpleTablePage;

    @Url("/material-ui-data-display-table--dense")
    public static WebPage displayDataDenseTablePage;

    @Url("/material-ui-data-display-table--sticky-header")
    public static WebPage displayDataStickyHeaderTablePage;

    @Url("/material-ui-data-display-table--table-with-pagination")
    public static WebPage displayDataTableWithPaginationPage;

    @Url("/material-ui-data-display-table--sorting-table")
    public static WebPage displayDataSortingTablePage;

    @Url("/material-ui-data-display-table--spanning-table")
    public static WebPage displayDataSpanningTablePage;

    // chip
    @Frame("storybook-preview-iframe")
    public static ChipFrame chipFrame;

    @Url("/material-ui-data-display-chips--default-chip")
    public static WebPage displayDataDefaultChipPage;

    @Url("/material-ui-data-display-chips--outlined-chip")
    public static WebPage displayDataOutlinedChipPage;

    @Url("/material-ui-data-display-chips--chip-array")
    public static WebPage displayDataArrayChipPage;

    @Url("/material-ui-data-display-chips--small-default-chip")
    public static WebPage displayDataSmallDefaultChipPage;

    @Url("/material-ui-data-display-chips--small-outlined-chip")
    public static WebPage displayDataSmallOutlinedChipPage;

    // lists
    @Frame("storybook-preview-iframe")
    public static ListsFrame listsFrame;

    @Url("/material-ui-data-display-lists--simple-list")
    public static WebPage dataDisplayListsSimpleListPage;

    @Url("/material-ui-data-display-lists--checkbox-list")
    public static WebPage dataDisplayCheckboxListPage;

    @Url("/material-ui-data-display-lists--pinned-subheader-list")
    public static WebPage dataPinnedSubheaderListPage;

    // feedback
    // backdrop
    @Frame("storybook-preview-iframe")
    public static BackdropPage backdropPage;

    @Url("/material-ui-feedback-backdrop--default-backdrop")
    public static WebPage feedbackBackdropDefaultPage;

    // circular
    @Url("/material-ui-feedback-progress--circular-indeterminate")
    public static WebPage circularIndeterminatePage;

    @Url("/material-ui-feedback-progress--circular-determinate")
    public static WebPage circularDeterminatePage;

    @Url("/material-ui-feedback-progress--circular-integration")
    public static WebPage circularIntegrationPage;

    @Url("/material-ui-feedback-progress--circular-with-value-label")
    public static WebPage circularWithValueLabel;

    @Frame("storybook-preview-iframe")
    public static CircularProgressFrame circularProgressFrame;

    // linear
    @Frame("storybook-preview-iframe")
    public static LinearProgressFrame linearProgressFrame;

    @Url("/material-ui-feedback-progress--linear-indeterminate")
    public static WebPage linearIndeterminatePage;

    @Url("/material-ui-feedback-progress--linear-determinate")
    public static WebPage linearDeterminatePage;

    @Url("/material-ui-feedback-progress--linear-buffer")
    public static WebPage linearBufferPage;

    @Url("/material-ui-feedback-progress--linear-with-value-label")
    public static WebPage linearWithLabelPage;

    @Url("/material-ui-feedback-progress--customized-progress-bars")
    public static WebPage customisedProgressPage;

    @Url("/material-ui-feedback-progress--delaying-appearance")
    public static WebPage delayingAppearancePage;

    // snackbar
    @Frame("storybook-preview-iframe")
    public static SnackbarPage simpleSnackbarPage;

    // navigation
    // tabs

    @Url("/material-ui-navigation-tabs--default")
    public static WebPage defaultTabPage;

    @Url("/material-ui-navigation-tabs--disabled-tab-example")
    public static WebPage disabledTabPage;

    @Url("/material-ui-navigation-tabs--scrollable-tab-example")
    public static WebPage scrollableTabPage;

    @Url("/material-ui-navigation-tabs--vertical-tab-example")
    public static WebPage verticalTabPage;

    @Frame("storybook-preview-iframe")
    public static TabFrame simpleTabFrame;

    @Frame("storybook-preview-iframe")
    public static TabFrame disabledTabFrame;

    @Frame("storybook-preview-iframe")
    public static TabFrame scrollableTabFrame;

    @Frame("storybook-preview-iframe")
    public static TabFrame verticalTabFrame;

    // utils
    // Click away listener
    @Url("/click_away_listener")
    public static ClickAwayListenerPage clickAwayListenerPage;

    // transition
    @Frame("storybook-preview-iframe")
    public static TransitionFrame transitionFrame;

    @Url("/material-ui-utils-transitions--fade-transition")
    public static WebPage utilsTransitionFadePage;

    @Url("/material-ui-utils-transitions--collapse-transition")
    public static WebPage utilsTransitionCollapsePage;

    // popover
    @Frame("storybook-preview-iframe")
    public static PopoverPage popoverPage;

    // utils
    // Click away listener

    @Frame("storybook-preview-iframe")
    public static ClickAwayListenerPage clickAwayListenerFrame;


    @Url("/material-ui-utils-click-away-listener--default")
    public static WebPage utilsClickAwayListenerDefaultPage;

    @Url("/material-ui-utils-click-away-listener--portal-example")
    public static WebPage utilsClickAwayListenerPortalExamplePage;

    // portal
    @Url("portal")
    public static PortalPage portalPage;

    @Url("/material-ui-utils-portal--default")
    public static WebPage defaultPortalPage;

    // navigation
    // breadcrumbs
    @Frame("storybook-preview-iframe")
    public static BreadcrumbsPage breadcrumbsPage;

    @Url("/simple_breadcrumbs")
    public static WebPage simpleBreadcrumbsPage;

    @Url("/router_breadcrumbs")
    public static WebPage routerIntegrationBreadcrumbsPage;


    @Url("/material-ui-navigation-breadcrumbs--customized")
    public static WebPage customizedBreadcrumbsPage;

    // drawer
    public static DrawerPage drawerPage;

    // stepper
    @Frame("storybook-preview-iframe")
    public static StepperFrame stepperFrame;

    @Url("/material-ui-navigation-stepper--horizontal-linear-stepper")
    public static WebPage navigationStepperHorizontalLinearStepperPage;

    @Url("/material-ui-navigation-stepper--stepper-with-optional-step")
    public static WebPage navigationStepperWithOptionalStepPage;

    @Url("/material-ui-navigation-stepper--nonlinear-stepper")
    public static WebPage navigationStepperNonlinearStepperPage;

    // links
    @Frame("storybook-preview-iframe")
    public static LinkFrame linkFrame;

    @Url("/material-ui-navigation-link--default")
    public static WebPage defaultLinkPage;

    @Url("/material-ui-navigation-link--secondary")
    public static WebPage secondaryLinkPage;

    @Url("/material-ui-navigation-link--text-primary")
    public static WebPage textPrimaryLinkPage;

    @Url("/material-ui-navigation-link--text-secondary")
    public static WebPage textSecondaryLinkPage;

    @Url("/material-ui-navigation-link--error")
    public static WebPage errorLinkPage;

    @Url("/material-ui-navigation-link--underline-always")
    public static WebPage underlineAlwaysLinkPage;

    // bottom navigation
   @Url("/button_navigation")
   public static BottomNavigationPage bottomNavigationPage;

    // menu
    @Frame("storybook-preview-iframe")
    public static MenuFrame menuFrame;

    @Url("/material-ui-navigation-menu--simple-menu")
    public static WebPage simpleMenuPage;

    @Url("/material-ui-navigation-menu--scroll-menu")
    public static WebPage scrollMenuPage;

    @Url("/material-ui-navigation-menu--selected-with-vertical-positioning")
    public static WebPage selectedVerticalPositioningPage;

    @Url("/material-ui-navigation-menu--selected-no-vertical-positioning")
    public static WebPage selectedNoVerticalPositioningPage;

    @Url("/material-ui-navigation-menu--menu-list-with-positioning")
    public static WebPage positioningMenuPage;

    @Url("/material-ui-navigation-menu--context-menu")
    public static WebPage contextMenuPage;

    @Url("/material-ui-navigation-menu--menu-with-icons")
    public static WebPage menuWithIconsPage;

    // layouts
    // hidden
    @Frame("storybook-preview-iframe")
    public static HiddenFrame hiddenFrame;

    @Url("/material-ui-layout-hidden--default-hidden")
    public static WebPage defaultHiddenPage;

    // box
    @Frame("storybook-preview-iframe")
    public static BoxFrame boxFrame;

    @Url("/material-ui-layout-box--default")
    public static WebPage defaultBoxPage;

    // container
    @Frame("storybook-preview-iframe")
    public static ContainerFrame containerFrame;

    @Url("/material-ui-layout-container--default")
    public static WebPage defaultContainerPage;

    // grid
    @Frame("storybook-preview-iframe")
    public static GridFrame gridFrame;

    @Url("/material-ui-layout-grid--grid-view")
    public static WebPage defaultGridPage;

    // login page
    @UI("#login-form")
    public static Form<User> loginForm;

    @Css(".logout")
    public static Button logout;
    public static Button userIcon;
    public static Text userName;

    public static class User extends DataClass<User> {
        public String name = "Roman";
        public String password = "Jdi1234";
    }
}
