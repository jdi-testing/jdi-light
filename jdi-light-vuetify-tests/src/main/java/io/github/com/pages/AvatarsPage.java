package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.com.custom.ProfileCard;
import java.util.List;

public class AvatarsPage extends VuetifyPage {

    @UI("#avatarsWithSize .v-avatar")
    public static List<Avatar> avatarsWithSize;

    @UI("#tileAvatar .v-avatar")
    public static Avatar tileAvatar;

    @UI("#slotAvatars .v-avatar")
    public static List<Avatar> slotAvatars;

    @UI("#profileCard")
    public static ProfileCard profileCard;
}
