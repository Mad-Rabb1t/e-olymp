package solutions.p975;

import java.util.Scanner;

public class Floyd {
    static int n;
    static int[][] g;

    static void floyd() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    if (Math.min(g[j][i], g[i][k]) != -1)
                        if (g[j][k] == -1 || g[j][k] > g[j][i] + g[i][k])
                            g[j][k] = g[j][i] + g[i][k];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = sc.nextInt();

        floyd();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, g[i][j]);
            }
        }

        System.out.println(max);
    }
}
