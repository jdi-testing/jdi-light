package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.elements.common.Image;
import io.github.com.custom.asserts.ProfileCardAssert;

/**
 * To see an example of Profile card web element please visit https://vuetifyjs.com/en/components/avatars/#profile-card
 */

public class ProfileCard extends UIBaseElement<ProfileCardAssert> {

    private static final String IMAGES_LOCATOR = ".v-image__image--cover";

    @JDIAction("Get '{name}'s avatar image")
    public Image avatarImage() {
        return new Image().setCore(Image.class, finds(IMAGES_LOCATOR).get(2));
    }

    @JDIAction("Get '{name}'s background image")
    public Image backgroundImage() {
        return new Image().setCore(Image.class, finds(IMAGES_LOCATOR).get(1));
    }

    @JDIAction("Get '{name}'s user's name")
    public String getUserName() {
        return find(".v-list-item__title").getText();
    }

    @JDIAction("Get '{name}'s user's job function")
    public String getUserJobFunction() {
        return find(".v-list-item__subtitle").getText();
    }

    public ProfileCardAssert is() {
        return new ProfileCardAssert().set(this);
    }

    public ProfileCardAssert has() {
        return this.is();
    }
}
