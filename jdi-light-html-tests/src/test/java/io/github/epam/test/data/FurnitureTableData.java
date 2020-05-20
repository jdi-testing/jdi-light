package io.github.epam.test.data;

import io.github.com.entities.Furniture;

public class FurnitureTableData {

    public static Furniture TABLE = new Furniture().set(x -> {
        x.name = "Table";
        x.type = "furniture";
        x.cost = "3.5";
        x.weight = "3.5";
    });
}
