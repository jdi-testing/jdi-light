package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.common.Image;
import javafx.scene.chart.ValueAxis;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.common.Exceptions.exception;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ImageAssert extends IsAssert {
    Image image;
    public ImageAssert(Image image) { super(image); this.image = image; }

    public void src(Matcher<String> condition) { assertThat(image.getSrc(), condition); }
    public void alt(Matcher<String> condition) { assertThat(image.getAlt(), condition); }

    public void height(int value) {
        int height;
        try {
            height = Integer.parseInt(image.getHeight());
        } catch (Exception ex) { throw exception("Can't parse 'height' attribute '"+image.getHeight()+"' to integer"); }
        assertThat(height, is(value));
    }
    public void width(int value) {
        int width;
        try {
            width = Integer.parseInt(image.getWidth());
        } catch (Exception ex) { throw exception("Can't parse 'width' attribute '"+image.getWidth()+"' to integer"); }
        assertThat(width, is(value));
    }

}
