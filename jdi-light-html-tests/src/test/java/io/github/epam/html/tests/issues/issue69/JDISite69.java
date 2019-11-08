package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
class JDISite69 {
    @Url("/issue69/issue69.html")
    protected static IssuePage69 issuePage69;
}