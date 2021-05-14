package com.jditest.tests.benchmarks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.jditest.testng.TestNGListener;
import com.jditest.tests.benchmarks.test.data.MarvelHero;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.util.Arrays.asList;
import static com.jditest.tests.benchmarks.test.data.HeroesData.*;

@Listeners(TestNGListener.class)
public class SelenideTests {

    @Test(enabled = false)
    public void simpleSearchTest() {
        open("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        $("#name").setValue("Roman");
        $("#password").setValue("Jdi1234");
        $(".fa-sign-in").click();

        SelenideElement menu = $(".sidebar-menu");
        menu.find(byText("Service")).click();
        menu.find(byText("User Table")).click();

        ElementsCollection userTableRow = $("#user-table tr", 2).findAll("td");
        userTableRow.get(0).shouldHave(text(SPIDER_MAN.number+""));
        userTableRow.get(1).find("option[selected]").shouldHave(text(SPIDER_MAN.type));
        userTableRow.get(2).find("a").shouldHave(text(SPIDER_MAN.name));
        userTableRow.get(3).find("span").shouldHave(text(SPIDER_MAN.heroName));
        userTableRow.get(3).find("img")
            .shouldHave(attribute("src", SPIDER_MAN.img));
    }

    @Test(enabled = false)
    public void simpleAllSearchTest() {
        open("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        $("#name").setValue("Roman");
        $("#password").setValue("Jdi1234");
        $(".fa-sign-in").click();

        SelenideElement menu = $(".sidebar-menu");
        menu.find(byText("Service")).click();
        menu.find(byText("User Table")).click();

        List<MarvelHero> allHeroes = asList(WOLVERINE, SPIDER_MAN, PUNISHER, CAPITAN_AMERICA, CYCLOPE, HULK);
        int i = 0;
        ElementsCollection userTableRow = $$("#user-table tbody tr");
        for (SelenideElement element : userTableRow) {
            validate(element.findAll("td"), allHeroes.get(i++));
        }
    }

    public void validate(ElementsCollection userTableRow, MarvelHero expected) {
        userTableRow.get(0).shouldHave(text(expected.number+""));
        userTableRow.get(1).find("option[selected]").shouldHave(text(expected.type));
        userTableRow.get(2).find("a").shouldHave(text(expected.name));
        userTableRow.get(3).find("span").shouldHave(text(expected.heroName));
        userTableRow.get(3).find("img")
            .shouldHave(attribute("src", expected.img));
    }

}
