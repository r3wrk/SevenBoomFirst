import java.util.Iterator;

public class SevenBoomThread extends Thread {
    private final Iterator<Integer> inputs;
    private final BoomFormatter boomFormatter;
    private final Object sevenBoomLock;

    public SevenBoomThread(Object sevenBoomLock, Iterator<Integer> inputs, BoomFormatter boomFormatter) {
        this.inputs = inputs;
        this.boomFormatter = boomFormatter;
        this.sevenBoomLock = sevenBoomLock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sevenBoomLock) {
                if (!inputs.hasNext()) {
                    return;
                }
                System.out.println(boomFormatter.format(inputs.next()));
            }
        }
    }
}