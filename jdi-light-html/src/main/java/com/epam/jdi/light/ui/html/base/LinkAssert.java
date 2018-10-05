package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.ui.html.common.Image;
import com.epam.jdi.light.ui.html.common.Link;
import org.hamcrest.Matcher;

import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LinkAssert extends IsAssert {
    Link link;
    public LinkAssert(Link link) { super(link); this.link = link; }

    public void src(Matcher<String> condition) { assertThat(link.getRef(), condition); }
    public void alt(Matcher<String> condition) { assertThat(link.getAlt(), condition); }

}
