package io.github.com.sections.modal;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;

public class EmbeddedVideoModalFrame extends Section {
    @UI(".ytp-title-link")
    private Link title;

    @UI(".ytp-progress-bar")
    private UIElement progressBar;

    @UI(".ytp-large-play-button")
    private Button playButton;

    public Link getVideoTitle() {
        return title;
    }

    public UIElement getProgressBar() {
        return progressBar;
    }

    public Button getPlayButton() {
        return playButton;
    }

}
