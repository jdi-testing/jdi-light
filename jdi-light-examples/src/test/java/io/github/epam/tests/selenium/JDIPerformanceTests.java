package io.github.epam.tests.selenium;

import com.epam.jdi.light.elements.complex.table.Line;
import org.apache.commons.lang3.time.StopWatch;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.entities.User;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatchers.containsValue;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static selenium.entities.TestData.TABLE_SNAPSHOOT;
import static selenium.seleniumPO.HomePage.leftNavigation;
import static selenium.seleniumPO.SiteSelenium.homePage;
import static selenium.seleniumPO.SiteSelenium.login;
import static selenium.site.pages.JDIPerformancePage.*;

public class JDIPerformanceTests extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        leftNavigation.select("Service", "Performance");
    }

    @Test
    public void hugeTableSearchTest() {
        StopWatch timer = StopWatch.createStarted();
        Line row = usersTable.row(
            containsValue("Meyer", inColumn("Name")),
            containsValue("co.uk", inColumn("Email")));
        System.out.println("Huge table search test Time: " + timer.getTime());
        Assert.assertEquals(row.getValue(),
        "Brian Meyer,(016977) 0358,mollis.nec@seddictumeleifend.co.uk,Houston");
    }

    @Test
    public void hugeTableValidateTest() {
        StopWatch timer = StopWatch.createStarted();
        String actualTable = usersTable.preview();
        System.out.println("Huge table validate test Time: " + timer.getTime());
        Assert.assertEquals(actualTable, TABLE_SNAPSHOOT);
    }

    @Test
    public void bigDropdownTest() {
        String name = "Charles Byers";
        StopWatch timer = StopWatch.createStarted();
        userNames.select(name);
        System.out.println("Big dropdown test Time: " + timer.getTime());
        Assert.assertEquals(userNames.selected(), name);
    }

    @Test
    public void longTextTest() {
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
