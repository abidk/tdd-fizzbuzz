package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;

import java.util.List;
import java.util.Optional;

public class NumberConverterServiceImpl implements NumberConverterService {

    private final List<NumberConverter> strategies;

    public NumberConverterServiceImpl(List<NumberConverter> strategies) {
        this.strategies = strategies;
    }

    @Override
    public Optional<NumberConverter> getConverter(FizzBuzzNumber number) {
        return strategies.stream()
                .filter(strategy -> strategy.getValue(number).isPresent())
                .findFirst();
    }
}
