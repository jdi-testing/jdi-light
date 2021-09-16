package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.BottomNavigationButton;

import java.util.List;

public class BottomNavigationPage extends VuetifyPage {

    @UI("//p[normalize-space(text())='Color']/following-sibling::div/button")
    public static List<BottomNavigationButton> color;
    @UI("//p[normalize-space(text())='Grow']/following-sibling::div/button")
    public static List<BottomNavigationButton> grow;
    @UI("//p[normalize-space(text())='Hide on scroll']/following-sibling::div//button")
    public static List<BottomNavigationButton> hideOnScroll;
    @UI("//p[normalize-space(text())='Horizontal']/following-sibling::div/button")
    public static List<BottomNavigationButton> horizontal;
    @UI("//p[normalize-space(text())='Scroll threshold']/following-sibling::div//button")
    public static List<BottomNavigationButton> scrollThreshold;
    @UI("//p[normalize-space(text())='Shift']/following-sibling::div/button")
    public static List<BottomNavigationButton> shift;
    @UI("//p[normalize-space(text())='Toggle']/following-sibling::div/div[2]//button")
    public static List<BottomNavigationButton> toggle;

}
