package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class TextAreaAutoSizePage extends WebPage {
    @UI("//textarea[@aria-label = 'empty textarea']")
    public static TextArea emptyTextArea;

    @UI("//textarea[@aria-label = 'minimum height']")
    public static TextArea minArea;

    @UI("//textarea[@aria-label = 'maximum height']")
    public static TextArea maxArea;

}
