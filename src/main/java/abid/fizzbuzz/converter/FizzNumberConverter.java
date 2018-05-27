package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.Optional;

public class FizzNumberConverter implements NumberConverter {

    private static final String FIZZ = "fizz";

    @Override
    public Optional<String> getValue(FizzBuzzNumber number) {
        if (number.isMultipleOfThree()) {
            return Optional.of(FIZZ);
        } else {
            return Optional.empty();
        }
    }
}
