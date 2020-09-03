package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SidenavSection.basicSidenav;

public class SidenavTests extends TestsInit {

    @Test
    public void verifyBasicSideNavTest() {
        System.out.println( basicSidenav.getSideNavByContent("Sidenav content").getText());
       // basicSidenav.getSideNavContent().is().

    }
}
