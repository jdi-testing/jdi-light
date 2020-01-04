package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class EmbeddedVideoModal extends Modal {

    @Frame("iframe")
    private EmbeddedVideoModalFrame videoModalFrameInModal;

    public EmbeddedVideoModalFrame getVideoModalFrame() {
        return this.videoModalFrameInModal;
    }

}
