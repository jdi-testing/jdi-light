package jdisite.pages;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.ui.html.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import jdisite.entities.User;

public class JDISite {
    public static HomePage homePage;
    public static ContactPage contactPage;
    public static Html5Page htmlPage;
    public static MarvelousPage marvelousPage;

    public static Form<User> loginForm;

    @UI(".sidebar-menu span") public static Menu leftMenu;
}
