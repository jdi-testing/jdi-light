package com.jdiai.asserts;

public class DisplayedTypes {
    public static final String isDisplayed =
        "element !== null && styles.visibility === 'visible' && styles.display !== 'none' && !element.hasAttribute('hidden')";
    public static final String isVisible =
        "const rect = element.getBoundingClientRect();" +
        "element !== null && styles.visibility === 'visible' && styles.display !== 'none' " +
        "&& styles.opacity >= 0.05 && !element.hasAttribute('hidden') " +
        "&& rect.width >= 5 && rect.height >= 5";
}
