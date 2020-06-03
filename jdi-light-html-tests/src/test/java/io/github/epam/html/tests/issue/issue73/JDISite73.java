package io.github.epam.html.tests.issue.issue73;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/issue73/")
public class JDISite73 {
    @Url("issue73.html")
    public static IssuePage73 issuePage73;
}