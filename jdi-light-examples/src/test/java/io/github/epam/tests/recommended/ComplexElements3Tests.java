package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.originalWindow;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.HomePage.githubLink;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.com.pages.MetalAndColorsPage.colors;
import static io.github.com.pages.MetalAndColorsPage.metals;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.*;
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
