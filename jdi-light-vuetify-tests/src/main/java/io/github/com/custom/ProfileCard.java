package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.elements.common.Image;
import io.github.com.custom.asserts.ProfileCardAssert;

/**
 * Represents profile card Vuetify component on GUI.
 * Profile card contains avatar image, background image, username and job function.
 *
 * @see <a href="https://vuetifyjs.com/en/components/avatars/#profile-card">Profile Card Vuetify documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/">Vuetify test page</a>
 */

public class ProfileCard extends UIBaseElement<ProfileCardAssert> {

    private static final String IMAGES_LOCATOR = ".v-image__image--cover";
    private static final String USERNAME_LOCATOR = ".v-list-item__title";
    private static final String JOB_FUNCTION_LOCATOR = ".v-list-item__subtitle";

    /**
     * Gets avatar image.
     *
     * @return avatar image as {@link Image}
     */
    @JDIAction("Get '{name}' avatar image")
    public Image avatarImage() {
        return new Image().setCore(Image.class, core().finds(IMAGES_LOCATOR).get(2));
    }

    /**
     * Gets background image.
     *
     * @return background image as {@link Image}
     */
    @JDIAction("Get '{name}' background image")
    public Image backgroundImage() {
        return new Image().setCore(Image.class, core().finds(IMAGES_LOCATOR).get(1));
    }

    /**
     * Gets avatar username.
     *
     * @return avatar username as {@link String}
     */
    @JDIAction("Get '{name}' username")
    public String username() {
        return core().find(USERNAME_LOCATOR).getText();
    }

    /**
     * Gets job function.
     *
     * @return job function as {@link String}
     */
    @JDIAction("Get '{name}' user job function")
    public String userJobFunction() {
        return core().find(JOB_FUNCTION_LOCATOR).getText();
    }

    @Override
    public ProfileCardAssert is() {
        return new ProfileCardAssert().set(this);
    }
}
