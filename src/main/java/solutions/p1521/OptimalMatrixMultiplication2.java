package solutions.p1521;

import java.util.*;

public class OptimalMatrixMultiplication2 {
    static long[][] m;
    static long[] p;
    static int[][] s;
    static String[] Stroka = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    static long Mult(int i, int j) {
        if (m[i][j] == Long.MAX_VALUE)
            for (int k = i; k <= j - 1; k++) {
                long temp = Mult(i, k) + Mult(k + 1, j) + p[i - 1] * p[k] * p[j];
                if (temp < m[i][j]) {
                    m[i][j] = temp;
                    s[i][j] = k;
                }
            }
        return m[i][j];
    }

    static String Print(int i, int j) {
        if (i == j) return "A" + Stroka[i];
        return "(" + Print(i, s[i][j]) + " x " + Print(s[i][j] + 1, j) + ")";
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int cs = 1;
        while (true) {
            int n = con.nextInt();
            if (n == 0) break;
            m = new long[n + 1][n + 1];
            s = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++)
                Arrays.fill(m[i], Long.MAX_VALUE);

            p = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i - 1] = con.nextLong();
                p[i] = con.nextLong();
            }

            Mult(1, n);

            String Answer;
            System.out.print("Case " + cs + ": ");
            cs++;
            if (n == 1)
                Answer = "(A1)";
            else
                Answer = Print(1, n);
            System.out.println(Answer);
        }
        con.close();
    }
}