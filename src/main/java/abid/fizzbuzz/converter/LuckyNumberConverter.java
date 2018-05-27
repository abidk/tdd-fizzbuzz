package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.Optional;

public class LuckyNumberConverter implements NumberConverter {

    private static final String LUCKY = "lucky";

    @Override
    public Optional<String> getValue(FizzBuzzNumber number) {
        if (number.contains(3)) {
            return Optional.of(LUCKY);
        } else {
            return Optional.empty();
        }
    }
}
