import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SevenBoomMultiThreaded {
    private static final int THREAD_COUNT = 4;
    private final Object sevenBoomLock = new Object();
    private final int maxInput;

    public SevenBoomMultiThreaded(int maxInput) {
        this.maxInput = maxInput;
    }

    public void run() {
        Predicate<Integer> isSevenBoom = n -> n % 7 == 0 || Integer.toString(n).contains("7");
        var inputs = IntStream.range(1, maxInput + 1).iterator();
        var boomFormatter = new BoomFormatter(isSevenBoom);

        for (int i = 0; i < THREAD_COUNT; i++) {
            new SevenBoomThread(sevenBoomLock, inputs, boomFormatter).start();
        }
    }
}