package org.mytests.tests.example;

import com.epam.jdi.light.elements.complex.table.Line;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mytests.tests.TestsInit;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mytests.tests.states.States.shouldBeLoggedIn;
import static org.mytests.uiobjects.example.TestData.TABLE_SNAPSHOOT;
import static org.mytests.uiobjects.example.site.SiteJdi.performancePage;
import static org.mytests.uiobjects.example.site.pages.JDIPerformancePage.*;

public class JDIPerformanceTests extends TestsInit {

    @BeforeEach
    void openPerformancePage() {
        shouldBeLoggedIn();
        performancePage.shouldBeOpened();
    }

    @Test
    void hugeTableSearchTest() {
        usersTable.assertThat().rowThat(
            containsValue("Meyer", inColumn("Name")),
            containsValue("co.uk", inColumn("Email")));
        usersTable.assertThat().no().rows(
            hasValue("NO_NAME", inColumn("Name")),
            hasValue("wrong.email", inColumn("Email")));

        StopWatch timer = StopWatch.createStarted();
        Line row = usersTable.row(
            containsValue("Meyer", inColumn("Name")),
            containsValue("co.uk", inColumn("Email")));
        System.out.println("Huge table search test Time: " + timer.getTime());

        assertEquals(row.getValue(),
    "Brian Meyer;(016977) 0358;mollis.nec@seddictumeleifend.co.uk;Houston");
    }

    @Test
    void hugeTableValidateTest() {
        StopWatch timer = StopWatch.createStarted();
        String actualTable = usersTable.preview();
        System.out.println("Huge table validate test Time: " + timer.getTime());
        assertEquals(actualTable, TABLE_SNAPSHOOT);
    }

    @Test
    void bigDropdownTest() {
        String name = "Charles Byers";
        StopWatch timer = StopWatch.createStarted();
        userNames.select(name);
        System.out.println("Big dropdown test Time: " + timer.getTime());
        assertEquals(userNames.selected(), name);
    }

    @Test
    void longTextTest() {
        String text = "Lorem ipsum dolor sit amet, eos numquam rationibus ad. Ius cu accumsan salutatus, ne pro purto ridens vulputate. Cu eum doctus tritani, munere sanctus complectitur vis id. Paulo vulputate te eos, suas tollit laudem nam id. His esse rebum reprimique ut, te solum atqui homero vim.\\n\\n" +
            "Labitur salutatus eos an. Vim ut dicam fuisset. Ex sed animal accommodare, utinam graeci iisque vim id, ea fugit scripta deleniti nec. Eos cu nisl veri meis. Affert audiam copiosae mel ne, fabulas menandri temporibus has et. Sed latine graecis ei, eu fugit soluta intellegam vis, nibh graeci meliore ad duo.\\n\\n" +
            "Et quis meis delenit mea, ius ea sumo laboramus vituperatoribus. Te simul luptatum tractatos nam, eam in causae constituam, quod stet ancillae nam ei. Ne his dico veniam legere, id has vidisse euismod sanctus. Vis putant volumus tincidunt et.\\n\\n" +
            "Has eirmod consequat ad. Sea illud clita ut, has quando accusata cotidieque an, volutpat iudicabit definitionem ut sea. Pri at atqui molestiae, nibh ullum consulatu vix at. Nec id nisl nonumes epicurei, et vitae possit probatus ius. Fierent delicata argumentum ut quo. Tation tincidunt sed eu, sit in nostrud democritum.\\n\\n" +
            "Usu esse utroque sapientem ad. Eam ut consul soleat sapientem, cu dolor consequuntur vis. Erat temporibus mea id, has ex dicam tritani. Pertinacia expetendis consectetuer eos ei, vidit malis periculis est ea, ne nam movet fuisset. Pro id habemus definitiones, in ferri solum reprehendunt mei. Vel eligendi honestatis liberavisse id.";
        StopWatch timer = StopWatch.createStarted();
        textareaPerformance.setText(text + "\\n"+ text);
        System.out.println("Long text test Time: " + timer.getTime());
    }
}
