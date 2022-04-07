package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.elements.common.Image;
import io.github.com.custom.asserts.ProfileCardAssert;

/**
 * Profile card contains avatar image, background image, username and job function.
 *
 * To see an example of Profile card web element please visit https://vuetifyjs.com/en/components/avatars/#profile-card
 */

public class ProfileCard extends UIBaseElement<ProfileCardAssert> {

    /**
     * Locators for avatar and background images, username and job function.
     */
    private static final String IMAGES_LOCATOR = ".v-image__image--cover";
    private static final String USERNAME_LOCATOR = ".v-list-item__title";
    private static final String JOB_FUNCTION_LOCATOR = ".v-list-item__subtitle";

    /**
     * Gets avatar image.
     * @return avatar image as {@link Image}
     */
    @JDIAction("Get '{name}'s avatar image")
    public Image avatarImage() {
        return new Image().setCore(Image.class, finds(IMAGES_LOCATOR).get(2));
    }

    /**
     * Gets background image.
     * @return background image as {@link Image}
     */
    @JDIAction("Get '{name}'s background image")
    public Image backgroundImage() {
        return new Image().setCore(Image.class, finds(IMAGES_LOCATOR).get(1));
    }

    /**
     * Gets avatar username.
     * @return avatar username as {@link String}
     */
    @JDIAction("Get '{name}'s username")
    public String username() {
        return find(USERNAME_LOCATOR).getText();
    }

    /**
     * Gets job function.
     * @return job function as {@link String}
     */
    @JDIAction("Get '{name}'s user's job function")
    public String userJobFunction() {
        return find(JOB_FUNCTION_LOCATOR).getText();
    }

    @Override
    public ProfileCardAssert is() {
        return new ProfileCardAssert().set(this);
    }

    public ProfileCardAssert has() {
        return is();
    }
}
