package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.Optional;

public class FizzBuzzNumberConverter implements NumberConverter {

    private static final String FIZZBUZZ = "fizzbuzz";

    @Override
    public Optional<String> getValue(FizzBuzzNumber number) {
        if (number.isMultipleOfThree() && number.isMultipleOfFive()) {
            return Optional.of(FIZZBUZZ);
        } else {
            return Optional.empty();
        }
    }
}
