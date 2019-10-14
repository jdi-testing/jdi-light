package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.gridModalSection;
import static io.github.com.pages.BootstrapPage.progressSections;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;


/**
 * Created by Aleksandr Shiganov on 14.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class gridModalTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] progressData() {
        return new Object[][]{
                {"striped_ordinary", "10", "rgba(0, 123, 255, 1)", "0", "100", "progress-bar-striped"},
                {"striped_success", "25", "rgba(40, 167, 69, 1)", "0", "100", "progress-bar-striped"},
                {"striped_info", "50", "rgba(23, 162, 184, 1)", "0", "100", "progress-bar-striped"},
                {"striped_warning", "75", "rgba(255, 193, 7, 1)", "0", "100", "progress-bar-striped"},
                {"striped_danger", "100", "rgba(220, 53, 69, 1)", "0", "100", "progress-bar-striped"}
        };
    }

    @Test(dataProvider = "progressData")
    public void checkProgressData(String progressId, String value, String color,
                                  String min, String max, String classStriped) {

        progressSections.stream().filter(progressSection ->
                progressSection.progress.attr("id").equals(progressId)).forEach(
                progressSection -> {
                    progressSection.progress.is().core().hasClass(classStriped);
                    progressSection.progress.is().ariaValue(value)
                            .color(color)
                            .minValue(min)
                            .maxValue(max);
                });
    }





    @DataProvider
    public static Object[][] baseModalValidationElementsData() {
        return new Object[][]{
                {"gridModalLabel"},
                {"save-modal"},
                {"close-modal"},
                {"close-modal-cross"}
        };
    }

    @Test(dataProvider = "baseModalValidationElementsData")
    public void baseModalElementsValidationTest(String elementId) {

        if (!gridModalSection.gridModal.isOpen()) {
            gridModalSection.btnOpenGridModal.click();
        }
        gridModalSection.gridModal.childs().stream().
                    filter(uiElement -> uiElement.attr("id").equals(elementId)).forEach(
                    e -> {
                        e.highlight();
                        baseValidation(e);
                        e.unhighlight();
                    }
            );
        }
}

