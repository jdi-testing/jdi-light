package io.github.epam.html.tests.performance;


import com.epam.jdi.light.elements.complex.table.Table;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.performancePage;
import static io.github.com.pages.PerformancePage.usersTableSetup;
import static io.github.com.pages.PerformancePage.usersTableUI;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class DataTableTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        performancePage.shouldBeOpened();
    }

    @Test
    public void tableTest() {
        tableValidation(usersTableSetup);
    }
    @Test
    public void getTableTest() {
        getValidation(usersTableUI);
    }

    private void tableValidation(Table table) {
        assertEquals(table.size(), 4);
        notMoreThan(200, table::count);
        assertEquals(table.count(), 400);
        assertEquals(table.header(), asList("Name", "Phone", "Email", "City"));
        notMoreThan(1500, table::preview);
        String value = table.preview();
        assertEquals(value.substring(0,194),
        "Name Phone Email City" +
            "Burke Tucker 076 1971 1687 et.euismod.et@ut.edu GozŽe" +
            "Grady Brock (011307) 16843 cursus.et@commodo.org Alcobendas" +
            "Harding Lloyd 0800 1111 neque.In.ornare@mauris.co.uk Beauvais");
    }

    private void getValidation(Table table) {
        //long a = getDuration(() -> table.count()); //100
        //long b = getDuration(() -> table.header()); //200
        //long c = getDuration(() -> table.row(395).getValue()); // 1100
        //long c = getDuration(() -> table.webRow(395).getValue()); // 1100
        //long e = getDuration(() -> table.headerUI().values()); //140
        //long f = getDuration(() -> table.row("Aileen Rodriguez").getValue()); //900
        //long f = getDuration(() -> table.webRow("Aileen Rodriguez").getValue()); //900
        //long g = getDuration(() -> table.cell(3,4)); //275
        //long h = getDuration(() -> table.cell("Email",4)); //426
        //long i = getDuration(() -> table.cell(3,"Aileen Rodriguez")); //176
        //long j = getDuration(() -> table.cell("Email","Aileen Rodriguez")); //311
        //long k = getDuration(() -> table.column(2).getValue()); // 12000
        //long k1 = getDuration(() -> table.jsColumn(2)); // 10
        //long l = getDuration(() -> table.column("Phone").getValue()); // 10300
        //long l1 = getDuration(() -> table.jsColumn("Phone")); // 8
        //long m = getDuration(() -> table.preview()); // 542
        //long n1 = getDuration(() -> table.jsCells()); //40
        //long n2 = getDuration(() -> table.jsRow(395)); // 800
        //long n3 = getDuration(() -> table.jsColumn(3)); // 100
        //long n = getDuration(() -> table.getValue()); // 1500

        List<String> row = notMoreThan(1000, () -> table.jsRow(395));
        notMoreThan(100, () -> table.jsRow("Aileen Rodriguez"));
        String aileenText = "Aileen Rodriguez;0845 46 46;mattis.velit.justo@Maurismolestie.com;Portico e San Benedetto";
        assertEquals(print(row, ";"), aileenText);

        String rowValue = notMoreThan(1000, () -> table.row("Aileen Rodriguez").getValue());
        assertEquals(rowValue, aileenText);

        rowValue = notMoreThan(1200, () -> table.row(395).getValue());
        assertEquals(rowValue, aileenText);

        String zacharyEmail = "mattis.velit.justo@Maurismolestie.com";
        String cell = notMoreThan(1000, () -> table.cell(3,395));
        assertEquals(cell, zacharyEmail);

        cell = notMoreThan(1000, () -> table.cell("Email",395));
        assertEquals(cell, zacharyEmail);

        cell = notMoreThan(1000, () -> table.cell(3,"Aileen Rodriguez"));
        assertEquals(cell, zacharyEmail);

        cell = notMoreThan(1000, () -> table.cell("Email","Aileen Rodriguez"));
        assertEquals(cell, zacharyEmail);

        List<String> column = notMoreThan(1000, () -> table.jsColumn(2));
        assertEquals(print(column, ";").substring(0, 30),
                "076 1971 1687;(011307) 16843;0");

        String value = notMoreThan(2000, () -> table.getValue());
        assertEquals(value.substring(0,228),
        "||X||Name|Phone|Email|City||" + LINE_BREAK +
            "||1||Burke Tucker|076 1971 1687|et.euismod.et@ut.edu|GozŽe||" + LINE_BREAK +
            "||2||Grady Brock|(011307) 16843|cursus.et@commodo.org|Alcobendas||" + LINE_BREAK +
            "||3||Harding Lloyd|0800 1111|neque.In.ornare@mauris.co.uk|Beauvais||");
    }

}
