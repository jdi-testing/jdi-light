package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Badge;

import java.util.List;

public class BadgesPage extends VuetifyPage {

    @UI("#simpleBadges .v-badge__badge")
    public static List<Badge> simpleBadges;

    @UI("//span[contains(text(), 'Unlock Account') or contains(text(), 'Lock account')]")
    public static Button lockUnlockAccountButton;

    @UI("#customBadges .v-badge__badge")
    public static Badge customBadges;

    @UI("//span[contains(text(), 'Send Message')]")
    public static Button sendMessageButton;

    @WaitAfterAction(1)
    @UI("//span[contains(text(), 'Clear Notifications')]")
    public static Button clearNotificationsButton;

    @WaitAfterAction(1)
    @UI("#dynamicBadge .v-badge__badge")
    public static Badge dynamicBadge;

    @UI("#hoverBadge > .v-badge")
    public static Icon hoverIcon;

    @UI("#hoverBadge .v-badge__badge")
    public static Badge hoverBadge;
}
