package com.jditest.tests;

import com.jditest.TestInit;
import com.jditest.entities.ElementInfo;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.jditest.Pages.SIMPLE_PAGE;
import static com.jditest.jswraper.JSWrapper.$w;
import static com.jditest.jswraper.JSWrapper.element;
import static com.jditest.states.States.loggedInAt;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class FilterTests implements TestInit {

    @BeforeMethod
    public void before() {
        loggedInAt(SIMPLE_PAGE);
    }

    @Test
    public void oneTest() {
        List<String> header = element("#furniture-double-hidden th").getAttributeList("textContent");
        assertEquals(header.size(), 6);
        List<String> filteredHeader = $w("#furniture-double-hidden th").getAttributeList("textContent");
        assertEquals(filteredHeader.size(), 4);
    }

    @Test
    public void oneStyleTest() {
        List<String> visibility = element("#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(visibility.size(), 6);
        assertEquals(visibility.get(0), "hidden");
        List<String> filteredVisibility = $w("#furniture-double-hidden th").getStylesList("visibility");
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
        List<ElementInfo> filteredInfo = $w(ElementInfo.class, "#furniture-double-hidden th")
            .getEntityList(json);
        assertEquals(filteredInfo.size(), 4);
        assertEquals(filteredInfo.toString(), FILTERED_INFO);
    }

    @Test
    public void complexSmartTest() {
        List<ElementInfo> info = element(ElementInfo.class, "#furniture-double-hidden th")
            .getEntityList();
        assertEquals(info.size(), 6);
        assertEquals(info.toString(), INFO);
        List<ElementInfo> filteredInfo = $w(ElementInfo.class, "#furniture-double-hidden th")
            .getEntityList();
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
