package org.jdiai.tests.benchmarks;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class PerfStatistic {
    public static  <T> String testScenario(JFunc<T> seleniumAction, JFunc<T> jdiAction, int count) {
        List<Long> seleniumStats = new ArrayList<>();
        List<Long> jsStats = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("RUN №"+ i);
            Timer t = new Timer();
            T seleniumResult = seleniumAction.execute();
            long seleniumTime = t.timePassedInMSec();
            seleniumStats.add(seleniumTime);

            t = new Timer();
            T jdiResult = jdiAction.execute();
            long jsTime = t.timePassedInMSec();
            jsStats.add(jsTime);
            System.out.println("Ratio: "+(double)seleniumTime/jsTime);
            assertEquals(seleniumResult, jdiResult);
        }
        double avSelenium = getAverage(seleniumStats);
        double avJdi = getAverage(jsStats);
        System.out.println("Average Selenium: " + avSelenium);
        System.out.println("Average JS: " + avJdi);
        String avRatio = df2(avSelenium/avJdi);
        System.out.println("Average Ratio: " + avRatio);
        String min = df2(min(seleniumStats, jsStats));
        String max = df2(max(seleniumStats, jsStats));
        System.out.println("Min [" + min + "] and Max [" + max + "]");
        return format("Selenium[average:%s];JS[average:%s];Ratio[average:%s;min:%s;max:%s]",
            df2(avSelenium), df2(avJdi), avRatio, min, max);
    }
    private static String df2(double value) {
        return new DecimalFormat("#.##").format(value);
    }

    private static double getAverage(Collection<Long> times) {
        return toLong(times).average().orElse(-1);
    }
    private static double min(List<Long> selenium, List<Long> js) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < js.size(); i++) {
            double ratio = (double) selenium.get(i)/js.get(i);
            if (min > ratio) {
                min = ratio;
            }
        }
        return min;
    }
    private static double max(List<Long> selenium, List<Long> js) {
        double max = -1;
        for (int i = 0; i < js.size(); i++) {
            double ratio = (double) selenium.get(i) / js.get(i);
            if (max < ratio) {
                max = ratio;
            }
        }
        return max;
    }
    private static LongStream toLong(Collection<Long> collection) {
        return collection.stream().mapToLong(a -> a);
    }
}
