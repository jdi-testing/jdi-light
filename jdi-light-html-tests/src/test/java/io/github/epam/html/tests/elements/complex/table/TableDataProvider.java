package io.github.epam.html.tests.elements.complex.table;

import io.github.com.entities.Furniture;

public class TableDataProvider {
    public static Furniture CHAIR = new Furniture().set(x -> {
        x.name = "Chair"; x.type = "furniture"; x.cost = "3.5"; x.weight = "2";
    });
    public static Furniture TABLE = new Furniture().set(x -> {
        x.name = "Table"; x.type = "furniture"; x.cost = "3.5"; x.weight = "3.5";
    });
    public static Furniture SOFA = new Furniture().set(x -> {
        x.name = "Sofa"; x.type = "furniture"; x.cost = "2"; x.weight = "2";
    });
    public static Furniture SHORT_CHAIR = new Furniture().set(x -> {
        x.name = "Chair"; x.type = "furniture"; x.cost = "3.5";
    });
    public static Furniture SHORT_TABLE = new Furniture().set(x -> {
        x.name = "Table"; x.type = "furniture"; x.cost = "3.5";
    });
    public static Furniture SHORT_SOFA = new Furniture().set(x -> {
        x.name = "Sofa"; x.type = "furniture"; x.cost = "2";
    });


    public static String[] NAME_COLUMN = { "Chair", "Table", "Sofa", "Kitchen", "Robot" };
    public static String[] WEIGHT_COLUMN = { "2","3.5", "2", "", "" };
    public static String[] COST_COLUMN = { "3.5","3.5", "2", "400", "" };
    public static String[] TYPE_COLUMN = { "furniture","furniture", "furniture", "kitchen", "robo" };
}
