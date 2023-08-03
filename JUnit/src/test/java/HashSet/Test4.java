package HashSet;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

public class Test4 {

    @org.junit.jupiter.api.Test
    public void test4() {

        HashMap<Address, Integer> costPerAddress = new HashMap<>();

        Address address = new Address("Россия", "Москва");
        costPerAddress.put(address, 500);

        assertThat(costPerAddress, hasKey(address));

    }
}
