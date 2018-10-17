package io.github.epam.tests.selenium;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.entities.User;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.tools.pairs.Pair.$;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.*;
import static selenium.site.SiteJdi.*;
import static selenium.site.pages.JDIPerformancePage.usersTable;


public class JDIPerformanceTests extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.shouldBeOpened();
        login(new User());
        navigation.select("Service");
        navigation.select("Performance");
    }

    @Test
    public void hugeTableTest() {
        StopWatch timer = StopWatch.createStarted();
        String row = usersTable.row($(containsString("Meyer"), inColumn("name")),
                               $(containsString("co.uk"), inColumn("email"))).print();
        System.out.println("Time: " + timer.getTime());
        assertEquals(row, "Brian Meyer,(016977) 0358,mollis.nec@seddictumeleifend.co.uk,Houston");
    }

    @Test
    public void bigDropdownTest() {
        String name = "Charles Byers";
        StopWatch timer = StopWatch.createStarted();
        jdiPerformancePage.names.select(name);
        System.out.println("Time: " + timer.getTime());
        assertEquals(jdiPerformancePage.isSelected(), name);
    }

    @Test
    public void longTextTest() {
        String text = "Lorem ipsum dolor sit amet, eos numquam rationibus ad. Ius cu accumsan salutatus, ne pro purto ridens vulputate. Cu eum doctus tritani, munere sanctus complectitur vis id. Paulo vulputate te eos, suas tollit laudem nam id. His esse rebum reprimique ut, te solum atqui homero vim.\\n\\n" +
                "Labitur salutatus eos an. Vim ut dicam fuisset. Ex sed animal accommodare, utinam graeci iisque vim id, ea fugit scripta deleniti nec. Eos cu nisl veri meis. Affert audiam copiosae mel ne, fabulas menandri temporibus has et. Sed latine graecis ei, eu fugit soluta intellegam vis, nibh graeci meliore ad duo.\\n\\n" +
                "Et quis meis delenit mea, ius ea sumo laboramus vituperatoribus. Te simul luptatum tractatos nam, eam in causae constituam, quod stet ancillae nam ei. Ne his dico veniam legere, id has vidisse euismod sanctus. Vis putant volumus tincidunt et.\\n\\n" +
                "Has eirmod consequat ad. Sea illud clita ut, has quando accusata cotidieque an, volutpat iudicabit definitionem ut sea. Pri at atqui molestiae, nibh ullum consulatu vix at. Nec id nisl nonumes epicurei, et vitae possit probatus ius. Fierent delicata argumentum ut quo. Tation tincidunt sed eu, sit in nostrud democritum.\\n\\n" +
                "Usu esse utroque sapientem ad. Eam ut consul soleat sapientem, cu dolor consequuntur vis. Erat temporibus mea id, has ex dicam tritani. Pertinacia expetendis consectetuer eos ei, vidit malis periculis est ea, ne nam movet fuisset. Pro id habemus definitiones, in ferri solum reprehendunt mei. Vel eligendi honestatis liberavisse id.";
        StopWatch timer = StopWatch.createStarted();
        jdiPerformancePage.textfield.setText(text + "\\n"+ text);
        System.out.println("Time: " + timer.getTime());
    }
}
