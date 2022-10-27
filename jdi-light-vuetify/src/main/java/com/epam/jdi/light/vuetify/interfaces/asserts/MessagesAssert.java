package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MessagesAssert<A, E extends HasMessages> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' has error messages")
    default A errorMessages() {
        jdiAssert(element().hasErrorMessages() ? "has error messages" : "has no error messages", Matchers.is("has error messages"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has no error messages")
    default A noErrorMessages() {
        jdiAssert(element().hasErrorMessages() ? "has error messages" : "has no error messages", Matchers.is("has no error messages"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has success messages")
    default A successMessages() {
        jdiAssert(element().hasSuccessMessages() ? "has success messages" : "has no success messages", Matchers.is("has success messages"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has no success messages")
    default A noSuccessMessages() {
        jdiAssert(element().hasSuccessMessages() ? "has success messages" : "has no success messages", Matchers.is("has no success messages"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} messages text")
    default A messagesText(List<String> messages) {
        jdiAssert(element().messages().equals(messages), Matchers.is(true),
                String.format("Actual messages: {%s}, but expected messages: {%s}",
                        element().messages(), messages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} messages")
    default A messagesCount(int count) {
        jdiAssert(element().messagesCount() == count, Matchers.is(true),
                String.format("Actual message count: {%s}, but expected message count: {%s}",
                        element().messagesCount(), count));
        return (A) this;
    }
}
