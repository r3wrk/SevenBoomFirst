import java.util.function.Predicate;

public class BoomTester {
    private static final String BOOM_OUTPUT_VALUE = "BOOM";
    private final Predicate<Integer> isNumberBoom;

    public BoomTester(Predicate<Integer> isNumberBoom) {
        this.isNumberBoom = isNumberBoom;
    }

    public String format(int input) {
        return isNumberBoom.test(input) ? BOOM_OUTPUT_VALUE : Integer.toString(input);
    }
}