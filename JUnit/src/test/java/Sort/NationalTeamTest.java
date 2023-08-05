package Sort;

import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;



public class NationalTeamTest {

    @org.junit.jupiter.api.Test
    public void teamSelection() {

        // given:
        int [] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};
        int[][] regional_teams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10}, {31, 18, 15, 12, 10, 8, 6, 4, 2, 1}, {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

        // when:
        NationalTeam nationalTeam = new NationalTeam();

        int[] result = nationalTeam.getNationalTeam(regional_teams);

        // then:
        // тест 1
        //Assertions.assertArrayEquals(expected, result);
        // тест 2
        assertThat(result, Matchers.is(expected));

    }



}

