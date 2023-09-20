public abstract class Product {
    String name;
    int price;
    String manufacturer;

    int count;
    public Product(String name, int price, String manufacturer, int count) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return name;
    }

}
