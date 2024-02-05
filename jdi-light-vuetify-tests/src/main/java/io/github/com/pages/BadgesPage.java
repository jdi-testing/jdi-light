package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Badge;

import java.util.List;

public class BadgesPage extends VuetifyPage {
    // @todo #5298 Locator to the Badge should be .v-bage, not icons, dots and avatar
    @UI("#simpleBadges .v-badge")
    public static List<Badge> simpleBadges;

    @UI("#customBadges .v-badge--icon")
    public static Badge lockUnlockAccountBadge;

    @UI("#customBadges .v-badge--dot")
    public static Badge dotBadge;

    @UI("#customBadges .v-badge--avatar")
    public static Badge imageBadge;
    @UI("//span[contains(text(), 'Send Message')]")
    public static Button sendMessageButton;

    @WaitAfterAction(1)
    @UI("//span[contains(text(), 'Clear Notifications')]")
    public static Button clearNotificationsButton;

    @UI("#dynamicBadge .v-badge")
    public static Badge dynamicBadge;
    @UI("#hoverBadge > .v-badge")
    public static Badge hoverBadge;
}
