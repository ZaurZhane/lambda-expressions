public class Motorbike extends Product implements Vehicle{

    public Motorbike(String name, int price, String manufacturer, int count) {
        super(name, price, manufacturer, count);
    }

    @Override
    public void description() {
        System.out.println("Мотоцикл");
    }

}
