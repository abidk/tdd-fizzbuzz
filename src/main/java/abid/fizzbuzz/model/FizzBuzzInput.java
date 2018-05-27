package abid.fizzbuzz.model;

import abid.fizzbuzz.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FizzBuzzInput implements Streamable<FizzBuzzNumber> {

    private final List<FizzBuzzNumber> list = new ArrayList<>();

    public void add(int value) {
        list.add(new FizzBuzzNumber(value));
    }

    @Override
    public Iterator<FizzBuzzNumber> iterator() {
        return list.iterator();
    }
}
