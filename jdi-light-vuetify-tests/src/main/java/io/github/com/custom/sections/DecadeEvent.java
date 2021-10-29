package io.github.com.custom.sections;

import com.epam.jdi.light.elements.composite.Section;

public class DecadeEvent extends Section {

    @Override
    public String getText() {
        return find("div").getText();
    }
}
