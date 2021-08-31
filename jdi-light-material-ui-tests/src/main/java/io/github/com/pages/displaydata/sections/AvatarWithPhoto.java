package io.github.com.pages.displaydata.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Badge;

import java.util.List;

public class AvatarWithPhoto extends Section {
    @UI("//span[@class='MuiBadge-root']/div")
    public static List<Badge> photo;
    @UI("//span[@class='MuiBadge-root']/span")
    public static List<Badge> onlineStatus;
}
