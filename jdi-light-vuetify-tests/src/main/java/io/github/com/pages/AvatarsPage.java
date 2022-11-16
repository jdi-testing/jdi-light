package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Avatar;

import java.util.List;

public class AvatarsPage extends VuetifyPage {

    @UI("#avatarsWithSize .v-avatar")
    public static List<Avatar> sizeAvatars;

    @UI("#avatarMenuCombi .v-avatar")
    public static Avatar menuAvatar;

    @UI("#tileAvatar .v-avatar")
    public static Avatar tileAvatar;

    @UI("#slotAvatars .v-avatar")
    public static List<Avatar> slotAvatars;

    @UI("#leftAvatar .v-avatar")
    public static Avatar leftAvatar;

    @UI("#rightAvatar .v-avatar")
    public static Avatar rightAvatar;
}
