package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.FileInputBootstrap;
import com.epam.jdi.light.ui.html.elements.common.FileInput;


public class InputFileSection extends Section {
@UI("label")
public Label labelInputFile;
@UI("input")
public FileInput fileInput;
@UI("input")
public FileInputBootstrap fileInputBootstrap;
}
