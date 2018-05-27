package abid.fizzbuzz.service;

import abid.fizzbuzz.model.FizzBuzzCount;
import abid.fizzbuzz.model.FizzBuzzResult;
import abid.fizzbuzz.model.FizzBuzzResults;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FizzBuzzCounterImplTest {

    private FizzBuzzResults givenInput = new FizzBuzzResults();
    private List<FizzBuzzCount> result;

    @Test
    public void shouldOrderResultsCorrectly() {
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("fizzbuzz");
        givenFizzBuzzInput("lucky");
        givenFizzBuzzInput("fizz");
        givenIntegerInput("1");

        whenCallingService();

        thenResultIdxIs(0, "fizz", 1);
        thenResultIdxIs(1, "buzz", 1);
        thenResultIdxIs(2, "fizzbuzz", 1);
        thenResultIdxIs(3, "lucky", 1);
        thenResultIdxIs(4, "integer", 1);
    }


    @Test
    public void shouldCountBuzzValuesAndReturnCorrectCount() {
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("buzz");

        whenCallingService();

        thenResultIdxIs(0, "buzz", 3);
    }

    @Test
    public void shouldCountFizzBuzzValuesAndReturnCorrectCount() {
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("fizz");

        whenCallingService();

        thenResultIdxIs(0, "fizz", 1);
        thenResultIdxIs(1, "buzz", 2);
    }

    @Test
    public void shouldCountFizzBuzzAndIntegerValuesAndReturnCorrectCount() {
        givenIntegerInput("1");
        givenIntegerInput("2");
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("buzz");
        givenFizzBuzzInput("fizz");
        givenIntegerInput("6");

        whenCallingService();

        thenResultIdxIs(0, "fizz", 1);
        thenResultIdxIs(1, "buzz", 2);
        thenResultIdxIs(2, "integer", 3);
    }

    private void thenResultIdxIs(int idx, String expectedValue, int expectedCount) {
        assertEquals(expectedValue, result.get(idx).getValue());
        assertEquals(expectedCount, result.get(idx).getCount());
    }

    private void whenCallingService() {
        FizzBuzzCounter service = new FizzBuzzCounterImpl();
        result = service.count(givenInput);
    }

    private void givenFizzBuzzInput(String input) {
        givenInput.add(new FizzBuzzResult(input, false));
    }

    private void givenIntegerInput(String input) {
        givenInput.add(new FizzBuzzResult(input, true));
    }

}