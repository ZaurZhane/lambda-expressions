package Taxes;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;


public class Test1 {

    @org.junit.jupiter.api.Test
    public void test1() {
        // given:
        int expected = 3; int a = 50; int b = 1;

        // when:
        USNIncome USNIncome = new USNIncome();
        int result = USNIncome.calcTaxFor(a, b);

        // then:
        //Assertions.assertEquals(expected, result);
        assertThat(expected, comparesEqualTo(result));

    }

}
