package Taxes;

import org.junit.jupiter.api.Assertions;

public class Test {

    @org.junit.jupiter.api.Test
    public void testConcat_validArgument_success() {
        // given:
        int expected = 3; int a = 50; int b = 1;

        // when:
        USNIncome USNIncome = new USNIncome();
        int result = USNIncome.calcTaxFor(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

}
