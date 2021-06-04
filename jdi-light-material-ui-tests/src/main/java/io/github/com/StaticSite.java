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
import io.github.com.pages.layout.BoxPage;
import io.github.com.pages.layout.ContainerPage;
import io.github.com.pages.layout.GridPage;
import io.github.com.pages.layout.HiddenPage;
import io.github.com.pages.navigation.*;
import io.github.com.pages.surfaces.AccordionPage;
import io.github.com.pages.surfaces.AppBarPage;
import io.github.com.pages.surfaces.CardPage;
import io.github.com.pages.surfaces.PaperPage;
import io.github.com.pages.utils.*;

@JSite("https://jdi-testing.github.io/jdi-light/material/")
public class StaticSite {

    // inputs
    // switch
    @Url("/basic_switches")
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

    @Url("/buttons")
    public static ButtonPage buttonPage;

    // radio
    @Url("/radio")
    public static RadioButtonPage radioButtonPage;

    // floating action button
    @Url("/floating_action_button")
    public static FabPage fabPage;

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

    @Url("/selects")
    public static SelectPage selectPage;

    //slider
    @Url("/sliders")
    public static SlidersPage slidersPage;


    // surfaces
    // accordion
    @Url("/accordion_surface")
    public static AccordionPage accordionPage;

    // appbar

    @Url("/appbar_surface")
    public static AppBarPage simpleAppBarPage;

    @Url("/appbar_bottom")
    public static WebPage bottomAppBarPage;

    @Url("/appbar_scroll_hide")
    public static WebPage hideAppBarPage;

    @Url("/appbar_elevate")
    public static WebPage elevateAppBarPage;

    @Url("/appbar_back_to_top")
    public static WebPage backToTopPage;

    // paper
    @Url("/paper_surface")
    public static PaperPage paperPage;

    @Url("/material-ui-surfaces-app-bar--simple-app-bar")
    public static WebPage surfaceSimpleAppBarPage;

    @Url("/card_surface")
    public static CardPage cardPage;

    // data display
    // divider
    @Url("/inset_divider")
    public static DividersPage insetDividersPage;

    @Url("/vertical_divider")
    public static DividersPage verticalDividerPage;

    // feedback
    // dialog
    @Url("/dialog")
    public static DialogPage dialogPage;

    @Url("/avatar")
    public static AvatarPage avatarPage;

    public static GroupCheckBoxFrame groupCheckBoxFrame;

    @Url("/material-ui-inputs-checkbox--group")
    public static WebPage groupCheckBoxPage;

    // Display data
    //icons
    @Url("/icons")
    public static IconsPage iconsPage;

    // material icon
    @Url("/material_icons")
    public static MaterialIconPage materialIconPage;

    @Frame("storybook-preview-iframe")
    public static ModalFrame modalFrame;

    @Url("/material-ui-utils-modal--transitions-modal")
    public static WebPage transitionsModalPage;

    @Url("/material-ui-utils-modal--server-modal")
    public static WebPage serverSideModalPage;

    // typography
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

    @Url("/typography")
    public static TypographyPage typographyPage;

    // badge
    @Url("/badge")
    public static BadgePage badgePage;

    // tooltip
    @Frame("storybook-preview-iframe")
    public static TooltipFrame tooltipFrame;

    @Url("/material-ui-data-display-tooltip--default")
    public static WebPage displayDataTooltipDefaultPage;

    @Url("/material-ui-data-display-tooltip--interactive")
    public static WebPage displayDataTooltipInteractivePage;

    // table
    @Url("simple_table")
    public static TablePage tablePage;

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
    @Url("/backdrop")
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
    @Url("/snackbar")
    public static SnackbarPage snackbarPage;

    // navigation
    // tabs

    @Url("/tabs")
    public static TabPage tabPage;

    // utils
    // Click away listener
    @Url("/click_away_listener")
    public static ClickAwayListenerPage clickAwayListenerPage;

    // transition
    @Url("/transitions")
    public static TransitionPage transitionPage;

    // popover
    @Url("/popover")
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
    @Url("/temporary_drawer")
    public static DrawerPage temporaryDrawerPage;

    @Url("/swipeable_drawer")
    public static DrawerPage swipeableDrawerPage;

    @Url("/responsive_drawer")
    public static DrawerPage responsiveDrawerPage;

    @Url("/persistent_drawer")
    public static DrawerPage persistentDrawerPage;

    @Url("/mini_drawer")
    public static DrawerPage miniDrawerPage;

    @Url("/permanent_drawer")
    public static DrawerPage permanentDrawerPage;

    @Url("/clipped_drawer")
    public static DrawerPage clippedDrawerPage;

    // stepper

    @Url("/steppers")
    public static StepperPage stepperPage;


    // links
    @Url("/link")
    public static LinkPage linkPage;

    // bottom navigation
   @Url("/button_navigation")
   public static BottomNavigationPage bottomNavigationPage;

    // menu
    @Url("/simple_menu")
    public static WebPage simpleMenuPage;

    @Url("/context_menu")
    public static WebPage contextMenuPage;

    // layouts
    // hidden
    @Url("/hidden_layout")
    public static HiddenPage hiddenPage;

    @Url("/material-ui-layout-hidden--default-hidden")
    public static WebPage defaultHiddenPage;

    // box
    @Url("/box_layout")
    public static BoxPage boxPage;

    // container
    @Url("/container_layout")
    public static ContainerPage containerPage;

    @Url("/material-ui-layout-container--default")
    public static WebPage defaultContainerPage;

    // grid
    @Url("grid_layout")
    public static GridPage gridPage;

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
