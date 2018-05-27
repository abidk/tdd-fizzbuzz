package abid.fizzbuzz.converter;

import abid.fizzbuzz.model.FizzBuzzNumber;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class LuckyNumberConverterTest {

    private FizzBuzzNumber givenInput;
    private Optional<String> result;

    @Test
    public void givenTheNumber1ShouldReturnEmptyResult() {
        givenNumbers(1);

        whenCallingService();

        thenResultIsEmpty();
    }

    @Test
    public void givenTheNumber3ShouldReturnLucky() {
        givenNumbers(3);

        whenCallingService();

        thenResultIsLucky();
    }

    @Test
    public void givenTheNumber13ShouldReturnLucky() {
        givenNumbers(13);

        whenCallingService();

        thenResultIsLucky();
    }

    @Test
    public void givenTheNumber33ShouldReturnLucky() {
        givenNumbers(33);

        whenCallingService();

        thenResultIsLucky();
    }

    private void thenResultIsEmpty() {
        assertEquals(false, result.isPresent());
    }

    private void thenResultIsLucky() {
        assertEquals("lucky", result.get());
    }

    private void whenCallingService() {
        NumberConverter strategy = new LuckyNumberConverter();
        result = strategy.getValue(givenInput);
    }

    private void givenNumbers(int number) {
        givenInput = new FizzBuzzNumber(number);
    }
}