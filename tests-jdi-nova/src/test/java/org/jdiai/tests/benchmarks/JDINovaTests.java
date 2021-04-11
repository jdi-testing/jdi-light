package org.jdiai.tests.benchmarks;

import com.epam.jdi.tools.DataClass;
import org.jdiai.annotations.UI;
import org.jdiai.jswraper.interfaces.GetValue;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.jdiai.JDI.*;
import static org.jdiai.asserts.Conditions.be;
import static org.jdiai.asserts.Conditions.haveAll;
import static org.jdiai.jsbuilder.QueryLogger.ALL;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;

@Listeners(TestNGListener.class)
public class JDINovaTests {
    public User DefaultUser = new User();
    @BeforeMethod
    public void before() {
        LOG_QUERY = ALL;
    }

    @Test(enabled = false)
    public void simpleSearchTest() {
        openPage("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        loginAs(DefaultUser);
        $(".sidebar-menu").select("Service", "User Table");
        $("#user-table tr").get(2).should(be(SPIDER_MAN));
    }

    @Test(enabled = false)
    public void simpleAllSearchTest() {
        openPage("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        loginAs(DefaultUser);
        $(".sidebar-menu").select("Service", "User Table");
        $("#user-table tbody tr").should(haveAll(
            SPIDER_MAN, WOLVERINE, CAPITAN_AMERICA, HULK, CYCLOPE, PUNISHER));
    }
    @Test(enabled = false)
    public void simpleAllOrderedSearchTest() {
        openPage("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        loginAs(DefaultUser);
        $(".sidebar-menu").select("Service", "User Table");
        $("#user-table tbody tr").should(be(
            WOLVERINE, SPIDER_MAN, PUNISHER, CAPITAN_AMERICA, CYCLOPE, HULK));
    }

    public static class User {
        @UI("#name") String name = "Roman";
        @UI("#password") String password = "Jdi1234";
    }
    public static MarvelHero WOLVERINE = new MarvelHero().set(h -> {
        h.number = 1;
        h.type = "Admin";
        h.name = "Roman";
        h.heroName = "Wolverine";
        h.img = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    });
    public static MarvelHero SPIDER_MAN = new MarvelHero().set(h -> {
        h.number = 2;
        h.type = "User";
        h.name = "Sergey Ivan";
        h.heroName = "Spider Man";
        h.img = "https://jdi-testing.github.io/jdi-light/images/spider-man.jpg";
    });
    public static MarvelHero PUNISHER = new MarvelHero().set(h -> {
        h.number = 3;
        h.type = "Manager";
        h.name = "Vladzimir";
        h.heroName = "Punisher";
        h.img = "https://jdi-testing.github.io/jdi-light/images/punisher.jpg";
    });
    public static MarvelHero CAPITAN_AMERICA = new MarvelHero().set(h -> {
        h.number = 4;
        h.type = "User";
        h.name = "Helen Bennett";
        h.heroName = "Captain America\nsome description";
        h.img = "https://jdi-testing.github.io/jdi-light/images/captain-america.jpg";
    });
    public static MarvelHero CYCLOPE = new MarvelHero().set(h -> {
        h.number = 5;
        h.type = "User";
        h.name = "Yoshi Tannamuri";
        h.heroName = "Cyclope\nsome description";
        h.img = "https://jdi-testing.github.io/jdi-light/images/cyclope.jpg";
    });
    public static MarvelHero HULK = new MarvelHero().set(h -> {
        h.number = 6;
        h.type = "User";
        h.name = "Giovanni Rovelli";
        h.heroName = "Hulk\nsome description";
        h.img = "https://jdi-testing.github.io/jdi-light/images/hulk.jpg";
    });
    public static class MarvelHero extends DataClass<MarvelHero> {
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
