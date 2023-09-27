import java.util.*;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] arg) {


        for (int i = 0; i <= 1000; i++) {

            new Thread(() -> {

                int count = 0;

                String route = generateRoute("RLRFR", 100);

                for (int j = 0; j < route.length(); j++) {

                    if (route.charAt(j) == 'R') {
                        count++;
                    }
                }

                synchronized(sizeToFreq) {

                    if (sizeToFreq.containsKey(count)){
                        sizeToFreq.put(count, sizeToFreq.get(count) + 1);
                    } else {
                        sizeToFreq.put(count, 1);
                    }

                }

            }).start();
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

    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }

}
