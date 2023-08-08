package taxes;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;


public class USNIncomeTest {

    @org.junit.jupiter.api.Test
    public void calculate() {
        // given:
        int expected = 3; int a = 50; int b = 1;

        // when:
        USNIncome USNIncome = new USNIncome();
        int result = USNIncome.calcTaxFor(a, b);

        // then:
        // тест 1
        //Assertions.assertEquals(expected, result);
        // тест 2
        assertThat(expected, comparesEqualTo(result));

    }

}
