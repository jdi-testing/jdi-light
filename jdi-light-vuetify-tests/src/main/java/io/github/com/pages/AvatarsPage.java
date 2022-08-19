package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.com.custom.cards.AvatarMenuCard;
import io.github.com.custom.cards.AvatarProfileCard;
import io.github.com.custom.panels.AvatarExpansionPanel;

import java.util.List;

public class AvatarsPage extends VuetifyPage {

    @UI("#avatarsWithSize .v-avatar")
    public static List<Avatar> avatarsWithSize;

    @UI("#tileAvatar .v-avatar")
    public static Avatar tileAvatar;

    @UI("#slotAvatars .v-avatar")
    public static List<Avatar> slotAvatars;

    @UI("#profileCard")
    public static AvatarProfileCard profileCard;

    @UI("#avatarMenuCombi .v-avatar.indigo")
    public static Avatar menuAvatarIndigo;
    @UI("//div[@role='menu']")
    public static AvatarMenuCard menuCard;

    @UI("#avatarMix .v-expansion-panel")
    public static List<AvatarExpansionPanel> avatarMix;
}
