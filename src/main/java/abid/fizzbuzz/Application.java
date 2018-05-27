package abid.fizzbuzz;

import abid.fizzbuzz.converter.*;
import abid.fizzbuzz.model.FizzBuzzCount;
import abid.fizzbuzz.model.FizzBuzzInput;
import abid.fizzbuzz.service.FizzBuzzCounter;
import abid.fizzbuzz.service.FizzBuzzCounterImpl;
import abid.fizzbuzz.service.FizzBuzzProcessor;
import abid.fizzbuzz.service.FizzBuzzProcessorImpl;
import abid.fizzbuzz.model.FizzBuzzResults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.execute();
    }

    public String execute() {
        FizzBuzzInput input = generateInputNumbers(1, 20);
        NumberConverterService converterService = getNumberConverters();

        FizzBuzzProcessor converter = new FizzBuzzProcessorImpl(converterService);
        FizzBuzzCounter counter = new FizzBuzzCounterImpl();

        FizzBuzzResults results = converter.process(input);
        List<FizzBuzzCount> resultCount = counter.count(results);

        return createOutput(results, resultCount);
    }

    private String createOutput(FizzBuzzResults results, List<FizzBuzzCount> count) {
        StringBuilder result = new StringBuilder();
        result.append(results.toString());

        count.forEach(value -> {
            result.append(" ");
            result.append(value.getValue());
            result.append(": ");
            result.append(value.getCount());
        });

        return result.toString();
    }

    private static NumberConverterService getNumberConverters() {
        List<NumberConverter> orderedConverters = new ArrayList<>();
        orderedConverters.add(new LuckyNumberConverter());
        orderedConverters.add(new FizzBuzzNumberConverter());
        orderedConverters.add(new FizzNumberConverter());
        orderedConverters.add(new BuzzNumberConverter());
        return new NumberConverterServiceImpl(orderedConverters);
    }

    private static FizzBuzzInput generateInputNumbers(int min, int max) {
        final FizzBuzzInput result = new FizzBuzzInput();

        IntStream.rangeClosed(min, max).forEach(result::add);

        return result;
    }
}
