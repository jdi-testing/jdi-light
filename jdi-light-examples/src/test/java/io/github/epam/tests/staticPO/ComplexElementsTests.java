package io.github.epam.tests.staticPO;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.originalWindow;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.*;
import static io.github.epam.enums.NavigationNums.*;
import static io.github.epam.tests.staticPO.steps.Preconditions.*;
import static org.hamcrest.Matchers.containsString;
import static staticPageObject.StaticSite.*;
import static staticPageObject.pages.HomePage.*;
import static staticPageObject.pages.MetalAndColorsPage.*;

public class ComplexElementsTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
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
    public void navigationMenuTest() {
        navigationL.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        navigationL.select(Home);
        homePage.checkOpened();
        navigationL.select(ComplexTable);
    }
    @Test
    public void navigationMenuSTest() {
        navigationS.select(ContactForm);
        //navigationL.select("Contact form");
        contactFormPage.checkOpened();
        navigationS.select(Home);
        homePage.checkOpened();
        navigationS.select(ComplexTable);
    }
}
