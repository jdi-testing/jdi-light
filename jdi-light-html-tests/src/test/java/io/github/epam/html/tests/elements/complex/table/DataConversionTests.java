package io.github.epam.html.tests.elements.complex.table;

import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.StringUtils.setPrimitiveField;
import static org.testng.Assert.*;

public class DataConversionTests {
    @Test
    public void convertData() {
        PrimitiveData pData = new PrimitiveData();
        PrimitiveData expected = new PrimitiveData().set(p -> {
            p.strings = "string";
            p.boolp = true;
            p.bools = true;
            p.charp = 'a';
            p.chars = 'b';
            p.bytep = 123;
            p.bytes = 124;
            p.shortp = 12333;
            p.shorts = 12234;
            p.intp = 1233332322;
            p.ints = 1223432323;
            p.longp = 1233332322323232325L;
            p.longs = 1223432323344535326L;
            p.doublep = 23.45;
            p.doubles = 24.56;
            p.floatp = 2.34f;
            p.floats = 3.45f;
        });
        for (Field field : expected.getClass().getDeclaredFields()) {
            try {
                Field dataField = first(pData.getClass().getDeclaredFields(),
                    f -> f.getName().equals(field.getName()));
                if (field.get(expected) != null)
                    setPrimitiveField(dataField, pData, field.get(expected).toString());
            } catch (Exception ignore) {}
        }
        assertEquals(pData, expected);
    }
}
