package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.DataClass;
import io.github.com.pages.AngularPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {

    public static User DEFAULT_USER = new User();

    @Url("/angular.html")
    public static AngularPage angularPage;

    @UI("#login-form")
    public static Form<User> loginForm;

    @UI("#epam-logo")
    public static Button logo;

    @Css(".logout")
    public static Button logout;
    @UI("#user-icon")
    public static Button userIcon;
    @UI("#user-name")
    public static Text userName;

    public static class User extends DataClass<User> {
        public String name = "Roman";
        public String password = "Jdi1234";
    }
}
