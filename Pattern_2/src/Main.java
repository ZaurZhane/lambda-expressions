import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");

        int listSize = scanner.nextInt();

        System.out.println("Введите верхнюю границу значений: " );

        int upperLimitOfValues = scanner.nextInt();

        logger.log(("Создаем и наполняем список"));


        List<Integer> list = new ArrayList<>(listSize);

        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(upperLimitOfValues));
        }

        System.out.println("Вот случайный список: " + list.toString().replace("[", "").replace("]", ""));
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");

        int treshold = scanner.nextInt();

        Filter filter = new Filter(treshold);

        List<Integer> resultList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + resultList.toString().replace("[", "").replace("]", ""));
        System.out.println("Завершаем программу");

    }
}
