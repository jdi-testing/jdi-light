package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.Switch;

import java.util.List;

public class BadgePage extends WebPage {
    @UI("#primaryColorBadge")
    public static Badge primaryColorBadgeContainer;

    @UI("#errorColorBadge")
    public static Badge errorColorBadgeContainer;

    @UI("#secondaryColorBadge")
    public static Badge secondaryColorBadgeContainer;

    @UI(".MuiButtonGroup-root")
    public static ButtonGroup buttons;

    @UI("//span[text()='Show Zero']/preceding-sibling::span[contains(@class,'MuiSwitch-root')]")
    public static Switch switchShowZero;

    @UI("#dotBadge")
    public static Badge dotBadgeContainer;

    @UI("//span[text()='Show Badge']/preceding-sibling::span[contains(@class,'MuiSwitch-root')]")
    public static Switch switchShowBadge;

    @UI("//span[text()='Show Badge']/following::span[@class='MuiBadge-root']")
    public static List<Badge> badgeDifferentPosition;

}
