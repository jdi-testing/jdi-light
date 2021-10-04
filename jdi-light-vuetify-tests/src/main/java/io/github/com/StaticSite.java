package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.entities.User;
import io.github.com.pages.AlertsPage;
import io.github.com.pages.AvatarsPage;
import io.github.com.pages.BadgesPage;
import io.github.com.pages.BannersPage;
import io.github.com.pages.BottomNavigationPage;
import io.github.com.pages.BottomSheetsPage;
import io.github.com.pages.BreadcrumbsPage;
import io.github.com.pages.ButtonGroupsPage;
import io.github.com.pages.CardsPage;
import io.github.com.pages.CheckboxesPage;
import io.github.com.pages.DividersPage;
import io.github.com.pages.ExpansionPanelsPage;
import io.github.com.pages.FootersPage;
import io.github.com.pages.SubheaderPage;
import io.github.com.pages.TabsPage;

@JSite("https://jdi-testing.github.io/jdi-light/vuetify")
public class StaticSite {

    public static User DEFAULT_USER = new User();

    @UI("#login-form")
    public static Form<User> loginForm;

    @Css(".logout")
    public static Button logout;
    public static Button userIcon;
    public static Text userName;

    @Url("/alerts")
    public static AlertsPage alertsPage;

    @Url("/avatars")
    public static AvatarsPage avatarsPage;
  
     @Url("/badges")
    public static BadgesPage badgesPage;

    @Url("/banners")
    public static BannersPage bannersPage;

    @Url("/breadcrumbs")
    public static BreadcrumbsPage breadcrumbsPage;
  
    @WaitAfterAction(3)
    @Url("/checkboxes")
    public static CheckboxesPage checkboxesPage;

    @WaitAfterAction(3)
    @Url("/dividers")
    public static DividersPage dividersPage;

    @Url("/bottom-sheets")
    public static BottomSheetsPage bottomSheetsPage;

    @Url("/tabs")
    public static TabsPage tabsPage;
  
    @Url("/subheaders")
    public static SubheaderPage subheaderPage;

    @Url("/footers")
    public static FootersPage footersPage;

    @Url("/cards")
    public static CardsPage cardsPage;

    @Url("/expansion-panels")
    public static ExpansionPanelsPage expansionPanelsPage;

    @Url("/bottom-navigation")
    public static BottomNavigationPage bottomNavigationPage;

    @Url("/button-groups")
    public static ButtonGroupsPage buttonGroupsPage;
}
