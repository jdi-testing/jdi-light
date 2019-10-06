package io.github.com.sections;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

import java.util.List;

public class ProgressBarInList extends Section {
    @UI(".progress-bar")
    public Progress progress;
}
