package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.ButtonWithBadge;
import io.github.com.custom.IconWithBadge;

public class BadgeSection extends Section {

    @UI("#text-with-badge")
    public static Button textButton;
    @UI("#text-with-badge span")
    public static Badge badgeWithText;


    public static ButtonWithBadge textWithBadge;
    public static IconWithBadge iconWithBadge;


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
