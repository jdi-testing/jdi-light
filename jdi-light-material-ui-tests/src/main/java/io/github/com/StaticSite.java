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
import io.github.com.pages.feedback.BackdropPage;
import io.github.com.pages.feedback.DialogPage;
import io.github.com.pages.feedback.ProgressPage;
import io.github.com.pages.feedback.SnackbarPage;
import io.github.com.pages.inputs.*;
import io.github.com.pages.layout.BoxPage;
import io.github.com.pages.layout.ContainerPage;
import io.github.com.pages.layout.GridPage;
import io.github.com.pages.layout.HiddenPage;
import io.github.com.pages.navigation.*;
import io.github.com.pages.surfaces.*;
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
    @Url("/simple_transfer_list")
    public static SimpleTransferListPage simpleTransferListPage;

    //enhanced transfer list
    @Url("/enhanced_transfer_list")
    public static EnhancedTransferListPage enhancedTransferListPage;

    @Url("/buttons")
    public static ButtonPage buttonPage;

    // radio
    @Url("/radio")
    public static RadioButtonPage radioButtonPage;

    // floating action button
    @Url("/floating_action_button")
    public static FloatingActionButtonPage floatingActionButtonPage;

    // text field
    @Url("/text_field")
    public static TextFieldPage textFieldPage;

    @Url("/textarea_autosize")
    public static TextAreaAutoSizePage textAreaAutoSizePage;

    //checkbox
    @Url("/checkboxes")
    public static CheckboxPage checkboxPage;

    // button group
    @Url("/button_groups")
    public static ButtonGroupPage buttonGroupPage;

    @Url("/material-ui-inputs-button-group--default")
    public static WebPage inputButtonGroupDefaultPage;

    @Url("/material-ui-inputs-button-group--disabled")
    public static WebPage inputButtonGroupDisabledPage;

    @Url("/button_groups")
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
    public static BottomAppBarPage bottomAppBarPage;

    @Url("/appbar_scroll_hide")
    public static HideAppBarPage hideAppBarPage;

    @Url("/appbar_elevate")
    public static ElevateAppBar elevateAppBarPage;

    @Url("/appbar_back_to_top")
    public static BackToTopPage backToTopPage;

    // paper
    @Url("/paper_surface")
    public static PaperPage paperPage;

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

    // Display data
    //icons
    @Url("/icons")
    public static IconsPage iconsPage;

    // material icon
    @Url("/material_icons")
    public static MaterialIconPage materialIconPage;

    @Url("/modal")
    public static ModalPage modalPage;

    // utils
    // popper
    @Url("/popper")
    public static PopperPage popperPage;

    // typography
    @Url("/typography")
    public static TypographyPage typographyPage;

    // badge
    @Url("/badge")
    public static BadgePage badgePage;

    // tooltip
    @Url("/tooltip")
    public static TooltipPage tooltipPage;

    // table
    @Url("simple_table")
    public static TablePage tablePage;

    // chip
    @Url("/chips")
    public static ChipsPage chipsPage;

    // lists

    @Url("/simple_list")
    public static ListPage ListPage;

    // feedback
    // backdrop
    @Url("/backdrop")
    public static BackdropPage backdropPage;

    @Url("/material-ui-feedback-backdrop--default-backdrop")
    public static WebPage feedbackBackdropDefaultPage;

    // circular
    @Url("/progress")
    public static ProgressPage progressPage;

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

    // useMediaQuery
    @Url("/use_media_query")
    public static UseMediaQueryPage useMediaQueryPage;

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

    @Url("/simple_breadcrumbs")
    public static SimpleBreadcrumbsPage simpleBreadcrumbsPage;

    @Url("/router_breadcrumbs")
    public static RouterBreadcrumbsPage routerBreadcrumbsPage;


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
    public static SimpleMenuPage simpleMenuPage;

    @Url("/context_menu")
    public static ContextMenuPage contextMenuPage;

    // layouts
    // hidden
    @Url("/hidden_layout")
    public static HiddenPage hiddenPage;

    // box
    @Url("/box_layout")
    public static BoxPage boxPage;

    // container
    @Url("/container_layout")
    public static ContainerPage containerPage;

    // grid
    @Url("grid_layout")
    public static GridPage gridPage;

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
