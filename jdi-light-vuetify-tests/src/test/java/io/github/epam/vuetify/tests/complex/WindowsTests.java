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
        reverseWindows.nextButton().click();
        reverseWindows.getActive().header().has().text("Slide 2");
        reverseWindows.previousButton().click();
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

    @Test(description = "Test checks if next/previous buttons are visible or hidden")
    public void customizedArrowsWindowsTest() {
        customizedArrowsWindows.show();
        customizedArrowsWindows.hover();
        customizedArrowsWindows.previousButton().is().hidden();
        customizedArrowsWindows.nextButton().is().visible();
    }

    @Test(description = "Test shows how to work with custom account creation windows")
    public void accountCreationWindowsTest() {
        accountCreationWindows.show();
        accountCreationWindows.previousButton().isDisabled();
        SignUpWindow signUpWindow = accountCreationWindows.getActive(SignUpWindow.class);
        signUpWindow.email().has().value("john@vuetifyjs.com");
        signUpWindow.email().has().hasLabel();
        signUpWindow.email().label().has().text("Email");
        signUpWindow.caption().has().text("This is the email you will use to login to your Vuetify account");
        accountCreationWindows.nextButton().click();

        PasswordCreationWindow passwordCreationWindow = accountCreationWindows.getActive(PasswordCreationWindow.class);
        passwordCreationWindow.password().has().hasLabel();
        passwordCreationWindow.password().label().has().text("Password");
        passwordCreationWindow.confirmPassword().has().hasLabel();
        passwordCreationWindow.confirmPassword().label().has().text("Confirm Password");
        passwordCreationWindow.caption().has().text("Please enter a password for your account");
        accountCreationWindows.nextButton().click();

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
        accountCreationWindows.nextButton().isDisabled();
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
