import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] arg) throws InterruptedException {

        SecondThread secondThread = new SecondThread(sizeToFreq);
        secondThread.start();

        for (int i = 0; i <= 100; i++) {

            FirstThread firstThead = new FirstThread(sizeToFreq);
            firstThead.start();
            firstThead.join();
            //firstThead.sleep(10);

        }

        secondThread.interrupt();
//        try {
//            secondThread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.printf("test_end");


    }

}


