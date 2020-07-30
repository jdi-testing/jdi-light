package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BadgeSection extends Section {

    @UI("#text-with-badge span")
    public static Badge badgeWithText;

    @UI("#button-with-left-badge")
    public static Button buttonWithBadge;

    @UI("#button-with-left-badge span.mat-button-wrapper")
    public static Text textOnButton;

    @UI("#button-with-left-badge span:not(.mat-button-wrapper)")
    public static Badge badgeWithButton;

    @UI("#icon-with-badge span")
    public static Badge badgeWithIcon;

    @UI("#hidden-message")
    public static Text hiddenText;
}
