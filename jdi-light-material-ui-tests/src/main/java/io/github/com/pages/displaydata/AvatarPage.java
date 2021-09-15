package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Avatar;

import java.util.List;

public class AvatarPage extends WebPage {

    @UI("//span[@class = 'MuiBadge-root']")
    public static List<Avatar> avatarsWithPhoto;

    @UI("//div/div[contains(@class, 'MuiAvatar-root')]")
    public static List<Avatar> avatarsWithoutPhoto;

    @UI("//div/div[contains(@class, 'MuiAvatar-root') and not(*)] ")
    public static List<Avatar> avatarsWithText;

    @UI("//div[contains(@class, 'MuiAvatar-root')]/*[contains(@class, 'MuiSvgIcon-root')]/parent::div")
    public static List<Avatar> avatarsWithIcon;

}

