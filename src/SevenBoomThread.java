import java.util.Iterator;

public class SevenBoomThread extends Thread {
    private final Iterator<Integer> inputs;
    private final BoomTester boomTester;
    private final Object sevenBoomLock;

    public SevenBoomThread(Object sevenBoomLock, Iterator<Integer> inputs, BoomTester boomTester) {
        this.inputs = inputs;
        this.boomTester = boomTester;
        this.sevenBoomLock = sevenBoomLock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sevenBoomLock) {
                if (!inputs.hasNext()) {
                    return;
                }
                System.out.println(boomTester.format(inputs.next()));
            }
        }
    }
}