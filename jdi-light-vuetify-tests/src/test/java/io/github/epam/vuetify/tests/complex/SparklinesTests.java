package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.sparklinesPage;

public class SparklinesTests extends TestsInit {

    @BeforeClass
    public void before() {
        sparklinesPage.open();
        sparklinesPage.checkOpened();
    }

//    @Test
//    public void fillSparklineTests() {
//    }
//
//    @Test
//    public void customLabelsSparklineTests() {
//    }
//
//    @Test
//    public void dashboardCardSparklineTests() {
//    }
//
//    @Test
//    public void heartRateSparkline() {
//    }
}
