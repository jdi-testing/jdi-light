package com.epam.jdi.light.ui.html.common;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;

public interface Link extends Button {
    default String getRef() { return getAttribute("href"); }
    default URL getUrl() {
        try { return new URL(getAttribute("href"));
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }}
    default String getAlt() { return getAttribute("alt"); }
}
