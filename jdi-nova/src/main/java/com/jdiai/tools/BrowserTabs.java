package com.jdiai.tools;

import com.jdiai.JDI;
import com.jdiai.annotations.Name;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.util.Set;

import static com.jdiai.JDI.driver;
import static com.jdiai.JDI.jsExecute;
import static com.jdiai.asserts.ShouldUtils.waitForResult;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 25.08.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class BrowserTabs {
    private static Safe<Set<String>> windowHandles = new Safe<>();

    private static Safe<MapArray<String, String>> windowHandlesMap = new Safe<>(MapArray::new);

    private static Safe<Boolean> newWindow = new Safe<>(() -> false);

    public static Set<String> getWindowHandles() {
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
            setTabName(name);
            return;
        }
        if (windowHandlesMap.get().has(name)) {
            switchToTab(name);
        } else {
            openNewTab(name);
        }
    }

    /**
     * Check the new window is opened
     * @return boolean
     */
    public static boolean newTabIsOpened(String url) {
        boolean newTabIsOpened = newTabIsOpened();
        JDI.urlShouldBe(url);
        return newTabIsOpened;
    }

    public static boolean newTabIsOpened() {
        getWindowHandles();
        boolean hasNewWindow = newWindow.get();
        if (hasNewWindow) {
            newWindow.set(false);
            return true;
        }
        return false;
    }

    public static void checkNewTabIsOpenedAndSwitch(String url) {
        boolean isNewWindow = newTabIsOpened(url);
        if (!isNewWindow) {
            throw new JDINovaException("New window is not opened");
        }
        switchToNewTab();
    }
    public static void checkNewTabIsOpenedAndSwitch() {
        boolean isNewWindow = newTabIsOpened();
        if (!isNewWindow) {
            throw new JDINovaException("New window is not opened");
        }
        switchToNewTab();
    }

    public static void setTabName(String value) {
        windowHandlesMap.get().update(value, driver().getWindowHandle());
    }

    public static void setTabNameNewPage() {
        String title = waitForResult(JDI::getTitle, t -> !t.equals("Index"));
        if (browserTabsCount() == 1 || !allBrowserTabs().contains(title)) {
            setTabName(title);
        } else {
            String newTabName = title + "[2]";
            int i = 3;
            while (allBrowserTabs().contains(newTabName)) {
                newTabName = title + "[" + i++ + "]";
            }
            setTabName(newTabName);
        }
    }

    public static List<String> allBrowserTabs() {
        return windowHandlesMap.get().keys();
    }

    /**
     * Get windows count
     * @return int count
     */
    public static int browserTabsCount() {
        return getWindowHandles().size();
    }

    /**
     * Switch to new window
     */
    public static void switchToNewTab() {
        String last = "";
        for (String window : getWindowHandles()) {
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
        switchToNewTab();
    }

    /**
     * Open new tab
     */
    public static void openNewTabPage(String url) {
        jsExecute("window.open()");
        switchToNewTab();
        JDI.openPage(url);
        setTabNameNewPage();
    }

    /**
     * Open new tab
     */
    public static void openNewTab(String name) {
        jsExecute("window.open()");
        switchToNewTab();
        setTabName(name);
    }
    /**
     * Go back to original window
     */
    public static void originalWindow() {
        driver().switchTo().window(getWindowHandles().iterator().next());
    }

    /**
     * Switch to the specified window
     * @param index
     */
    public static void switchToTab(int index) {
        if (index < 0) {
            throw new JDINovaException("Window's index starts from 1. You try to use '%s' that less than 1.", index);
        }
        int counter = 0;
        if (getWindowHandles().size() < index + 1) {
            throw new JDINovaException(index + " is too much. Only " + getWindowHandles().size() + " windows found");
        }
        for (String window : getWindowHandles()) {
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
    public static void switchToTab(String value) {
        if (!windowHandlesMap.get().has(value)) {
            throw new JDINovaException("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", value);
        }
        driver().switchTo().window(windowHandlesMap.get().get(value));
    }

    /**
     * Close current window
     */
    public static void closeTab() {
        driver().close();
        originalWindow();
    }

    /**
     * Close the specified window
     * @param value
     */
    public static void closeTab(String value) {
        switchToTab(value);
        closeTab();
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
