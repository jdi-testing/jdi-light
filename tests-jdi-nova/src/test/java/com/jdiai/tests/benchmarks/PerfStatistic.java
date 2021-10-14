package com.jdiai.tests.benchmarks;

import com.jdiai.tests.benchmarks.test.data.Statistic;
import com.jdiai.tools.Timer;
import com.jdiai.tools.func.JAction;
import com.jdiai.tools.func.JFunc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;

import static com.jdiai.tools.PropertyReader.getProperties;
import static com.jdiai.tools.StringUtils.format;
import static java.lang.Boolean.parseBoolean;
import static java.util.Collections.sort;
import static org.testng.Assert.assertEquals;

public class PerfStatistic {
    public static <T> Statistic testScenario(String testName, JFunc<T> seleniumAction, JFunc<T> jdiAction, int count) {
        return testScenario(testName, () -> {}, "Selenium", seleniumAction, "JDI Nova", jdiAction, count);
    }
    private static Boolean runPerformance = null;

    private static boolean runPerformance() {
        if (runPerformance == null) {
            runPerformance = parseBoolean(getProperties("/../../target/classes/test.properties")
                .getProperty("run.performance"));
        }
        return runPerformance;
    }

    public static <T> Statistic testScenario(String testName, JAction precondition, String framework1, JFunc<T> seleniumAction,
              String framework2, JFunc<T> jdiAction, int count) {
        List<Long> seleniumStats = new ArrayList<>();
        List<Long> jsStats = new ArrayList<>();
        int executionCount = runPerformance() ? count : 1;
        for (int i = 0; i < executionCount; i++) {
            System.out.println("RUN#"+ i);
            precondition.execute();
            Timer t = new Timer();
            T seleniumResult = seleniumAction.execute();
            long seleniumTime = t.timePassedInMSec();
            seleniumStats.add(seleniumTime);

            precondition.execute();
            t = new Timer();
            T jdiResult = jdiAction.execute();
            long jsTime = t.timePassedInMSec();
            jsStats.add(jsTime);
            System.out.println(testName + " Ratio: " + df2((double)seleniumTime/jsTime));
            assertEquals(seleniumResult, jdiResult);
        }
        sort(seleniumStats);
        sort(jsStats);
        double avFramework = getAverage(seleniumStats);
        double avJdi = getAverage(jsStats);
        System.out.println("Average " + framework1 + ": " + df2(avFramework));
        System.out.println("Average " + framework2 + ": " + df2(avJdi));
        String avRatio = df2(avFramework/avJdi);
        System.out.println("Average Ratio: " + avRatio);
        String min = df2(minAverage(seleniumStats, jsStats));
        String max = df2(maxAverage(seleniumStats, jsStats));
        System.out.println("Min [" + min + "] and Max [" + max + "]");

        return new Statistic().set(s -> {
            s.scenario = testName;
            s.framework1 = framework1;
            s.stat1 = df2(avFramework);
            s.stat2 = df2(avJdi);
            s.ratio = avRatio;
            s.additionalInfo = format("[%s; %s]", min, max);
        });
    }

    private static String df2(double value) {
        return new DecimalFormat("#.##").format(value);
    }

    private static double getAverage(Collection<Long> times) {
        return toLong(times).average().orElse(-1);
    }

    private static double minAverage(List<Long> stat1, List<Long> stat2) {
        if (stat1.size() == 1 || stat1.size() == 2) {
            return (double) stat1.get(0) / stat2.get(0);
        }
        return (double) stat1.get(0) / stat2.get(stat2.size() - 2);
    }

    private static double maxAverage(List<Long> stat1, List<Long> stat2) {
        if (stat1.size() == 1 || stat1.size() == 2) {
            return (double) stat1.get(0) / stat2.get(0);
        }
        return (double) stat1.get(stat1.size() - 2) / stat2.get(0);
    }

    private static LongStream toLong(Collection<Long> collection) {
        return collection.stream().mapToLong(a -> a);
    }
}
