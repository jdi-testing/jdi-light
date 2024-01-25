package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;

import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MessagesAssert<A, E extends HasMessages> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' has error messages")
    default A errorMessages() {
        jdiAssert(element().hasErrorMessages(), Matchers.is(true),
                "Element does not have error messages");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has no error messages")
    default A noErrorMessages() {
        jdiAssert(element().hasErrorMessages(), Matchers.is(false),
                "Element has error messages");
        return (A) this;
    }

    @JDIAction("Assert that number of {name} error messages is '{0}'")
    default A errorMessagesCount(int count) {
        jdiAssert(element().errorMessagesCount(), Matchers.equalTo(count));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has error messages '{0}'")
    default A errorMessages(List<String> errorMessages) {
        jdiAssert(element().errorMessagesText(), Matchers.equalTo(errorMessages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has error messages '{0}'")
    default A errorMessage(String errorMessage) {
        jdiAssert(element().errorMessagesText(), Matchers.contains(errorMessage));
        return (A) this;
    }


    @JDIAction("Assert that '{name}' has success messages")
    default A successMessages() {
        jdiAssert(element().hasSuccessMessages(), Matchers.is(true),
                "Element does not have success messages");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has no success messages")
    default A noSuccessMessages() {
        jdiAssert(element().hasSuccessMessages(), Matchers.is(false),
                "Element has success messages");
        return (A) this;
    }

    @JDIAction("Assert that number of {name}'s success messages is '{0}'")
    default A successMessagesCount(int count) {
        jdiAssert(element().successMessagesCount(), Matchers.equalTo(count));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has success messages '{0}'")
    default A successMessages(List<String> successMessages) {
        jdiAssert(element().successMessagesText(), Matchers.equalTo(successMessages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has success message '{0}'")
    default A successMessage(String successMessage) {
        jdiAssert(element().successMessagesText(), Matchers.contains(successMessage));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} messages text")
    default A messagesText(List<String> messages) {
        jdiAssert(element().messagesText(), Matchers.is(messages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has message text '{0}'")
    default A messageText(String message) {
        messagesText(Collections.singletonList(message));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has messages '{0}'")
    default A messagesCount(int count) {
        jdiAssert(element().messagesCount(), Matchers.is(count));
        return (A) this;
    }
}
