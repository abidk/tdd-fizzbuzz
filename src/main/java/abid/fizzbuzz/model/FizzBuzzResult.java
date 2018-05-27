package abid.fizzbuzz.model;


public final class FizzBuzzResult {

    private final String value;
    private final Boolean isInteger;

    public FizzBuzzResult(String value, Boolean isInteger) {
        this.value = value;
        this.isInteger = isInteger;
    }

    public String getValue() {
        return value;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public static FizzBuzzResult of(String value, Boolean isInteger) {
        return new FizzBuzzResult(value, isInteger);
    }
}
