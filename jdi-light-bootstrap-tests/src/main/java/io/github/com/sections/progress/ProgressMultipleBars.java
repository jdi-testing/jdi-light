package io.github.com.sections.progress;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

/**
 * Created by Roman Bordiugov on 7.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class ProgressMultipleBars extends Section {

    @UI("#progress-multiple-ordinary")
    public Progress multipleOrdinary;

    @UI("#progress-multiple-success")
    public Progress multipleSuccess;

    @UI("#progress-multiple-info")
    public Progress multipleInfo;
}
