import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {

        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        logger.log("Запускаем фильтрацию");

        int amountOfElements = 0;

        for (int i:source) {
            if (i >= treshold) {

                logger.log(String.format("Элемент \"%d\" проходит", i));
                result.add(i);

            } else logger.log(String.format("Элемент \"%d\" не проходит", i));

            amountOfElements++;

        }
        logger.log("Прошло фильтр " + amountOfElements + " элемента из " + source.size());

        return result;
    }
}
