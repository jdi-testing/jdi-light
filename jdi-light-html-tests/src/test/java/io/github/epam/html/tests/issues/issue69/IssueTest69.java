package io.github.epam.html.tests.issues.issue69;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.init.PageFactory.*;
import static io.github.epam.html.tests.issues.issue69.IssuePage69.*;
import static io.github.epam.html.tests.issues.issue69.JDISite69.*;
import static org.testng.Assert.*;

public class IssueTest69 {
    static boolean first = true;
    @BeforeMethod
    public void before() {
        if (first) {
            initSite(JDISite69.class);
            first = false;
        }
        issuePage69.shouldBeOpened();
    }

    @Test(dataProvider = "paragraphs")
    public void issue69Tests(String paragraphName) {
        int index = paragraphName.contains("template") ? 1 : 2;
        Paragraph p = paragraph(paragraphName).get(index);
        assertEquals(p.toString(), "element_1_1,element_1_2,element_1_3");
    }

    ParagraphData expectedParagraph = new ParagraphData().set(p-> {
        p.paragraph="element_1_1"; p.paragraph2="element_1_2"; p.paragraph3="element_1_3";
    });
    @Test
    public void issue69DataTests() {
        ParagraphData p = templateData.getData(1);
        assertEquals(p, expectedParagraph);
    }
    @Test
    public void issue69DataParagraphTests() {
        ParagraphData p = paragraphsData.getData(2);
        assertEquals(p, expectedParagraph);
    }


    // region DataProvider
    public static List<Paragraph> paragraph(String paragraph) {
        switch (paragraph) {
            case "template"         : return template;
            case "paragraphs"       : return paragraphs;
            case "templateList"     : return templateList;
            case "paragraphsList"   : return paragraphsList;
            case "templateData"     : return templateData;
            case "paragraphsData"   : return paragraphsData;
        }
        return new ArrayList<>();
    }

    @DataProvider(name = "paragraphs")
    public static Object[][] paragraphs() {
        return new Object[][] {
                { "template"      },
                { "paragraphs"    },
                { "templateList"  },
                { "paragraphsList"},
                { "templateData"  },
                { "paragraphsData"}
        };
    }
    // endregion
}
