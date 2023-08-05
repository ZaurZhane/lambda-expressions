package HashSet;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

public class AddressTest {

    @org.junit.jupiter.api.Test
    public void adressExistence() {

        HashMap<Address, Integer> costPerAddress = new HashMap<>();

        Address address = new Address("Россия", "Москва");
        costPerAddress.put(address, 500);

        assertThat(costPerAddress, hasKey(address));

    }
}
