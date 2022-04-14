package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JAppBar;
import com.epam.jdi.light.ui.html.elements.common.Text;
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
 * Represents app bar MUI component on GUI. The app bar displays information and actions relating to the current screen.
 *
 * @see <a href="https://mui.com/components/app-bar/">App bar MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class AppBar extends Section implements ISetup {

    /**
     * Locator for the navigation button element.
     */
    protected By navigationButtonLocator;

    /**
     * Locator for the title element.
     */
    protected By titleLocator;

    /**
     * Locator for the action item elements.
     */
    protected List<By> actionItemsLocators = new ArrayList<>();

    /**
     * Locator for the overflow menu button element.
     */
    protected By overflowMenuButtonLocator;

    /**
     * Gets a navigation button.
     *
     * @return navigation button as {@link UIElement}
     */
    @JDIAction(value = "Get '{name}' navigation button")
    public UIElement navigationButton() {
        return core().find(navigationButtonLocator);
    }

    /**
     * Gets a title.
     *
     * @return title as {@link Text}
     */
    @JDIAction(value = "Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, find(titleLocator));
    }

    /**
     * Gets list of action items. Each element of the list is a {@link UIElement}.
     *
     * @return items as {@link WebList}
     */
    @JDIAction(value = "Get '{name}' action items")
    public WebList actionItems() {
        List<UIElement> actionItemsList = new ArrayList<>();
        for (By by : actionItemsLocators) {
            actionItemsList.add(core().find(by));
        }
        return WebList.newList(actionItemsList);
    }

    /**
     * Gets an overflow menu button.
     *
     * @return overflow menu button as {@link UIElement}
     */
    @JDIAction(value = "Get '{name}' overflow menu button")
    public UIElement overflowMenuButton() {
        return core().find(overflowMenuButtonLocator);
    }

    /**
     * Checks that the app bar is elevated.
     */
    @JDIAction(value = "Check that '{name}' is elevated")
    public void isElevated() {
        this.has().classValue(containsString("MuiPaper-elevation0"));
    }

    /**
     * Checks that the app bar is elevated.
     */
    @JDIAction(value = "Check that '{name}' is not elevated")
    public void isNotElevated() {
        this.has().classValue(containsString("MuiPaper-elevation4"));
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JAppBar.class, AppBar.class)) {
            return;
        }
        JAppBar jAppBar = field.getAnnotation(JAppBar.class);
        if (isNotBlank(jAppBar.root())) {
            core().setLocator(NAME_TO_LOCATOR.execute(jAppBar.root()));
            this.navigationButtonLocator = NAME_TO_LOCATOR.execute(jAppBar.navigationButton());
            this.titleLocator = NAME_TO_LOCATOR.execute(jAppBar.title());
            this.overflowMenuButtonLocator = NAME_TO_LOCATOR.execute(jAppBar.overflowMenuButton());
            if (jAppBar.actionItems().length != 0) {
                actionItemsLocators = new ArrayList<>();
                Arrays.stream(jAppBar.actionItems())
                    .forEach(actionItem -> actionItemsLocators.add(NAME_TO_LOCATOR.execute(actionItem)));
            }
        }
    }
}
