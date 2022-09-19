package io.github.com.custom.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.vuetify.elements.complex.CustomText;

public class DecadeEvent extends Section {

    private String contentLocator = ".//div|.//label|../p";
    private String titleLocator = ".headline";

    @Override
    public String getText() {
        return find("div").getText();
    }

    public CustomText title() { return new CustomText().setCore(CustomText.class, core().find(titleLocator)); }

    public CustomText content() { return new CustomText().setCore(CustomText.class, core().find(contentLocator)); }
}
