package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.Smart;
import com.epam.jdi.light.ui.html.elements.common.Button;

import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class Paragraph extends Section {
    @Smart("ui") public Button paragraph;
    @Smart("ui") public Button paragraph2;
    @Smart("ui") public Button paragraph3;

    @Override
    public String toString() {
        return print(asList(paragraph.getText(),
                paragraph2.getText(),
                paragraph3.getText()));
    }
}