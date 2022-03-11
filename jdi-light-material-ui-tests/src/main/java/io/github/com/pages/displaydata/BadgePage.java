package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.annotations.JDIBadgeContainer;
import io.github.com.custom.elements.BadgeContainer;

import java.util.List;

public class BadgePage extends WebPage {

    @JDIBadgeContainer(
            root = "#primaryColorBadge",
            context = ".MuiSvgIcon-root")
    public static BadgeContainer primaryColorBadgeContainer;

    @JDIBadgeContainer(
            root = "#errorColorBadge",
            context = ".MuiSvgIcon-root")
    public static BadgeContainer errorColorBadgeContainer;

    @JDIBadgeContainer(
            root = "#secondaryColorBadge",
            context = ".MuiSvgIcon-root")
    public static BadgeContainer secondaryColorBadgeContainer;

    @UI(".MuiButtonGroup-root  button[aria-label='reduce']")
    public static Button buttonReduce;

    @UI(".MuiButtonGroup-root  button[aria-label='increase']")
    public static Button buttonIncrease;

    @UI("//span[text()='Show Zero']/preceding-sibling::span[contains(@class,'MuiSwitch-root')]")
    public static Switch switchShowZero;

    @JDIBadgeContainer(
            root = "#dotBadge",
            context = ".MuiSvgIcon-root")
    public static BadgeContainer dotBadgeContainer;

    @UI("//span[text()='Show Badge']/preceding-sibling::span[contains(@class,'MuiSwitch-root')]")
    public static Switch switchShowBadge;

    @UI("//span[text()='Show Badge']/following::span[@class='MuiBadge-root']")
    public static List<BadgeContainer> badgeDifferentPosition;

}
