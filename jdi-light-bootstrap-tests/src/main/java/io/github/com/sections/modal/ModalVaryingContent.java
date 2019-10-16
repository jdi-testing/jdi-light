package io.github.com.sections.modal;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextArea;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalVaryingContent extends Modal {

    @UI(".modal-header .close")
    public Button closeX;
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
