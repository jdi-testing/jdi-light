package org.jdiai;

import com.epam.jdi.tools.func.JAction2;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.jdiai.interfaces.HasName;

import java.io.File;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.Math.*;
import static java.lang.String.format;
import static org.jdiai.ImageTypes.JPG;
import static org.testng.Assert.assertEquals;

public class VisualSettings {
    public static ImageTypes DEFAULT_IMAGE_TYPE = JPG;
    public static JFunc2<String, JS, String> IMAGE_TEMPLATE =  (tag, js) -> "src/test/images/" + tag;
    public static JFunc1<JS, String> DEFAULT_IMAGE_NAME = js -> {
        String name = "";
        if (js.parent() != null) {
            name += isInterface(js.parent().getClass(), HasName.class)
                ? ((HasName<?>)js.parent()).getName()
                : js.parent().getClass().getSimpleName();
            name += "_";
        }
        return name + js.getName();
    };
    public static JFunc2<File, File, Boolean> COMPARE_IMAGES = (newImage, baselineImage) -> {
        long actual = newImage.length();
        long expected = baselineImage.length();
        long threshHold = Math.round(min(max(actual, expected) * 0.01, 100));
        String result = abs(actual - expected) < threshHold
            ? "Images are the same"
            : format("Images are different '%s' '%s'", newImage.getAbsolutePath(), baselineImage.getAbsolutePath());
        assertEquals(result, "Images are the same");
        return result.equals("Images are the same");
    };
    public static JAction2<String, JS> VISUAL_VALIDATION = (tag, js) -> {
        try {
            if (js.images.has(tag)) {
                File baseLineImage = new File(js.images.get(tag));
                File newImage = makePhoto(tag + "-new", js);
                COMPARE_IMAGES.execute(newImage, baseLineImage);
            } else {
                makePhoto(tag, js);
            }
        } catch (Exception ex) { throw new JSException(ex, "Can't compare files"); }
    };

    protected static File makePhoto(String tag, JS js) {
        js.show();
        File imageFile = js.makeScreenshot().asFile(js.getScreenshotName(tag));
        js.images.update(tag, imageFile.getPath());
        js.imageFile = imageFile;
        return imageFile;
    }
}
