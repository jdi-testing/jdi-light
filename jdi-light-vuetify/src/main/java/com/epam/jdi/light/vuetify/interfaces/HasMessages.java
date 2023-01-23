package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface <code>HasMessages</code> includes methods to get and check element messages.
 */
public interface HasMessages extends ICoreElement {

    /**
     * Get element messages.
     *
     * @return list of messages
     */
    @JDIAction("Get '{name}' messages")
    default List<UIElement> messages() {
        return messages(".v-messages__message");
    }

	@JDIAction("Get '{name}' messages text by locator '{0}'")
	default List<UIElement> messages(String locator) {
		return core().finds(locator);
	}

	/**
	 * Get element's messages text by locator.
	 *
	 * @return list of messages text
	 */
	@JDIAction("Get '{name}' messages text by locator '{0}'")
	default List<String> messagesText(String locator) {
		return messages(locator).stream().map(UIElement::getText).collect(Collectors.toList());
	}

    /**
     * Get element messages text.
     *
     * @return list of messages text
     */
    @JDIAction("Get '{name}' messages text")
    default List<String> messagesText() {
        return messagesText(".v-messages__message");
    }

    /**
     * Get element messages count.
     *
     * @return count of messages
     */
    @JDIAction("Get '{name}' messages count")
    default int messagesCount() {
        return messagesText().size();
    }


    /**
     * Checks if element has error messages.
     *
     * @return {@code true} if element has error messages, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has error messages")
    default boolean hasErrorMessages() {
        return errorMessagesCount() > 0;
    }

    /**
     * Get element's error messages.
     *
     * @return list of error messages
     */
	@JDIAction("Get '{name}' error messages")
    default List<String> errorMessagesText() {
        return messagesText(".error--text .v-messages__message");
    }

    /**
     * Get element's error messages count.
     *
     * @return count of error messages
     */
     @JDIAction("Get the number of '{name}' error messages")
     default int errorMessagesCount() {
        return errorMessagesText().size();
    }

    /**
     * Checks if element has success messages.
     *
     * @return {@code true} if element has success messages, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has success messages")
    default boolean hasSuccessMessages() {
        return successMessagesCount() > 0;
    }

    /**
     * Get element's success messages.
     *
     * @return list of success messages
     */
    @JDIAction("Get '{name}' success messages")
    default List<String> successMessagesText() {
        return messagesText(".success--text .v-messages__message");
    }

    /**
     * Get element's success messages count.
     *
     * @return count of success messages
     */
    @JDIAction("Get the number of '{name}' success messages")
    default int successMessagesCount() {
        return successMessagesText().size();
    }
}
