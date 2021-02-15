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
import io.github.com.pages.inputs.ButtonGroupFrame;
import io.github.com.pages.inputs.ButtonFrame;
import io.github.com.pages.inputs.SplitButtonGroupFrame;
import io.github.com.pages.inputs.SwitchFrame;
import io.github.com.pages.surfaces.AccordionFrame;

//@JSite("https://jdi-testing.github.io/jdi-light/")
@JSite("http://100.64.56.255:6006/?path=/story/")
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

    // button group
    @Frame("storybook-preview-iframe")
    public static ButtonGroupFrame buttonGroupFrame;

    @Frame("storybook-preview-iframe")
    public static SplitButtonGroupFrame splitButtonGroupFrame;

    @Url("/material-ui-buttongroup--default")
    public static WebPage inputButtonGroupDefaultPage;

    @Url("/material-ui-buttongroup--disabled")
    public static WebPage inputButtonGroupDisabledPage;

    @Url("/material-ui-buttongroup--split-button")
    public static WebPage inputButtonGroupSplitPage;

    // surfaces
    // accordion
    @Frame("storybook-preview-iframe")
    public static AccordionFrame accordionFrame;

    @Url("/material-ui-surfaces-accordion--default")
    public static WebPage surfaceAccordionPage;

    @Url("/material-ui-surfaces-accordion--disabled")
    public static WebPage surfaceAccordionDisabledPage;

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
