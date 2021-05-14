package com.jditest.tests.benchmarks.test.data;

import com.jditest.testng.TestNGListener;
import org.testng.annotations.Listeners;

@Listeners(TestNGListener.class)
public class HeroesData {
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
}
