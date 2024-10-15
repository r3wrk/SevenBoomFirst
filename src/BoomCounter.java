import java.io.PrintStream;
import java.util.function.Predicate;

public class BoomCounter {
    private int count = 0;
    private final Predicate<Integer> isBoom;
    private final PrintStream out;

    public BoomCounter(Predicate<Integer> isBoom, PrintStream out) {
        this.isBoom = isBoom;
        this.out = out;
    }

    private String getCountAsString() {

        return isBoom.test(count) ? "BOOM" : Integer.toString(count);

    }

    public synchronized boolean tryStep(int maxCount) {
        if (count >= maxCount) {
            return false;
        }

        count++;
        out.println(getCountAsString());
        return true;
    }
}
