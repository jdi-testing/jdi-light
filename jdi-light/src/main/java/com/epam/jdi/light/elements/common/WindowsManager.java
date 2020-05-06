package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getWebDriverFactory;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WindowsManager {
    private static Set<String> windowHandles;
    private static final MapArray<String, String> windowHandlesMap = new MapArray<>();
    private static boolean newWindow = false;
    private static final WebDriverFactory driverFactory = getWebDriverFactory();
    private static final WebDriver webDriver = driverFactory.getDriver();

    public static Set<String> getWindows() {
        Set<String> wHandles = webDriver.getWindowHandles();
        if (windowHandles != null && windowHandles.size() < wHandles.size())
            newWindow = true;
        return windowHandles = wHandles;
    }

    /**
     * Check the new window is opened
     * @return boolean
     */
    public static boolean newWindowIsOpened() {
        getWindows();
        if (newWindow) {
            newWindow = false;
            return true;
        }
        return false;
    }
    public static void checkNewWindowIsOpened() {
        boolean isNewWindow = newWindowIsOpened();
        if (!isNewWindow)
            throw exception("New window is not opened");
        switchToNewWindow();
    }
    public static void setWindowName(String value) {
        windowHandlesMap.update(value, webDriver.getWindowHandle());
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
        for (String window : getWindows()) {
            last = window;
        }
        if (!isBlank(last)) {
            webDriver.switchTo().window(last);
        } else {
            throw exception("No windows found");
        }
    }

    /**
     * Open new tab
     */
    @JDIAction("Open new tab")
    public static void openNewTab() {
        driverFactory.jsExecute("window.open()");
    }

    /**
     * Go back to original window
     */
    @JDIAction("Go back to original window")
    public static void originalWindow() {
        webDriver.switchTo().window(getWindows().iterator().next());
    }

    /**
     * Switch to the specified window
     * @param index
     */
    @JDIAction("Switch to window '{index}'")
    public static void switchToWindow(int index) {
        if (index < 1)
            throw exception("Window's index starts from 1. You try to use '%s' that less than 1.", index);
        int counter = 0;
        if (getWindows().size() < index)
            throw exception(index + " is too much. Only "+getWindows().size()+" windows found");
        for (String window : getWindows()) {
            counter++;
            if (counter == index) {
                webDriver.switchTo().window(window);
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
        if (!windowHandlesMap.has(value))
            throw exception("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", value);
        webDriver.switchTo().window(windowHandlesMap.get(value));
    }

    /**
     * Close current window
     */
    @JDIAction("Close current window")
    public static void closeWindow() {
        webDriver.close();
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
     * @param width - window width
     * @param height - window height
     */
    @JDIAction("Resize window '{0}'")
    public static void resizeWindow(int width, int height) {
        webDriver.manage().window().setSize(new Dimension(width, height));
    }
}
