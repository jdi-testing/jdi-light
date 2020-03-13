package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import io.github.epam.html.tests.site.steps.States;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.common.WindowsManager.*;
import static io.github.com.StaticSite.*;
import static io.github.com.enums.ColorsList.*;
import static io.github.com.enums.Metals.*;
import static io.github.com.enums.Navigation.*;
import static io.github.com.enums.NavigationNums.*;
import static io.github.com.pages.HomePage.*;
import static io.github.com.pages.MetalAndColorsPage.*;
import static org.hamcrest.Matchers.*;

public class ComplexElementsTests implements TestsInit {

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
        navigationElement.select(ContactForm);
        contactFormPage.checkOpened();
        navigationL.select(Home);
        homePage.checkOpened();
        navigationS.select(Service);
        navigationElement.select("Complex Table");
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
