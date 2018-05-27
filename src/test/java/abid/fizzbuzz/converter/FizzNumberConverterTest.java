package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class FizzNumberConverterTest {

    private FizzBuzzNumber givenInput;
    private Optional<String> result;

    @Test
    public void givenTheNumber3ShouldReturnFizz() {
        givenNumbers(3);

        whenCallingService();

        thenResultIsFizz();
    }

    @Test
    public void givenTheNumber6ShouldReturnFizz() {
        givenNumbers(6);

        whenCallingService();

        thenResultIsFizz();
    }

    @Test
    public void givenTheNumber9ShouldReturnFizz() {
        givenNumbers(9);

        whenCallingService();

        thenResultIsFizz();
    }

    @Test
    public void givenTheNumber12ShouldReturnFizz() {
        givenNumbers(12);

        whenCallingService();

        thenResultIsFizz();
    }

    @Test
    public void givenTheNumberOneShouldNotReturnResult() {
        givenNumbers(1);

        whenCallingService();

        thenResultIsEmpty();
    }

    private void thenResultIsEmpty() {
        assertEquals(false, result.isPresent());
    }

    private void thenResultIsFizz() {
        assertEquals("fizz", result.get());
    }

    private void whenCallingService() {
        NumberConverter strategy = new FizzNumberConverter();
        result = strategy.getValue(givenInput);
    }

    private void givenNumbers(int number) {
        givenInput = new FizzBuzzNumber(number);
    }
}