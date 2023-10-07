import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {

    public static AtomicInteger counter1 = new AtomicInteger(0);
    public static AtomicInteger counter2 = new AtomicInteger(0);
    public static AtomicInteger counter3 = new AtomicInteger(0);

    public static void main(String[] arg) {

        Random random = new Random();

        String[] texts = new String[100_000];

        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            for (int i = 0; i < texts.length; i++) {
                String text = texts[i];
                if (text.equals(new StringBuilder(text).reverse().toString())) {
                    countAdd(text);
                }
            }
        };
        executor.submit(task1);

        Runnable task2 = () -> {
            for (int i = 0; i < texts.length; i++) {
                String text = texts[i];
                if (identicalLetters(text)) {
                    countAdd(text);
                }
            }
        };
        executor.submit(task2);

        Runnable task3 = () -> {
            for (int i = 0; i < texts.length; i++) {
                String text = texts[i];
                if (sortAscending(text)) {
                    countAdd(text);
                }
            }
        };
        executor.submit(task3);

        try {
            executor.awaitTermination(1, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        System.out.println("Красивых слов с длиной 3: " + counter1 + " шт");
        System.out.println("Красивых слов с длиной 4: " + counter2 + " шт");
        System.out.println("Красивых слов с длиной 5: " + counter3 + " шт");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void countAdd(String text) {

        if (text.length() == 3) {
            counter1.getAndIncrement();
        } else if (text.length() == 4) {
            counter2.getAndIncrement();
        } else if (text.length() == 5) {
            counter3.getAndIncrement();
        }
    }

    public static boolean identicalLetters(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean sortAscending(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
