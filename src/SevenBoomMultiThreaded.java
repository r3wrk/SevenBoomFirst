import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SevenBoomMultiThreaded {
    private static final int MIN_SEVEN_BOOM_INPUT = 1;
    private final Object sevenBoomLock = new Object();
    private final int maxSevenBoomInput;
    private final int sevenBoomDivisor;
    private final int threadCount;

    public SevenBoomMultiThreaded(int maxSevenBoomInput, int sevenBoomDivisor, int threadCount) {
        this.maxSevenBoomInput = maxSevenBoomInput;
        this.sevenBoomDivisor = sevenBoomDivisor;
        this.threadCount = threadCount;
    }

    public void run() {
        Predicate<Integer> isSevenBoom = createIsSevenBoomPredicate();
        var sevenBoomInputs = IntStream.range(MIN_SEVEN_BOOM_INPUT, maxSevenBoomInput + 1).iterator();
        var boomTester = new BoomTester(isSevenBoom);

        for (int i = 0; i < threadCount; i++) {
            var sevenBoomThread = new SevenBoomThread(sevenBoomLock, sevenBoomInputs, boomTester);
            sevenBoomThread.start();
        }
    }

    private Predicate<Integer> createIsSevenBoomPredicate() {
        Predicate<Integer> isDivisibleByDivisor = n -> n % sevenBoomDivisor == 0;
        var divisorString = Integer.toString(sevenBoomDivisor);
        Predicate<Integer> containsDivisorAsString = n -> Integer.toString(n).contains(divisorString);
        return isDivisibleByDivisor.or(containsDivisorAsString);
    }
}