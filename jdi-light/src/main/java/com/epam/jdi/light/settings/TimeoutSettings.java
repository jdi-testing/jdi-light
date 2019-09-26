package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.Timeout;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TimeoutSettings {
    public static Timeout TIMEOUT = new Timeout(10);
    public static Timeout PAGE_TIMEOUT = new Timeout(30);
}
