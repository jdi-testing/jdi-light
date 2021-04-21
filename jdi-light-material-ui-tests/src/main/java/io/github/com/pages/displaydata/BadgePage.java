package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import java.util.List;

public class BadgePage extends WebPage {

    @UI("//span[@class='MuiBadge-root']")
    public static List<Badge> badge;

    @UI("//span[text()='Show Badge']/following::span[@class='MuiBadge-root']")
    public static List<Badge> badgeDifferentPosition;

    @UI("//div[@class='MuiButtonGroup-root']/preceding-sibling::span[@class='MuiBadge-root']")
    public static Badge badgeWithVariableCounter;

    @UI("//span[@id='dotBadge']")
    public static Badge dotBadge;

    @UI("//span[contains(@class,'MuiBadge-dot')]")
    public static Badge dot;

    @UI("//span[contains(@class,'MuiBadge-badge')]")
    public static List<Text> badgeCounter;

    @UI("//span[text()='Show Badge']/following::span[contains(@class,'MuiBadge-badge')]")
    public static List<Text> badgeCounterWithDifferentPosition;

    @UI("//div[@class='MuiButtonGroup-root']/button")
    public static List<Button> badgeButton;

    @UI("//span[@class='MuiIconButton-label']")
    public static List<Button> badgeToggler;
}
