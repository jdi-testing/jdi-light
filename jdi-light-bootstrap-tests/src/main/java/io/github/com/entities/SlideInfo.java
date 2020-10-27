package io.github.com.entities;

import com.epam.jdi.tools.DataClass;

import static java.lang.String.format;

public class SlideInfo extends DataClass<SlideInfo> {
    public String title;
    public String image;
    public String text;
    public String src;
    @Override
    public String toString() {
        return format("%s[%s:%s]", title, image, text);
    }
    public String visibleText() {
        return format("%s[%s:%s]", title.toUpperCase(), image, text);
    }
}
