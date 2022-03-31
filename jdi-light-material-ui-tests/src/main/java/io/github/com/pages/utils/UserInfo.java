package io.github.com.pages.utils;

import com.jdiai.tools.DataClass;

/**
 * Data transfer object from row in Data table.
 */
public class UserInfo extends DataClass<UserInfo> {

    /**
     * 'ID' cell.
     */
    public String id;

    /**
     * 'First name' cell.
     */
    public String firstName;

    /**
     * 'Last name' cell.
     */
    public String lastName;

    /**
     * 'Age' cell.
     */
    public String age;

    /**
     * 'Full name' cell.
     */
    public String fullName;
}
