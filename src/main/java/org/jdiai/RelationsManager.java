package org.jdiai;

import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static java.lang.Math.abs;
import static org.jdiai.JS.JDI_STORAGE;

public class RelationsManager {
    public static String RELATIONS_STORAGE = JDI_STORAGE + "/relations.json";
    public static JFunc2<Direction, Direction, Boolean> EQUAL_POSITIONS = (actual, expected)
        -> actual.angle() == expected.angle() && actual.length() == expected.length();
    public static JFunc2<Direction, Direction, Boolean> ALMOST_SAME_POSITIONS = (actual, expected)
        -> abs(actual.angle() - expected.angle()) < 3 && abs(actual.length() / expected.length()) < 1.05;
    public static JFunc2<Direction, Direction, Boolean> COMPARE_POSITIONS = ALMOST_SAME_POSITIONS;

    public static File getRelationsStorage() {
        File storage = new File(RELATIONS_STORAGE);
        if (!storage.exists()) {
            try {
                storage.getParentFile().mkdirs();
                storage.createNewFile();
            } catch (IOException ex) {
                throw new JSException(ex, "Failed to create relations storage: " + RELATIONS_STORAGE);
            }
        }
        return storage;
    }
    public static void storeRelations(JS element, MapArray<String, Direction> relations) {
        storeRelations(element.getFullName(), relations);
    }
    public static void storeRelations(String name, MapArray<String, Direction> relations) {
        try {
            new Gson().toJson(relations, new FileWriter(getRelationsStorage()));
        } catch (IOException ex) {
            throw new JSException(ex, "Failed to store relations: " + relations);
        }
    }
    public static MapArray<String, Direction> readRelations(JS element) {
        return readRelations(element.getFullName());
    }
    public static MapArray<String, Direction> readRelations(String name) {
        Map allRelations;
        try {
             allRelations = new Gson().fromJson(new FileReader(getRelationsStorage()), Map.class);
        } catch (IOException ex) {
            throw new JSException(ex, "Failed to read relations storage: " + RELATIONS_STORAGE);
        }
        return allRelations != null
            ? (MapArray<String, Direction>) allRelations.get(name)
            : null;
    }
}
