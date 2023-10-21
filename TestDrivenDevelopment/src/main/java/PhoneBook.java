import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    Map<String, String> list = new HashMap<>();

    public int add(String name, String phone) {

        if (!list.containsKey(name)) {
            list.put(name, phone);
        } else {
            System.out.println("В телефонной книге уже есть такой контакт " + name);
        }

        return list.size();

    }

    public String findByNumber(String number) {
        return null;
    }


}
