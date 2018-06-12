package io.github.epam.tests.epam;

import io.github.epam.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.*;
import static io.github.epam.enums.NavigationNums.*;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class ComplexElementsTests extends SimpleTestsInit {

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
        System.out.println("Set elements");
    }
    @Test
    public void navigationListTest() {
        navigation.get(nContactForm).click();
        contactFormPage.checkOpened();
        navigation.get(nHome).click();
        homePage.checkOpened();
        navigation.get(nComplexTable).click();
    }
    @Test
    public void navigationMenuTest() {
        navigationL.select(ContactForm);
        contactFormPage.checkOpened();
        navigationL.select(Home);
        homePage.checkOpened();
        navigationL.select(ComplexTable);
    }
}
