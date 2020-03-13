package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.*;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.pages.MarvelousPage;

public class SiteJdi {
    @Url("/index.html") @Title("Home Page")
    public static WebPage homePage;
    @Url("/user-table.html") @Title("User Table")
    public static MarvelousPage marvelousPage;

    @UI("form") public static Form<User> loginForm;

    public static Icon userIcon;
    public static Text userName;
    @UI(".sidebar-menu span")
    public static Menu leftMenu;

}
