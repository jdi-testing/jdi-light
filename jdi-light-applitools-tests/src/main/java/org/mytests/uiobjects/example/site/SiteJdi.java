package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.ui.html.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
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
    @UI(".sidebar-menu li") public static Menu leftMenu;

}
