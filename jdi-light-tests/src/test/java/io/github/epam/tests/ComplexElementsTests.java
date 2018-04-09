package io.github.epam.tests;

import io.github.epam.SimpleTestsInit;
import io.github.epam.enums.NavigationNums;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.enums.ColorsList.Green;
import static io.github.epam.enums.Metals.Gold;
import static io.github.epam.enums.Navigation.*;
import static io.github.epam.enums.NavigationNums.nComplexTable;
import static io.github.epam.enums.NavigationNums.nContactForm;
import static io.github.epam.enums.NavigationNums.nHome;
import static io.github.epam.enums.Vegetables.Onion;
import static io.github.epam.enums.Vegetables.Tomato;
import static io.github.epam.steps.Preconditions.loggedIn;

public class ComplexElementsTests extends SimpleTestsInit {

    @BeforeMethod
    public void before() {
        loggedIn();
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
