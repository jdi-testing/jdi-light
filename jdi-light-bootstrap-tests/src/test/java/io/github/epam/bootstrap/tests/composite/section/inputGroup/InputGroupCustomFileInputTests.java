package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.customFileInput1;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Olga Ivanova on 19.09.2019
 * Email: olga_ivanova@epam.com
 */

public class InputGroupCustomFileInputTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    public final static String UPLOAD_TEXT = "Upload";
    public final static String INPUT_FIELD = "Browser";
    public final static String LABEL_TEXT = "Choose file";

    //customFileInput1
    //customFileInput12
    @Test
    public void isValidationOptionsSectionTests() {


        customFileInput1.uploadTextBefore.is().text(UPLOAD_TEXT);
        customFileInput1.uploadTextBefore.is().value(UPLOAD_TEXT);

        customFileInput1.labelText.is().text(LABEL_TEXT);
        customFileInput1.labelText.is().value(LABEL_TEXT);

        customFileInput1.inputFiled.click();
      //  customFileInput1.inputFiled.is().value(INPUT_FIELD);



/*      customFileInput1.optionText.is().text(optionText);
        customSelect.optionText.is()
                .core()
                .hasClass("input-group-prepend")
                .css("font-size", is("14px"))
                .tag("div");*/
    }

    @Test
    public void selectorByIndexTests() {
/*        customSelect.selector.is().selected(selectChoose);
        customSelect.selector.select(2);
        customSelect.selector.is().selected(selectOne);
        customSelect.selector.select(3);
        customSelect.selector.is().selected(selectTwo);
        customSelect.selector.select(4);
        customSelect.selector.is().selected(selectThree);
        customSelect.selector.select(1);
        customSelect.selector.is().selected(selectChoose);*/
    }

    @Test(priority = 1)
    public void selectorByValueTests() {
/*        customSelect.selector.is().selected(selectChoose);
        customSelect.selector.select(selectOne);
        customSelect.selector.is().selected(selectOne);
        customSelect.selector.select(selectTwo);
        customSelect.selector.is().selected(selectTwo);
        customSelect.selector.select(selectThree);
        customSelect.selector.is().selected(selectThree);*/
    }

    @Test
    public void selectorIsValidationTests() {
/*        customSelect.selector.is().displayed()
                .enabled()
                .core()
                .hasClass("custom-select")
                .css("font-size", is("16px"));;
        customSelect.selector.is().size(4);*/
    }
}
