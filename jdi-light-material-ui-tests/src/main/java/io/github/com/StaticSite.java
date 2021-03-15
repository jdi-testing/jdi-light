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
import io.github.com.pages.datadisplay.ListsFrame;
import io.github.com.pages.inputs.EnhancedTransferListFrame;
import io.github.com.pages.inputs.SimpleTransferListFrame;
import io.github.com.pages.displaydata.BadgeFrame;
import io.github.com.pages.inputs.ButtonGroupFrame;
import io.github.com.pages.displaydata.TypographyFrame;
import io.github.com.pages.inputs.FabFrame;
import io.github.com.pages.displaydata.MaterialIconFrame;
import io.github.com.pages.displaydata.TooltipFrame;
import io.github.com.pages.displaydata.InsetDividerFrame;
import io.github.com.pages.displaydata.VerticalDividerFrame;
import io.github.com.pages.feedback.ConsecutiveSnackbarFrame;
import io.github.com.pages.feedback.SimpleSnackbarFrame;
import io.github.com.pages.feedback.BackdropFrame;
import io.github.com.pages.feedback.CircularProgressFrame;
import io.github.com.pages.feedback.LinearProgressFrame;
import io.github.com.pages.inputs.SelectFrame;
import io.github.com.pages.inputs.ButtonFrame;
import io.github.com.pages.inputs.GroupCheckBoxFrame;
import io.github.com.pages.inputs.CheckboxFrame;
import io.github.com.pages.inputs.SplitButtonGroupFrame;
import io.github.com.pages.inputs.SliderFrame;
import io.github.com.pages.inputs.SwitchFrame;
import io.github.com.pages.layouts.HiddenFrame;
import io.github.com.pages.navigation.LinkFrame;
import io.github.com.pages.inputs.TextFieldFrame;
import io.github.com.pages.navigation.StepperFrame;
import io.github.com.pages.surfaces.AccordionFrame;
import io.github.com.pages.utils.PopoverClickFrame;
import io.github.com.pages.utils.PopoverHoverFrame;
import io.github.com.pages.utils.TransitionFrame;
import io.github.com.pages.surfaces.PaperFrame;

@JSite("https://jdi-testing.github.io/jdi-light")
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


    // button
    @Frame("storybook-preview-iframe")
    public static ButtonFrame buttonFrame;

    @Url("/material-ui-inputs-button--default")
    public static WebPage inputButtonDefaultPage;

    @Url("/material-ui-inputs-button--disabled")
    public static WebPage inputButtonDisabledPage;

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

    // paper
    @Frame("storybook-preview-iframe")
    public static PaperFrame paperFrame;

    @Url("/material-ui-surfaces-paper--default")
    public static WebPage surfacePaperDefaultPage;

    // inputs
    // switch
    @Frame("storybook-preview-iframe")
    public static InsetDividerFrame insetDividerFrame;

    @Url("/material-ui-data-display-dividers--inset-dividers-view")
    public static WebPage dataDisplayInsetDividerPage;

    @Frame("storybook-preview-iframe")
    public static VerticalDividerFrame verticalDividerFrame;

    @Url("/material-ui-data-display-dividers--vertical-dividers-view")
    public static WebPage dataDisplayVerticalDividerPage;

    @Frame("storybook-preview-iframe")
    public static GroupCheckBoxFrame groupCheckBoxFrame;

    @Url("/material-ui-inputs-checkbox--group")
    public static WebPage groupCheckBoxPage;

    // Display data
    // material icon
    @Frame("storybook-preview-iframe")
    public static MaterialIconFrame materialIconFrame;

    @Url("/material-ui-data-display-material-icons--default")
    public static WebPage displayDataDefaultMaterialIconPage;

    @Url("/material-ui-data-display-material-icons--secondary")
    public static WebPage displayDataLargeMaterialIconPage;

    // typography
    @Frame("storybook-preview-iframe")
    public static TypographyFrame typographyFrame;

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

    // utils
    // transition
    @Frame("storybook-preview-iframe")
    public static TransitionFrame transitionFrame;

    @Url("/material-ui-utils-transitions--fade-transition")
    public static WebPage utilsTransitionFadePage;

    @Url("/material-ui-utils-transitions--collapse-transition")
    public static WebPage utilsTransitionCollapsePage;

    // utils
    // popover
    @Frame("storybook-preview-iframe")
    public static PopoverClickFrame popoverClickFrame;

    @Url("/material-ui-utils-popover--click")
    public static WebPage utilsPopoverClickPage;

    @Frame("storybook-preview-iframe")
    public static PopoverHoverFrame popoverHoverFrame;

    @Url("/material-ui-utils-popover--hover")
    public static WebPage utilsPopoverHoverPage;

    // navigation
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

    // layouts
    // hidden
    @Frame("storybook-preview-iframe")
    public static HiddenFrame hiddenFrame;

    @Url("/material-ui-layout-hidden--default-hidden")
    public static WebPage defaultHiddenPage;

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
