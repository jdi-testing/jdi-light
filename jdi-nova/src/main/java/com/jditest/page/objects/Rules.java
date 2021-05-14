package com.jditest.page.objects;

import com.epam.jdi.tools.map.MapArray;
import com.jditest.DataList;
import com.jditest.JDI;
import com.jditest.JS;
import com.jditest.interfaces.HasCore;
import com.jditest.interfaces.HasName;
import com.jditest.interfaces.ISetup;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.jditest.page.objects.CreateRule.cRule;
import static com.jditest.page.objects.PageFactory.initPageElements;
import static com.jditest.page.objects.PageFactoryRules.*;
import static com.jditest.page.objects.SetupRule.sRule;

public class Rules {
    public static MapArray<String, CreateRule> CREATE_RULES = map(
        $("WebElement", cRule(WebElement.class, cl -> new JS())),
        $("List", cRule(List.class, cl -> new DataList<>()))
    );
    public static MapArray<String, SetupRule> SETUP_RULES = map(
        $("JSElement", sRule(HasCore.class, info -> {
            JS core = new JS(JDI::driver, GET_LOCATOR.execute(info.field), info.parent);
            ((HasCore) info.instance).setCore(core);
        })),
        $("Name", sRule(HasName.class,
            info -> ((HasName) info.instance).setName(GET_NAME.execute(info.field)))),
        $("UI Object", sRule(info -> IS_UI_OBJECT.execute(info.field),
            info -> initPageElements(info.instance))),
        $("Setup", sRule(ISetup.class, info -> ((ISetup)info.instance).setup(info.field)))
    );

}
