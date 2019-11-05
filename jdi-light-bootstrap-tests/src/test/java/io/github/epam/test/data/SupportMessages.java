package io.github.epam.test.data;

import io.github.com.entities.SupportMessage;

public class SupportMessages {
    public static SupportMessage EXAMPLE_MESSAGE = getExampleMessage();

    private static SupportMessage getExampleMessage() {
        return new SupportMessage().set(field -> {
            field.supportInputEmail = "help-me.please@mail.org";
            field.supportTextArea = "Nothing works! Nothing! Answer me, PLEASE!";
        });
    }
}
