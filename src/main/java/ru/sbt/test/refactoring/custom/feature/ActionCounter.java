package ru.sbt.test.refactoring.custom.feature;

import java.util.HashMap;

/**
 * Created by Maxim on 12/8/2015.
 */
public class ActionCounter {
    private final HashMap<String, Integer> actionCounts;

    public ActionCounter() {
        actionCounts = new HashMap<>();
    }

    public void count(String action) {
        if (actionCounts.containsKey(action)) {
            actionCounts.put(action, actionCounts.get(action) + 1);
        } else {
            actionCounts.put(action, 1);
        }
    }

    public void summary() {
        System.out.println("Summary:");
        int total = actionCounts.values().stream()
                .mapToInt(x -> x)
                .sum();
        actionCounts.entrySet()
                .forEach(entry ->
                        System.out.format("> action \"%s\" was performed %d time(s)\n", entry.getKey(), entry.getValue()));
        System.out.format("> Total actions number: %d\n", total);
    }
}
