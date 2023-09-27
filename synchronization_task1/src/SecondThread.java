import java.util.Comparator;
import java.util.Map;

public class SecondThread extends Thread {
    Map<Integer, Integer> sizeToFreq;

    public SecondThread(Map<Integer, Integer> sizeToFreq) {
        this.sizeToFreq = sizeToFreq;
    }
    @Override
    public void run(){
        while (!Thread.interrupted()) {

            synchronized(sizeToFreq) {

                try {
                    sizeToFreq.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int maxLider = sizeToFreq.keySet()
                        .stream()
                        .max(Comparator.naturalOrder())
                        .get();

                System.out.println("Текущий лидер " + maxLider + " (встретилось " + sizeToFreq.get(maxLider) + " раз)");
            }
        }
    }
}
