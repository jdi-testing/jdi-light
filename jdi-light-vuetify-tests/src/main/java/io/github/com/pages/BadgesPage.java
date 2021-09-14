package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Badge;

import java.util.List;

public class BadgesPage extends WebPage {

    @UI("#simpleBadges .v-badge__badge")
    List<Badge> simpleBadges;

    @UI("#customBadges .v-badge__badge")
    List<Badge> customBadges;

    @UI("#dynamicBadge .v-badge__badge")
    Badge dynamicBadge;

    @UI("#hoverBadge .v-badge__badge")
    Badge hoverBadge;
}
