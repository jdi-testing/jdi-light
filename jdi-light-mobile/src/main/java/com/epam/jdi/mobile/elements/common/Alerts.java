package com.epam.jdi.mobile.elements.common;

import com.epam.jdi.mobile.common.JDIAction;
import org.hamcrest.Matcher;
import org.openqa.selenium.Alert;

import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Alerts {

    /**
     * Accept alert
     */
    @JDIAction
    public static void acceptAlert() {
        alert().accept();
    }

    /**
     * Dismiss alert
     */
    @JDIAction
    public static void dismissAlert() {
        alert().dismiss();
    }

    /**
     * Get alert text
     * @return String text
     */
    @JDIAction
    public static String getAlertText() {
        return alert().getText();
    }

    /**
     * Validate alert by matching passed value with alert text
     * @param text to compare
     */
    @JDIAction
    public static void validateAlert(Matcher<String> text) {
        assertThat(getAlertText(), text);
        acceptAlert();
    }

    /**
     * Input the specified text in the alert and accept it
     * @param text to compare
     */
    @JDIAction("Input '{0}' in alert and accept")
    public static void inputAndAcceptAlert(String text) {
        alert().sendKeys(text);
        alert().accept();
    }

    private static Alert alert() {
        return getDriver().switchTo().alert();
    }
}
