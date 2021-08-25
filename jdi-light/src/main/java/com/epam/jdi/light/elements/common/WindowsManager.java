package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.util.Set;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WindowsManager {
    private static Safe<Set<String>> windowHandles = new Safe<>();
    private static Safe<MapArray<String, String>> windowHandlesMap = new Safe<>(MapArray::new);
    private static Safe<Boolean> newWindow = new Safe<>(() -> false);

    public static Set<String> getWindows() {
        Set<String> wHandles = getDriver().getWindowHandles();
        if (windowHandles.get() != null && windowHandles.get().size() < wHandles.size()) {
            newWindow.set(true);
        }
        windowHandles.set(wHandles);
        return wHandles;
    }

    public static void openSiteTab(Class<?> site) {
        String name = site.isAnnotationPresent(Name.class)
            ? site.getAnnotation(Name.class).value()
            : site.getSimpleName();
        if (isEmpty(windowHandlesMap.get())) {
            setWindowName(name);
            return;
        }
        if (windowHandlesMap.get().has(name)) {
            switchToWindow(name);
        } else {
            openNewTab(name);
        }
    }

    /**
     * Check the new window is opened
     * @return boolean
     */
    public static boolean newWindowIsOpened() {
        getWindows();
        if (newWindow.get()) {
            newWindow.set(false);
            return true;
        }
        return false;
    }
    @JDIAction("Check that new window is opened")
    public static void checkNewWindowIsOpened() {
        boolean isNewWindow = newWindowIsOpened();
        if (!isNewWindow) {
            throw exception("New window is not opened");
        }
        switchToNewWindow();
    }
    public static void setWindowName(String value) {
        windowHandlesMap.get().update(value, getDriver().getWindowHandle());
    }

    public static List<String> registeredWindows() {
        return windowHandlesMap.get().keys();
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
            getDriver().switchTo().window(last);
        }
        else throw exception("No windows found");
    }

    /**
     * Open new tab
     */
    @JDIAction("Open new tab")
    public static void openNewTab() {
        jsExecute("window.open()");
        switchToNewWindow();
    }

    /**
     * Open new tab
     */
    @JDIAction("Open new tab '{0}'")
    public static void openNewTab(String name) {
        jsExecute("window.open()");
        switchToNewWindow();
        setWindowName(name);
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
     * @param index
     */
    @JDIAction("Switch to window '{index}'")
    public static void switchToWindow(int index) {
        if (index < ELEMENT.startIndex) {
            throw exception("Window's index starts from 1. You try to use '%s' that less than 1.", index);
        }
        int counter = 0;
        if (getWindows().size() < index - ELEMENT.startIndex + 1) {
            throw exception(index + " is too much. Only " + getWindows().size() + " windows found");
        }
        for (String window : getWindows()) {
            counter++;
            if (counter == index) {
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
        if (!windowHandlesMap.get().has(value)) {
            throw exception("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", value);
        }
        getDriver().switchTo().window(windowHandlesMap.get().get(value));
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
     * @param width - window width
     * @param height - window height
     */
    @JDIAction("Resize window '{0}'")
    public static void resizeWindow(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }
}
