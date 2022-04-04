package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.feedback.progress.CircularProgress;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;
import com.epam.jdi.light.material.elements.feedback.progress.Progress;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for setting custom locators for progress and its components.
 *
 * @see Progress
 * @see CircularProgress
 * @see LinearProgress
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JProgress {

    /**
     * Locator for the {@link Progress} root from which the elements within the progress will be searched.
     * Default is '.Progress-root'.
     *
     * @return root locator as {@link String}
     */
    @MarkupLocator String root() default ".Progress-root";

    /**
     * Locator for label with the numerical value of {@link Progress} (e.g. "30%").
     * Default is '.MuiTypography-root'.
     *
     * @return label locator as {@link String}
     */
    @MarkupLocator String label() default ".MuiTypography-root";

    /**
     * Locator for the first bar of {@link LinearProgress}.
     * Default is '.MuiLinearProgress-bar1'.
     *
     * @return the first bar locator as {@link String}
     */
    @MarkupLocator String firstBar() default ".MuiLinearProgress-bar1";

    /**
     * Locator for the second bar of {@link LinearProgress}.
     * Default is '.MuiLinearProgress-bar2'.
     *
     * @return the second bar locator as {@link String}
     */
    @MarkupLocator String secondBar() default ".MuiLinearProgress-bar2";
}
