package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MessagesAssert<A, E extends HasMessages> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' has error messages")
    default A errorMessages() {
        jdiAssert(element().hasErrorMessages() ? "has error messages" : "has no error messages", Matchers.is("has error messages"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} error messages text")
    default A errorMessagesText(List<String> errorMessages) {
        jdiAssert(element().errorMessages().equals(errorMessages), Matchers.is(true),
                String.format("Actual: {%s}, but expected: {%s}", element().errorMessages(), errorMessages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} error messages")
    default A errorMessagesCount(int count) {
        jdiAssert(element().errorMessagesCount() == count, Matchers.is(true),
                String.format("Actual: {%s}, but expected: {%s}", element().errorMessagesCount(), count));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has success messages")
    default A successMessages() {
        jdiAssert(element().hasSuccessMessages() ? "has success messages" : "has no success messages", Matchers.is("has success messages"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} success messages text")
    default A successMessagesText(List<String> successMessages) {
        jdiAssert(element().successMessages().equals(successMessages), Matchers.is(true), String.format("Actual: {%s}, but expected: {%s}", element().successMessages(), successMessages));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has {0} success messages")
    default A successMessagesCount(int count) {
        jdiAssert(element().successMessagesCount() == count, Matchers.is(true),
                String.format("Actual: {%s}, but expected: {%s}", element().successMessagesCount(), count));
        return (A) this;
    }
}
