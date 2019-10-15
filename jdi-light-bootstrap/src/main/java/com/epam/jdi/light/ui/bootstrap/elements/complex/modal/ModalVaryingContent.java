package com.epam.jdi.light.ui.bootstrap.elements.complex.modal;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextArea;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class ModalVaryingContent extends Modal {

    @UI("label[for='recipient-name']")
    public Label recipientLabel;
    @UI("#recipient-name")
    public TextField recipientTextField;
    @UI("label[for='message-text']")
    public Label messageLabel;
    @UI("#message-text")
    public TextArea messageTextArea;
    @ByText("Close")
    public Button closeButton;
    @ByText("Send message")
    public Button sendMessageButton;
}
