import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class SevenBoomThread extends Thread {
    private final Iterator<Integer> inputs;
    private final BoomTester boomTester;
    private final ReentrantLock sevenBoomLock;

    public SevenBoomThread(ReentrantLock sevenBoomLock, Iterator<Integer> inputs, BoomTester boomTester) {
        this.inputs = inputs;
        this.boomTester = boomTester;
        this.sevenBoomLock = sevenBoomLock;
    }

    @Override
    public void run() {
        while (true) {
            sevenBoomLock.lock();
            try {
                if (!inputs.hasNext()) {
                    return;
                }
                String formattedOutput = boomTester.format(inputs.next());
                System.out.println(formattedOutput);
            } finally {
                sevenBoomLock.unlock();
            }
        }
    }
}