package org.mytests.tests;

import com.epam.jdi.tools.pairs.Pair;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.stream.LongStream;

import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.PrintUtils.*;
import static com.epam.jdi.tools.StringUtils.format;
import static com.epam.jdi.tools.pairs.Pair.$;

public class PerfStatistic {
    private PerfStatistic() {
        stats = new ArrayListValuedHashMap<>();
    }
    private MultiValuedMap<String, Long> stats;
    private static LongStream toLong(Collection<Long> collection) {
        return collection.stream().mapToLong(a -> a);
    }
    private LongStream values() {
        return toLong(instance.stats.values());
    }

    private static PerfStatistic instance;
    private static PerfStatistic Statistic() {
        if (instance == null)
            instance = new PerfStatistic();
        return instance;
    }

    public static void addStatistic(String action, Long time) {
        Statistic().stats.put(action, time);
    }
    public static Long maxTime() {
        return Statistic().values().max().orElse(-1);
    }
    public static Pair<String, Long> maxAction() {
        Pair<String, Long> maxAction = null;
        for (Entry<String, Collection<Long>> stat : Statistic().stats.asMap().entrySet()) {
            Long max = toLong(stat.getValue()).max().orElse(-1);
            if (maxAction == null || max > maxAction.value)
                maxAction = $(stat.getKey(), max);
        }
        return maxAction;
    }
    public static Long minTime() {
        return Statistic().values().min().orElse(-1);
    }
    public static Pair<String, Long> minAction() {
        Pair<String, Long> minAction = null;
        for (Entry<String, Collection<Long>> stat : Statistic().stats.asMap().entrySet()) {
            Long min = toLong(stat.getValue()).min().orElse(-1);
            if (minAction == null || min < minAction.value)
                minAction = $(stat.getKey(), min);
        }
        return minAction;
    }
    public static Double averageTime() {
        return Statistic().values().average().orElse(-1);
    }
    public static void printStatistic() {
        for (Entry<String, Collection<Long>> stat : Statistic().stats.asMap().entrySet())
            System.out.println(format("%s:[%s]", stat.getKey(),
                    print(select(stat.getValue(), v -> v+""))));
    }
}
