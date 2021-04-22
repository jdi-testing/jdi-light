package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.displaydata.TypographyPage.typographyTexts;

/**
 * To see an example of Typography web element please visit https://material-ui.com/components/typography/
 */


public class TypographyTests extends TestsInit {


    @BeforeMethod
    public void before() {
        openSection("Typography");
    }


    @Test
    public void typographyViewTest() {

        ArrayList<String> textField = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            textField.add("Head " + (i + 1));
        }
        textField.add("Subtitle 1");
        textField.add("Subtitle 2");
        textField.add("Body 1");
        textField.add("Body 2");
        textField.add("BUTTON TEXT");
        textField.add("Caption text");
        textField.add("OVERLINE TEXT");

        for (int i = 0; i < typographyTexts.size(); i++) {
            typographyTexts.get(i+1).has().text(textField.get(i));
        }

      /* typographyTexts.has().text("Head 1");
        typographyTexts.has().styleClass("h1");*/


    }
}
