package persons;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;

public class PersonTest {
    @org.junit.jupiter.api.Test
    public void personTest() {

        Person person=new Person("Zaur", "Azamatovich", "Zhane");
        String str = person.toString();

        assertThat(person, hasToString(str));

    }




}
