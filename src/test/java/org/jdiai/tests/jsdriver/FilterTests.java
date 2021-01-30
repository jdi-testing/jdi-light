package org.jdiai.tests.jsdriver;

import org.jdiai.entity.ElementInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.jdiai.jswraper.JSWrapper.$;
import static org.jdiai.jswraper.JSWrapper.element;
import static org.jdiai.tests.jsdriver.states.States.atSimplePage;
import static org.testng.Assert.assertEquals;

public class FilterTests extends TestInit {

    @BeforeMethod
    public void before() {
        atSimplePage();
    }

    @Test
    public void oneTest() {
        List<String> header = element("#furniture-double-hidden th").getAttributeList("textContent");
        assertEquals(header.size(), 6);
        List<String> filteredHeader = $("#furniture-double-hidden th").getAttributeList("textContent");
        assertEquals(filteredHeader.size(), 4);
    }

    @Test
    public void oneStyleTest() {
        List<String> visibility = element("#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        List<String> filteredVisibility = $("#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(filteredVisibility.size(), 4);
        assertEquals(filteredVisibility.get(0), "visible");
    }

    @Test
    public void complexTest() {
        String json =
            "{ 'tag': element.tagName, " +
            "'id': element.id, " +
            "'text': element.textContent, " +
            "'visibility': getComputedStyle(element).visibility, " +
            "'fontSize': getComputedStyle(element).fontSize, " +
            "'selected': !!element.selected, " +
            "'html': element.innerHTML }";
        List<ElementInfo> info = element(ElementInfo.class, "#furniture-double-hidden th")
            .getEntityList(json);
        assertEquals(info.size(), 6);
        assertEquals(info.toString(), INFO);
        List<ElementInfo> filteredInfo = $(ElementInfo.class, "#furniture-double-hidden th")
            .getEntityList(json);
        assertEquals(filteredInfo.size(), 4);
        assertEquals(filteredInfo.toString(), FILTERED_INFO);
    }
    String INFO =
        "[ElementInfo(tag:TH; id:; text:\n\t\t\t\t\t\t\t\t; html:\n\t\t\t\t\t\t\t\t; visibility:hidden; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Name; html:Name; visibility:visible; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Type; html:Type; visibility:visible; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Cost *; html:Cost *; visibility:visible; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:; html:; visibility:hidden; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Weight; html:Weight; visibility:visible; fontSize:14px; selected:false)]";
    String FILTERED_INFO =
        "[ElementInfo(tag:TH; id:; text:Name; html:Name; visibility:visible; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Type; html:Type; visibility:visible; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Cost *; html:Cost *; visibility:visible; fontSize:14px; selected:false), " +
        "ElementInfo(tag:TH; id:; text:Weight; html:Weight; visibility:visible; fontSize:14px; selected:false)]";
}
