package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;

import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MessagesAssert<A, E extends HasMessages> extends VuetifyElement<E> {

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

    @JDIAction("Assert that number of {name}'s error messages is {0}")
    default A errorMessagesCount(int count) {
        Integer actualNumberOfErrorMessages = element().errorMessagesCount();
        jdiAssert(actualNumberOfErrorMessages, Matchers.equalTo(count), String.format("Actual number of error messages %s "
                + "is not equal to %s", actualNumberOfErrorMessages, count));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has error messages {0}")
    default A errorMessages(List<String> errorMessages) {
        List<String> actualErrorMessages = element().errorMessagesText();
        jdiAssert(actualErrorMessages, Matchers.equalTo(errorMessages), String.format("Actual element's messages %s "
                + "is not equal to expected messages %s", actualErrorMessages, errorMessages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has error messages {0}")
    default A errorMessage(String errorMessage) {
        jdiAssert(element().errorMessagesText().contains(errorMessage), Matchers.is(true), String.format("Actual element's error"
                + " messages %s doesn't contain expected message %s", element().errorMessagesText(), errorMessage));
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
                "Element has error messages");
        return (A) this;
    }

    @JDIAction("Assert that number of {name}'s success messages is {0}")
    default A successMessagesCount(int count) {
        Integer actualNumberOfSuccessMessages = element().successMessagesCount();
        jdiAssert(actualNumberOfSuccessMessages, Matchers.equalTo(count), String.format("Actual number of success messages %s "
                + "is not equal to %s", actualNumberOfSuccessMessages, count));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has success messages {0}")
    default A successMessages(List<String> successMessages) {
        jdiAssert(element().successMessagesText(), Matchers.equalTo(successMessages), String.format("Actual element's success"
                + " messages %s is not equal to expected messages %s", element().successMessagesText(), successMessages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has success message {0}")
    default A successMessage(String successMessage) {
        jdiAssert(element().successMessagesText().contains(successMessage), Matchers.is(true), String.format("Actual element's success"
                + " messages %s doesn't contain expected message %s", element().successMessagesText(), successMessage));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} messages text")
    default A messagesText(List<String> messages) {
        List<String> actualMessages = element().messagesText();
        jdiAssert(actualMessages, Matchers.is(messages),
                String.format("Actual messages: '%s', but expected: '%s'",
                        StringUtils.join(actualMessages, ", "), StringUtils.join(messages, ", ")));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} message text")
    default A messageText(String message) {
        messagesText(Collections.singletonList(message));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} messages")
    default A messagesCount(int count) {
        int actualMessagesCount = element().messagesCount();
        jdiAssert(actualMessagesCount, Matchers.is(count),
                String.format("Actual message count: '%s', but expected message count: '%s'",
                        actualMessagesCount, count));
        return (A) this;
    }
}
