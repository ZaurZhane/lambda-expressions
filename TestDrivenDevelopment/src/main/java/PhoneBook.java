import java.util.Collection;
import java.util.HashMap;
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

        Collection<String> collection = list.keySet();

        for (String key : collection) {

            String value = list.get(key);

            if (value.equals(number)) {
                return key;
            }

        }

        return null;

    }


}
