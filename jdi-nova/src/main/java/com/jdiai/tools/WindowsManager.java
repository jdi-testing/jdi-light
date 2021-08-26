package com.jdiai.tools;

import com.jdiai.annotations.Name;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.util.Set;

import static com.jdiai.JDI.driver;
import static com.jdiai.JDI.jsExecute;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 25.08.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class WindowsManager {
    private static Safe<Set<String>> windowHandles = new Safe<>();

    private static Safe<MapArray<String, String>> windowHandlesMap = new Safe<>(MapArray::new);

    private static Safe<Boolean> newWindow = new Safe<>(() -> false);

    public static Set<String> getWindows() {
        Set<String> wHandles = driver().getWindowHandles();
        if (windowHandles.get() != null &&
            windowHandles.get().size() < wHandles.size()) {
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
        boolean hasNewWindow = newWindow.get();
        if (hasNewWindow) {
            newWindow.set(false);
            return true;
        }
        return false;
    }
    public static void checkNewWindowIsOpened() {
        boolean isNewWindow = newWindowIsOpened();
        if (!isNewWindow) {
            throw new JDINovaException("New window is not opened");
        }
        switchToNewWindow();
    }

    public static void setWindowName(String value) {
        windowHandlesMap.get().update(value, driver().getWindowHandle());
    }

    public static List<String> registeredWindows() {
        return windowHandlesMap.get().keys();
    }

    /**
     * Get windows count
     * @return int count
     */
    public static int windowsCount() {
        return getWindows().size();
    }

    /**
     * Switch to new window
     */
    public static void switchToNewWindow() {
        String last = "";
        for (String window : getWindows()) {
            last = window;
        }
        if (!isBlank(last)) {
            driver().switchTo().window(last);
        }
        else throw new JDINovaException("No windows found");
    }

    /**
     * Open new tab
     */
    public static void openNewTab() {
        jsExecute("window.open()");
        switchToNewWindow();
    }


    /**
     * Open new tab
     */
    public static void openNewTab(String name) {
        jsExecute("window.open()");
        switchToNewWindow();
        setWindowName(name);
    }
    /**
     * Go back to original window
     */
    public static void originalWindow() {
        driver().switchTo().window(getWindows().iterator().next());
    }

    /**
     * Switch to the specified window
     * @param index
     */
    public static void switchToWindow(int index) {
        if (index < 0) {
            throw new JDINovaException("Window's index starts from 1. You try to use '%s' that less than 1.", index);
        }
        int counter = 0;
        if (getWindows().size() < index + 1) {
            throw new JDINovaException(index + " is too much. Only " + getWindows().size() + " windows found");
        }
        for (String window : getWindows()) {
            counter++;
            if (counter == index) {
                driver().switchTo().window(window);
                return;
            }
        }
    }

    /**
     * Switch to the specified window
     * @param value
     */
    public static void switchToWindow(String value) {
        if (!windowHandlesMap.get().has(value)) {
            throw new JDINovaException("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", value);
        }
        driver().switchTo().window(windowHandlesMap.get().get(value));
    }

    /**
     * Close current window
     */
    public static void closeWindow() {
        driver().close();
        originalWindow();
    }

    /**
     * Close the specified window
     * @param value
     */
    public static void closeWindow(String value) {
        switchToWindow(value);
        closeWindow();
    }
    /**
     * Resize window according to specified width and height
     * @param width - window width
     * @param height - window height
     */
    public static void resizeWindow(int width, int height) {
        driver().manage().window().setSize(new Dimension(width, height));
    }
}
