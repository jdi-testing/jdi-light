package com.jdiai.asserts;

public class ElementFilters {
    static final String isExist = "element !== null";

    static final String isDisplayed =
        "element !== null && styles.visibility === 'visible' && styles.display !== 'none' " +
        "&& !element.hasAttribute('hidden')";

    static final String isEnabled = isDisplayed + " && element.hasAttribute('enabled')";

    // onmousemove = function(e){ console.log("mouse location:", e.clientX, e.clientY); }
    static final String isVisible =
        "if (!element) { return false; }\n" +
        "rect = element.getBoundingClientRect();\n" +
        "if (!styles || !rect || styles.visibility !== 'visible' || styles.display === 'none' || " +
        "element.hasAttribute('hidden') || styles.opacity < 0.05 || rect.width < 3 || rect.height < 3) {\n" +
        "  return false;\n" +
        "}\n" +
        "element.scrollIntoView({behavior:'auto',block:'center',inline:'center'});\n" +
        "cx = rect.left + rect.width - 2;\n" +
        "cy = rect.top + 2;\n" +
        "e = document.elementFromPoint(cx, cy);\n" +
        "for (; e; e = e.parentElement) {\n" +
        "  if (e === element) {\n" +
        "    return true;\n" +
        "  }\n" +
        "}\n" +
        "return false;";
}
