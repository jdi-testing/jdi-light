package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.Timeout;

public class TimeoutSettings {
    public static ThreadLocal<Timeout> TIMEOUT = new ThreadLocal<>();
    public static ThreadLocal<Timeout> PAGE_TIMEOUT = new ThreadLocal<>();

}
