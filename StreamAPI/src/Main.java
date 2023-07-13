import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List result = new ArrayList<>();

        for (int i:arrayList) {

            if (i > 0 && i%2==0) {
                result.add(i);
            }
        }

        Collections.sort(result);
        System.out.print(result.toString());

    }
}

