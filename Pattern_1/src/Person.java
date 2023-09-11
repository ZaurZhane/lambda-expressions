import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {

        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, int age) {

        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {

        return age >= 0;

    }

    public boolean hasAddress() {

        return address.isEmpty();

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age = age + 1;
    }

    @Override
    public String toString() {

        return name + " " + surname + " " + age + " " + address;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address);
    }

}
