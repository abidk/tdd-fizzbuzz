package abid.fizzbuzz;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ApplicationTest {

    private String result;

    @Test
    public void shouldGetCorrectOutput() {
        whenCallingService();

        thenResultIs("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10");
    }

    private void whenCallingService() {
        Application application = new Application();
        result = application.execute();
    }

    private void thenResultIs(String expectedResult) {
        assertEquals(expectedResult, result);
    }
}