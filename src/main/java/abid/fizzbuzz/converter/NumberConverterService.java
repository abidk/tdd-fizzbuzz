package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.Optional;

public interface NumberConverterService {
    Optional<NumberConverter> getConverter(FizzBuzzNumber number);
}
