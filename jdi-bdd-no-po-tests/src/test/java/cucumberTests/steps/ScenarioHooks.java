package cucumberTests.steps;

import cucumber.api.java.After;

import static com.epam.jdi.light.elements.init.UIFactory.$;


public class ScenarioHooks {
    @After
    public static void closeDriver() {
        $("img#user-icon").driver().quit();
    }
}

