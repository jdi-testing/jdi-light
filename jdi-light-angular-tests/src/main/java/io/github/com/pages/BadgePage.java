package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.common.Icon;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.elements.UIElementWithBadge;

public class BadgePage extends NewAngularPage {

//    public static Badge textWithBadge;
    @UI("#text-with-badge")
    public static UIElementWithBadge textWithBadge;
    @UI("#large-badge")
    public static UIElementWithBadge textWithLargeBadge;
    @UI("#small-badge")
    public static UIElementWithBadge textWithSmallBadge;
    @UI("#custom-size-badge")
    public static UIElementWithBadge elementWithCustomSizeBadge;
    @UI("#bellow-position-badge")
    public static UIElementWithBadge belowPositionBadge;
    @UI("#button-with-badge")
    public static Button buttonWithBadge;
    @UI("#icon-with-badge")
    public static Icon iconWithBadge;
    @UI("#toggle-visibility-badge")
    public static Button buttonToggleVisibilityBadge;
    @UI("#toggle-disabled-badge")
    public static Button buttonToggleDisabledBadge;

}
