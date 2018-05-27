package abid.fizzbuzz.model;

public final class FizzBuzzCount {

    private final String value;
    private int count = 0;

    public FizzBuzzCount(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
