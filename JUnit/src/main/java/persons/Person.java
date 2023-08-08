package persons;

public class Person {

    String name;
    String surname;
    String family;

    public Person(String name, String surname, String family) {
        this.name = name;
        this.surname = surname;
        this.family = family;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + family;
    }
}