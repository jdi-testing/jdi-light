package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.mobile.elements.pageobjects.annotations.JSite;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
class JDISite69 {
    @Url("/issue69/issue69.html")
    static IssuePage69 issuePage69;
}