package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.custom.MenuItem;
import org.mytests.uiobjects.example.site.pages.*;
import org.openqa.selenium.WebElement;

//@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    public static HomePage homePage;
    public static JDIPerformancePage performancePage;
    public static ContactFormPage contactFormPage;
    public static ContactsPage contactsPage;
    public static DatesPage datesPage;
    public static Html5Page html5Page;
    public static UsersPage usersPage;
    @Css("form") public static Form<User> loginForm;

    @Css(".profile-photo [ui=label]") public static UIElement userName;
    @Css(".fa-sign-out") public static WebElement logout;
    @Css("img#user-icon") public static UIElement userIcon;
    @UI(".sidebar-menu span") public static Menu leftMenu;
    @UI(".sidebar-menu li") public static JList<MenuItem> menu;

}
