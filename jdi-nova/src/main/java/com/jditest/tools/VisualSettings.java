package com.jditest.tools;

import com.epam.jdi.tools.func.JAction2;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.jditest.JS;
import com.jditest.interfaces.HasName;
import com.jditest.jsdriver.JSException;
import com.jditest.visual.ImageTypes;

import java.io.File;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.Math.*;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static com.jditest.JS.JDI_STORAGE;
import static com.jditest.visual.ImageTypes.JPG;

public class VisualSettings {
    public static String IMAGE_STORAGE = JDI_STORAGE + "/images/";
    public static ImageTypes DEFAULT_IMAGE_TYPE = JPG;
    public static JFunc1<JS, String> DEFAULT_IMAGE_NAME = js -> {
        String name = "";
        if (js.parent() != null) {
            name += isInterface(js.parent().getClass(), HasName.class)
                ? ((HasName)js.parent()).getName()
                : js.parent().getClass().getSimpleName();
            name += "_";
        }
        return name + js.getName();
    };
    public static JFunc2<String, JS, String> IMAGE_TEMPLATE =  (tag, js) -> {
        String imageName = isNotBlank(tag) ? tag : DEFAULT_IMAGE_NAME.execute(js);
        return IMAGE_STORAGE + imageName;
    };
    public static JFunc2<File, File, Boolean> COMPARE_IMAGES = (newImage, baselineImage) -> {
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
    public static JAction2<String, JS> VISUAL_VALIDATION = (tag, js) -> {
        try {
            if (js.imagesData().images.has(tag)) {
                File baseLineImage = new File(js.imagesData().images.get(tag));
                File newImage = makePhoto(tag + "-new", js);
                COMPARE_IMAGES.execute(newImage, baseLineImage);
            } else {
                makePhoto(tag, js);
            }
        } catch (Exception ex) { throw new JSException(ex, "Can't compare files"); }
    };

    protected static File makePhoto(String tag, JS js) {
        js.show();
        File imageFile = js.makeScreenshot().asFile(getScreenshotName(tag, js));
        js.imagesData().images.update(tag, imageFile.getPath());
        js.imagesData().imageFile = imageFile;
        return imageFile;
    }
    protected static String getScreenshotName(String tag, JS js) {
        return IMAGE_TEMPLATE.execute(tag, js);
    }
}
