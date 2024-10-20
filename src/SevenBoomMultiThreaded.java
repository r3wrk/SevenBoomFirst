import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SevenBoomMultiThreaded {
    private static final int MIN_SEVEN_BOOM_INPUT = 1;
    private final Object sevenBoomLock = new Object();
    private final int maxInput;
    private final int threadCount;

    public SevenBoomMultiThreaded(int maxInput, int threadCount) {
        this.maxInput = maxInput;
        this.threadCount = threadCount;
    }

    public void run() {
        Predicate<Integer> isSevenBoom = createIsSevenBoomPredicate();
        var sevenBoomInputs = IntStream.range(MIN_SEVEN_BOOM_INPUT, maxInput + 1).iterator();
        var boomFormatter = new BoomFormatter(isSevenBoom);

        for (int i = 0; i < threadCount; i++) {
            var sevenBoomThread = new SevenBoomThread(sevenBoomLock, sevenBoomInputs, boomFormatter);
            sevenBoomThread.start();
        }
    }

    private Predicate<Integer> createIsSevenBoomPredicate() {
        Predicate<Integer> isDivisibleBySeven = n -> n % 7 == 0;
        Predicate<Integer> containsSevenAsString = n -> Integer.toString(n).contains("7");
        return isDivisibleBySeven.or(containsSevenAsString);
    }
}