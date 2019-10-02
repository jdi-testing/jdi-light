package io.github.com.sections.progress;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

public class ProgressBase extends Progress {
    @UI("#progress-bar-base-width-0") public Progress progress0;
    @UI("#progress-bar-base-width-0 .progress-bar") public Progress width0;

    @UI("#progress-bar-base-width-25") public Progress progress25;
    @UI("#progress-bar-base-width-25 .progress-bar") public Progress width25;

    @UI("#progress-bar-base-width-50") public Progress progress50;
    @UI("#progress-bar-base-width-50 .progress-bar") public Progress width50;

    @UI("#progress-bar-base-width-75") public Progress progress75;
    @UI("#progress-bar-base-width-75 .progress-bar") public Progress width75;

    @UI("#progress-bar-base-width-100") public Progress progress100;
    @UI("#progress-bar-base-width-100 .progress-bar") public Progress width100;
}
