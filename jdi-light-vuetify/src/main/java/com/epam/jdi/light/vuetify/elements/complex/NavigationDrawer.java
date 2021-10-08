package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.NavigationDrawerAssert;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see an example of Banner web element please visit https://jdi-testing.github.io/jdi-light/vuetify/navigation-drawers
 *
 * From vuetify docs: "The v-navigation-drawer component is what your users will utilize to navigate
 * through the application. "
 *
 */

public class NavigationDrawer extends UIBaseElement<NavigationDrawerAssert> {

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public NavigationDrawerAssert is() {
        return new NavigationDrawerAssert().set(this);
    }

    public NavigationDrawerAssert has() {
        return this.is();
    }
}
