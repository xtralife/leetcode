package com.github.xtralife.leetcode.problems.p380.insert_delete_getrandom_o1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {
    private final Map<Integer, Integer> values = new HashMap<>(); //value: index
    private final List<Integer> valuesList = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (values.containsKey(val)) {
            return false;
        }
        values.put(val, valuesList.size());
        valuesList.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!values.containsKey(val)) {
            return false;
        }
        int valIndex = values.get(val);
        int lastVal = valuesList.get(valuesList.size() - 1);
        valuesList.set(valIndex, lastVal);
        values.put(lastVal, valIndex);

        values.remove(val);
        valuesList.remove(valuesList.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return valuesList.get(ThreadLocalRandom.current().nextInt(valuesList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */