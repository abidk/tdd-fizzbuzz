package abid.fizzbuzz.model;


public final class FizzBuzzNumber {

    private final int value;

    public FizzBuzzNumber(int value) {
        this.value = value;
    }

    public boolean contains(int number) {
        return String.valueOf(value).contains(String.valueOf(number));
    }

    public boolean isMultipleOfThree() {
        return value % 3 == 0;
    }

    public boolean isMultipleOfFive() {
        return value % 5 == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
