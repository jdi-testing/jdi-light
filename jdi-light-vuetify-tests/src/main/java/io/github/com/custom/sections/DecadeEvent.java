package io.github.com.custom.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class DecadeEvent extends Section {

    private String contentLocator = ".//div|.//label|../p";
    private String titleLocator = ".headline";

    @Override
    public String getText() {
        return core().find("div").getText();
    }

    public Text title() { return new Text().setCore(Text.class, core().find(titleLocator)); }

    public Text content() { return new Text().setCore(Text.class, core().find(contentLocator)); }
}
