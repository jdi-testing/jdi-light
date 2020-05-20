package cucumberTests;

import cucumber.api.java.Before;
import io.qameta.allure.model.Label;
import io.qameta.allure.util.ResultsUtils;

import java.util.List;

import static io.qameta.allure.Allure.getLifecycle;


public class CucumberHooks {

    private final Label parentSuiteLabel = ResultsUtils.createParentSuiteLabel("JDI-Light BDD");
    private final Label suiteLabel = ResultsUtils.createSuiteLabel("Tests");

    @Before
    public void beforeTest() {
        String uuid = getLifecycle().getCurrentTestCase().get();
        getLifecycle().updateTestCase(uuid, testResult -> {
            List<Label> labels = testResult.getLabels();
            labels.stream()
                    .filter(label -> label.getName().equals("suite"))
                    .forEach(label -> label.setName("subSuite"));
            labels.add(parentSuiteLabel);
            labels.add(suiteLabel);
            testResult.setLabels(labels);
        });
    }
}
