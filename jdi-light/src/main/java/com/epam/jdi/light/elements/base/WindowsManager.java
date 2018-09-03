package com.epam.jdi.light.elements.base;

import com.epam.jdi.tools.map.MapArray;

import java.util.Set;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
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
        String windowHandle = getDriver().getWindowHandle();
        for (String window : getWindows()) {
            if (window.equals(windowHandle)) {
                windowHandles.add(name, windowHandle);
                return;
            }
        }
    }
    public static int windowsCount() {
        return getWindows().size();
    }

    public static void openNewWindow() {
        String last = "";
        for (String window : getWindows())
            last = window;
        if (!isBlank(last))
            getDriver().switchTo().window(last);
        else throw exception("No windows found");
    }

    public static void originalWindow() {
        getDriver().switchTo().window(getWindows().iterator().next());
    }

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
    public static void switchToWindow(String name) {
        if (!windowHandles.has(name))
            throw exception("Window %s not registered. Use setWindowName method to setup window name for current windowHandle", name);
        getDriver().switchTo().window(windowHandles.get(name));
    }
}
