package io.github.epam.html.tests.issue.issue69;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/issue69/")
class JDISite69 {
    @Url("issue69.html")
    static IssuePage69 issuePage69;
}