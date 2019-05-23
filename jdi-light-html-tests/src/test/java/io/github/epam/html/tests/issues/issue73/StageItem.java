package io.github.epam.html.tests.issues.issue73;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.common.TextField;

class StageItem extends Section {

    //@UI("[id='stageTitle']")
    //@UI(".stageTitle")
    private TextField stageTitle;

    void AddBefore(){
        stageTitle.hover();
    }
}
