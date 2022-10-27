package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;
import java.util.stream.Collectors;

public interface HasMessages extends ICoreElement {

    /**
     * Get element messages.
     *
     * @return list of messages
     */

    @JDIAction("Get 'name' messages")
    default List<String> messages() {
        return core().finds(".v-messages__message").stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Get element messages count.
     *
     * @return count of messages
     */

    @JDIAction("Get 'name' messages count")
    default int messagesCount() {
        return messages().size();
    }


    /**
     * Checks if element has error or not.
     *
     * @return {@code true} if element has error, otherwise {@code false}
     */
    @JDIAction("Check that {name} has error messages")
    default boolean hasErrorMessages() {
        return core().hasClass("error--text");
    }

    /**
     * Checks if element has success or not.
     *
     * @return {@code true} if element has success, otherwise {@code false}
     */
    @JDIAction("Check that {name} has success messages")
    default boolean hasSuccessMessages() {
        return core().hasClass("success--text");
    }
}
