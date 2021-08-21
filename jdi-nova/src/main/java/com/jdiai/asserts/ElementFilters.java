package com.jdiai.asserts;

public class ElementFilters {
    public final static String isExist = "element !== null";

    public final static String isDisplayed =
        "element && styles.visibility === 'visible' && styles.display !== 'none' " +
        "&& !element.hasAttribute('hidden')";

    public final static String isEnabled = isDisplayed + " && !element.hasAttribute('disabled')";

    // onmousemove = function(e){ console.log("mouse location:", e.clientX, e.clientY); }
    public final static String isVisible =
        "if (!element) { return false; }\n" +
        "rect = element.getBoundingClientRect();\n" +
        "if (!styles || !rect || styles.visibility !== 'visible' || styles.display === 'none' || " +
        "element.hasAttribute('hidden') || styles.opacity < 0.05 || rect.width < 3 || rect.height < 3) {\n" +
        "  return false;\n" +
        "}\n" +
        "cx = rect.left + rect.width / 2;\n" +
        "cy = rect.top + rect.height / 2;\n" +
        "e = document.elementFromPoint(cx, cy);\n" +
        "for (; e; e = e.parentElement) {\n" +
        "  if (e === element) {\n" +
        "    return true;\n" +
        "  }\n" +
        "}\n" +
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
