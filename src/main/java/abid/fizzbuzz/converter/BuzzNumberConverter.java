package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.Optional;

public class BuzzNumberConverter implements NumberConverter {

    private static final String BUZZ = "buzz";

    @Override
    public Optional<String> getValue(FizzBuzzNumber number) {
        if (number.isMultipleOfFive()) {
            return Optional.of(BUZZ);
        } else {
            return Optional.empty();
        }
    }
}
