package org.jdiai.tests.jsdriver.benchmarks;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;

import static org.testng.Assert.assertEquals;

public class PerfStatistic {
    public static  <T> void testScenario(JFunc<T> seleniumAction, JFunc<T> jdiAction, int count) {
        List<Long> seleniumStats = new ArrayList<>();
        List<Long> jsStats = new ArrayList<>();
        for (int i = 0; i < count; i++) {
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
        System.out.println("Average Ratio: "+avSelenium/avJdi);
    }

    private static double getAverage(Collection<Long> times) {
        return toLong(times).average().orElse(-1);
    }
    private static LongStream toLong(Collection<Long> collection) {
        return collection.stream().mapToLong(a -> a);
    }
}
