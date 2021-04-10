package org.jdiai.tests;

import org.jdiai.annotations.UI;
import org.jdiai.jswraper.interfaces.GetValue;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jdiai.JDI.*;
import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class SimpleTests {
    public User DefaultUser = new User();

    @Test(enabled = false)
    public void simpleSearchTest() {
        LOG_QUERY = ALL;
        openPage("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        loginAs(DefaultUser);
        $(".sidebar-menu").select("Service", "User Table");
        MarvelHero spiderMan = $("#user-table tr").get(2).getEntity(MarvelHero.class);
        assertEquals(spiderMan.number, 2);
        assertEquals(spiderMan.heroName, "Spider Man");
        assertThat(spiderMan.img).contains("spider-man.jpg");
    }

    public static class User {
        @UI("#name")
        String name = "Roman";
        @UI("#password")
        String password = "Jdi1234";
    }
    public static class MarvelHero {
        @UI(".//td[1]")
        public int number;
        @UI(".//td[2]//option[@selected]")
        public String type;
        @UI(".//td[3]//a")
        public String name;
        @UI(".//td[4]//span")
        public String heroName;
        @UI(".//td[4]//img") @GetValue("src")
        public String img;
    }
}
