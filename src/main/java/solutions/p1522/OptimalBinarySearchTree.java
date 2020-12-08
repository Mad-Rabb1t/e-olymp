package solutions.p1522;

import java.util.*;

public class OptimalBinarySearchTree {
    static int[][] t;
    static int[] sum;

    static int weight(int i, int j) {
        if (i > j) return 0;
        return sum[j] - sum[i - 1];
    }

    static int go(int i, int j) {
        int k, temp;
        if (i > j) return 0;
        if (t[i][j] == Integer.MAX_VALUE) {
            for (k = i; k <= j; k++) {
                temp = go(i, k - 1) + go(k + 1, j) + weight(i, k - 1) + weight(k + 1, j);
                if (temp < t[i][j]) t[i][j] = temp;
            }
        }
        return t[i][j];
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        while (con.hasNextInt()) {
            int n = con.nextInt();
            t = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++)
                Arrays.fill(t[i], Integer.MAX_VALUE);

            int[] m = new int[n + 1];
            sum = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                m[i] = con.nextInt();
                t[i][i] = 0;
            }

            sum[0] = 0;
            for (int i = 1; i <= n; i++)
                sum[i] = sum[i - 1] + m[i];

            go(1, n);
            System.out.println(t[1][n]);
        }
        con.close();
    }
}
