public class Car extends Product implements Vehicle {

    //S - принцип единственной ответственности (Single Responsibility Principle).
    // Класс "Car" выполняет только те функции, для которых он логически предназначен;

    //I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
    //Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения.

    String bodyType;

    public Car(String name, int price, String manufacturer, int count) {
        super(name, price, manufacturer, count);
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    //O - принцип открытости/закрытости (Open Closed Principle). Класс "Car" наследует функциональность от класс Product и интерфейса Vehicle,
    // при этом в самом классе ничего не меняется.
    @Override
    public void description() {
        System.out.println("Автомобиль");
    }

    @Override
    public String toString() {
        return name + " " + manufacturer;
    }

}
