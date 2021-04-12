package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.SearchStrategies.ANY_ELEMENT;
import static com.epam.jdi.light.common.TextTypes.LABEL;

/**
 * To see an example of RadioButtons in bootstrap please visit https://getbootstrap.com/docs/4.3/components/forms/#default-stacked
 */

public class RadioButtons extends com.epam.jdi.light.ui.html.elements.complex.RadioButtons {

    @Override
    public webList list() {
        webList radioBtnWebList = new webList(base()).setup(b -> b.setSearchRule("Any", ANY_ELEMENT))
                .setUIElementName(LABEL);
        // TODO REFACTOR
        //radioBtnWebList.setClickArea(ACTION_CLICK);
        return radioBtnWebList;
    }

    public webList list(JFunc1<WebElement, Boolean> searchRule, ElementArea elementArea) {
        webList radioBtnWebList = new webList(base()).setup(jdiB -> jdiB.setSearchRule("UNDEFINED", searchRule))
                .setUIElementName(LABEL);
        // TODO REFACTOR
        //radioBtnWebList.setClickArea(elementArea);
        return radioBtnWebList;
    }

}
