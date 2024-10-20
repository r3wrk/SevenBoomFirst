public class Application {
    private static final int maxSevenBoomInput = 200;
    private static final int sevenBoomDivisor = 7;
    private static final int threadCount = 4;

    public static void main(String[] args) {
        var sevenBoom = new SevenBoomMultiThreaded(maxSevenBoomInput, sevenBoomDivisor, threadCount);
        sevenBoom.run();
    }
}