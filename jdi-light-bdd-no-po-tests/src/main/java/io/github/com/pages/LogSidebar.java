package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Text;

public class LogSidebar {
    @UI(".logs  li:first-child")
    public static Text lastLogEntry;
}