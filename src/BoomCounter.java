import java.util.function.Predicate;

public class BoomCounter {
    private int count = 0;
    private final Predicate<Integer> isBoom;

    public BoomCounter(Predicate<Integer> isBoom) {
        this.isBoom = isBoom;
    }

    private String getCountAsString() {

        return isBoom.test(count) ? "BOOM" : Integer.toString(count);

    }

    public synchronized boolean tryStep(int maxCount) {
        if (count >= maxCount) {
            return false;
        }

        count++;
        System.out.println(getCountAsString());
        return true;
    }
}
