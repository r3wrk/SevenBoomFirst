public class Main {
    public static void main(String[] args) {

        BoomCounter counter = new BoomCounter(n -> n % 7 == 0 || Integer.toString(n).contains("7"));

        Runnable playSevenBoom = () -> {
            while (counter.tryStep(200)) {
            }
        };

        for (int i = 0; i < 4; i++) {
            new Thread(playSevenBoom).start();
        }

    }
}