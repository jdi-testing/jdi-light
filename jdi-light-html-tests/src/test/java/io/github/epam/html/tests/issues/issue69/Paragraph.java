package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.elements.common.Button;

import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class Paragraph extends Section {
    public Button paragraph;
    public Button paragraph2;
    public Button paragraph3;

    @Override
    public String toString() {
        return print(asList(paragraph.getText(),
                paragraph2.getText(),
                paragraph3.getText()));
    }
}