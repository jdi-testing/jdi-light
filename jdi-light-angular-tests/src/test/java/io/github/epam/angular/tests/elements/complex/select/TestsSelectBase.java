package io.github.epam.angular.tests.elements.complex.select;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.disableCheckboxSelect;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TestsSelectBase extends TestsInit {
    public static final String PIZZA = "Pizza";
    public static final String STEAK = "Steak";
    public static final String TACOS = "Tacos";
    public static final String AUDI = "Audi";
    public static final String MERCEDES = "Mercedes";
    public static final String SAAB = "Saab";
    public static final String VOLVO = "Volvo";
    public static final String SWEDISH_CARS = "Swedish Cars";
    public static final String GERMAN_CARS = "German Cars";
    public static final String OPTION_1 = "Option 1";
    public static final String OPTION_2 = "Option 2";
    public static final String OPTION_3 = "Option 3";
    public static final String RED = "Red";
    public static final String GREEN = "Green";
    public static final String BLUE = "Blue";
    public static final String VALID_OPTION = "Valid option";
    public static final String INVALID_OPTION = "Invalid option";
    public static final String ARIA_INVALID = "aria-invalid";
    public static final String MUST_MAKE_SELECTION = "You must make a selection";
    public static final String INVALID_SELECTON = "Your selection is invalid";
    public static final String EXTRA_CHEESE = "Extra cheese";
    public static final String MUSHROOM = "Mushroom";
    public static final String ONION = "Onion";
    public static final String PEPPERONI = "Pepperoni";
    public static final String SAUSAGE = "Sausage";
    public static final String TOMATO = "Tomato";
    public static final String GRASS = "Grass";
    public static final String WATER = "Water";
    public static final String FIRE = "Fire";
    public static final String PSYCHIC = "Psychic";
    public static final String BULBASAUR = "Bulbasaur";
    public static final String ODDISH = "Oddish";
    public static final String BELLSPROUT = "Bellsprout";
    public static final String SQUIRTLE = "Squirtle";
    public static final String PSYDUCK = "Psyduck";
    public static final String HORSEA = "Horsea";
    public static final String CHARMANDER = "Charmander";
    public static final String VULPIX = "Vulpix";
    public static final String FLAREON = "Flareon";
    public static final String MEW = "Mew";
    public static final String MEWTWO = "Mewtwo";

    @BeforeTest(alwaysRun = true)
    public static void beforeStartTest() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    public static Map<String, List<String>> getPokemonsMap() {
        Map<String, List<String>> pokemons = new LinkedHashMap<>();
        pokemons.put(GRASS, Arrays.asList(BULBASAUR, ODDISH, BELLSPROUT));
        pokemons.put(WATER, Arrays.asList(SQUIRTLE, PSYDUCK, HORSEA));
        pokemons.put(FIRE, Arrays.asList(CHARMANDER, VULPIX, FLAREON));
        pokemons.put(PSYCHIC, Arrays.asList(MEW, MEWTWO));
        return pokemons;
    }

    public static Map<String, List<String>> getCarsMap() {
        Map<String, List<String>> cars = new LinkedHashMap<>();
        cars.put(SWEDISH_CARS, Arrays.asList(VOLVO, SAAB));
        cars.put(GERMAN_CARS, Arrays.asList(MERCEDES, AUDI));
        return cars;
    }

    protected void pickDisableSelectCheckboxAsUnchecked() {
        if (disableCheckboxSelect.isSelected() && disableCheckboxSelect.isVisible()) {
            disableCheckboxSelect.uncheck();
        }
        disableCheckboxSelect.is().deselected();
    }

    protected void pickDisableSelectCheckboxAsChecked() {
        if (!disableCheckboxSelect.isSelected() && disableCheckboxSelect.isVisible()) {
            disableCheckboxSelect.check();
        }
        disableCheckboxSelect.assertThat().selected();
    }
}
