package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.com.pages.displaydata.AvatarPage;
import io.github.com.pages.displaydata.BadgePage;
import io.github.com.pages.displaydata.ChipsPage;
import io.github.com.pages.displaydata.InsetDividerPage;
import io.github.com.pages.displaydata.VerticalDividerPage;
import io.github.com.pages.displaydata.IconsPage;
import io.github.com.pages.displaydata.ListPage;
import io.github.com.pages.displaydata.MaterialIconPage;
import io.github.com.pages.displaydata.TablePage;
import io.github.com.pages.displaydata.TooltipPage;
import io.github.com.pages.displaydata.TypographyPage;
import io.github.com.pages.feedback.BackdropPage;
import io.github.com.pages.feedback.DialogPage;
import io.github.com.pages.feedback.ProgressPage;
import io.github.com.pages.feedback.SnackbarPage;
import io.github.com.pages.inputs.ButtonGroupPage;
import io.github.com.pages.inputs.ButtonPage;
import io.github.com.pages.inputs.CheckboxPage;
import io.github.com.pages.inputs.DateTimePickersPage;
import io.github.com.pages.inputs.EnhancedTransferListPage;
import io.github.com.pages.inputs.FloatingActionButtonPage;
import io.github.com.pages.inputs.RadioButtonPage;
import io.github.com.pages.inputs.SelectPage;
import io.github.com.pages.inputs.SimpleTransferListPage;
import io.github.com.pages.inputs.SlidersPage;
import io.github.com.pages.inputs.SwitchPage;
import io.github.com.pages.inputs.TextFieldPage;
import io.github.com.pages.layout.BoxPage;
import io.github.com.pages.layout.ContainerPage;
import io.github.com.pages.layout.GridPage;
import io.github.com.pages.layout.HiddenPage;
import io.github.com.pages.navigation.BottomNavigationPage;
import io.github.com.pages.navigation.ClippedDrawerPage;
import io.github.com.pages.navigation.ContextMenuPage;
import io.github.com.pages.navigation.LinkPage;
import io.github.com.pages.navigation.MiniDrawerPage;
import io.github.com.pages.navigation.PermanentDrawerPage;
import io.github.com.pages.navigation.PersistentDrawerPage;
import io.github.com.pages.navigation.ResponsiveDrawerPage;
import io.github.com.pages.navigation.RouterBreadcrumbsPage;
import io.github.com.pages.navigation.SimpleBreadcrumbsPage;
import io.github.com.pages.navigation.SimpleMenuPage;
import io.github.com.pages.navigation.StepperPage;
import io.github.com.pages.navigation.SwipeableDrawerPage;
import io.github.com.pages.navigation.TabPage;
import io.github.com.pages.navigation.TemporaryDrawerPage;
import io.github.com.pages.surfaces.AccordionPage;
import io.github.com.pages.surfaces.AppBarPage;
import io.github.com.pages.surfaces.BackToTopPage;
import io.github.com.pages.surfaces.BottomAppBarPage;
import io.github.com.pages.surfaces.CardPage;
import io.github.com.pages.surfaces.ElevateAppBar;
import io.github.com.pages.surfaces.HideAppBarPage;
import io.github.com.pages.surfaces.PaperPage;
import io.github.com.pages.utils.ClickAwayListenerPage;
import io.github.com.pages.utils.ModalPage;
import io.github.com.pages.utils.PopoverPage;
import io.github.com.pages.utils.PopperPage;
import io.github.com.pages.utils.PortalPage;
import io.github.com.pages.utils.TextAreaAutoSizePage;
import io.github.com.pages.utils.TransitionPage;
import io.github.com.pages.utils.UseMediaQueryPage;

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


    // selects
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
    // dividers
    @Url("/inset_divider")
    public static InsetDividerPage insetDividerPage;

    @Url("/vertical_divider")
    public static VerticalDividerPage verticalDividerPage;

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

    // portal
    @Url("/portal")
    public static PortalPage portalPage;

    // navigation
    // breadcrumbs

    @Url("/simple_breadcrumbs")
    public static SimpleBreadcrumbsPage simpleBreadcrumbsPage;

    @Url("/router_breadcrumbs")
    public static RouterBreadcrumbsPage routerBreadcrumbsPage;


    // drawer
    @Url("/temporary_drawer")
    public static TemporaryDrawerPage temporaryDrawerPage;

    @Url("/swipeable_drawer")
    public static SwipeableDrawerPage swipeableDrawerPage;

    @Url("/responsive_drawer")
    public static ResponsiveDrawerPage responsiveDrawerPage;

    @Url("/persistent_drawer")
    public static PersistentDrawerPage persistentDrawerPage;

    @Url("/mini_drawer")
    public static MiniDrawerPage miniDrawerPage;

    @Url("/permanent_drawer")
    public static PermanentDrawerPage permanentDrawerPage;

    @Url("/clipped_drawer")
    public static ClippedDrawerPage clippedDrawerPage;

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
}
