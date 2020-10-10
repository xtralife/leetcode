package com.github.xtralife.facebook.minimum_number_of_conversions;

import java.util.*;

public class Solution {
    public int findMinimumConversions(Map<String, List<String>> conversions, String inputCurrency, String outputCurrency) {
        if (!conversions.containsKey(inputCurrency)) {
            return -1;
        }

        Queue<String> currencies = new LinkedList<String>();
        for (String currency : conversions.get(inputCurrency)) { //ex for USD
            currencies.add(currency);
        }
        Set<String> checkedCurrencies = new HashSet<>();
        checkedCurrencies.add(inputCurrency);
        int length = 1;
//        double exchangeRate = 1;
        while (!currencies.isEmpty()) {
            int size = currencies.size();
            for (int i = 0; i < size; i++) {
                String currency = currencies.poll();
//                <String, Double>

                if (checkedCurrencies.contains(currency)) {
                    continue;
                }
                checkedCurrencies.add(currency);
                if (currency.equals(outputCurrency)) {
                    return length;
                }
                if (conversions.containsKey(currency)) {
                    for (String exchange : conversions.get(currency)) {
                        currencies.add(exchange);
                    }
                }
            }
            length++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<String, List<String>> conversions = new HashMap<>();
        conversions.put("USD", Arrays.asList("GBP", "EUR", "CHF"));
        conversions.put("GBP", Arrays.asList("USD", "EUR"));
        conversions.put("EUR", Arrays.asList("USD", "GBP"));
        conversions.put("CHF", Arrays.asList("USD"));

        Solution solution = new Solution();
        int result = solution.findMinimumConversions(conversions, "CHF", "GBP");
        System.out.println(result);

        conversions = new HashMap<>();
        conversions.put("USD", Arrays.asList("GBP"));
        conversions.put("GBP", Arrays.asList("USD", "EUR"));
        conversions.put("EUR", Arrays.asList("USD"));
        conversions.put("CHF", Arrays.asList("UAH"));
        conversions.put("UAH", Arrays.asList("CHF"));

        result = solution.findMinimumConversions(conversions, "GBP", "CHF");
        System.out.println(result);
    }
}
