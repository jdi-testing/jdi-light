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
        reverseWindows.activeItem().header().has().text("Slide 1");
    }

    @Test(description = "Test checks if windows show arrows on hover or not")
    public void verticalButtonsWindowsTest() {
        verticalButtonsWindows.show();
        verticalButtonsWindows.activeItem().title().has().text("Title 1");
    }

    @Test(description = "Test checks windows color")
    public void colorWindowsTest() {
        reverseWindows.show();
        reverseWindows.activeItem().header().has().css("color", WHITE.value());
        reverseWindows.activeItem().sheet().has().css("background-color", GREY.value());
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

    @Test(enabled = false, description = "Test checks if next/previous actions buttons and navigation buttons exist or not")
    public void nextPreviousActionsButtonsAndNavigationButtonsWindowsTest() {
        reverseWindows.show();
    }

    @Test(description = "Test shows how to work with custom account creation windows")
    public void accountCreationWindowsTest() {
        accountCreationWindows.show();
        accountCreationWindows.previousActionsButton().isDisabled();
        SignUpWindow signUpWindow = accountCreationWindows.slider.activeItem(SignUpWindow.class);
        signUpWindow.email().has().value("john@vuetifyjs.com");
        signUpWindow.email().label().has().text("Email");
        signUpWindow.caption().has().text("This is the email you will use to login to your Vuetify account");
        accountCreationWindows.nextActionsButton().click();

        PasswordCreationWindow passwordCreationWindow = accountCreationWindows.slider.activeItem(PasswordCreationWindow.class);
        passwordCreationWindow.password().label().has().text("Password");
        passwordCreationWindow.confirmPassword().label().has().text("Confirm Password");
        passwordCreationWindow.caption().has().text("Please enter a password for your account");
        accountCreationWindows.nextActionsButton().click();

        AccountCreatedWindow accountCreatedWindow = accountCreationWindows.slider.activeItem(AccountCreatedWindow.class);
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
