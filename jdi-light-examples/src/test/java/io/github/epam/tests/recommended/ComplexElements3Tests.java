package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.originalWindow;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.menu;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.StaticSite.metalAndColorsPageParams;
import static io.github.com.StaticSite.navigation;
import static io.github.com.StaticSite.navigationL;
import static io.github.com.StaticSite.navigationS;
import static io.github.com.pages.HomePage.githubLink;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.com.pages.MetalAndColorsPage.colors;
import static io.github.com.pages.MetalAndColorsPage.colorsXpath;
import static io.github.com.pages.MetalAndColorsPage.metals;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.ComplexTable;
import static io.github.epam.enums.Navigation.ContactForm;
import static io.github.epam.enums.Navigation.Home;
import static io.github.epam.enums.Navigation.Service;
import static io.github.epam.enums.NavigationNums.nContactForm;
import static io.github.epam.enums.NavigationNums.nHome;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;

public class ComplexElements3Tests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
    }

    @Test
    public void pageParamsTest() {
        metalAndColorsPageParams.open("?");
        metalAndColorsPageParams.shouldBeOpened("?");
        metalAndColorsPageParams.checkOpened();
    }
    @Test
    public void complexXpathTest() {
        colorsXpath.select(Green);
    }
    @Test
    public void complexTest() {
        colors.select(Green);
        metals.select(Gold);
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
    public void navigationMenuTest() {
        navigationL.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        navigationL.select(Home);
        homePage.checkOpened();
        navigationL.select(Service);
        navigationL.select(ComplexTable);
    }
    @Test
    public void navigationMenuTemplate() {
        navigationS.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        menu.select(Home);
        homePage.checkOpened();
        navigationL.select(3);
        menu.select(ComplexTable);
    }
}
