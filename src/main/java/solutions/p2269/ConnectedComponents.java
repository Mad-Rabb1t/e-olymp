package solutions.p2269;

import java.util.*;

public class ConnectedComponents {
    static int[][] g;
    static int[] used;
    static int n, m;

    static void dfs(int v) {
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if (g[v][i] == 1 && used[i] == 0) dfs(i);
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        n = con.nextInt();
        g = new int[n + 1][n + 1];
        used = new int[n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                g[i][j] = con.nextInt();

        int res = 0;
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) {
                dfs(i);
                res++;
            }

        System.out.println(res);
        con.close();
    }
}
