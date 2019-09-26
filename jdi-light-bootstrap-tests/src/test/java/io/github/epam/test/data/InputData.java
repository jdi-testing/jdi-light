package io.github.epam.test.data;

import java.util.ArrayList;
import java.util.List;

public class InputData {

    public static List<String> inputDataAsList(int size) {
        List<String> inputData = new ArrayList<String>(size);

        for (int index = 0; index < size; index++) {
            inputData.add("data" + index);
        }

        return inputData;
    }

    public static String TEXT = "data";
}
