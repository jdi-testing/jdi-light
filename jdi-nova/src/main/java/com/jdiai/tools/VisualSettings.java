package com.jdiai.tools;

import com.jdiai.JS;
import com.jdiai.interfaces.HasName;
import com.jdiai.jsdriver.JSException;
import com.jdiai.visual.ImageTypes;

import java.io.File;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.jdiai.JS.JDI_STORAGE;
import static com.jdiai.visual.ImageTypes.JPG;
import static java.lang.Math.*;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class VisualSettings {
    public static String IMAGE_STORAGE = JDI_STORAGE + "/images/";

    public static ImageTypes DEFAULT_IMAGE_TYPE = JPG;

    public static Function<JS, String> DEFAULT_IMAGE_NAME = js -> {
        String name = "";
        if (js.parent() != null) {
            name += isInterface(js.parent().getClass(), HasName.class)
                ? ((HasName)js.parent()).getName()
                : js.parent().getClass().getSimpleName();
            name += "_";
        }
        return name + js.getName();
    };
    public static BiFunction<String, JS, String> IMAGE_TEMPLATE =  (tag, js) -> {
        String imageName = isNotBlank(tag)
            ? tag
            : DEFAULT_IMAGE_NAME.apply(js);
        return IMAGE_STORAGE + imageName;
    };
    public static BiFunction<File, File, Boolean> COMPARE_IMAGES = (newImage, baselineImage) -> {
        long actual = newImage.length();
        long expected = baselineImage.length();
        long threshHold = Math.round(min(max(actual, expected) * 0.01, 100));
        String result = abs(actual - expected) < threshHold
            ? "Images are the same"
            : format("Images are different '%s' '%s'", newImage.getAbsolutePath(), baselineImage.getAbsolutePath());
        if (result.equals("Images are the same")) {
            throw new AssertionError("Images are different." +
                "\nActual: " + newImage +
                "\nExpected: " + baselineImage.getAbsolutePath());
        }
        return result.equals("Images are the same");
    };
    public static BiConsumer<String, JS> VISUAL_VALIDATION = (tag, js) -> {
        try {
            if (js.imagesData().images.has(tag)) {
                File baseLineImage = new File(js.imagesData().images.get(tag));
                File newImage = js.makeScreenshot(tag + "-new");
                COMPARE_IMAGES.apply(newImage, baseLineImage);
            } else {
                js.makeScreenshot(tag);
            }
        } catch (Exception ex) { throw new JSException(ex, "Can't compare files"); }
    };
}
