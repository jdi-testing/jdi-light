package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.custom.windows.AccountCreatedWindow;
import io.github.com.custom.windows.PasswordCreationWindow;
import io.github.com.custom.windows.SignUpWindow;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.*;
import static io.github.com.StaticSite.windowsPage;
import static io.github.com.pages.WindowsPage.*;

public class WindowsTests extends TestsInit {

    @BeforeClass
    public void before() {
        windowsPage.open();
        windowsPage.checkOpened();
    }

    @Test
    public void reverseWindowsTest() {
        int i = 1;
        for (UIElement nav : reverseNavigation) {
            nav.click();
            reverseWindows.getActive().header().has().text("Slide " + i);
            reverseWindows.getActive().header().has().css("color", WHITE.value());
            reverseWindows.getActive().sheet().has().css("background-color", GREY.value());
            i++;
        }
        for (i = 3; i >= 1; i--) {
            reverseWindows.getActive().header().has().text("Slide " + i);
            reverseWindows.getActive().header().has().css("color", WHITE.value());
            reverseWindows.getActive().sheet().has().css("background-color", GREY.value());
            reverseBack.click();
        }
    }

    @Test
    public void verticalWindowsTest() {
        int i = 1;
        for (UIElement nav : verticalNavigation) {
            nav.click();
            verticalWindows.getActive().header().has().text("Slide " + i);
            verticalWindows.getActive().header().has().css("color", WHITE.value());
            verticalWindows.getActive().sheet().has().css("background-color", GREY.value());
            i++;
        }
        verticalNext.click();
        verticalWindows.getActive().header().has().text("Slide 1");
        verticalBack.click();
        verticalWindows.getActive().header().has().text("Slide 3");
    }

    @Test
    public void customizedArrowsWindowsTest() {
        customizedArrowsWindows.hover();
        previousSlide.is().hidden();
        nextSlide.is().visible();
        customizedArrowsWindows.getActive().header().has().text("Slide 1");
        customizedArrowsWindows.getActive().header().has().css("color", WHITE.value());
        customizedArrowsWindows.getActive().sheet().has().css("background-color", GREY.value());

        int i;
        for (i = 2; i <= 5; i++) {
            nextSlide.click();
            customizedArrowsWindows.getActive().header().has().text("Slide " + i);
            customizedArrowsWindows.getActive().header().has().css("color", WHITE.value());
            customizedArrowsWindows.getActive().sheet().has().css("background-color", GREY.value());
        }
        nextSlide.is().hidden();
    }

    @Test
    public void accountCreationWindowsTest() {
        SignUpWindow signUpWindow = accountCreationWindows.getActive(SignUpWindow.class);
        signUpWindow.email().has().value("john@vuetifyjs.com");
        signUpWindow.email().label().has().text("Email");
        signUpWindow.caption().has().text("This is the email you will use to login to your Vuetify account");
        accountNext.click();

        PasswordCreationWindow passwordCreationWindow = accountCreationWindows.getActive(PasswordCreationWindow.class);
        passwordCreationWindow.password().label().has().text("Password");
        passwordCreationWindow.confirmPassword().label().has().text("Confirm Password");
        passwordCreationWindow.caption().has().text("Please enter a password for your account");
        accountNext.click();

        AccountCreatedWindow accountCreatedWindow = accountCreationWindows.getActive(AccountCreatedWindow.class);
        System.out.println(accountCreatedWindow.image().height());
        accountCreatedWindow.welcome().has().text("Welcome to Vuetify");
        accountCreatedWindow.caption().has().text("Thanks for signing up!");


    }


}
