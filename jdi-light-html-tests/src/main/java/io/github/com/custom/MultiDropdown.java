package io.github.com.custom;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;

public class MultiDropdown extends Dropdown {
//
//    /**
//     * Closing DropDown
//     */
//    @JDIAction(level = DEBUG)
//    public void close() {
//        if (expander != null) {
//            if (isExpanded())
//                expander.click();
//        }
//        else { try { core().click(); }
//        catch (Throwable ignore) {
//            assertLinked(expander, "expander", "close");
//        }
//        }
//    }
//
//    /**
//     * Get the element text
//     * @return String text
//     */
//    @JDIAction(level = DEBUG)
//    public String selected() {
//        return getText();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        if (list() == null || expander == null)
//            return ds().isEnabled();
//        expand();
//        return list().listEnabled().size() > 0;
//    }
//
//    @JDIAction("Check that '{name}' is displayed")
//    public boolean isDisplayed() {
//        return ds().isDisplayed() || value.isDisplayed();
//    }
//
//    public void highlight(String color) {
//        core().highlight(color);
//    }
//    public void highlight() {
//        core().highlight();
//    }
//    public void show() {
//        core().show();
//    }
//
//    public boolean wait(JFunc1<Dropdown, Boolean> condition) {
//        return base().timer().wait(() -> condition.execute(this));
//    }
//
//    public boolean selected(String option) {
//        return selected().equals(option);
//    }
//
//    @JDIAction("Get '{name}' values")
//    public List<String> values() {
//        if (list() != null && list().size() > 0)
//            return list().values();
//        if (list() == null && core().getTagName().contains("select"))
//            return ds().values();
//        if (!list().hasAny(UIElement::isDisplayed))
//            click();
//        List<String> result = list().values();
//        if (list().hasAny(UIElement::isDisplayed))
//            click();
//        return result;
//    }
//
//    /**
//     * Get values as text of the specific type
//     * @return List
//     */
//    @JDIAction("Get '{name}' values")
//    public List<String> values(TextTypes type) {
//        List<String> result = new ArrayList<>();
//        if (list() == null && core().getTagName().contains("select"))
//            return ds().values(type);
//        if (list() != null) {
//            if (!list().hasAny(UIElement::isDisplayed))
//                click();
//            result = list().values(type);
//            if (list().hasAny(UIElement::isDisplayed))
//                click();
//        }
//        return result;
//    }
//    public List<String> listEnabled() {
//        return list() != null
//                ? list().listEnabled()
//                : ds().listEnabled();
//    }
//
//    public List<String> listDisabled() {
//        return list() != null
//                ? list().listDisabled()
//                : ds().listDisabled();
//    }
//
//    protected void assertLinked(Object element, String name, String actionName) {
//        if (element == null)
//            throw exception(format("You must specify '%s' in Dropdown annotation in order to perform %s action", name ,actionName));
//    }

}
