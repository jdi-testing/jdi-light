package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import io.github.epam.html.tests.site.steps.States;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.originalWindow;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.leftMenu;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.StaticSite.navigation;
import static io.github.com.StaticSite.navigationL;
import static io.github.com.StaticSite.navigationS;
import static io.github.com.enums.ColorsList.Green;
import static io.github.com.enums.Metals.Gold;
import static io.github.com.enums.Metals.Silver;
import static io.github.com.enums.Navigation.ComplexTable;
import static io.github.com.enums.Navigation.ContactForm;
import static io.github.com.enums.Navigation.Home;
import static io.github.com.enums.Navigation.Service;
import static io.github.com.enums.NavigationNums.nContactForm;
import static io.github.com.enums.NavigationNums.nHome;
import static io.github.com.pages.HomePage.githubLink;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.com.pages.MetalAndColorsPage.colors;
import static io.github.com.pages.MetalAndColorsPage.metals;
import static io.github.com.pages.MetalAndColorsPage.metals2;
import static org.hamcrest.Matchers.containsString;

public class ComplexElementsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        States.shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
    }
    @Test
    public void complexTest() {
        colors.select(Green);
        metals.select(Gold);
        metals2.select(Silver);
        //metalAndColorsPage.vegetables.check(Onion, Tomato);
    }
    @Test
    public void navigationListTest() {
        navigation.get(nContactForm).click();
        contactFormPage.checkOpened();
        navigation.get(nHome).click();
        jdiText.is().text(containsString("QUIS NOSTRUD EXERCITATION"));
        githubLink.click();
        originalWindow();
    }
    @Test
    public void menuTest() {
        leftMenu.select(ContactForm);
        contactFormPage.checkOpened();
        leftMenu.select(Home);
        homePage.checkOpened();
        leftMenu.select(Service, ComplexTable);
    }
    @Test
    public void navigationMenuTest() {
        navigationL.select(ContactForm);
        contactFormPage.checkOpened();
        navigationL.select(Home);
        homePage.checkOpened();
        navigationS.select(Service);
        navigationS.select(ComplexTable);
    }
    @Test
    public void navigationMenuSTest() {
        navigationS.select(ContactForm);
        contactFormPage.checkOpened();
        navigationS.select(Home);
        homePage.checkOpened();
        navigationS.select(Service);
        navigationS.select(ComplexTable);
    }
}
