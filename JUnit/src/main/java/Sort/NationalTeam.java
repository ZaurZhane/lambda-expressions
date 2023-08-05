package Sort;

public class NationalTeam {

    public int[] getNationalTeam(int[][] regional_teams) {

        int[] team = regional_teams[0];

        for (int i = 1; i < regional_teams.length; i++) {
            team = merge(team, regional_teams[i]);
        }

        return team;

    }

    public int[] merge(int[] A, int[] B) {

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
