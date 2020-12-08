package solutions.p974;

import java.util.*;

public class Floyd1 {
    static int[][] g;
    static int n;

    static void floyd() {
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (g[i][k] + g[k][j] < g[i][j])
                        g[i][j] = g[i][k] + g[k][j];
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        n = con.nextInt();
        g = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = con.nextInt();

        floyd();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(g[i][j] + " ");
            System.out.println();
        }
        con.close();
    }
}