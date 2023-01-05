package io.github.epam.vuetify.tests.complex;

import io.github.com.custom.windows.AccountCreatedWindow;
import io.github.com.custom.windows.PasswordCreationWindow;
import io.github.com.custom.windows.SignUpWindow;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.windowsPage;
import static io.github.com.enums.Colors.GREY;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.WindowsPage.accountCreationWindows;
import static io.github.com.pages.WindowsPage.customizedArrowsWindows;
import static io.github.com.pages.WindowsPage.onboardingWindows;
import static io.github.com.pages.WindowsPage.reverseWindows;
import static io.github.com.pages.WindowsPage.verticalButtonsWindows;
import static io.github.com.pages.WindowsPage.verticalWindows;
import static org.hamcrest.Matchers.containsString;

public class WindowsTests extends TestsInit {

    @BeforeClass
    public void before() {
        windowsPage.open();
        waitCondition(() -> windowsPage.isOpened());
        windowsPage.checkOpened();
    }

    @Test(description = "Test checks windows navigation")
    public void navigationWindowsTest() {
        reverseWindows.show();
        reverseWindows.navigation().get(1).click();
        reverseWindows.getActive().header().has().text("Slide 1");
        reverseWindows.nextActionsButton().click();
        reverseWindows.getActive().header().has().text("Slide 2");
        reverseWindows.previousActionsButton().click();
        reverseWindows.getActive().header().has().text("Slide 1");
    }

    @Test(description = "Test checks if windows show arrows on hover or not")
    public void verticalButtonsWindowsTest() {
        verticalButtonsWindows.show();
        verticalButtonsWindows.navigation().get(1).click();
        verticalButtonsWindows.getActive().title().has().text("Title 1");
        verticalButtonsWindows.navigation().get(2).click();
        verticalButtonsWindows.getActive().title().has().text("Title 2");
    }

    @Test(description = "Test checks windows color")
    public void colorWindowsTest() {
        reverseWindows.show();
        reverseWindows.getActive().header().has().css("color", WHITE.value());
        reverseWindows.getActive().sheet().has().css("background-color", GREY.value());
    }

    @Test(description = "Test checks if next/previous buttons exist or not")
    public void customizedArrowsWindowsTest() {
        customizedArrowsWindows.show();
        customizedArrowsWindows.has().noPreviousButton();
        customizedArrowsWindows.has().nextButton();
        customizedArrowsWindows.nextButton().click();
        customizedArrowsWindows.has().previousButton();
        customizedArrowsWindows.nextButton().click();
        customizedArrowsWindows.nextButton().click();
        customizedArrowsWindows.nextButton().click();
        customizedArrowsWindows.has().noNextButton();
    }

    @Test(description = "Test checks if next/previous actions buttons and navigation buttons exist or not")
    public void nextPreviousActionsButtonsAndNavigationButtonsWindowsTest() {
        reverseWindows.show();
        reverseWindows.has().previousActionsButton();
        reverseWindows.has().nextActionsButton();
        reverseWindows.has().navigationButtons();
        reverseWindows.has().navigationButtonsNumber(3);
        customizedArrowsWindows.show();
        customizedArrowsWindows.has().noPreviousActionsButton();
        customizedArrowsWindows.has().noNextActionsButton();
        customizedArrowsWindows.has().noNavigationButtons();
    }

    @Test(description = "Test shows how to work with custom account creation windows")
    public void accountCreationWindowsTest() {
        accountCreationWindows.show();
        accountCreationWindows.previousActionsButton().isDisabled();
        SignUpWindow signUpWindow = accountCreationWindows.getActive(SignUpWindow.class);
        signUpWindow.email().has().value("john@vuetifyjs.com");
        signUpWindow.email().has().hasLabel();
        signUpWindow.email().label().has().text("Email");
        signUpWindow.caption().has().text("This is the email you will use to login to your Vuetify account");
        accountCreationWindows.nextActionsButton().click();

        PasswordCreationWindow passwordCreationWindow = accountCreationWindows.getActive(PasswordCreationWindow.class);
        passwordCreationWindow.password().has().hasLabel();
        passwordCreationWindow.password().label().has().text("Password");
        passwordCreationWindow.confirmPassword().has().hasLabel();
        passwordCreationWindow.confirmPassword().label().has().text("Confirm Password");
        passwordCreationWindow.caption().has().text("Please enter a password for your account");
        accountCreationWindows.nextActionsButton().click();

        AccountCreatedWindow accountCreatedWindow = accountCreationWindows.getActive(AccountCreatedWindow.class);
        accountCreatedWindow.image().has().attr("style", "height: 128px;");
        waitCondition(() -> accountCreatedWindow.image()
                .find("div.v-image__image.v-image__image--contain").attr("syle")
                .contains("background-image: url(\"https://cdn.vuetifyjs.com/images/logos/v.svg\")"));
        accountCreatedWindow.image().find("div.v-image__image.v-image__image--contain")
                .has().attr("style", containsString("background-image: " +
                        "url(\"https://cdn.vuetifyjs.com/images/logos/v.svg\")"));
        accountCreatedWindow.welcome().has().text("Welcome to Vuetify");
        accountCreatedWindow.caption().has().text("Thanks for signing up!");
        accountCreationWindows.nextActionsButton().isDisabled();
    }

    @Test(description = "Test checks windows theme")
    public void reverseWindowsTest() {
        onboardingWindows.show();
        onboardingWindows.has().darkTheme();
        verticalWindows.show();
        verticalWindows.is().lightTheme();
    }

    @Test(description = "Test checks if windows show arrows on hover or not")
    public void showArrowsOnHoverWindowsTest() {
        verticalWindows.show();
        verticalWindows.is().showArrowsOnHover();
        customizedArrowsWindows.show();
        customizedArrowsWindows.is().notShowArrowsOnHover();
    }
}
