import java.util.*;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] arg) {

        FirstThread firstThead = new FirstThread(sizeToFreq);
        SecondThread secondThread = new SecondThread(sizeToFreq);

        for (int i = 0; i <= 1000; i++) {

            firstThead.start();
            secondThread.start();

            try {
                secondThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            secondThread.interrupt();

        }

        int max = sizeToFreq.keySet()
                .stream()
                .max(Comparator.naturalOrder())
                .get();

        System.out.println("Самое частое количество повторений " + max + " (встретилось " + sizeToFreq.get(max) + " раз)\nДругие размеры:");

        sizeToFreq.entrySet()
                .stream()
                .filter(entry -> max != entry.getKey())
                .forEach(entry -> System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " раз)"));

    }



}


