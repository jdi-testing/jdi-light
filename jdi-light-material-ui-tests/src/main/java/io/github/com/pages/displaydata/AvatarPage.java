package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import io.github.com.pages.displaydata.sections.AvatarWithPhoto;

import java.util.List;

public class AvatarPage extends WebPage {
    public static AvatarWithPhoto avatarWithPhoto = new AvatarWithPhoto();
    @UI("//span[@class='MuiBadge-root']/following-sibling::div")
    public static List<Badge> avatarWithoutPhoto;
}
