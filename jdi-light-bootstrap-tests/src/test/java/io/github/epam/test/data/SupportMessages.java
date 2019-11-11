package io.github.epam.test.data;

import io.github.com.entities.SupportMessage;

public class SupportMessages {
    public static SupportMessage EXAMPLE_MESSAGE = getExampleMessage();
    public static SupportMessage TEMPLATE_MESSAGE = getTemplateMessage();

    private static SupportMessage getExampleMessage() {
        return new SupportMessage().set(field -> {
            field.supportEmail = "help-me.please@mail.org";
            field.supportMessage = "Nothing works! Nothing! Answer me, PLEASE!";
        });
    }

    private static SupportMessage getTemplateMessage() {
        return new SupportMessage().set(field -> {
            field.supportEmail = "";
            field.supportMessage = "";
        });
    }
}
