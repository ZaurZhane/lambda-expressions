import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static final BlockingQueue<String> texts1 = new ArrayBlockingQueue<>(100);
    private static final BlockingQueue<String> texts2 = new ArrayBlockingQueue<>(100);
    private static final BlockingQueue<String> texts3 = new ArrayBlockingQueue<>(100);

    private static class Counter implements Runnable {

        private final char searchedСhar;
        private final BlockingQueue<String> texts;
        Counter(char searchedСhar, BlockingQueue texts) {
            this.searchedСhar = searchedСhar;
            this.texts = texts;
        }

        @Override
        public void run() {

            int maxCount1 = 0;

            for (int i = 0; i < 10000; i++) {

                try {
                    String text = texts.take();

                    int count1 = (int)text.chars().filter(ch -> ch == searchedСhar).count();

                    if (count1 > maxCount1) {
                        maxCount1 = count1;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Максимольное количеством символов " + searchedСhar + " равно " + maxCount1);
        }

    }
    public static void main(String[] arg) throws InterruptedException {

        Thread generator = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {

                String route = generateRoute("abc", 100000);

                try {
                    texts1.put(route);
                    texts2.put(route);
                    texts3.put(route);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        generator.start();

        Thread thread1 = new Thread(new Counter('a', texts1));
        thread1.start();
        Thread thread2 = new Thread(new Counter('b', texts1));
        thread2.start();
        Thread thread3 = new Thread(new Counter('c', texts1));
        thread3.start();


    }

    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }

}
