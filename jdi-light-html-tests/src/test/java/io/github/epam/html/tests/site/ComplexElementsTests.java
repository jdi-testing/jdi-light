package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import io.github.epam.html.tests.site.steps.Preconditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.originalWindow;
import static io.github.com.StaticSite.*;
import static io.github.com.enums.ColorsList.Green;
import static io.github.com.enums.Metals.Gold;
import static io.github.com.enums.Navigation.*;
import static io.github.com.enums.NavigationNums.nContactForm;
import static io.github.com.enums.NavigationNums.nHome;
import static io.github.com.pages.HomePage.githubLink;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.com.pages.MetalAndColorsPage.colors;
import static io.github.com.pages.MetalAndColorsPage.metals;
import static org.hamcrest.Matchers.containsString;

public class ComplexElementsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        Preconditions.shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
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
        System.out.println(jdiText.getText());
        jdiText.is().text(containsString("QUIS NOSTRUD EXERCITATION"));
        githubLink.click();
        originalWindow();
    }
    @Test
    public void menuTest() {
        leftMenu.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        leftMenu.select(Home);
        homePage.checkOpened();
        leftMenu.select(Service, ComplexTable);
    }
    @Test
    public void navigationMenuTest() {
        navigationL.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        navigationL.select(Home);
        homePage.checkOpened();
        navigationS.select(Service);
        navigationS.select(ComplexTable);
    }
    @Test
    public void navigationMenuSTest() {
        navigationS.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        navigationS.select(Home);
        homePage.checkOpened();
        navigationS.select(Service);
        navigationS.select(ComplexTable);
    }
}
