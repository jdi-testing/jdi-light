package com.jdi.states;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import jdisite.entities.DefaultData;

import static jdisite.pages.HomePage.*;
import static jdisite.pages.JDISite.loginForm;

public class State {
    public static void loggedOut() {
        if (userName.isDisplayed()) {
            if (!logout.isDisplayed())
                userIcon.click();
            logout.click();
        }
    }
    public static void loggedIn() {
        if (!userName.isDisplayed()) {
            if (loginForm.isHidden())
                userIcon.click();
            loginForm.loginAs(DefaultData.ROMAN);
        }
    }
}
