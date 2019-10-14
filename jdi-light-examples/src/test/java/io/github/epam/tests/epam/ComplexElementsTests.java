package io.github.epam.tests.epam;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.originalWindow;
import static io.github.epam.EpamGithubSite.contactFormPage;
import static io.github.epam.EpamGithubSite.homePage;
import static io.github.epam.EpamGithubSite.metalAndColorsPage;
import static io.github.epam.EpamGithubSite.navigation;
import static io.github.epam.EpamGithubSite.navigationL;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.ComplexTable;
import static io.github.epam.enums.Navigation.ContactForm;
import static io.github.epam.enums.Navigation.Home;
import static io.github.epam.enums.Navigation.Service;
import static io.github.epam.enums.NavigationNums.nContactForm;
import static io.github.epam.enums.NavigationNums.nHome;
import static io.github.epam.tests.epam.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;

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
    }
}
