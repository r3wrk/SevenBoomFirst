import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SevenBoomThread extends Thread {
    private final AtomicInteger nextSevenBoomInput;
    private final int maxSevenBoomInput;
    private final BoomTester boomTester;
    private final ReentrantLock sevenBoomLock;

    public SevenBoomThread(ReentrantLock sevenBoomLock, AtomicInteger nextSevenBoomInput, int maxSevenBoomInput, BoomTester boomTester) {
        this.nextSevenBoomInput = nextSevenBoomInput;
        this.maxSevenBoomInput = maxSevenBoomInput;
        this.boomTester = boomTester;
        this.sevenBoomLock = sevenBoomLock;
    }

    @Override
    public void run() {
        while (nextSevenBoomInput.get() <= maxSevenBoomInput) {
            sevenBoomLock.lock();
            try {
                if (nextSevenBoomInput.get() <= maxSevenBoomInput) {
                    String formattedOutput = boomTester.format(nextSevenBoomInput.getAndIncrement());
                    System.out.println(formattedOutput);
                }
            } finally {
                sevenBoomLock.unlock();
            }
        }
    }
}