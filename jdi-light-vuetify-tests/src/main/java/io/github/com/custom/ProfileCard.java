package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import io.github.com.custom.asserts.ProfileCardAssert;

/**
 * To see an example of Profile card web element please visit https://vuetifyjs.com/en/components/avatars/#profile-card
 */

public class ProfileCard extends UIBaseElement<ProfileCardAssert> {

    private static final String IMAGES_LINK = ".v-image__image--cover";

    @JDIAction("'{name}' has avatar image")
    public boolean hasAvatarImage() {
        return finds(IMAGES_LINK).get(2).getAttribute("style").contains("url");
    }

    @JDIAction("'{name}' has background image")
    public boolean hasBackgroundImage() {
        return finds(IMAGES_LINK).get(1).getAttribute("style").contains("url");
    }

    @JDIAction("'{name}' has expected text in 'name' text field")
    public String hasName() {
        return find(".v-list-item__title").getText();
    }

    @JDIAction("'{name}' has expected text in 'job function' text field")
    public String hasJobFunction() {
        return find(".v-list-item__subtitle").getText();
    }

    public ProfileCardAssert is() {
        return new ProfileCardAssert().set(this);
    }

    public ProfileCardAssert has() {
        return this.is();
    }
}
