import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SevenBoomMultiThreaded {
    private final Object sevenBoomLock = new Object();
    private final int maxInput;
    private final int threadCount;

    public SevenBoomMultiThreaded(int maxInput, int threadCount) {
        this.maxInput = maxInput;
        this.threadCount = threadCount;
    }

    public void run() {
        Predicate<Integer> isSevenBoom = n -> n % 7 == 0 || Integer.toString(n).contains("7");
        var inputs = IntStream.range(1, maxInput + 1).iterator();
        var boomFormatter = new BoomFormatter(isSevenBoom);

        for (int i = 0; i < threadCount; i++) {
            var sevenBoomThread = new SevenBoomThread(sevenBoomLock, inputs, boomFormatter);
            sevenBoomThread.start();
        }
    }
}