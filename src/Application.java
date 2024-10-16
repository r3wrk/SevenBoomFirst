public class Application {
    private static final int maxSevenBoomInput = 200;

    public static void main(String[] args) {
        var sevenBoom = new SevenBoomMultiThreaded(maxSevenBoomInput);
        sevenBoom.run();
    }
}