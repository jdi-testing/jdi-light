package io.github.epam.test.data;

import java.util.HashMap;
import java.util.Map;

public class InputDataHelper {
    public static Map<Integer, String> inputDataAsMap(int size) {
        Map<Integer, String> inputData = new HashMap<Integer, String>(size);

        for (int index = 1; index <= size; index++) {
            inputData.put(index, "data" + index);
        }

        return inputData;
    }
}
