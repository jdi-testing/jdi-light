package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Badge;

import java.util.List;

public class AvatarPage extends WebPage {

    @UI(".MuiBadge-root")
    public static List<Badge> badgeWithAvatars;

    @UI("//div/div[contains(@class, 'MuiAvatar-root') and not(*)]")
    public static List<Avatar> avatarsWithText;

    @UI("//div[contains(@class, 'MuiAvatar-root')][name(./*)='svg']")
    public static List<Avatar> avatarsWithIcon;

}

