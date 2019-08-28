package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.tools.func.JFunc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static io.github.epam.html.tests.issues.issue69.JDISite69.issuePage69;
import static org.testng.Assert.assertEquals;

public class IssueTest69 {
    static boolean first = true;
    @BeforeMethod
    public void before() {
        if (first) {
            initSite(JDISite69.class);
            SMART_SEARCH_LOCATORS.add("[ui=%s]");
            first = false;
        }
        issuePage69.shouldBeOpened();
    }
    public static JFunc<List<Paragraph>> func(JFunc<List<Paragraph>> p) {
        return p;
    }

    @DataProvider(name = "paragraphs")
    public static Object[][] paragraphs() {
        return new Object[][] {
            { func(()->issuePage69.template) },
            { func(()->issuePage69.paragraphs)},
            { func(()->issuePage69.templateList)},
            { func(()->issuePage69.paragraphsList)},
            { func(()->issuePage69.templateData)},
            { func(()->issuePage69.paragraphsData)},
        };
    }

    @Test(dataProvider = "paragraphs")
    public void issue69Tests(JFunc<List<Paragraph>> paragraphs) {
        Paragraph p = paragraphs.execute().get(0);
        assertEquals(p.toString(), "element_0_1,element_0_2,element_0_3");
    }

    ParagraphData expectedParagraph = new ParagraphData().set(p-> {
        p.paragraph="element_0_1"; p.paragraph2="element_0_2"; p.paragraph3="element_0_3";
    });
    @Test
    public void issue69DataTests() {
        ParagraphData p = issuePage69.templateData.getData(0);
        assertEquals(p, expectedParagraph);
    }
    @Test
    public void issue69DataParagraphTests() {
        ParagraphData p = issuePage69.paragraphsData.getData(0);
        assertEquals(p, expectedParagraph);
    }
}
