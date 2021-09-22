package com.epam.jdi.light.ui.html.elements.complex.vue;

import java.util.List;

import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.format;

public class ChartData {
    public List<String> labels;
    public List<DataSet> dataset;
    public DataSet getByLabel(String dataSetLabel) {
        for (DataSet ds : dataset)
            if (ds.label.equals(dataSetLabel))
                return ds;
        return null;
    }
    @Override
    public String toString() {
        return format("Labels: [%s]; %s", print(labels), dataset.toString());
    }
}
