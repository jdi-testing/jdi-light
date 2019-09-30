package io.github.epam.test.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputData {
    public static Map<Integer, String> inputDataAsMap(int size) {
        Map<Integer, String> inputData = new HashMap<Integer, String>(size);

        for (int index = 1; index <= size; index++) {
            inputData.put(index, "data" + index);
        }

        return inputData;
    }

    public static String TEXT = "data";
}
