package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.displaydata.TypographyPage.typographyTexts;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Typography web element please visit https://material-ui.com/components/typography/
 */


public class TypographyTests extends TestsInit {


    @BeforeMethod
    public void before() {
        openSection("Typography");
    }


    @Test
    public void typographyTextTest() {

        List<String> textFields = Arrays.asList("Head 1", "Head 2", "Head 3", "Head 4", "Head 5", "Head 6",
                "Subtitle 1", "Subtitle 2", "Body 1", "Body 2", "BUTTON TEXT", "Caption text", "OVERLINE TEXT");

        List<String> typographyClasses = Arrays.asList("MuiTypography-h1", "MuiTypography-h2", "MuiTypography-h3",
                "MuiTypography-h4", "MuiTypography-h5", "MuiTypography-h6", "MuiTypography-subtitle1",
                "MuiTypography-subtitle2", "MuiTypography-body1", "MuiTypography-body2", "MuiTypography-button",
                "MuiTypography-caption", "MuiTypography-overline");

        for (Text typographyText : typographyTexts) {
            Assert.assertTrue(textFields.contains(typographyText.getText()));
        }

        for (int i = 0; i < typographyTexts.size(); i++) {
            typographyTexts.get(i + 1).has().classValue(containsString(typographyClasses.get(i)));
        }
    }
}
