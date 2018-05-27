package abid.fizzbuzz.service;

import abid.fizzbuzz.model.FizzBuzzCount;
import abid.fizzbuzz.model.FizzBuzzResult;
import abid.fizzbuzz.model.FizzBuzzResults;

import java.util.*;

public class FizzBuzzCounterImpl implements FizzBuzzCounter {

    private static final List<String> LIST_ORDER = Arrays.asList("fizz", "buzz", "fizzbuzz", "lucky", "integer");
    private static final String INTEGER = "integer";

    @Override
    public List<FizzBuzzCount> count(FizzBuzzResults results) {
        final Map<String, FizzBuzzCount> result = new HashMap<>();

        results.stream().forEach(value -> {
            FizzBuzzCount count = getFizzBuzzCount(result, value);
            count.incrementCount();
        });

        return getOrderedList(result);
    }

    private FizzBuzzCount getFizzBuzzCount(Map<String, FizzBuzzCount> result, FizzBuzzResult value) {
        final String key = value.isInteger() ? INTEGER : value.getValue();

        FizzBuzzCount count = result.getOrDefault(key, new FizzBuzzCount(key));
        result.putIfAbsent(key, count);
        return count;
    }

    private List<FizzBuzzCount> getOrderedList(Map<String, FizzBuzzCount> count) {
        final Map<Integer, FizzBuzzCount> result = new TreeMap<>();

        for (FizzBuzzCount item : count.values()) {
            result.put(LIST_ORDER.indexOf(item.getValue()), item);
        }

        return new ArrayList<>(result.values());
    }
}
