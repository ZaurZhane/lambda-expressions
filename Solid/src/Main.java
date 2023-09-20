import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //Правило Magic
    public static final String CARRANCY = "Руб.";

    public static void main(String[] args) {

        // L - принцип замены Барбары Лисков (Liskov Substitution Principle)
        // Классы "Car", "Motorbike", "Powerboat" играют роль предка "products"
        Product[] products = {
                new Car("Mercedes-Benz GL", 6500000, "Германия", 1),
                new Motorbike("Harley Davidson V-Rod", 1900000, "США", 3),
                new Powerboat("Windboat DCX 4.6", 1500000, "Китай", 2)
        };

        //Правило Dry
        showPriceList(products);

        HashMap<Product, Integer> productsInCart = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Введите номер продукта и его количество или введите. Чтобы закончить подбор продуктов введите `end` ");
            String input = scanner.nextLine();

            if ("end".equals(input)) break;

            String[] parts = input.split(" ");

            int productsNumber = Integer.parseInt(parts[0]) - 1;

            int count = Integer.parseInt(parts[1]);

            productsInCart.put(products[productsNumber], count);

            showPriceList(products);

        }

        showBasket(productsInCart);

    }

    public static void showPriceList(Product[] products) {

        System.out.println("Прайс-лист: ");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }

    }

    public static void showBasket(HashMap<Product, Integer> map) {

        int totalAmount = 0;

        System.out.println("Корзина: ");

        for (Map.Entry<Product, Integer> entry : map.entrySet()) {

            Product product = entry.getKey();
            int count = entry.getValue();
            int price = product.getPrice();
            int sum = price * count;

            totalAmount += sum;

            System.out.printf("%s %d шт. цена %d %s стоимость %d %s%n", product, count, price, CARRANCY, sum, CARRANCY);

        }

        System.out.println("Итого: " + totalAmount + " " + CARRANCY);

    }
}
