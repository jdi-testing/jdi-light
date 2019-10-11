package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.Dimension;

import java.util.Set;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class WindowsManager {
    private static Set<String> windowHandlers;
    private static MapArray<String, String> windowHandles = new MapArray<>();

    public static Set<String> getWindows() {
        return windowHandlers = getDriver().getWindowHandles();
    }

    /**
     * Check the new window is opened
     * @return boolean
     */
    @JDIAction("Check that new window is opened")
    public static boolean newWindowIsOpened() {
        return windowHandlers.size() < getDriver().getWindowHandles().size();
    }
    public static void setWindowName(String value) {
        windowHandles.update(value, getDriver().getWindowHandle());
    }

    /**
     * Get windows count
     * @return int count
     */
    @JDIAction("Get windows count")
    public static int windowsCount() {
        return getWindows().size();
    }

    /**
     * Switch to new window
     */
    @JDIAction("Switch to new window")
    public static void switchToNewWindow() {
        String last = "";
        for (String window : getWindows())
            last = window;
        if (!isBlank(last))
            getDriver().switchTo().window(last);
        else throw exception("No windows found");
    }

    /**
     * Open new tab
     */
    @JDIAction("Open new tab")
    public static void openNewTab() {
        jsExecute("window.open()");
    }

    /**
     * Go back to original window
     */
    @JDIAction("Go back to original window")
    public static void originalWindow() {
        getDriver().switchTo().window(getWindows().iterator().next());
    }

    /**
     * Switch to the specified window
     * @param number
     */
    @JDIAction("Switch to window '{number}'")
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

    /**
     * Switch to the specified window
     * @param value
     */
    @JDIAction("Switch to window '{0}'")
    public static void switchToWindow(String value) {
        if (!windowHandles.has(value))
            throw exception("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", value);
        getDriver().switchTo().window(windowHandles.get(value));
    }

    /**
     * Close current window
     */
    @JDIAction("Close current window")
    public static void closeWindow() {
        getDriver().close();
        originalWindow();
    }

    /**
     * Close the specified window
     * @param value
     */
    @JDIAction("Close window '{0}'")
    public static void closeWindow(String value) {
        switchToWindow(value);
        closeWindow();
    }

    /**
     * Resize window according to specified width and height
     * @param width
     * @param height
     */
    @JDIAction("Resize window '{0}'")
    public static void resizeWindow(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        WebDriverFactory.getDriver().manage().window().setSize(dimension);
    }
}
