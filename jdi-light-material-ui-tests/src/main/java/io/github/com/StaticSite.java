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
import io.github.com.pages.displaydata.AvatarFrame;
import io.github.com.pages.displaydata.BadgeFrame;
import io.github.com.pages.displaydata.ChipFrame;
import io.github.com.pages.displaydata.IconsFrame;
import io.github.com.pages.displaydata.InsetDividerFrame;
import io.github.com.pages.displaydata.ListsFrame;
import io.github.com.pages.displaydata.MaterialIconFrame;
import io.github.com.pages.displaydata.TableFrame;
import io.github.com.pages.displaydata.TooltipFrame;
import io.github.com.pages.displaydata.TypographyFrame;
import io.github.com.pages.displaydata.VerticalDividerFrame;
import io.github.com.pages.feedback.BackdropFrame;
import io.github.com.pages.feedback.CircularProgressFrame;
import io.github.com.pages.feedback.ConsecutiveSnackbarFrame;
import io.github.com.pages.feedback.DialogFrame;
import io.github.com.pages.feedback.LinearProgressFrame;
import io.github.com.pages.feedback.SimpleSnackbarFrame;
import io.github.com.pages.inputs.*;
import io.github.com.pages.layout.BoxFrame;
import io.github.com.pages.layout.ContainerFrame;
import io.github.com.pages.layout.HiddenFrame;
import io.github.com.pages.layout.GridFrame;
import io.github.com.pages.navigation.*;
import io.github.com.pages.surfaces.AccordionFrame;
import io.github.com.pages.surfaces.AppBarFrame;
import io.github.com.pages.surfaces.CardFrame;
import io.github.com.pages.surfaces.PaperFrame;
import io.github.com.pages.utils.ModalFrame;
import io.github.com.pages.utils.PopoverClickFrame;
import io.github.com.pages.utils.PopoverHoverFrame;
import io.github.com.pages.utils.PopperFrame;
import io.github.com.pages.utils.PortalPage;
import io.github.com.pages.utils.TransitionFrame;

@JSite("https://jdi-testing.github.io/jdi-light/material/")
public class StaticSite {

    // inputs
    // switch
    @Frame("storybook-preview-iframe")
    public static SwitchFrame switchFrame;

    @Url("/material-ui-inputs-switch--default")
    public static WebPage inputSwitchDefaultPage;

    @Url("/material-ui-inputs-switch--disabled")
    public static WebPage inputSwitchDisabledPage;

    @Url("/material-ui-inputs-switch--disabled-and-checked")
    public static WebPage inputSwitchDisabledAndCheckedPage;

    //date and time pickers
    @Frame("storybook-preview-iframe")
    public static DateTimePickersFrame dateTimePickersFrame;

    @Url("/material-ui-inputs-date-time--date-picker-inline")
    public static WebPage datePickerInlinePage;

    @Url("/material-ui-inputs-date-time--date-picker-dialog")
    public static WebPage datePickerDialogPage;

    @Url("/material-ui-inputs-date-time--time-picker")
    public static WebPage timePickerPage;

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
    @Frame("storybook-preview-iframe")
    public static CheckboxFrame checkboxFrame;

    @Url("/material-ui-inputs-checkbox--disabled")
    public static WebPage inputCheckboxDisabled;

    @Url("/material-ui-inputs-checkbox--primary")
    public static WebPage primaryCheckBoxPage;

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
    public static AccordionFrame accordionFrame;

    @Url("/material-ui-surfaces-accordion--default")
    public static WebPage surfaceAccordionPage;

    @Url("/material-ui-surfaces-accordion--disabled")
    public static WebPage surfaceAccordionDisabledPage;

    @Url("/material-ui-surfaces-app-bar--simple-app-bar")
    public static WebPage appBarPage;

    @Frame("storybook-preview-iframe")
    public static AppBarFrame appBarFrame;

    // paper
    @Frame("storybook-preview-iframe")
    public static PaperFrame paperFrame;

    @Url("/material-ui-surfaces-paper--default")
    public static WebPage surfacePaperDefaultPage;

    @Url("/material-ui-surfaces-app-bar--simple-app-bar")
    public static WebPage surfaceSimpleAppBarPage;

