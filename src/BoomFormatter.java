import java.util.function.Predicate;

public class BoomFormatter {
    private static final String BOOM_OUTPUT_VALUE = "BOOM";
    private final Predicate<Integer> isNumberBoom;

    public BoomFormatter(Predicate<Integer> isNumberBoom) {
        this.isNumberBoom = isNumberBoom;
    }

    public String format(int input) {
        return isNumberBoom.test(input) ? BOOM_OUTPUT_VALUE : Integer.toString(input);
    }
}