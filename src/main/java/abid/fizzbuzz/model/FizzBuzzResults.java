package abid.fizzbuzz.model;


import abid.fizzbuzz.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public final class FizzBuzzResults implements Streamable<FizzBuzzResult> {

    private final List<FizzBuzzResult> list = new ArrayList<>();

    public void add(FizzBuzzResult value) {
        list.add(value);
    }

    @Override
    public String toString() {
        return list.stream()
                .map(FizzBuzzResult::getValue)
                .collect(Collectors.joining(" "));
    }

    @Override
    public Iterator<FizzBuzzResult> iterator() {
        return list.iterator();
    }
}
