package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.feedback.progress.Progress;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;

/**
 * Annotation for setting locators for root, label, the first and the second bars in {@link Progress}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JProgress {

    /**
     * Locator for root of {@link Progress}.
     *
     * @return root locator as {@link String}
     */
    @MarkupLocator String root() default "//*[contains(@class, 'Progress-root')]";

    /**
     * Locator for label of {@link Progress}.
     *
     * @return label locator as {@link String}
     */
    @MarkupLocator String label() default ".MuiTypography-root";

    /**
     * Locator for the first bar of {@link LinearProgress}.
     *
     * @return the first bar locator as {@link String}
     */
    @MarkupLocator String firstBar() default ".MuiLinearProgress-bar1";

    /**
     * Locator for the second bar of {@link LinearProgress}.
     *
     * @return the second bar locator as {@link String}
     */
    @MarkupLocator String secondBar() default ".MuiLinearProgress-bar2";
}
