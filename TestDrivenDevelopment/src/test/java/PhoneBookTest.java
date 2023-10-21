import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {

    @Test
    public void addTest() {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Жане Заур Азаматович", "+79615285387");
        int numberRecords = phoneBook.add("Жане Заур Азаматович", "+79603255588");

        Assertions.assertEquals(1, numberRecords);

    }

    @Test
    public void findByNumber() {

        PhoneBook phoneBook = new PhoneBook();
        String name = phoneBook.findByNumber("+79615285387");

        Assertions.assertEquals("79615285387", name);

    }

}
