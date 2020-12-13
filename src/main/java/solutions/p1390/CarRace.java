package solutions.p1390;

import java.util.*;

public class CarRace {
    static int[][] g;
    static int[] used;
    static int n, m, flag;

    static void dfs(int v, int prev) {
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if ((i != prev) && g[v][i] == 1)
                if (used[i] == 1) flag = 1;
                else dfs(i, v);
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        n = con.nextInt();
        m = con.nextInt();
        g = new int[n + 1][n + 1];
        used = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int u = con.nextInt();
            int v = con.nextInt();
            g[u][v] = g[v][u] = 1;
        }

        for (int i = 1; i <= n; i++)
            if (used[i] == 0) dfs(i, -1);

        if (flag == 1) System.out.println("YES");
        else System.out.println("NO");
    }
}
