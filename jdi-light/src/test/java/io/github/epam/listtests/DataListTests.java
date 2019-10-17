package io.github.epam.listtests;

import com.epam.jdi.light.elements.complex.DataList;
import io.github.epam.ListTestsInit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataListTests extends ListTestsInit {
    @Test
    public void jdiDataListTest() {
        dataList = new DataList();
        dataList.list().setWebElements(list);
        assertEquals(dataList.get(1).getText(), element0Text);
        assertEquals(dataList.get(2).getText(), element1Text);
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void jdiDataListNullTest() {
        dataList = new DataList();
        dataList.list().setWebElements(list);
        dataList.get(0);
    }
}
