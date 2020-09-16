package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class BadgeSection extends Section {

    @UI("#text-with-badge")
    public static Badge textWithBadge;

    @UI("#button-with-left-badge")
    public static Badge buttonWithBadge;

    @UI("#icon-with-badge")
    public static Badge iconWithBadge;

}
