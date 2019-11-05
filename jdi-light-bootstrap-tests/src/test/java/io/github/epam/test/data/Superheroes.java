package io.github.epam.test.data;

import io.github.com.entities.Superhero;

public class Superheroes {
    public static Superhero EXAMPLE_HERO = getExampleHero();
    public static Superhero TEMPLATE_HERO = getHeroTemplate();

    private static Superhero getExampleHero() {
        return new Superhero().set(c -> {
            c.currentAlias = "Venom";
            c.alterEgo = "Peter Parker";
            c.species = "Symbiote";
            c.selectUniverse = "Marvel";
            c.superheroRange = "10.0";
            c.superheroSwitch = "true";
        });
    }

    private static Superhero getHeroTemplate() {
        return new Superhero().set(c -> {
            c.currentAlias = "";
            c.alterEgo = "";
            c.species = "Human";
            c.selectUniverse = "Select character's universe";
            c.superheroRange = "50.0";
            c.superheroSwitch = "false";
        });
    }
}
/*public String currentAlias = "Venom";
    public String alterEgo = "Peter Parker";
    public String species = "Symbiote";
    public String selectUniverse = "Marvel";
    public String superheroRange = "10.0";
    public String superheroSwitch = "true";*/