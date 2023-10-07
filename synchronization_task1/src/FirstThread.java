import java.util.Comparator;
import java.util.Map;
import java.util.Random;

public class FirstThread extends Thread{
    private Map<Integer, Integer> sizeToFreq;

    public FirstThread(Map<Integer, Integer> sizeToFreq) {
        this.sizeToFreq = sizeToFreq;
    }
    @Override
    public void run(){

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
            System.out.println("Добавлено повторение " + count + " (встретилось " + sizeToFreq.get(count) + " раз)");

            sizeToFreq.notify();

        }

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
