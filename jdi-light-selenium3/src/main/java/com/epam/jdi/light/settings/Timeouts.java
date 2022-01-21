package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.Timeout;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Timeouts {
    public Timeout element = new Timeout(5);
    public Timeout page = new Timeout(20);
    public Timeouts() { }

    public Timeouts(int elementTimeout, int pageTimeout) {
        this.element = new Timeout(elementTimeout);
        this.page = new Timeout(pageTimeout);
    }
}
