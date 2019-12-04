package org.mytests.tests;

import com.epam.jdi.tools.pairs.Pair;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.stream.LongStream;

import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.format;
import static com.epam.jdi.tools.pairs.Pair.$;

public class PerfStatistic {
    private MultiValuedMap<String, Long> stats;
    private static PerfStatistic instance;

    private PerfStatistic() {
        stats = new ArrayListValuedHashMap<>();
    }
    private static LongStream toLong(Collection<Long> collection) {
        return collection.stream().mapToLong(a -> a);
    }
    private LongStream values() {
        return toLong(instance.stats.values());
    }
    private static PerfStatistic statistic() {
        if (instance == null)
            instance = new PerfStatistic();
        return instance;
    }

    public static void addStatistic(String action, Long time) {
        statistic().stats.put(action, time);
    }
    public static Long maxTime() {
        return statistic().values().max().orElse(-1);
    }
    public static Pair<String, Long> maxAction() {
        Pair<String, Long> maxAction = null;
        for (Entry<String, Collection<Long>> stat : statistic().stats.asMap().entrySet()) {
            Long max = toLong(stat.getValue()).max().orElse(-1);
            if (maxAction == null || max > maxAction.value)
                maxAction = $(stat.getKey(), max);
        }
        return maxAction;
    }
    public static Long minTime() {
        return statistic().values().min().orElse(-1);
    }
    public static Pair<String, Long> minAction() {
        Pair<String, Long> minAction = null;
        for (Entry<String, Collection<Long>> stat : statistic().stats.asMap().entrySet()) {
            Long min = toLong(stat.getValue()).min().orElse(-1);
            if (minAction == null || min < minAction.value)
                minAction = $(stat.getKey(), min);
        }
        return minAction;
    }
    public static Double averageTime() {
        return statistic().values().average().orElse(-1);
    }
    public static void printStatistic() {
        for (Entry<String, Collection<Long>> stat : statistic().stats.asMap().entrySet())
            System.out.println(format("%s:[%s]", stat.getKey(),
                    print(select(stat.getValue(), v -> v+""))));
    }
    public static int actionsCount() {
        return statistic().stats.size();
    }
}
