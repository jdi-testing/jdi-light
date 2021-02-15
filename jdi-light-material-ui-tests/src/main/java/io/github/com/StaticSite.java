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
import io.github.com.pages.displaydata.InsetDividerFrame;
import io.github.com.pages.displaydata.VerticalDividerFrame;
import io.github.com.pages.inputs.ButtonFrame;
import io.github.com.pages.inputs.SwitchFrame;
import io.github.com.pages.layouts.BoxFrame;
import io.github.com.pages.surfaces.AccordionFrame;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {

    // inputs
    // switch
    @Frame("storybook-preview-iframe")
    public static SwitchFrame switchFrame;

    @Url("/material-ui-switch--default")
    public static WebPage inputSwitchDefaultPage;

    @Url("/material-ui-switch--disabled")
    public static WebPage inputSwitchDisabledPage;

    @Url("/material-ui-switch--disabled-and-checked")
    public static WebPage inputSwitchDisabledAndCheckedPage;

    // button
    @Frame("storybook-preview-iframe")
    public static ButtonFrame buttonFrame;

    @Url("/material-ui-button--default")
    public static WebPage inputButtonDefaultPage;

    @Url("/material-ui-button--disabled")
    public static WebPage inputButtonDisabledPage;

    // surfaces
    // accordion
    @Frame("storybook-preview-iframe")
    public static AccordionFrame accordionFrame;

    @Url("/material-ui-surfaces-accordion--default")
    public static WebPage surfaceAccordionPage;

    @Url("/material-ui-surfaces-accordion--disabled")
    public static WebPage surfaceAccordionDisabledPage;

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

    // layouts
    //box
    @Frame("storybook-preview-iframe")
    public static BoxFrame boxFrame;

    @Url("/material-ui-box--default")
    public static WebPage defaultBoxPage;

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
