public class BinOps {
    public String sum(String a, String b) {
    /*Переведите числа из двоичной записи в
      строках в int, сложите и переведите
      обратно в двоичную запись*/

        int aa = Integer.parseInt(a, 2);
        int bb = Integer.parseInt(b, 2);

        return Integer.toBinaryString(aa + bb);

    }

    public String mult(String a, String b) {
    /*Переведите числа из двоичной записи в
      строках в int, перемножьте и переведите
      обратно в двоичную запись*/

        int aa = Integer.parseInt(a, 2);
        int bb = Integer.parseInt(b, 2);

        return Integer.toBinaryString(aa * bb);
    }
}