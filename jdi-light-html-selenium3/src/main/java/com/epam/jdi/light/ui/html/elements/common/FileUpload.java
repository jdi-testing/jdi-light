package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.elements.common.Keyboard;
import com.jdiai.tools.Timer;

public class FileUpload extends Button {
    public void uploadFile(String filePath) {
        click();
        Timer.sleep(1000);
        Keyboard.pasteText(filePath);
    }
}
