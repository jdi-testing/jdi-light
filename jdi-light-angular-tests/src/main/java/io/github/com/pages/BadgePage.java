package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.elements.ButtonWithBadge;
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
    public static ButtonWithBadge buttonWithBadge;
    @UI("#icon-with-badge")
    public static UIElementWithBadge iconWithBadge;
    @UI("#toggle-visibility-badge")
    public static ButtonWithBadge buttonToggleVisibilityBadge;
    @UI("#toggle-disabled-badge")
    public static ButtonWithBadge buttonToggleDisabledBadge;

}
