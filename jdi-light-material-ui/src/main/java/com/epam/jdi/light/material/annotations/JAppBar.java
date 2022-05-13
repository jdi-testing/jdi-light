package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for setting custom locators for {@link AppBar}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JAppBar {

    /**
     * Root locator for this app bar, i.e. locator to start searching from for all inner components.
     * Default is '.MuiAppBar-root'.
     *
     * @return root locator as {@link String}
     */
    @MarkupLocator String root() default ".MuiAppBar-root";

    /**
     * Navigation button locator for this app bar. This element located on the left side of the app bar.
     * Default is '.MuiIconButton-edgeStart'.
     *
     * @return navigation button locator as {@link String}
     */
    @MarkupLocator String navigationButton() default ".MuiIconButton-edgeStart";

    /**
     * Title locator for this app bar.
     * Default is '.MuiTypography-root'.
     *
     * @return title locator as {@link String}
     */
    @MarkupLocator String title() default ".MuiTypography-root";

    /**
     * Action items locator for this app bar. These are all buttons except the navigation button and the overflow menu button.
     * Default is '' because there may not be such action items.
     *
     * @return action items locator as {@link String}
     */
    @MarkupLocator String[] actionItems() default "";

    /**
     * Overflow menu button locator for this app bar. This element located on the right side of the app bar.
     * Default is '.MuiTypography-root'.
     *
     * @return overflow menu button locator as {@link String}
     */
    @MarkupLocator String overflowMenuButton() default ".MuiIconButton-edgeEnd";
}
