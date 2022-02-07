package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;

public class BadgePage extends WebPage {
    // TODO: Badge is element with class MuiBadge-root, not a circle
    @UI("#primaryColorBadge .MuiBadge-badge")
    public static Badge primaryColorBadge;

    @UI("#errorColorBadge .MuiBadge-badge")
    public static Badge errorColorBadge;

    @UI("#secondaryColorBadge .MuiBadge-badge")
    public static Badge secondaryColorBadge;

    @UI(".MuiButtonGroup-root  button[aria-label='reduce']")
    public static Button buttonReduce;

    @UI(".MuiButtonGroup-root  button[aria-label='increase']")
    public static Button buttonIncrease;

    @UI("//span[text()='Show Zero']/preceding-sibling::span/span[contains(@class,'MuiSwitch-switchBase')]")
    public static Checkbox switchShowZero;

    @UI("#dotBadge .MuiBadge-badge")
    public static Badge dotBadge;

    @UI("//span[text()='Show Badge']/preceding-sibling::span/span[contains(@class,'MuiSwitch-switchBase')]")
    public static Checkbox switchShowBadge;

    @UI("//span[text()='Show Badge']/following::span[@class='MuiBadge-root']/span[contains(@class,'MuiBadge-badge')]")
    public static List<Badge> badgeDifferentPosition;

}
