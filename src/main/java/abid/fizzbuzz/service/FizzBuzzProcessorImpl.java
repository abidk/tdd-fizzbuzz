package abid.fizzbuzz.service;

import abid.fizzbuzz.converter.NumberConverter;
import abid.fizzbuzz.converter.NumberConverterService;
import abid.fizzbuzz.model.FizzBuzzInput;
import abid.fizzbuzz.model.FizzBuzzNumber;
import abid.fizzbuzz.model.FizzBuzzResult;
import abid.fizzbuzz.model.FizzBuzzResults;

import java.util.Optional;

public class FizzBuzzProcessorImpl implements FizzBuzzProcessor {

    private final NumberConverterService converterService;

    public FizzBuzzProcessorImpl(NumberConverterService converterService) {
        this.converterService = converterService;
    }

    @Override
    public FizzBuzzResults process(FizzBuzzInput input) {
        final FizzBuzzResults result = new FizzBuzzResults();

        input.forEach(number -> result.add(convertNumberToValue(number)));

        return result;
    }

    private FizzBuzzResult convertNumberToValue(final FizzBuzzNumber number) {
        Optional<NumberConverter> converter = converterService.getConverter(number);

        return converter.map(numberConverter -> getConverterValue(numberConverter, number)).orElseGet(() -> getNumberValue(number));
    }

    private FizzBuzzResult getNumberValue(FizzBuzzNumber number) {
        final String value = number.toString();
        return FizzBuzzResult.of(value, true);
    }

    private FizzBuzzResult getConverterValue(NumberConverter strategy, FizzBuzzNumber number) {
        final String value = strategy.getValue(number).get();
        return FizzBuzzResult.of(value, false);
    }
}
