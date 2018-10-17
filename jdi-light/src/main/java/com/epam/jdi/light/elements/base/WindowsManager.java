package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.Alert;

import java.util.Set;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class WindowsManager {
    private static Set<String> windowHandlers;
    public static Set<String> getWindows() {
        return windowHandlers = getDriver().getWindowHandles();
    }
    public static boolean newWindowIsOpened() {
        return windowHandlers.size() < getDriver().getWindowHandles().size();
    }
    private static MapArray<String, String> windowHandles = new MapArray<>();
    public static void setWindowName(String name) {
        windowHandles.update(name, getDriver().getWindowHandle());
    }
    public static int windowsCount() {
        return getWindows().size();
    }

    @JDIAction
    public static void switchToNewWindow() {
        String last = "";
        for (String window : getWindows())
            last = window;
        if (!isBlank(last))
            getDriver().switchTo().window(last);
        else throw exception("No windows found");
    }
    @JDIAction
    public static void openNewTab() {
        jsExecute("window.open()");
    }

    @JDIAction
    public static void originalWindow() {
        getDriver().switchTo().window(getWindows().iterator().next());
    }

    @JDIAction
    public static void switchToWindow(int number) {
        int counter = 0;
        if (getWindows().size() < number)
            throw exception(number + " is to much. Only "+getWindows().size()+" windows found");
        for (String window : getWindows()) {
            counter++;
            if (counter == number) {
                getDriver().switchTo().window(window);
                return;
            }
        }
    }
    @JDIAction
    public static void switchToWindow(String name) {
        if (!windowHandles.has(name))
            throw exception("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", name);
        getDriver().switchTo().window(windowHandles.get(name));
    }
    @JDIAction
    public static void closeWindow() {
        getDriver().close();
        originalWindow();
    }
    @JDIAction
    public static void closeWindow(String name) {
        switchToWindow(name);
        closeWindow();
    }
    @JDIAction
    public static void acceptAlert() {
        alert().accept();
    }

    @JDIAction
    public static void declineAlert() {
        alert().dismiss();
    }

    @JDIAction
    public static String getAlertText() {
        return alert().getText();
    }

    @JDIAction
    public static void sendKeysInAlert(String text) {
        alert().sendKeys(text);
    }

    private static Alert alert() {
        return getDriver().switchTo().alert();
    }
}
