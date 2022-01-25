package io.github.com.entities;

import com.jdiai.tools.DataClass;

import static com.jdiai.tools.StringUtils.format;

public class SlideInfo extends DataClass<SlideInfo> {
    public String title, image, text, src;
    @Override
    public String toString() {
        return format("%s[%s:%s]", title, image, text);
    }
    public String visibleText() {
        return format("%s[%s:%s]", title.toUpperCase(), image, text);
    }
}
