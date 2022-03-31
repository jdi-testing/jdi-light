package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;

/**
 * Data transfer object from row in Data Table.
 */
public class WesterosUser extends Section {

    /**
     * 'ID' cell.
     */
    public UIElement id;

    /**
     * 'First name' cell.
     */
    public UIElement firstName;

    /**
     * 'Last name' cell.
     */
    public UIElement lastName;

    /**
     * 'Age' cell.
     */
    public UIElement age;

    /**
     * 'Full name' cell.
     */
    public UIElement fullName;
}
