package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JAppBar;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Tooltip web element please visit
 * https://material-ui.com/components/app-bar/
 */

public class AppBar extends Section implements ISetup {

    protected String rootLocator = "";
    protected By navigationButtonLocator = By.cssSelector(".MuiIconButton-edgeStart");
    protected By titleLocator = By.xpath("//*[contains(@class, 'MuiTypography-root')]");
    protected List<By> actionItemsLocators = new ArrayList<>();
    protected By overflowMenuButtonLocator = By.cssSelector(".MuiIconButton-edgeEnd");

    @JDIAction(value = "Get '{name}' navigation button")
    public UIElement getNavigationButton() {
        return core().find(navigationButtonLocator);
    }

    @JDIAction(value = "Get '{name}' title")
    public UIElement getTitle() {
        return core().find(titleLocator);
    }

    @JDIAction(value = "Get '{name}' action items")
    public WebList getActionItems() {
        List<UIElement> actionItemsList = new ArrayList<>();
        for (By by : actionItemsLocators) {
            actionItemsList.add(core().find(by));
        }
        return WebList.newList(actionItemsList);
    }

    @JDIAction(value = "Get '{name}' overflow menu button")
    public UIElement getOverflowMenuButton() {
        return core().find(overflowMenuButtonLocator);
    }

    @JDIAction(value = "Check that '{name}' is elevated")
    public void isElevated() {
        this.has().classValue(containsString("MuiPaper-elevation0"));
    }

    @JDIAction(value = "Check that '{name}' is not elevated")
    public void isNotElevated() {
        this.has().classValue(containsString("MuiPaper-elevation4"));
    }

    @Override
    public void setup(Field field) {
        if(!fieldHasAnnotation(field, JAppBar.class, AppBar.class)) {
            return;
        }
        JAppBar jAppBar = field.getAnnotation(JAppBar.class);
        if(isNotBlank(jAppBar.root())) {
            core().setLocator(NAME_TO_LOCATOR.execute(jAppBar.root()));
            this.rootLocator = jAppBar.root();
            this.navigationButtonLocator = NAME_TO_LOCATOR.execute(jAppBar.navigationButton());
            this.titleLocator = NAME_TO_LOCATOR.execute(jAppBar.title());

            if(jAppBar.actionItems().length != 0) {
                actionItemsLocators = new ArrayList<>();
                Arrays.stream(jAppBar.actionItems())
                        .forEach(actionItem -> actionItemsLocators.add(NAME_TO_LOCATOR.execute(actionItem)));
            }
            this.overflowMenuButtonLocator = NAME_TO_LOCATOR.execute(jAppBar.overflowMenuButton());
        }
    }
}
