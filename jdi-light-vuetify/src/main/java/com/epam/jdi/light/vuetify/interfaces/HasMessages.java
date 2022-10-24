package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;
import java.util.stream.Collectors;

public interface HasMessages extends ICoreElement {

    /**
     * Get element error messages.
     *
     * @return list of error messages
     */

    @JDIAction("Get 'name' error messages")
    default List<String> errorMessages() {
        return core().finds(".error--text .v-messages__message").stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Get element error messages count.
     *
     * @return count of error messages
     */

    @JDIAction("Get 'name' error messages count")
    default int errorMessagesCount() {
        return errorMessages().size();
    }


    /**
     * Checks if element has error or not.
     *
     * @return {@code true} if element has error, otherwise {@code false}
     */
    @JDIAction("Check that {name} has error")
    default boolean hasErrorMessages() {
        return core().hasClass("error--text");
    }

    /**
     * Get element success messages.
     *
     * @return list of success messages
     */

    @JDIAction("Get 'name' success messages")
    default List<String> successMessages() {
        return core().finds(".success--text .v-messages__message").stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Checks if element has success or not.
     *
     * @return {@code true} if element has success, otherwise {@code false}
     */
    @JDIAction("Check that {name} has success")
    default boolean hasSuccessMessages() {
        return core().hasClass("success--text");
    }

    /**
     * Get element success messages count.
     *
     * @return count of success messages
     */

    @JDIAction("Get 'name' success messages count")
    default int successMessagesCount() {
        return successMessages().size();
    }
}
