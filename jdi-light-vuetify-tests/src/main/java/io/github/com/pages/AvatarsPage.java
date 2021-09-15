package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.elements.complex.ProfileCard;

import java.util.List;

public class AvatarsPage extends VuetifyPage {

    @UI("//div[@id = 'avatarsWithSize']/div/div")
    public static List<Avatar> avatarsWithSize;

    @UI("//div[@id = 'tileAvatar']//div[contains(@class, 'v-avatar')]")
    public static Avatar tileAvatar;

    @UI("//div[@id = 'slotAvatars']//div[contains(@class, 'v-avatar')]")
    public static List<Avatar> slotAvatars;

    @UI("//div[@id = 'profileCard']")
    public static ProfileCard profileCard;

}
