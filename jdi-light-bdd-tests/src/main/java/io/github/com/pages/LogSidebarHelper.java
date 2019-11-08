package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class LogSidebarHelper {
    @UI(".logs  li:first-child")
    public static Text lastLogEntry;
}