package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

@SuppressWarnings("PMD.ClassNamingConventions")
public class LogSidebar {
    @UI(".logs  li:first-child")
    public static Text lastLogEntry;
}