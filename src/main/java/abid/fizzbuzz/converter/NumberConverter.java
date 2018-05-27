package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.Optional;

public interface NumberConverter {

    Optional<String> getValue(FizzBuzzNumber number);
}
