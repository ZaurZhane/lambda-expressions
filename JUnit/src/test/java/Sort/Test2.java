package Sort;

import org.junit.jupiter.api.Assertions;


public class Test2 {

    @org.junit.jupiter.api.Test
    public void testConcat_validArgument_success() {

        // given:
        int [] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};
        int[][] regional_teams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10}, {31, 18, 15, 12, 10, 8, 6, 4, 2, 1}, {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

        // when:
        int[] result = national_team(regional_teams);

        // then:
        Assertions.assertArrayEquals(expected, result);

    }

    public static int[] national_team(int[][] regional_teams) {

        int[] team = regional_teams[0];

        for (int i = 1; i < regional_teams.length; i++) {
            team = merge(team, regional_teams[i]);
        }

        return team;

    }

    public static int[] merge(int[] A, int[] B) {

        int aLength = A.length;
        int bLength = B.length;

        int[] C = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int ia = 0;
        int ib = 0;
        int ic = 0;

        while (ia + ib < 10) {

            if (A[ia] >= B[ib]) {

                C[ic] = A[ia];
                ia += 1;

            } else {

                C[ic] = B[ib];
                ib += 1;

            }


            ic += 1;

        }

        return C;
    }

}

