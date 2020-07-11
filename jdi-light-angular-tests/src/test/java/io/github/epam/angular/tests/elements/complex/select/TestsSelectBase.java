package io.github.epam.angular.tests.elements.complex.select;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.checkboxDisableSelect;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TestsSelectBase extends TestsInit {
    protected static final String PIZZA = "Pizza";
    protected static final String STEAK = "Steak";
    protected static final String TACOS = "Tacos";
    protected static final String AUDI = "Audi";
    protected static final String MERCEDES = "Mercedes";
    protected static final String SAAB = "Saab";
    protected static final String VOLVO = "Volvo";
    protected static final String OPTION_1 = "Option 1";
    protected static final String OPTION_2 = "Option 2";
    protected static final String OPTION_3 = "Option 3";
    protected static final String VALID_OPTION = "Valid option";
    protected static final String INVALID_OPTION = "Invalid option";
    protected static final String EXTRA_CHEESE = "Extra cheese";
    protected static final String MUSHROOM = "Mushroom";
    protected static final String ONION = "Onion";
    protected static final String PEPPERONI = "Pepperoni";
    protected static final String SAUSAGE = "Sausage";
    protected static final String TOMATO = "Tomato";

    @BeforeTest(alwaysRun = true)
    public static void beforeStartTest() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    protected void pickDisableSelectCheckboxAsUnchecked() {
        if (checkboxDisableSelect.isSelected()) {
            checkboxDisableSelect.uncheck();
        }
        checkboxDisableSelect.is().deselected();
    }

    protected void pickDisableSelectCheckboxAsChecked() {
        if (!checkboxDisableSelect.isSelected()) {
            checkboxDisableSelect.check();
        }
        checkboxDisableSelect.assertThat().selected();
    }
}
