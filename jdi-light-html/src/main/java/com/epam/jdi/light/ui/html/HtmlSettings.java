package com.epam.jdi.light.ui.html;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.base.*;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import com.epam.jdi.light.ui.html.complex.RadioGroup;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.elements.init.InitActions.INIT_RULES;
import static com.epam.jdi.light.settings.WebSettings.initialized;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.pairs.Pair.$;

public class HtmlSettings {

    public static synchronized void init() {
        if (!initialized) {
            WebSettings.init();
            INIT_RULES.add(
                $(f -> isInterface(f, WebElement.class), info -> new HtmlElement()),
                $(f -> isInterface(f, HtmlChecklist.class), info -> new HtmlChecklist()),
                $(f -> isInterface(f, RadioGroup.class) || isInterface(f, RadioButtons.class),
                        info -> new HtmlRadioGroup()),
                $(f -> isInterface(f, BaseSelector.class), info -> new HtmlSelector()),
                $(f -> isInterface(f, BaseElement.class) , info -> new HtmlElement())
                );

        }
    }
}
