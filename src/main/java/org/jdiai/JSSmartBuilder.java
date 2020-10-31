package org.jdiai;

import org.jdiai.interfaces.IBuilderActions;
import org.openqa.selenium.WebDriver;

public class JSSmartBuilder extends JSBuilder {
    public JSSmartBuilder(WebDriver driver) {
        this(driver, null);
    }
    public JSSmartBuilder(WebDriver driver, IBuilderActions builderActions) {
        super(driver, builderActions);
        this.builderActions = builderActions != null
                ? builderActions
                : new SmartBuilderActions(this);
    }


}
