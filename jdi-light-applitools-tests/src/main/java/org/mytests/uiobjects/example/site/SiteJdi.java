package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.custom.MenuItem;
import org.mytests.uiobjects.example.site.pages.*;
import org.openqa.selenium.WebElement;

public class SiteJdi {
    @Url("/index.html")      @Title("Home Page")    public static WebPage homePage;
    @Url("/performance.html")                       public static WebPage performancePage;
    @Url("/contacts.html")   @Title("Contact Form") public static ContactFormPage contactFormPage;
    @Url("/contacts.html")   @Title("Contact Form") public static ContactsPage contactsPage;
    @Url("/dates.html")      @Title("Dates")        public static WebPage datesPage;
    @Url("/html5.html")      @Title("HTML 5")       public static WebPage html5Page;
    @Url("/user-table.html") @Title("User Table")   public static UsersPage usersPage;

    @UI("form") public static Form<User> loginForm;

    @UI(".profile-photo [ui=label]") public static UIElement userName;
    @UI(".fa-sign-out") public static WebElement logout;
    @UI("img#user-icon") public static UIElement userIcon;
    @UI(".sidebar-menu span") public static Menu leftMenu;
    @UI(".sidebar-menu li") public static JList<MenuItem> menu;

}
