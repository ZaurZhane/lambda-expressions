public class Powerboat extends Product implements Vehicle, WaterTransport {

    //I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
    // Интерфейсы реализую Vehicle, WaterTransport реализуют разную функциональность
    //D - принцип инверсии зависимостей (Dependency Inversion Principle)
    //Всё зависит от абстракций (интерфейсов Vehicle, WaterTransport), а не от деталей реализации класса Powerboat.
    //SOLID
    public Powerboat(String name, int price, String manufacturer, int count) {
        super(name, price, manufacturer, count);
    }

    @Override
    public void description() {
        System.out.println("Моторная лодка");
    }

    @Override
    public TypesWaterTransport waterTransportType() {
        return TypesWaterTransport.River;
    }
}
