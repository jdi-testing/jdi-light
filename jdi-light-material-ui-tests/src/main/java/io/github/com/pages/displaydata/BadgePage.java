package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import java.util.List;

public class BadgePage extends WebPage {

    @UI("#primaryColorBadge")
    public static Badge primaryBadge;

    @UI("#primaryColorBadge .MuiBadge-badge")
    public static Text primaryBadgeCounter;

    @UI("#errorColorBadge")
    public static Badge errorBadge;

    @UI("#errorColorBadge .MuiBadge-badge")
    public static Text errorBadgeCounter;

    @UI("#secondaryColorBadge")
    public static Badge variousBadge;

    @UI("#secondaryColorBadge .MuiBadge-badge")
    public static Text variousBadgeCounter;

    @UI("//div[@class='MuiButtonGroup-root']/button[@aria-label='reduce']")
    public static Button buttonReduce;

    @UI("//div[@class='MuiButtonGroup-root']/button[@aria-label='increase']")
    public static Button buttonIncrease;

    @UI("//span[text()='Show Zero']/preceding-sibling::span/span[contains(@class,'MuiSwitch-switchBase')]")
    public static Checkbox switchShowZero;

    @UI("//span[@id='dotBadge']")
    public static Badge dotBadge;

    @UI("//span[contains(@class,'MuiBadge-dot')]")
    public static Badge dot;

    @UI("//span[text()='Show Badge']/preceding-sibling::span/span[contains(@class,'MuiSwitch-switchBase')]")
    public static Checkbox switchShowBadge;

    @UI("//span[text()='Show Badge']/following::span[@class='MuiBadge-root']")
    public static List<Badge> badgeDifferentPosition;

    @UI("//span[text()='Show Badge']/following::span[contains(@class,'MuiBadge-badge')]")
    public static List<Text> badgeCounterWithDifferentPosition;
}
