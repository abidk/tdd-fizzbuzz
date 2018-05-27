package abid.fizzbuzz.service;

import abid.fizzbuzz.converter.*;
import abid.fizzbuzz.model.FizzBuzzInput;
import abid.fizzbuzz.model.FizzBuzzResults;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FizzBuzzProcessorImplTest {

    private FizzBuzzInput givenInput = new FizzBuzzInput();
    private FizzBuzzResults result;

    @Test
    public void givenFirstTwentyNumbersShouldReturnCorrectResult() {
        givenNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        whenCallingService();

        thenResultIs("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz");
    }

    private void thenResultIs(String expectedResult) {
        assertEquals(expectedResult, result.toString());
    }

    private void whenCallingService() {
        List<NumberConverter> orderedConverters = new ArrayList<>();
        orderedConverters.add(new LuckyNumberConverter());
        orderedConverters.add(new FizzBuzzNumberConverter());
        orderedConverters.add(new FizzNumberConverter());
        orderedConverters.add(new BuzzNumberConverter());
        NumberConverterService converterService = new NumberConverterServiceImpl(orderedConverters);

        FizzBuzzProcessor service = new FizzBuzzProcessorImpl(converterService);
        result = service.process(givenInput);
    }

    private void givenNumbers(int... numbers) {
        Arrays.stream(numbers).forEach(givenInput::add);
    }
}
