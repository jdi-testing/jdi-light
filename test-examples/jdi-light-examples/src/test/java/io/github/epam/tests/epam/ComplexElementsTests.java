package io.github.epam.tests.epam;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.common.WindowsManager.*;
import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.enums.ColorsList.*;
import static io.github.epam.enums.Metals.*;
import static io.github.epam.enums.Navigation.*;
import static io.github.epam.enums.NavigationNums.*;
import static io.github.epam.tests.epam.steps.Preconditions.*;
import static org.hamcrest.Matchers.*;

public class ComplexElementsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
    }
    @Test
    public void complexTest() {
        metalAndColorsPage.colors.select(Green);
        metalAndColorsPage.metals.select(Gold);
        //metalAndColorsPage.vegetables.check(Onion, Tomato);
    }
    @Test
    public void navigationListTest() {
        navigation.get(nContactForm).click();
        contactFormPage.checkOpened();
        navigation.get(nHome).click();
        homePage.jdiText.is().text(containsString("QUIS NOSTRUD EXERCITATION"));
        homePage.githubLink.click();
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
        complextablePage.checkOpened();
    }
}
