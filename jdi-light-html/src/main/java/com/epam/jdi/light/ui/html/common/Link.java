package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.ui.html.common.utility.WithAlt;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;

public interface Link extends Button, WithAlt {
    default String getRef() { return getAttribute("href"); }
    default URL getUrl() {
        try { return new URL(getAttribute("href"));
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }}
}
