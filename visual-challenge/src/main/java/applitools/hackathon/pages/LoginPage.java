package applitools.hackathon.pages;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.mobile.asserts.core.SoftAssert;
import com.epam.jdi.mobile.elements.common.Label;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.*;

public class LoginPage extends WebPage {
    @UI(".auth-header") Label header;
    @UI(".logo-w img") Image circleImage;
    @UI(".alert-warning") public Text alert;
    @ByText("Username") Label userLabel;
    @ByText("Password") Label passwordLabel;
    @UI(".os-icon-user-male-circle") Icon userIcon;
    @UI(".os-icon-fingerprint") Icon fingerprintIcon;
    @UI(".form-check-label") Checkbox rememberMe;
    @UI("[src*=twitter]") Icon twitter;
    @UI("[src*=facebook]") Icon facebook;
    @UI("[src*=linkedin]") Icon linkedin;

    TextField username, password;
    Button logIn;

    public LoginPage validatateForm() {
        try {
            //header.is().displayed();
            //header.has().text("Login Form");
            //circleImage.is().displayed().fileName("logo-big.png");
            userIcon.is().displayed();
            //fingerprintIcon.is().displayed();
            //userLabel.is().text("Username");
            //passwordLabel.is().text("Password");
            //username.is().core().attr("placeholder", "Enter your username");
            //password.is().core().attr("placeholder", "Enter your password");
            //logIn.is().text("Log In");
            //rememberMe.is().core().text("Remember Me");
            //twitter.is().displayed().fileName("twitter.png");
            //facebook.is().displayed().fileName("facebook.png");
            //linkedin.is().displayed().fileName("linkedin.png");
            return this;
        } catch (Exception ex) {
            SoftAssert.assertResults();
            throw new RuntimeException(ex);
        }
    }
    public LoginPage validatateAlert(String message) {
        alert.has().text(message)
            .core().css("background-color", "rgba(252, 237, 190, 1)");
        return this;
    }
}