    // card
    @Frame("storybook-preview-iframe")
    public static CardFrame cardFrame;

    @Url("/material-ui-surfaces-card--card-with-clickable-area")
    public static WebPage surfaceCardPage;


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
    @Frame("storybook-preview-iframe")
    public static DialogFrame dialogFrame;

    @Url("/material-ui-feedback-dialog--dialog-alert")
    public static WebPage alertDialogPage;

    @Url("/material-ui-feedback-dialog--dialog-confirm")
    public static WebPage confirmDialogPage;

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
    @Frame("storybook-preview-iframe")
    public static IconsFrame iconsFrame;

    @Url("/material-ui-data-display-icons--simple-icons")
    public static WebPage simpleIconsPage;

    @Url("/material-ui-data-display-icons--color-icons")
    public static WebPage colorIconsPage;

    @Url("/material-ui-data-display-icons--size-icons")
    public static WebPage sizeIconsPage;

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
    public static BadgeFrame badgeFrame;

    @Url("/material-ui-data-display-badge--primary")
    public static WebPage dataDisplayBadgePrimaryPage;

    @Url("/material-ui-data-display-badge--dot")
    public static WebPage dataDisplayBadgeDotPage;

    @Url("/material-ui-data-display-badge--invisible")
    public static WebPage dataDisplayBadgeInvisiblePage;

    @Url("/material-ui-data-display-badge--alignment")
    public static WebPage dataDisplayBadgeAlignmentPage;

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
    public static BackdropFrame backdropFrame;

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
    public static SimpleSnackbarFrame simpleSnackbarFrame;

    @Frame("storybook-preview-iframe")
    public static ConsecutiveSnackbarFrame consecutiveSnackbarFrame;

    @Url("/material-ui-feedback-snackbar--simple-snackbar")
    public static WebPage feedbackSnackbarSimplePage;

    @Url("/material-ui-feedback-snackbar--consecutive-snackbars")
    public static WebPage feedbackSnackbarConsecutivePage;

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
    // transition
    @Frame("storybook-preview-iframe")
    public static TransitionFrame transitionFrame;

    @Url("/material-ui-utils-transitions--fade-transition")
    public static WebPage utilsTransitionFadePage;

    @Url("/material-ui-utils-transitions--collapse-transition")
    public static WebPage utilsTransitionCollapsePage;

    // popover
    @Frame("storybook-preview-iframe")
    public static PopoverClickFrame popoverClickFrame;

    @Url("/material-ui-utils-popover--click")
    public static WebPage utilsPopoverClickPage;

    @Frame("storybook-preview-iframe")
    public static PopoverHoverFrame popoverHoverFrame;

    @Url("/material-ui-utils-popover--hover")
    public static WebPage utilsPopoverHoverPage;

    // portal
    @Url("portal")
    public static PortalPage portalPage;

    @Url("/material-ui-utils-portal--default")
    public static WebPage defaultPortalPage;

    // navigation
    // breadcrumbs
    @Frame("storybook-preview-iframe")
    public static BreadcrumbsFrame breadcrumbsFrame;

    @Url("/material-ui-navigation-breadcrumbs--simple")
    public static WebPage simpleBreadcrumbsPage;

    @Url("/material-ui-navigation-breadcrumbs--custom-separator")
    public static WebPage customSeparatorBreadcrumbsPage;

    @Url("/material-ui-navigation-breadcrumbs--with-icons")
    public static WebPage withIconsBreadcrumbsPage;

    @Url("/material-ui-navigation-breadcrumbs--collapsed")
    public static WebPage collapsedBreadcrumbsPage;

    @Url("/material-ui-navigation-breadcrumbs--router-integration")
    public static WebPage routerIntegrationBreadcrumbsPage;

    @Url("/material-ui-navigation-breadcrumbs--customized")
    public static WebPage customizedBreadcrumbsPage;

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
    @Frame("storybook-preview-iframe")
    public static BottomNavigationFrame bottomNavigationFrame;

    @Url("/material-ui-navigation-bottom-navigation--default")
    public static WebPage bottomNavigationPage;

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
