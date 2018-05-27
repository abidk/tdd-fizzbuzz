package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class BuzzNumberConverterTest {

    private FizzBuzzNumber givenInput;
    private Optional<String> result;

    @Test
    public void givenTheNumberFiveShouldReturnBuzz() {
        givenNumbers(5);

        whenCallingService();

        thenResultIsBuzz();
    }

    @Test
    public void givenTheNumber10ShouldReturnBuzz() {
        givenNumbers(10);

        whenCallingService();

        thenResultIsBuzz();
    }

    @Test
    public void givenTheNumberFifteenShouldReturnBuzz() {
        givenNumbers(15);

        whenCallingService();

        thenResultIsBuzz();
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

    private void thenResultIsBuzz() {
        assertEquals("buzz", result.get());
    }

    private void whenCallingService() {
        NumberConverter strategy = new BuzzNumberConverter();
        result = strategy.getValue(givenInput);
    }

    private void givenNumbers(int number) {
        givenInput = new FizzBuzzNumber(number);
    }
}