package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class FizzBuzzNumberConverterTest {

    private FizzBuzzNumber givenInput;
    private Optional<String> result;

    @Test
    public void givenTheNumber15ShouldReturnFizzBuzz() {
        givenNumbers(15);

        whenCallingService();

        thenResultIsFizzBuzz();
    }

    @Test
    public void givenTheNumber30ShouldReturnFizzBuzz() {
        givenNumbers(30);

        whenCallingService();

        thenResultIsFizzBuzz();
    }

    @Test
    public void givenTheNumber45ShouldReturnFizzBuzz() {
        givenNumbers(45);

        whenCallingService();

        thenResultIsFizzBuzz();
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

    private void thenResultIsFizzBuzz() {
        assertEquals("fizzbuzz", result.get());
    }

    private void whenCallingService() {
        NumberConverter strategy = new FizzBuzzNumberConverter();
        result = strategy.getValue(givenInput);
    }

    private void givenNumbers(int number) {
        givenInput = new FizzBuzzNumber(number);
    }
}