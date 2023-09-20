public class Motorbike extends Product implements Vehicle{

    //O - принцип открытости/закрытости (Open Closed Principle)
    public Motorbike(String name, int price, String manufacturer, int count) {
        super(name, price, manufacturer, count);
    }

    @Override
    public void description() {
        System.out.println("Мотоцикл");
    }

}
