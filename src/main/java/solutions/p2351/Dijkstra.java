package solutions.p2351;

import java.util.*;

public class Dijkstra {
    static final int INFINITY = 2000000000;
    static int[][] g;
    static int[] used;
    static int[] dist;

    static void Relax(int i, int j) {
        if (dist[i] + g[i][j] < dist[j])
            dist[j] = dist[i] + g[i][j];
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int n = con.nextInt();
        int s = con.nextInt();
        int f = con.nextInt();

        g = new int[n + 1][n + 1];
        for (int[] row : g) Arrays.fill(row, INFINITY);

        used = new int[n + 1];
        Arrays.fill(used, 0);
        dist = new int[n + 1];
        Arrays.fill(dist, INFINITY);
        dist[s] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                g[i][j] = con.nextInt();

        for (int i = 1; i < n; i++) {
            int min = INFINITY, v = -1;
            for (int j = 1; j <= n; j++)
                if (used[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    v = j;
                }

            if (v < 0) break;

            for (int j = 1; j <= n; j++)
                if (used[j] == 0 && g[v][j] != -1) Relax(v, j);

            used[v] = 1;
        }

        if (dist[f] == INFINITY) System.out.println(-1);
        else System.out.println(dist[f]);

        con.close();
    }
}