package io.github.com.custom.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Avatar;

import java.util.List;

public class ScheduledEvent extends Section {

    @UI(".col strong[1]")
    protected UIElement time;

    @UI(".col strong[2]")
    protected UIElement event;

    @UI(".text-caption")
    protected UIElement caption;

    public UIElement time() {
        return time;
    }

    public UIElement event() {
        return event;
    }

    public UIElement caption() {
        return caption;
    }

    public List<Avatar> avatars() {
        return core().finds(".v-avatar").map(element -> new Avatar().setCore(Avatar.class, element));
    }
}
