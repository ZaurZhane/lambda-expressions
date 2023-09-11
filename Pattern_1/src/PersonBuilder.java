public class PersonBuilder {

    String name;
    String surname;
    int age;

    String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {

        if (!name.isEmpty()) {
            this.name = name;
        } else throw new IllegalArgumentException();

        return this;

    }

    public PersonBuilder setSurname(String surname) {

        if (!surname.isEmpty()) {
            this.surname = surname;
        } else throw new IllegalArgumentException();

        return this;

    }

    public PersonBuilder setAge(int age) {

        if (age > 0) {
            this.age = age;
        } else throw new IllegalArgumentException("Не указан возраст!");

        return this;

    }

    public PersonBuilder setAddress(String address) {

        if (!address.isEmpty()) {
            this.address = address;
        } else throw new IllegalArgumentException();

        return this;
    }

    public Person build() {

        Person person;

        if (name == null || surname == null)
            throw new IllegalStateException("Не заполнено имя или фамилия!");
        if (age < 0) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);

        person.setAddress(address);

        return person;
    }


}
